package com.qk365.sample.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import com.qk365.base.persist.base.AbstractBaseMapperDAO;
import com.qk365.sample.core.SampleBean;
import com.qk365.sample.core.SampleBeanMapper;
import com.qk365.sample.dao.ISampleDao;

@Repository("sampleDaoImpl")
@DependsOn("sqlSessionTemplate")
public class SampleDaoImpl extends AbstractBaseMapperDAO<SampleBean, Long> implements ISampleDao {

	@Autowired(required = false)
	public SampleDaoImpl(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate) {
		super(sqlSessionTemplate);
	}

	@Override
	protected Class<SampleBeanMapper> getMapperClass() {
		return SampleBeanMapper.class;
	}

}
