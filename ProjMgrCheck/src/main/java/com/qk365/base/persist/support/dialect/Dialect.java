package com.qk365.base.persist.support.dialect;

public abstract class Dialect {
	public static enum Type {
		MYSQL, ORACLE, SQLSERVER
	}

	/**
	 * @param sql
	 *            原始SQL查询语句
	 * @param offset
	 *            记录偏移量(开区间,如为5,则从第6条数据开始)
	 * @param limit
	 *            记录数
	 * @return 增加范围查询后的SQL语句
	 */
	public abstract String getLimitString(String sql, int skipResults, int maxResults);
}