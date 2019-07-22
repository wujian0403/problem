package com.accp.email.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.email.dao.InboxDao;
import com.accp.email.dao.OutboxDao;
import com.accp.email.pojo.Inbox;
import com.accp.email.pojo.Outbox;
import com.accp.email.vo.SelectVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class OutboxBiz {
	@Autowired
	private OutboxDao dao;

	public PageInfo<Outbox> findInboxByEid(Integer pageNum, Integer pageSize, SelectVo vo) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<Outbox>(dao.selectByEid(vo));
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer removeOutbox(Integer outboxId) {
		return dao.deleteByPrimaryKey(outboxId);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer modeifyStatus(Outbox out) {
		return dao.updateByPrimaryKeySelective(out);
	}
	
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly = false)
	public Integer addOutbox(Outbox out) {
		dao.insertSelective(out);
		int id = out.getOutboxId();
		return id;
	}
	
	public Outbox getOutbox(Integer outboxId) {
		return dao.selectByPrimaryKey(outboxId);
	}

}
