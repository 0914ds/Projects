package com.qk365.base.persist.base;;

/**
 * AbstractBaseMapper用于抽取MyBatis Generator生成代码的常用参数。
 */
public abstract class AbstractBaseMapper {
	
	protected final static String SELECT_BY_PRIMARY_KEY = "selectByPrimaryKey";
	protected final static String SELECT_BY_EXAMPLE = "selectByExample";
	protected final static String COUNT_BY_EXAMPLE = "countByExample";

	protected final static String INSERT = "insert";
	protected final static String INSERT_SELECTIVE = "insertSelective";

	protected final static String UPDATE_BY_PRIMARY_KEY = "updateByPrimaryKey";
	protected final static String UPDATE_BY_PRIMARY_KEY_SELECTIVE = "updateByPrimaryKeySelective";
	protected final static String UPDATE_BY_EXAMPLE = "updateByExample";
	protected final static String UPDATE_BY_EXAMPLE_SELECTIVE = "updateByExampleSelective";
	
	protected final static String DELETE_BY_PRIMARY_KEY = "deleteByPrimaryKey";
	protected final static String DELETE_BY_EXAMPLE = "deleteByExample";

	@SuppressWarnings("rawtypes")
	protected abstract Class getMapperClass();

	protected String getFullMapperId(MapperIdType type) {
		return getMapperClass().getName() + "." + type.getMapperId();
	}

	protected enum MapperIdType {

		SelectByPrimaryKey(SELECT_BY_PRIMARY_KEY), SelectByExample(
				SELECT_BY_EXAMPLE), CountByExample(COUNT_BY_EXAMPLE), Insert(
				INSERT), InsertSelective(INSERT_SELECTIVE), UpdateByPrimaryKey(
				UPDATE_BY_PRIMARY_KEY), UpdateByPrimaryKeySelective(
				UPDATE_BY_PRIMARY_KEY_SELECTIVE), UpdateByExample(
				UPDATE_BY_EXAMPLE), UpdateByExampleSelective(UPDATE_BY_EXAMPLE_SELECTIVE),
				DeleteByPrimaryKey(DELETE_BY_PRIMARY_KEY), DeleteByExample(DELETE_BY_EXAMPLE);

		private final String mapperId;

		private MapperIdType(String value) {
			mapperId = value;
		}

		public String getMapperId() {
			return mapperId;
		}
	}

}
