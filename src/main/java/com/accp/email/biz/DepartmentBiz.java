package com.accp.email.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.email.dao.DepartmentDao;
import com.accp.email.pojo.Department;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class DepartmentBiz {
	@Autowired
	private DepartmentDao dao;
	
	public Department getDepartmentById(Integer id) {
		return dao.selectByPrimaryKey(id);
	}
	
	public List<Department> findDepartment(){
		return dao.selectAll();
	}
}
