package com.qk365.precheck.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qk365.base.controller.ControllerTemplate;
import com.qk365.base.utils.ResultUtils;
import com.qk365.base.vo.ResultVO;
import com.qk365.precheck.service.PreCheckService;

public class PrecheckController extends ControllerTemplate {
	
	
   private ArrayList list;
	@Autowired
	private PreCheckService precheckService;

	/**
	 * sample
	 */
	@RequestMapping(value = "/celllist")
	public void cellList(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "int", required = true) Integer prcid,
			@RequestParam(value = "int", required = true) Integer prcid2
			){
		prcid=2;
		prcid=28;
		list = new ArrayList<Integer>();
		list.add(prcid);
		list.add(prcid2);
		precheckService.findProvincil(list);
		precheckService.findProvincil2(list);
		ResultVO result = ResultUtils.buildSuccessData(precheckService.findProvincil2(list));
		//this.outputResult(result, request, response);
        this.outputResult(result, request, response);
        
        
		
		/*ResultVO result = ResultUtils.buildSuccessData(sampleService.sample1());
		result.setValue(sampleService.sample2());
		result.setMessage(str);
		this.outputResult(result, request, response);*/
	}
	

}
