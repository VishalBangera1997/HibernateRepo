package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mlocation")
public class Location {
	@Id
	private int lcode;
	
	private String lname;
	
	@ManyToMany(mappedBy = "locations" ,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Department> departments=new ArrayList<>();

	public Location() {
		super();
	}

	public Location(int lcode, String lname) {
		super();
		this.lcode = lcode;
		this.lname = lname;
		
	}

	public int getLcode() {
		return lcode;
	}

	public void setLcode(int lcode) {
		this.lcode = lcode;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	
	
	
	
	
	

}
