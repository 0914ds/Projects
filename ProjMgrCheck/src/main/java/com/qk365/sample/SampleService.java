package com.qk365.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qk365.base.dao.CustomDaoImpl;
import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.sample.core.SampleBean;
import com.qk365.sample.core.SampleBeanExample;
import com.qk365.sample.dao.ISampleDao;

@Service
public class SampleService {
	@Autowired
	private CustomDaoImpl customDao;

	@Autowired
	private ISampleDao sampleDao;

	public String sample1() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Integer recNum = customDao.selectCount("sampleSql", paramMap);
		return "Room表一共有" + recNum + "条数据";
	}

	public String sample2() {
		SampleBeanExample sbe = new SampleBeanExample();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		sbe.or().andCutIdIn(list1);
		// sbe.or();
		PaginationData<SampleBean> page = sampleDao.getByCriteria(sbe, 1, 10);
		List<SampleBean> list = page.getPageData();
		return list.toString();
	}
}
