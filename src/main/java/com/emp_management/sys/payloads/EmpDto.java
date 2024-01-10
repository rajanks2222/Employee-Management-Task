package com.emp_management.sys.payloads;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.util.Streamable;

import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter


public class EmpDto {
	private long id;
	private String name;
	private String position;
	private String department;
	private int salary;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public static Streamable<Order> stream() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
