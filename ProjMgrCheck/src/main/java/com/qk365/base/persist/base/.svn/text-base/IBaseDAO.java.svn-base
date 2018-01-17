package com.qk365.base.persist.base;

import java.util.Date;
import java.util.List;

import com.qk365.base.persist.support.pagination.PaginationData;

/**
 * 
 * 基本的DAO接口
 *
 * @param <T>实体类型
 * @param <K>实体的主键类型
 */
public interface IBaseDAO<T,K> {
	
	/**
	 * 计算符合动态条件的记录条数.
	 * @param example 动态查询条件
	 * @return
	 */
	int countByCriteria(IModelExample example);

	/**
	 * 添加一条记录
	 * @param record 要新增的实体实例
	 */
	int add(T record);

	/**
	 * 选择地新增一条记录，如果字段不为null，则作为insert字段.
	 * @param record 要新增的实体实例
	 */
	int addSelective(T record);

	/**
	 * 查询符合动态条件的记录集合.
	 * @param example 动态查询条件
	 * @return
	 */
	List<T> getListByCriteria(IModelExample example);

	/**
	 * 根据主键查询实体.
	 * @param id 实体主键
	 * @return
	 */
	T getByPrimaryKey(K id);

	/**
	 * 根据条件有选择地修改实体.
	 * 如果record的字段为空，将不会出现在update语句中.
	 * @param record 要修改的数据
	 * @param example 动态条件
	 */
	int editByCriteriaSelective(T record,
			IModelExample example);

	/**
	 * 根据条件修改实体.
	 * 如果record的字段为null，将被更新为null.
	 * @param record 要修改的数据
	 * @param example 动态条件
	 */
	int editByCriteria(T record,
			IModelExample example);

	/**
	 * 有选择地按主键更新实体.
	 * 实体字段为null，将不出现在update语句中.
	 * @param record 要修改的数据
	 */
	int editByPrimaryKeySelective(T record);

	/**
	 * 按主键更新实体.
	 * 实体字段为null，在update语句中将被更新为null.
	 * @param record 要修改的数据
	 */
	int editByPrimaryKey(T record);
	
	/**
	 * 根据动态条件分页查询.
	 * @param example 动态查询条件
	 * @param pageId 要查询的页数
	 * @param pageSize 每页显示条数
	 * @return
	 */
	PaginationData<T> getByCriteria(IModelExample example, int pageId, int pageSize);
	
	/**
	 * 根据动态条件分页查询,使用默认的pageSize.
	 * @param example 动态查询条件
	 * @param pageId 要查询的页数
	 * @return
	 */
	PaginationData<T> getByCriteria(IModelExample example, int pageId);
	
	/**
	 * 获得数据库的系统时间.
	 * @return
	 */
	Date getSysDate();
	
	/**
	 * 根据主键删除
	 * @param key
	 */
	int deleteByPrimaryKey(K id);
	
	/**
	 * 根据动态条件删除数据
	 * @param example
	 * @return
	 */
	int deleteByExample(IModelExample example);
	
	/**
	 * 更新或添加资源
	 * @param record
	 * @param id
	 */
	int updateOrAdd(T record, K id);
	
	/**
	 * 动态条件查询实体对象
	 * @param example
	 * @return
	 */
	T getModelByCriteria(IModelExample example);

}
