package com.accp.email.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.email.util.MD5Signature;
import com.accp.email.vo.EmployeeVo;
import com.accp.email.vo.SelectVo;
import com.accp.email.biz.DepartmentBiz;
import com.accp.email.biz.EmployeeBiz;
import com.accp.email.biz.InboxBiz;
import com.accp.email.pojo.Department;
import com.accp.email.pojo.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeAction {
	@Autowired
	private EmployeeBiz biz;
	@Autowired
	private DepartmentBiz biz1;
	@Autowired
	private InboxBiz biz2;
	@GetMapping("login/{eid}/{epwd}")
	public Map<String, String> login(@PathVariable String eid,@PathVariable String epwd,HttpSession session){
		Map<String, String> map = new HashMap<String,String>();
		SelectVo vo = new SelectVo();
		vo.setEid(eid);
		vo.setInbox_eid(eid);
		vo.setEpwd(MD5Signature.md5(epwd));
		Employee user = biz.getEmployee(vo);
		if(user!=null) {
			map.put("code", "200");
			Department dpt = biz1.getDepartmentById(user.getDepartmentId());
			EmployeeVo evo = new EmployeeVo(user,dpt);
			session.setAttribute("user", evo);;
		}else{
			map.put("code", "300");
		}
		return map;
	}
	
	@GetMapping("loginCheck/{eid}")
	public Map<String, String> login(@PathVariable String eid){
		Map<String, String> map =new HashMap<String,String>();
		SelectVo aa1 = new SelectVo();
		aa1.setEid(eid);
		if( biz.getEmployee(aa1)!=null) {
			map.put("code", "200");
		}else {
			map.put("code", "300");
		}
		return map;
	}
	
	@GetMapping("loginObj")
	public EmployeeVo loginObj(HttpSession session){
		return (EmployeeVo)session.getAttribute("user");
	}
	
	@GetMapping("loginout")
	public void loginout(HttpSession session){
		session.removeAttribute("user");
	}
	
	@GetMapping("all")
	public List<Employee> findAll(){
		return biz.findEmployee();
	}
}
