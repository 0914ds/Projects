package com.qk365.base.webservice.client.oa.bean;



public class PurchaseManagerDto {
	private Integer perId;
	private String perName;

	public Integer getPerId() {
		return perId;
	}

	public void setPerId(Integer perId) {
		this.perId = perId;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	@Override
	public String toString() {
		return "PurchaseManager [perId=" + perId + ", perName=" + perName + "]";
	}

}
