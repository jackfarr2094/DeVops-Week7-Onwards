package com.nationwide.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
@NamedQuery(name = "Employees.getName",
			query = "select e.emp_name from Employees e where e.rempno=?1")
public class Employees {
	
	@Id
	private String rempno;
	private String emp_name;
	
	public Employees() {
	}

	public Employees(String rempno, String emp_name) {
		this.rempno = rempno;
		this.emp_name = emp_name;
	}

	public String getRempno() {
		return rempno;
	}

	public void setRempno(String rempno) {
		this.rempno = rempno;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
}
