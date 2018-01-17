package com.qk365.base.persist.support.dialect;

/**
 * SQLServer数据库方言处理对象
 */
public class SQLServerDialect extends Dialect {

	/**
	 * 得到分页的SQL
	 * 
	 * @param offset
	 *            偏移量
	 * @param limit
	 *            位置
	 * @return 分页SQL
	 */
	@Override
	public String getLimitString(String querySelect, int offset, int limit) {
		querySelect = this.getLineSql(querySelect);
		// 得到最后一个Order By的插入点位置
		// 如果没有orderby，就加一个,按照主键orderby
		int orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
		if (orderIndex == -1
				|| !this.isBracketCanPartnership(querySelect.substring(orderIndex, querySelect.length()))) {
			querySelect = querySelect + " order by 201510132012orderBySqu_yangxx";// 201510132012orderBySqu_yangxx占位符
			orderIndex = querySelect.toLowerCase().lastIndexOf("order by");
		}
		String retStr = new StringBuffer(querySelect.length()).append("select * from (")
				.append("select *,ROW_NUMBER() OVER (")
				.append(querySelect.substring(orderIndex).replaceAll("[^\\s,]+\\.", "")).append(") _row_num from (")
				.append(querySelect.substring(0, orderIndex)).append(") _t").append(") _t where _t._row_num > ")
				.append(offset == -1 ? "?" : offset).append(" and _t._row_num <=  ").append(limit == -1 ? "?" : limit)
				.toString();
		retStr = retStr.replace("201510132012orderBySqu_yangxx",
				"(SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.KEY_COLUMN_USAGE WHERE TABLE_NAME='"
						+ this.getTableName(querySelect) + "' )");
		return retStr;
	}

	/**
	 * 获取表名
	 * 
	 * @param querySelect
	 * @return
	 */
	public String getTableName(String querySelect) {
		int orderIndex = querySelect.toLowerCase().indexOf("from");
		String newStr = querySelect.substring(orderIndex + 5);
		if (newStr.indexOf(" ") != -1) {
			newStr = newStr.substring(0, newStr.indexOf(" "));
		}
		return newStr;
	}

	/**
	 * 将SQL语句变成一条语句，并且每个单词的间隔都是1个空格
	 * 
	 * @param sql
	 *            SQL语句
	 * @return 如果sql是NULL返回空，否则返回转化后的SQL
	 */
	private String getLineSql(String sql) {
		return sql.replaceAll("[\r\n]", " ").replaceAll("\\s{2,}", " ");
	}

	/**
	 * 判断括号"()"是否匹配,并不会判断排列顺序是否正确
	 * 
	 * @param text
	 *            要判断的文本
	 * @return 如果匹配返回TRUE,否则返回FALSE
	 */
	private boolean isBracketCanPartnership(String text) {
		if (text == null || (this.getIndexOfCount(text, '(') != this.getIndexOfCount(text, ')'))) {
			return false;
		}
		return true;
	}

	/**
	 * 得到一个字符在另一个字符串中出现的次数
	 * 
	 * @param text
	 *            文本
	 * @param ch
	 *            字符
	 */
	private int getIndexOfCount(String text, char ch) {
		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			count = (text.charAt(i) == ch) ? count + 1 : count;
		}
		return count;
	}
}
