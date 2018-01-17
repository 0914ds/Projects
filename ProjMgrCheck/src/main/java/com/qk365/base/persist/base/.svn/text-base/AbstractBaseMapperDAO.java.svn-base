package com.qk365.base.persist.base;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.util.Assert;

import com.qk365.base.persist.support.PageableDAO;
import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.base.persist.support.pagination.PaginationInfo;

public abstract class AbstractBaseMapperDAO<T, K> extends AbstractBaseMapper implements IBaseDAO<T, K> {

	private final static Logger log = Logger.getLogger(AbstractBaseMapperDAO.class);

	private SqlSessionTemplate sqlSessionTemplate;
	private PageableDAO pageableDAO;
	private ISqlMapper<T, K> mapper;
	
	public AbstractBaseMapperDAO() {
		
	}

	public AbstractBaseMapperDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		pageableDAO = new PageableDAO(getSqlSessionTemplate());
		mapper = getSqlSessionTemplate().getMapper(getMapperClass());
	}

	public final SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	protected final ISqlMapper<T, K> getSqlMapper() {
		return mapper;
	}

	protected String getClassName(@SuppressWarnings("rawtypes") Class clazz) {
		return clazz.getName();
	}

	@Override
	public int countByCriteria(IModelExample example) {
		return getSqlMapper().countByExample(example);
	}

	@Override
	public int add(T record) {
		Assert.notNull(record, "AbstractBaseMapperDAO.add(record) : 传入的record参数不能为null.");
		int count = getSqlSessionTemplate().insert(getFullMapperId(MapperIdType.Insert), record);
		return handleCount(count);
	}

	@Override
	public int addSelective(T record) {
		Assert.notNull(record, "AbstractBaseMapperDAO.addSelective(record) : 传入的record参数不能为null.");
		int count = getSqlSessionTemplate().insert(getFullMapperId(MapperIdType.InsertSelective), record);
		return handleCount(count);
	}

	@Override
	public List<T> getListByCriteria(IModelExample example) {
		final List<T> results = getSqlSessionTemplate().selectList(getFullMapperId(MapperIdType.SelectByExample), example);
		if (results == null || results.size() == 0) {
			return Collections.emptyList();
		}
		log.debug(results.size() + "条记录符合条件.");
		return results;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getByPrimaryKey(K id) {
		return (T) getSqlSessionTemplate().selectOne(getFullMapperId(MapperIdType.SelectByPrimaryKey), id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int editByCriteriaSelective(T record, IModelExample example) {
		Assert.notNull(record, "AbstractBaseMapperDAO.editByCriteriaSelective(record,example) : 传入的record参数不能为null.");
		final Map map = new HashMap();
		map.put("record", record);
		if (example != null) {
			map.put("example", example);
		}
		return handleEdit(MapperIdType.UpdateByExampleSelective, map);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public int editByCriteria(T record, IModelExample example) {
		Assert.notNull(record, "AbstractBaseMapperDAO.editByCriteria(record, example) : 传入的record参数不能为null.");
		final Map map = new HashMap();
		map.put("record", record);
		if (example != null) {
			map.put("example", example);
		}
		return handleEdit(MapperIdType.UpdateByExample, map);
	}

	@Override
	public int editByPrimaryKeySelective(T record) {
		Assert.notNull(record, "AbstractBaseMapperDAO.editByPrimaryKeySelective(record) : 传入的参数不能为null.");
		return handleEdit(MapperIdType.UpdateByPrimaryKeySelective, record);
	}

	@Override
	public int editByPrimaryKey(T record) {
		Assert.notNull(record, "AbstractBaseMapperDAO.editByPrimaryKey(record) : 传入的参数不能为null.");
		return handleEdit(MapperIdType.UpdateByPrimaryKey, record);
	}

	protected int handleCount(int count) {
		return count;
	}

	private int handleEdit(MapperIdType editStatement, Object param) {
		int count = getSqlSessionTemplate().update(getFullMapperId(editStatement), param);
		return handleCount(count);
	}

	@Override
	protected abstract Class<? extends ISqlMapper<T, K>> getMapperClass();

	@Override
	public PaginationData<T> getByCriteria(final IModelExample example, final int pageId, final int pageSize) {
		return getByCriteriaForInner(example, pageId, pageSize);
	}

	@SuppressWarnings("static-access")
	protected final PaginationData<T> getByCriteriaForInner(final IModelExample example, final int pageId,
			final int pageSize) {
		// 总记录条数
		final int totalCount = countByCriteria(example);
		// no data found
		if (totalCount == 0) {
			return new PaginationData<T>(Collections.<T> emptyList(), 1, pageableDAO.getLimit(pageSize), 0, 0);
		}
		// 每页显示条数
		final int limit = pageableDAO.getLimit(pageSize);
		// 总页数
		final int totalPages = (int) Math.ceil(totalCount * 1.0 / limit);
		// 当前页码
		final int curPageId = pageableDAO.getCurPageId(pageId, totalPages);
		// 偏移量:当前页的第一条记录的前一个位置
		final int offset = pageableDAO.getOffset(curPageId, limit);
		// 当前页应包含的数据
		final List<T> list = getSqlSessionTemplate().selectList(getFullMapperId(MapperIdType.SelectByExample), example,
				new RowBounds(offset, limit));

		final PaginationData<T> data = new PaginationData<T>(list, curPageId, limit, totalPages, totalCount);

		return data;
	}

	@Override
	public PaginationData<T> getByCriteria(IModelExample example, int pageId) {
		return getByCriteriaForInner(example, pageId, PaginationInfo.DEFAULT_PAGE_SIZE);
	}

	@Override
	public Date getSysDate() {
		return getSqlSessionTemplate().selectOne("com.drift.core.mapper.manager.DictoryMapper.selectSysDate");
	}
	
	@Override
	public int deleteByPrimaryKey(K id) {
		return getSqlSessionTemplate().delete(getFullMapperId(MapperIdType.DeleteByPrimaryKey), id);
	}
	
	@Override
	public int deleteByExample(IModelExample example) {
		return getSqlSessionTemplate().delete(getFullMapperId(MapperIdType.DeleteByExample), example);
	}
	
	@Override
	public int updateOrAdd(T record, K id) {
		//先查询是否存在
		T obj = getByPrimaryKey(id);
		//添加
		if(null == obj){
			return this.addSelective(record);
		}
		//修改
		else{
			return this.editByPrimaryKeySelective(record);
		}
	}
	
	protected final <E> PaginationData<E> getByMap(final String count, final String select, Map<String, Object> params,
			int pageId, int pageSize) {
		return pageableDAO.getByMap(count, select, params, pageId, pageSize);
	}

	protected String getMybatisExecutionStatement(String methodName) {
		return getMapperClass().getName() + "." + methodName;
	}
	
	protected final Object getByMap(final String select, Map<String,Object> params){
		return getSqlSessionTemplate().selectOne(select, params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getModelByCriteria(IModelExample example) {
		return (T)getSqlSessionTemplate().selectOne(getFullMapperId(MapperIdType.SelectByExample), example);
	}
	
	
}
