package com.mphasis.training.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Job {
	
	@Id
	private String jcode;
	
	private String jname;
	
	@OneToMany(mappedBy = "job",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<Employee> employees=new ArrayList<Employee>();
	

	public Job() {
		super();
	}

	public Job(String jcode, String jname, List<Employee> employees) {
		super();
		this.jcode = jcode;
		this.jname = jname;
		this.employees = employees;
	}

	public String getJcode() {
		return jcode;
	}

	public void setJcode(String jcode) {
		this.jcode = jcode;
	}

	public String getJname() {
		return jname;
	}

	public void setJname(String jname) {
		this.jname = jname;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
