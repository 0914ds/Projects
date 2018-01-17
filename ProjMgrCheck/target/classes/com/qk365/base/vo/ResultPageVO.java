package com.qk365.base.vo;

import com.qk365.base.persist.support.pagination.PaginationInfo;

/**
 * 带分页数据的结果对象
 */
public class ResultPageVO extends ResultVO {

	private PaginationInfo page;

	public PaginationInfo getPage() {
		return page;
	}

	public void setPage(PaginationInfo page) {
		this.page = page;
	}

}
