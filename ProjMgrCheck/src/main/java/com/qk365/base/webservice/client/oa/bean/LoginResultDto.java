package com.qk365.base.webservice.client.oa.bean;

import java.io.Serializable;
import java.util.List;

import com.qk365.base.utils.JsonUtil;

/**
 * 登录new_HouseRent数据库的登录结果对象
 * 
 * @author zhaoxy
 *
 */
public class LoginResultDto implements Serializable {

	private static final long serialVersionUID = 5203822726600847089L;

	private int result;
	private int userId;
	private String userNo = ""; // 员工号(A8)
	private String useraccount;
	private String userName;
	private String userEnName;
	private String perDistrict;
	private String perLastLogDate;
	private String postion;
	private String company;
	private List<PersonDto> personJsonDtoList;
	private List<PersonFunctionDto> personFunctionJsonDtoList;
	private List<PersonAreaDto> personAreaJsonDtoList;
	private List<PurchaseManagerDto> purchaseManagerList;
	private String serverscenterIds;
	private List<Object> positionIds;
	private String entryDate;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEnName() {
		return userEnName;
	}

	public void setUserEnName(String userEnName) {
		this.userEnName = userEnName;
	}

	public String getPerDistrict() {
		return perDistrict;
	}

	public void setPerDistrict(String perDistrict) {
		this.perDistrict = perDistrict;
	}

	public String getPerLastLogDate() {
		return perLastLogDate;
	}

	public void setPerLastLogDate(String perLastLogDate) {
		this.perLastLogDate = perLastLogDate;
	}

	public String getPostion() {
		return postion;
	}

	public void setPostion(String postion) {
		this.postion = postion;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<PersonDto> getPersonJsonDtoList() {
		return personJsonDtoList;
	}

	public void setPersonJsonDtoList(List<PersonDto> personJsonDtoList) {
		this.personJsonDtoList = personJsonDtoList;
	}

	public List<PersonFunctionDto> getPersonFunctionJsonDtoList() {
		return personFunctionJsonDtoList;
	}

	public void setPersonFunctionJsonDtoList(List<PersonFunctionDto> personFunctionJsonDtoList) {
		this.personFunctionJsonDtoList = personFunctionJsonDtoList;
	}

	public List<PersonAreaDto> getPersonAreaJsonDtoList() {
		return personAreaJsonDtoList;
	}

	public void setPersonAreaJsonDtoList(List<PersonAreaDto> personAreaJsonDtoList) {
		this.personAreaJsonDtoList = personAreaJsonDtoList;
	}

	public List<PurchaseManagerDto> getPurchaseManagerList() {
		return purchaseManagerList;
	}

	public void setPurchaseManagerList(List<PurchaseManagerDto> purchaseManagerList) {
		this.purchaseManagerList = purchaseManagerList;
	}

	public String getServerscenterIds() {
		return serverscenterIds;
	}

	public void setServerscenterIds(String serverscenterIds) {
		this.serverscenterIds = serverscenterIds;
	}

	public String getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(String useraccount) {
		this.useraccount = useraccount;
	}

	@Override
	public String toString() {
		return JsonUtil.beanToJson(this);
	}

	public List<Object> getPositionIds() {
		return positionIds;
	}

	public void setPositionIds(List<Object> positionIds) {
		this.positionIds = positionIds;
	}

	public String getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

}
