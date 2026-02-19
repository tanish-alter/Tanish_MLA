package com.test;

public class Student {
	private int USN;
	
	private String name;
	
	private String sch;
	
	private String city;

	public int getUSN() {
		return USN;
	}

	public void setUSN(int uSN) {
		USN = uSN;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [USN=" + USN + ", name=" + name + ", school=" + sch + ", city=" + city + "]";
	}
	
}