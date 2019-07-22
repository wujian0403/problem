package com.accp.email.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.email.dao.AccessoryboxDao;
import com.accp.email.pojo.Accessorybox;
import com.accp.email.pojo.Inbox;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class AccessoryboxBiz {
	@Autowired
	private AccessoryboxDao dao;
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer addAccessorybox(Accessorybox box){
		return dao.insertSelective(box);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer removeAccessorybox(Integer outbox_id) {
		return dao.deleteByPrimaryKey(outbox_id);
	}
}
