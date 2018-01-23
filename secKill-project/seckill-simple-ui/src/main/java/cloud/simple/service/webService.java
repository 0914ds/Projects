/*
 * Copyright 2012-2020 the original author or authors.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * @author lzhoumail@126.com/zhouli
 * Git http://git.oschina.net/zhou666/spring-cloud-7simple
 */
package cloud.simple.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cloud.seckilled.service.dto.Exposer;
import cloud.seckilled.service.model.Seckill;
import cloud.simple.model.User;

@Service
public class webService {
	 @Autowired	 
	 RestTemplate restTemplate;
	
	 /*@Autowired
	 FeignUserService feignUserService;*/
	 
	 final String SERVICE_NAME="http://cloud-seckill-service/seckill";
	 
	 public List<Seckill> getSeckillList(){
		 
		 return restTemplate.getForObject("SERVICE_NAME"+"/list", List.class);
	 }
	 
	 public Seckill getById(Long seckillId) {
		 
		 return restTemplate.getForObject("SERVICE_NAME"+"/{seckillId}", Seckill.class); 
	 }
	 
	 public Exposer exportSeckillUrl(Long seckillId) {
			
	        Seckill seckill =	getById(seckillId);
	       
	        if (seckill == null) {
	            return new Exposer(false, seckillId);
	        }
	    	
	        Date startTime = seckill.getStartTime();
	        Date endTime = seckill.getEndTime();

	        Date nowTime = new Date();

	        if (nowTime.getTime() > endTime.getTime() || nowTime.getTime() < startTime.getTime()) {
	            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
	        }

	        //转化特定字符串的过程,不可逆
	        String md5 = getMD5(seckillId);
	        return new Exposer(true, md5, seckillId);
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @HystrixCommand(fallbackMethod = "fallbackSearchAll")
	 public List<User> readUserInfo() {
	        return restTemplate.getForObject("http://"+SERVICE_NAME+"/user", List.class);
		 //return feignUserService.readUserInfo();
	 }	 
	 private List<User> fallbackSearchAll() {
		 System.out.println("HystrixCommand fallbackMethod handle!");
		 List<User> ls = new ArrayList<User>();
		 User user = new User();
		 user.setUsername("TestHystrixCommand");
		 ls.add(user);
		 return ls;
	 }
}
