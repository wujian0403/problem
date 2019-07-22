package com.accp.email.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.email.biz.DepartmentBiz;
import com.accp.email.pojo.Department;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/depar")
public class DepartmentAction {
	@Autowired
	private DepartmentBiz biz;
	
	@GetMapping("selectDepartment")
	public List<Department> selectDepartment(){
		return biz.findDepartment();
	}
//	
//	@GetMapping("selectAll")
//	public PageInfo<Object> selectAll(Integer pageNum, Integer pageSize, String startDate, String endDate,
//			String eid, String topic, String outbox_name,String inbox_name,Integer type){
//		if(type==0) {
//			
//		}
//	}
}
