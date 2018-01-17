package com.qk365.base.persist.support.plugin;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.DefaultParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;

import com.qk365.base.persist.base.IModelExample;
import com.qk365.base.persist.support.dialect.Dialect;
import com.qk365.base.persist.support.dialect.MySQLDialect;
import com.qk365.base.persist.support.dialect.OracleDialect;
import com.qk365.base.persist.support.dialect.SQLServerDialect;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {
	// 日志对象
	private final static Logger log = Logger.getLogger(PaginationInterceptor.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin
	 * .Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);

		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue("delegate.rowBounds");
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}

		DefaultParameterHandler defaultParameterHandler = (DefaultParameterHandler) metaStatementHandler
				.getValue("delegate.parameterHandler");

		String originalSql = (String) metaStatementHandler.getValue("delegate.boundSql.sql");

		Object paramObj = defaultParameterHandler.getParameterObject();
		if (paramObj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map parameterMap = (Map) paramObj;
			Object sidx = parameterMap.get("_sidx");
			Object sord = parameterMap.get("_sord");

			if (sidx != null && sord != null) {
				originalSql = originalSql + " order by " + sidx + " " + sord;
			}
		}

		Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");

		Dialect.Type databaseType = null;
		try {
			databaseType = Dialect.Type.valueOf(configuration.getVariables().getProperty("dialect").toUpperCase());
		} catch (Exception e) {
			// ignore
		}
		if (databaseType == null) {
			throw new RuntimeException("the value of the dialect property in configuration.xml is not defined : "
					+ configuration.getVariables().getProperty("dialect"));
		}
		Dialect dialect = null;
		switch (databaseType) {
		case ORACLE:
			dialect = new OracleDialect();
			break;
		case MYSQL:// 需要实现MySQL的分页逻辑
			dialect = new MySQLDialect();
			break;
		case SQLSERVER:// 需要实现MySQL的分页逻辑
			dialect = new SQLServerDialect();
			break;
		}

		if (dialect == null) {
			throw new RuntimeException("No dialect exists.");
		}

		// 对mybatisGenerater 的example处理特殊处理
		if (!(paramObj instanceof IModelExample)) {

			Integer count = PaginationContext.getPageContext();
			if (count.intValue() == 0) {
				BoundSql boundSql = statementHandler.getBoundSql();
				Connection connection = configuration.getEnvironment().getDataSource().getConnection();
				count = PaginationUtils.getCount(originalSql, connection, configuration, paramObj, boundSql);
				PaginationContext.setContext(count);
			}

			if (count.intValue() == 0) {
				return invocation.proceed();
			}
		}

		metaStatementHandler.setValue("delegate.boundSql.sql",
				dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		if (log.isDebugEnabled()) {
			BoundSql boundSql = statementHandler.getBoundSql();
			log.debug("Generate the pagination SQL : " + boundSql.getSql().replaceAll("[ \t\n][ ]*", " "));
		}
		return invocation.proceed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.plugin.Interceptor#plugin(java.lang.Object)
	 */
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	@Override
	public void setProperties(Properties arg0) {

	}

}