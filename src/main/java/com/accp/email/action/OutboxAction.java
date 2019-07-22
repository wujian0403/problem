package com.accp.email.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accp.email.biz.AccessoryboxBiz;
import com.accp.email.biz.EmployeeBiz;
import com.accp.email.biz.InboxBiz;
import com.accp.email.biz.OutboxBiz;
import com.accp.email.pojo.Accessorybox;
import com.accp.email.pojo.Inbox;
import com.accp.email.pojo.Outbox;
import com.accp.email.vo.SelectVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/Outbox")
public class OutboxAction {
	@Autowired
	private OutboxBiz biz;
	
	@Autowired
	private InboxBiz biz3;
	
	@Autowired
	private EmployeeBiz biz1;
	
	@Autowired
	private AccessoryboxBiz biz2;
	
	@GetMapping("outboxList")
	public PageInfo<Outbox> findinboxList(Integer pageNum,Integer pageSize,String startDate,String endDate,String eid,String topic,String outbox_name,Integer remove_status){
		if(startDate.equals("")) {
			startDate=null;
		}
		if(endDate.equals("")) {
			endDate=null;
		}
		if(topic.equals("")) {
			topic=null;
		}
		if(outbox_name.equals("")) {
			outbox_name=null;
		}
		SelectVo vo = new SelectVo(eid,startDate,endDate,outbox_name,topic,remove_status);
		vo.setDraft_status(0);
		return biz.findInboxByEid(pageNum, pageSize, vo);
	}
	
	@GetMapping("outboxList1")
	public PageInfo<Outbox> findinboxList1(Integer pageNum,Integer pageSize,String startDate,String endDate,String eid,String topic,String outbox_name,Integer draft_status){
		if(startDate.equals("")) {
			startDate=null;
		}
		if(endDate.equals("")) {
			endDate=null;
		}
		if(topic.equals("")) {
			topic=null;
		}
		if(outbox_name.equals("")) {
			outbox_name=null;
		}
		SelectVo vo = new SelectVo(eid,startDate,endDate,outbox_name,topic);
		vo.setDraft_status(draft_status);
		return biz.findInboxByEid(pageNum, pageSize, vo);
	}
	
	@DeleteMapping("deleteOutbox")
	public Map<String, String> deleteOutbox(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		for (String i : list) {
			if(biz.getOutbox(Integer.parseInt(i)).getDraftStatus()==0) {
				biz2.removeAccessorybox(Integer.parseInt(i));
			}
			if (biz.removeOutbox(Integer.parseInt(i)) <= 0) {
				num = false;
			}
		}
		if (num) {
			map.put("code", "200");
		} else {
			map.put("code", "300");
		}
		return map;
	}
	
	@PostMapping("insertOutbox0")
	public Map<String, String> insertOutbox0(@RequestBody Outbox out) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		List<Integer> inboxs = new ArrayList<Integer>();
		out.setDraftStatus(0);
		String[] eids = out.getInboxEid().split(",");
		String names = "";
		for (String string : eids) {
			names+=","+biz1.getEmployeeById(string).getEname();
		}
		names = names.substring(names.indexOf(",")+1,names.length());
		out.setInboxName(names);
		out.setOutboxName(biz1.getEmployeeById(out.getOutboxEid()).getEname());
		if(out.getOutboxId()!=null) {
			biz.removeOutbox(out.getOutboxId());
			biz2.removeAccessorybox(out.getOutboxId());
		}
		Integer i = biz.addOutbox(out);
			for (String string : eids) {
				Accessorybox box = new Accessorybox();
				box.setOutboxId(i);
				Inbox in = new Inbox();
				in.setContent(out.getContent());
				in.setDraftStatus(0);
				in.setInboxEid(string);
				in.setInboxName(out.getInboxName());
				in.setOutboxEid(out.getOutboxEid());
				in.setOutboxName(out.getOutboxName());
				in.setReadStatus(1);
				in.setTopic(out.getTopic());
				in.setInboxEid(string);
				in.setReceiptStatus(1);
				box.setInboxId(biz3.addInbox(in));
				for (String string2 : out.getStrs()) {
						box.setPath(string2);
					biz2.addAccessorybox(box);
				}
			}
		if (num) {
			map.put("code", "200");
		} else {
			map.put("code", "300");
		}
		return map;
	}
	
	@PostMapping("insertOutbox1")
	public Map<String, String> insertOutbox1(@RequestBody Outbox out) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		List<Integer> inboxs = new ArrayList<Integer>();
		out.setDraftStatus(1);
		String[] eids = out.getInboxEid().split(",");
		String names = "";
		for (String string : eids) {
			names+=","+biz1.getEmployeeById(string).getEname();
		}
		names = names.substring(names.indexOf(",")+1,names.length());
		out.setInboxName(names);
		out.setOutboxName(biz1.getEmployeeById(out.getOutboxEid()).getEname());
		if(out.getOutboxId()!=null) {
			biz.removeOutbox(out.getOutboxId());
			biz2.removeAccessorybox(out.getOutboxId());
		}
		Integer i = biz.addOutbox(out);
			for (String string : eids) {
				Accessorybox box = new Accessorybox();
				box.setOutboxId(i);
				for (String string2 : out.getStrs()) {
					box.setPath(string2);
					biz2.addAccessorybox(box);
				}
			}
		if (num) {
			map.put("code", "200");
		} else {
			map.put("code", "300");
		}
		return map;
	}
	
	@GetMapping("selectById/{bid}")
	public Outbox selectById(@PathVariable Integer bid) {
		return biz.getOutbox(bid);
	}
}
