package com.qk365.base.persist.support.dialect;

/**
 * Oracle数据库方言处理对象
 */
public class OracleDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");
		pagingSelect.append(sql);
		pagingSelect.append(" ) row_ ) where rownum_ > ").append(offset).append(" and rownum_ <= ")
				.append(offset + limit);
		return pagingSelect.toString();
	}

}
