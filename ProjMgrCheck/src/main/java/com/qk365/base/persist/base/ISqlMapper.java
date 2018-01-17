package com.qk365.base.persist.base;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * Interface ISqlMapper only identifies the semantics of being MyBatis's Mappers.
 */
public interface ISqlMapper<T,K> {
	
	int countByExample(IModelExample example);

	int insert(T record);

	int insertSelective(T record);

	List<T> selectByExample(IModelExample example);

	T selectByPrimaryKey(K id);

	int updateByExampleSelective(@Param("record") T record,
			@Param("example") IModelExample example);

	int updateByExample(@Param("record") T record,
			@Param("example") IModelExample example);

	int updateByPrimaryKeySelective(T record);

	int updateByPrimaryKey(T record);

}
