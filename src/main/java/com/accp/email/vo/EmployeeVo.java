package com.accp.email.vo;

import com.accp.email.pojo.Department;
import com.accp.email.pojo.Employee;

public class EmployeeVo {
	private Employee user;
	private Department dpt;
	private Integer inboxSize;
	public Employee getUser() {
		return user;
	}
	public void setUser(Employee user) {
		this.user = user;
	}
	public Department getDpt() {
		return dpt;
	}
	public void setDpt(Department dpt) {
		this.dpt = dpt;
	}
	public Integer getInboxSize() {
		return inboxSize;
	}
	public void setInboxSize(Integer inboxSize) {
		this.inboxSize = inboxSize;
	}
	public EmployeeVo(Employee user, Department dpt, Integer inboxSize) {
		super();
		this.user = user;
		this.dpt = dpt;
		this.inboxSize = inboxSize;
	}
	public EmployeeVo(Employee user, Department dpt) {
		super();
		this.user = user;
		this.dpt = dpt;
	}
	public EmployeeVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeVo [user=" + user + ", dpt=" + dpt + ", inboxSize=" + inboxSize + "]";
	}
	
	
}
