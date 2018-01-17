package com.qk365.base.persist.support;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.base.persist.support.pagination.PaginationInfo;
import com.qk365.base.persist.support.plugin.PaginationContext;

/**
 * 本类将分页所需的代码进行了抽取。帮助具体需要分页的dao实现分页功能.
 */
public class PageableDAO {

	private final SqlSessionTemplate sqlSessionTemplate;

	public PageableDAO(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public final <E> PaginationData<E> getByMap(final String count, final String select, Map<String, Object> params,
			int pageId, int pageSize) {

		if (pageId <= 0) {
			pageId = 1;
		}

		// 每页显示条数
		final int limit = getLimit(pageSize);
		// 当前页码
		// final int curPageId = getCurPageId(pageId, totalPages);
		// 偏移量:当前页的第一条记录的前一个位置
		final int offset = getOffset(pageId, limit);
		// 当前页应包含的数据
		final List<E> list = getSqlSessionTemplate().selectList(select, params, new RowBounds(offset, limit));

		// 总记录条数
		final int totalCount = PaginationContext.getPageContext();

		// no data found
		if (totalCount == 0) {
			return new PaginationData<E>(Collections.<E> emptyList(), 1, getLimit(pageSize), 0, 0);
		}

		// 总页数
		final int totalPages = (int) Math.ceil(totalCount * 1.0 / limit);

		if (pageId > totalPages) {
			int curPageId = getCurPageId(pageId, totalPages);
			return getByMap(count, select, params, curPageId, pageSize);
		}

		final PaginationData<E> data = new PaginationData<E>(list, pageId, limit, totalPages, totalCount);
		PaginationContext.removeContext();
		return data;
	}

	protected final Integer countByMap(final String count, Map<String, Object> params) {
		return getSqlSessionTemplate().selectOne(count, params);
	}

	public static int getLimit(final int pageSize) {
		return pageSize <= 0 ? PaginationInfo.DEFAULT_PAGE_SIZE : pageSize;
	}

	public static int getOffset(final int pageId, final int limit) {
		if (pageId <= 1) {
			return 0;
		}
		return (pageId - 1) * limit;
	}

	public int getCurPageId(final int pageId, final int totalPages) {
		if (pageId <= 0) {
			return 1;
		}
		if (pageId > totalPages) {
			return totalPages;
		}
		return pageId;
	}

	public final SqlSessionTemplate getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}
}
