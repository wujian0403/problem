package com.accp.email.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.email.dao.EmployeeDao;
import com.accp.email.pojo.Employee;
import com.accp.email.vo.SelectVo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class EmployeeBiz {
	@Autowired
	private EmployeeDao dao;
	
	public Employee getEmployee(SelectVo vo){
		return dao.selectByPrimaryKey(vo);
	}
	
	public List<Employee> findEmployee(){
		return dao.selectAll();
	}
	
	public Employee getEmployeeById(String id) {
		return dao.selectById(id);
	}
}
