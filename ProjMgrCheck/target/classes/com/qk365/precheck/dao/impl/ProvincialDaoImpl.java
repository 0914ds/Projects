package com.qk365.precheck.dao.impl;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;
import com.qk365.base.persist.base.AbstractBaseMapperDAO;
import com.qk365.domain.Provincial;
import com.qk365.domain.ProvincialMapper;
import com.qk365.precheck.dao.inter.ProvincialDao;

@Repository("provincialSampleImpl")
@DependsOn("sqlSessionTemplate")
public class ProvincialDaoImpl extends AbstractBaseMapperDAO<Provincial, Long> implements ProvincialDao {

	@Autowired(required = false)
	public ProvincialDaoImpl(@Qualifier("sqlSessionTemplate") SqlSessionTemplate sqlSessionTemplate) {
		super(sqlSessionTemplate);
	}
	@Override
	public void findProvincil(List list) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	@Override
	protected Class<ProvincialMapper> getMapperClass() {
		return ProvincialMapper.class;
	}

}
