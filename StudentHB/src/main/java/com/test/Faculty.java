package com.test;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("faculy")
public class Faculty extends College{
	private String f_type;
	private String f_skill;
	public Faculty() {
		
	}
	public Faculty(int id, String c_name, String f_type, String f_skill) {
		super(id, c_name);
		this.f_type = f_type;
		this.f_skill = f_skill;
	}
	public String getF_type() {
		return f_type;
	}
	public void setF_type(String f_type) {
		this.f_type = f_type;
	}
	public String getF_skill() {
		return f_skill;
	}
	public void setF_skill(String f_skill) {
		this.f_skill = f_skill;
	}
	
}