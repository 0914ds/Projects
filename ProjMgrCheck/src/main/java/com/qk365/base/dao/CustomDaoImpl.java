package com.qk365.base.dao;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import com.qk365.base.persist.support.PageableDAO;
import com.qk365.base.persist.support.pagination.PaginationData;

/**
 * 自定义SQL对象
 */
@Repository("customDaoImpl")
@DependsOn("sqlSessionTemplate")
public class CustomDaoImpl {

	// ****Property****
	private SqlSessionTemplate sessionTemplate;
	private PageableDAO pageableDAO;

	private static final String Mapper_Prefix = "com.dt.snail.core.mapper.CustomMapper.";

	// ****Public Function****
	/**
	 * 构造函数
	 * 
	 * @param sqlSessionTemplate
	 */
	@Autowired(required = false)
	public CustomDaoImpl(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate) {
		this.sessionTemplate = sqlSessionTemplate;
		pageableDAO = new PageableDAO(sqlSessionTemplate);
	}

	/**
	 * 自定义查询
	 * 
	 * @param clazz
	 * @param sqlName
	 * @param paramMap
	 * @return
	 */
	public <T> List<T> selectList(Class<T> clazz, String sqlName, Map<String, Object> paramMap) {
		return sessionTemplate.selectList(Mapper_Prefix + sqlName, paramMap);
	}

	/**
	 * 自定义查询-分页
	 * 
	 * @param clazz
	 * @param sqlName
	 * @param paramMap
	 * @return
	 */
	public <T> List<T> selectList(Class<T> clazz, String sqlName, Map<String, Object> paramMap, Integer pageId,
			Integer pageSize) {
		// 每页显示条数
		int limit = PageableDAO.getLimit(pageSize);
		// 当前页码
		int offset = PageableDAO.getOffset(pageId, limit);
		return sessionTemplate.selectList(Mapper_Prefix + sqlName, paramMap, new RowBounds(offset, limit));
	}

	/**
	 * 自定义查询-个数
	 * 
	 * @param sqlName
	 * @param paramMap
	 * @return
	 */
	public int selectCount(String sqlName, Map<String, Object> paramMap) {
		return sessionTemplate.selectOne(Mapper_Prefix + sqlName, paramMap);
	}

	/**
	 * 自定义查询-分页
	 * 
	 * @param clazz
	 *            泛型
	 * @param sqlName
	 *            查询SQL名
	 * @param paramMap
	 *            参数
	 * @param pageId
	 *            页码
	 * @param pageSize
	 *            每页记录数
	 * @return
	 */
	@SuppressWarnings("static-access")
	public <T> PaginationData<T> selectListByPage(Class<T> clazz, String sqlName, Map<String, Object> paramMap,
			Integer pageId, Integer pageSize) {
		// 总记录条数
		final int totalCount = sessionTemplate.selectList(Mapper_Prefix + sqlName, paramMap).size();
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
		final List<T> list = sessionTemplate.selectList(Mapper_Prefix + sqlName, paramMap,
				new RowBounds(offset, limit));
		final PaginationData<T> data = new PaginationData<T>(list, curPageId, limit, totalPages, totalCount);
		return data;
	}

}
