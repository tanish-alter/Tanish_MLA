package com.test;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
//@Table(name = "student")
//@PrimaryKeyJoinColumn(name = "ID")
public class Student extends College{
	
	private String s_type;
	private String s_branch;
	public Student(){
		
	}
	public Student(int id, String c_name, String s_type, String s_branch) {
		super(id, c_name);
		this.s_type = s_type;
		this.s_branch = s_branch;
	}
	public String getS_type() {
		return s_type;
	}
	public void setS_type(String s_type) {
		this.s_type = s_type;
	}
	public String getS_branch() {
		return s_branch;
	}
	public void setS_branch(String s_branch) {
		this.s_branch = s_branch;
	}
	
	
}