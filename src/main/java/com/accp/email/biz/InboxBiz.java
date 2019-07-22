package com.accp.email.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.email.dao.InboxDao;
import com.accp.email.pojo.Inbox;
import com.accp.email.vo.SelectVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class InboxBiz {
	@Autowired
	private InboxDao dao;
	
	public PageInfo<Inbox> findInboxByEid(Integer pageNum,Integer pageSize,SelectVo vo){
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Inbox>(dao.selectByEid(vo));
	}
	
	public Integer findInboxSize(String eid) {
		if(dao.selectSizeByEid(eid)!=null) {
			return dao.selectSizeByEid(eid).size();
		}
		return 0;
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer modifyInbox(Inbox in){
		return dao.updateByPrimaryKeySelective(in);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer modifyInboxStatus(Integer status,Integer inboxId) {
		return dao.updateStatus(status,inboxId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer removeInbox(Integer inboxId){
		return dao.deleteByPrimaryKey(inboxId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer addInbox(Inbox record){
		dao.insertSelective(record);
		return record.getInboxId();
	}
	
	public Inbox getInbox(Integer inboxId) {
		return dao.selectByPrimaryKey(inboxId);
	}
	
}
