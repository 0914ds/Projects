package com.qk365.base.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.base.persist.support.pagination.PaginationInfo;
import com.qk365.base.vo.ResultPageVO;
import com.qk365.base.vo.ResultVO;

/**
 * 消息结果工具类
 */
public class ResultUtils {

	private static final Logger logger = Logger.getLogger(ResultUtils.class);

	/**
	 * 构建执行正确的消息返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultVO buildSuccessMessage(String msg) {
		ResultVO vo = new ResultVO();
		vo.setCode(ResultVO.Result_Success);
		vo.setMessage(msg);
		return vo;
	}

	/**
	 * 构建执行正确的消息返回结果-默认消息
	 */
	public static ResultVO buildSuccessMessage() {
		return buildSuccessMessage("success");
	}

	/**
	 * 构建执行正确的数据返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultVO buildSuccessData(Object data) {
		ResultVO vo = new ResultVO();
		vo.setCode(ResultVO.Result_Success);
		vo.setData(data);
		return vo;
	}

	/**
	 * 构建执行正确的数据返回结果-带分页数据
	 * 
	 * @param obj
	 * @param pageInfo
	 * @return
	 */
	public static ResultVO buildSuccessData(Object data, PaginationInfo pageInfo) {
		ResultPageVO vo = new ResultPageVO();
		vo.setCode(ResultVO.Result_Success);
		vo.setData(data);
		vo.setPage(pageInfo);
		return vo;
	}

	/**
	 * 构建空分页返回结果集
	 * 
	 * @param clazz
	 * @param pageId
	 * @param pageSize
	 * @return
	 */
	public static <T> ResultVO buildSuccessEmptyPageData(Class<T> clazz, Integer pageId, Integer pageSize) {
		PaginationData<T> page = new PaginationData<T>(new ArrayList<T>(), pageId, pageSize, 0, 0);
		return ResultUtils.buildSuccessData(page.getPageData(), page.getPageInfo());
	}

	/**
	 * 构建执行异常的数据返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultVO buildErrorData(Object data) {
		ResultVO vo = new ResultVO();
		vo.setCode(ResultVO.Result_Error);
		vo.setData(data);
		return vo;
	}

	/**
	 * 构建执行异常的消息返回结果
	 * 
	 * @param msg
	 * @return
	 */
	public static ResultVO buildErrorMessage(String msg) {
		ResultVO vo = new ResultVO();
		vo.setCode(ResultVO.Result_Error);
		vo.setMessage(msg);
		return vo;
	}

	/**
	 * 实体列表转实体ID列表
	 * 
	 * @param result
	 * @param claszz
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<Long> searchResultToKeyList(ResultVO result, Class<T> clazz) {
		List<Long> idList = new ArrayList<Long>();
		try {
			Object obj = result.getData();
			List<T> list = null;
			if (obj instanceof PaginationData) {
				PaginationData<T> page = (PaginationData<T>) obj;
				list = page.getPageData();
			} else {
				list = (List<T>) result.getData();
			}
			Method method = clazz.getDeclaredMethod("getId");
			if (list.size() > 0) {
				for (T t : list) {
					Long id = (Long) method.invoke(t);
					idList.add(id);
				}
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return idList;
	}

}
