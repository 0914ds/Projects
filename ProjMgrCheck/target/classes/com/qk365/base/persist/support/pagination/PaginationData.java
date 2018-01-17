package com.qk365.base.persist.support.pagination;

import java.util.Collections;
import java.util.List;

public class PaginationData<T> {

	private final List<T> pageData;
	private final PaginationInfo pageInfo;

	public PaginationData(final List<T> data, final int pageId, final int totalPages, final int totalCount) {
		this(data, pageId, PaginationInfo.DEFAULT_PAGE_SIZE, totalPages, totalCount);
	}

	public PaginationData(final List<T> data, final int pageId, final int pageSize, final int totalPages,
			final int totalCount) {
		pageData = Collections.unmodifiableList(data);
		pageInfo = new PaginationInfo(pageId, pageSize, totalPages, totalCount);
	}

	public PaginationData(final List<T> pageData, final PaginationInfo pageInfo) {
		this.pageData = pageData;
		this.pageInfo = pageInfo;
	}

	public final List<T> getPageData() {
		return pageData;
	}

	public final PaginationInfo getPageInfo() {
		return pageInfo;
	}

}
