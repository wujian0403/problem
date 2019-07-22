package email;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.accp.email.biz.EmployeeBiz;
import com.accp.email.biz.InboxBiz;
import com.accp.email.pojo.Employee;
import com.accp.email.pojo.Inbox;
import com.accp.email.util.MD5Signature;
import com.accp.email.vo.SelectVo;
import com.github.pagehelper.PageInfo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-ctx.xml" })
public class Test{

	@Autowired
	private EmployeeBiz biz;
	@Autowired
	private InboxBiz biz1;
	@org.junit.Test
	public void Test() {
//		List<Employee> user= biz.findEmployee();
//		for (Employee employee : user) {
//			System.out.println(employee.toString());
//		}
//		SelectVo aa1 = new SelectVo();
//		aa1.setEid("E2018001");
//		aa1.setEpwd("123");
//		Employee aa = biz.getEmployee(aa1);
//		System.out.println(aa);
	}
}
