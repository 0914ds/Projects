package com.qk365.precheck.dao.inter;

import java.util.List;

import com.qk365.base.persist.base.IBaseDAO;
import com.qk365.domain.Provincial;

public interface ProvincialDao extends IBaseDAO<Provincial,Long> {

	void findProvincil(List list);
	
	
}
