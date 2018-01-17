package com.qk365.sample.core;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qk365.base.persist.base.ISqlMapper;

public interface SampleBeanMapper extends ISqlMapper<SampleBean, Long> {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int countByExample(SampleBeanExample example); 
	

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int deleteByExample(SampleBeanExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int deleteByPrimaryKey(Integer cutId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int insert(SampleBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int insertSelective(SampleBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	List<SampleBean> selectByExample(SampleBeanExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	SampleBean selectByPrimaryKey(Integer cutId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int updateByExampleSelective(@Param("record") SampleBean record, @Param("example") SampleBeanExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int updateByExample(@Param("record") SampleBean record, @Param("example") SampleBeanExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int updateByPrimaryKeySelective(SampleBean record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table Customer_Tenant
	 *
	 * @mbggenerated Tue Oct 13 16:14:36 CST 2015
	 */
	int updateByPrimaryKey(SampleBean record);
}