package com.test;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String e_name;

    private String e_cmp;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")   // Owning side
    private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public String getE_cmp() {
		return e_cmp;
	}

	public void setE_cmp(String e_cmp) {
		this.e_cmp = e_cmp;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    
}