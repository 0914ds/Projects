package com.qk365.precheck.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qk365.base.dao.CustomDaoImpl;
import com.qk365.base.persist.support.pagination.PaginationData;
import com.qk365.domain.Provincial;
import com.qk365.domain.ProvincialExample;
import com.qk365.precheck.dao.inter.ProvincialDao;

@Service
public class PreCheckService {

	@Autowired
	private CustomDaoImpl customDao;
	
	@Autowired
	private ProvincialDao provincialdao;

	public void findProvincil(ArrayList list) {
		provincialdao.findProvincil(list);
	}

	/**
	 * 
	 * @param str
	 * @return
	 */
	public String findProvincil2(List<Integer> list) {
       
		//		PaginationData<Provincial> page =  provincialdao.getByCriteria(example, pageId, pageSize)
		//		List<Integer> list1 = new ArrayList<Integer>();
		//		list1.add(1);
		//		list1.add(2);
		//		list1.add(3);
		//		pbe.or().andCutIdIn(list1);
		//		// sbe.or();
		//		PaginationData<SampleBean> page = precheckdao.getByCriteria(sbe, 1, 10);
		//		List<SampleBean> list = page.getPageData();

		/** 根据 prcid查询provincial表信息 */
		ProvincialExample  pbe = new ProvincialExample();
		pbe.or().andPrcIdIn(list);
		PaginationData<Provincial> page =  provincialdao.getByCriteria(pbe, 1, 10);
		List<Provincial> provincialinfo = page.getPageData();
		
		return provincialinfo.toString();
	}
	
}
