package com.qk365.base.webservice.client.oa.bean;




public class PersonAreaDto {
	private String city;
	private String district;
	private String servicecenter;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getServicecenter() {
		return servicecenter;
	}

	public void setServicecenter(String servicecenter) {
		this.servicecenter = servicecenter;
	}

	@Override
	public String toString() {
		return "PersonArea [city=" + city + ", district=" + district + ", servicecenter=" + servicecenter + "]";
	}

}
