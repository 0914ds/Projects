package com.qk365.base.utils;

import java.util.ArrayList;
import java.util.List;

import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.base.vo.ResultVO;

/**
 * 分页工具类
 */
public class PageUtills {

	/**
	 * 服务端假分页
	 * @param result 业务层返回数据
	 * @param pageId 页码
	 * @param pageSize 每页记录数
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ResultVO doPage(ResultVO result ,int pageId, int pageSize){
		if(null == result.getData() || !(result.getData() instanceof List)){
			return result;
		}
		List list = (List) result.getData();
		int totalCount = list.size();
		int totalPages = 0;
		if(totalCount > 0){
			totalPages = (int) Math.ceil(totalCount * 1.0 / pageSize);
		}
		List resultList = new ArrayList();
		int index = (pageId - 1) * pageSize;
		while(true){
			if(resultList.size() == pageSize || index >= list.size()){
				break;
			}
			resultList.add(list.get(index));
			index += 1;
		}
		PaginationData page = new PaginationData(resultList, pageId, pageSize, totalPages, totalCount);
		return ResultUtils.buildSuccessData(page.getPageData(), page.getPageInfo());
	}
	
}
