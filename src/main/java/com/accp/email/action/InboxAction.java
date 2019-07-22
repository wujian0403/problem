package com.accp.email.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.accp.email.biz.InboxBiz;
import com.accp.email.biz.OutboxBiz;
import com.accp.email.pojo.Inbox;
import com.accp.email.pojo.Outbox;
import com.accp.email.vo.SelectVo;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/Inbox")
public class InboxAction {
	@Autowired
	private InboxBiz biz;
	
	@Autowired
	private OutboxBiz biz1;
	
	

	@GetMapping("inboxList")
	public PageInfo<Inbox> findinboxList(Integer pageNum, Integer pageSize, String startDate, String endDate,
			String eid, String topic, String outbox_name, Integer remove_status) {
		if (startDate.equals("")) {
			startDate = null;
		}
		if (endDate.equals("")) {
			endDate = null;
		}
		if (topic.equals("")) {
			topic = null;
		}
		if (outbox_name.equals("")) {
			outbox_name = null;
		}
		SelectVo vo = new SelectVo(eid, startDate, endDate, outbox_name, topic, remove_status);
		return biz.findInboxByEid(pageNum, pageSize, vo);
	}

	@GetMapping("selectSize")
	public Integer selectSize(String eid) {
		return biz.findInboxSize(eid);
	}

	@PutMapping("updateStatus0")
	public Map<String, String> updateStatus(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		Inbox inbo = new Inbox();
		inbo.setReadStatus(0);
		for (String i : list) {
			Inbox in = biz.getInbox(Integer.parseInt(i));
			if(in.getReceiptStatus()==1&&in.getReadStatus()==1) {
				Inbox box = new Inbox();
				box.setContent("对象已经阅读了你的邮件");
				box.setDraftStatus(1);
				box.setInboxEid(in.getOutboxEid());
				box.setInboxName(in.getOutboxName());
				box.setOutboxEid(in.getInboxEid());
				box.setOutboxName(in.getInboxName());
				box.setTopic("回执提示");
				biz.addInbox(box);
				inbo.setReceiptStatus(0);
			}
			inbo.setInboxId(Integer.parseInt(i));
			if (biz.modifyInbox(inbo) <= 0) {
				num = false;
			}

		}
		if (num) {
			map.put("code", "200");
			map.put("msg", "标记成功");
		} else {
			map.put("code", "300");
			map.put("msg", "标记失败");
		}
		return map;
	}

	@PutMapping("updateStatus1")
	public Map<String, String> updateStatus1(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		Inbox inbo = new Inbox();
		inbo.setReadStatus(1);
		for (String i : list) {
			inbo.setInboxId(Integer.parseInt(i));
			if (biz.modifyInbox(inbo) <= 0) {
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

	@PutMapping("remove")
	public Map<String, String> remove(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		for (String i : list) {
			if (biz.modifyInboxStatus(Integer.parseInt(i), 1) <= 0) {
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

	@PutMapping("recover")
	public Map<String, String> recover(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		for (String i : list) {
			if (biz.modifyInboxStatus(Integer.parseInt(i), 0) <= 0) {
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

	@DeleteMapping("deleteInbox")
	public Map<String, String> deleteInbox(@RequestBody List<String> list) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		for (String i : list) {
			if (biz.removeInbox(Integer.parseInt(i)) <= 0) {
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
	
	@PostMapping("insertInbox")
	public Map<String, String> insertInbox(@RequestBody Inbox in) {
		Map<String, String> map = new HashMap<String, String>();
		Boolean num = true;
		
		if (num) {
			map.put("code", "200");
		} else {
			map.put("code", "300");
		}
		return map;
	}
	
	@GetMapping("selectById/{bid}")
	public Inbox selectById(@PathVariable Integer bid) {
		Inbox inbo = new Inbox();
		inbo.setReadStatus(0);
		Inbox in = biz.getInbox(bid);
		if(in.getReceiptStatus()==1&&in.getReadStatus()==1) {
			Inbox box = new Inbox();
			box.setContent("对象已经阅读了你的邮件");
			box.setDraftStatus(1);
			box.setInboxEid(in.getOutboxEid());
			box.setInboxName(in.getOutboxName());
			box.setOutboxEid(in.getInboxEid());
			box.setOutboxName(in.getInboxName());
			box.setTopic("回执提示");
			biz.addInbox(box);
			inbo.setReceiptStatus(0);
		}
		inbo.setInboxId(bid);
		biz.modifyInbox(inbo);
		return biz.getInbox(bid);
	}
}
