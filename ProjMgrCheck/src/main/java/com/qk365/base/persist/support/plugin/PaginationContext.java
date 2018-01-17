package com.qk365.base.persist.support.plugin;

public class PaginationContext {

	/**
	 * 分页参数上下文，
	 */
	private static final ThreadLocal<Integer> PAGE_CONTEXT_THREAD_LOCAL = new ThreadLocal<Integer>();

	public static int getPageContext() {
		Integer totalCount = PAGE_CONTEXT_THREAD_LOCAL.get();
		if (totalCount == null) {
			totalCount = new Integer(0);
			PAGE_CONTEXT_THREAD_LOCAL.set(totalCount);
		}
		return totalCount.intValue();
	}

	/**
	 * 清理分页参数上下文
	 */
	public static void removeContext() {
		PAGE_CONTEXT_THREAD_LOCAL.remove();
	}

	public static void setContext(Integer count) {
		if (count == null) {
			count = 0;
		}
		PAGE_CONTEXT_THREAD_LOCAL.set(count);
	}
}
