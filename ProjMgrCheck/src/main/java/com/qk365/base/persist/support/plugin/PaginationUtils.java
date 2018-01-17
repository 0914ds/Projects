package com.qk365.base.persist.support.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;

public class PaginationUtils {

	public static int getCount(final String sql, final Connection connection, final Configuration configuration,
			final Object parameterObject, final BoundSql boundSql) throws SQLException {
		final String countSql = "select count(1) from (" + sql + ") as tmp_count";
		PreparedStatement countStmt = null;
		ResultSet rs = null;
		try {
			countStmt = connection.prepareStatement(countSql);
			setParameters(countStmt, configuration, boundSql, parameterObject);
			rs = countStmt.executeQuery();
			int count = 0;
			if (rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (countStmt != null) {
				countStmt.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void setParameters(PreparedStatement ps, Configuration configuration, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		// ErrorContext.instance().activity("setting
		// parameters").object(this.mappedStatement.getParameterMap().getId());
		List parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = (parameterObject == null) ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); ++i) {
				ParameterMapping parameterMapping = (ParameterMapping) parameterMappings.get(i);
				if (parameterMapping.getMode() != ParameterMode.OUT) {
					Object value;
					String propertyName = parameterMapping.getProperty();
					PropertyTokenizer prop = new PropertyTokenizer(propertyName);
					if (parameterObject == null) {
						value = null;
					} else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else if (boundSql.hasAdditionalParameter(propertyName)) {
						value = boundSql.getAdditionalParameter(propertyName);
					} else if ((propertyName.startsWith("__frch_"))
							&& (boundSql.hasAdditionalParameter(prop.getName()))) {
						value = boundSql.getAdditionalParameter(prop.getName());
						if (value != null)
							value = configuration.newMetaObject(value)
									.getValue(propertyName.substring(prop.getName().length()));
					} else {
						value = (metaObject == null) ? null : metaObject.getValue(propertyName);
					}
					TypeHandler typeHandler = parameterMapping.getTypeHandler();
					if (typeHandler == null)
						throw new ExecutorException(
								"There was no TypeHandler found for parameter " + propertyName + " of statement ");

					JdbcType jdbcType = parameterMapping.getJdbcType();
					if ((value == null) && (jdbcType == null))
						jdbcType = configuration.getJdbcTypeForNull();
					typeHandler.setParameter(ps, i + 1, value, jdbcType);
				}
			}
		}
	}
}
