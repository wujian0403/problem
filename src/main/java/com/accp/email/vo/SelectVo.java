package com.accp.email.vo;


public class SelectVo {
	private String eid;
	private String epwd = null;
	private String startDate = null;
	private String endDate  = null;
	private String outbox_name = null;
	private String topic = null;
	private Integer remove_status = null;
	private Integer draft_status = null;
	
	
	
	public Integer getDraft_status() {
		return draft_status;
	}
	public void setDraft_status(Integer draft_status) {
		this.draft_status = draft_status;
	}
	public Integer getRemove_status() {
		return remove_status;
	}
	public void setRemove_status(Integer remove_status) {
		this.remove_status = remove_status;
	}
	public String getOutbox_name() {
		return outbox_name;
	}
	public void setOutbox_name(String outbox_name) {
		this.outbox_name = outbox_name;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	private String inbox_eid;
	
	public String getInbox_eid() {
		return inbox_eid;
	}
	public void setInbox_eid(String inbox_eid) {
		this.inbox_eid = inbox_eid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public SelectVo(String eid, String startDate, String endDate) {
		super();
		this.eid = eid;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public String getEpwd() {
		return epwd;
	}
	public void setEpwd(String epwd) {
		this.epwd = epwd;
	}
	
	public SelectVo(String eid, String startDate, String endDate, String outbox_name, String topic) {
		super();
		this.eid = eid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outbox_name = outbox_name;
		this.topic = topic;
	}
	public SelectVo(String eid, String epwd, String startDate, String endDate) {
		super();
		this.eid = eid;
		this.epwd = epwd;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public SelectVo(String eid, String startDate, String endDate, String outbox_name, String topic,
			Integer remove_status) {
		super();
		this.eid = eid;
		this.startDate = startDate;
		this.endDate = endDate;
		this.outbox_name = outbox_name;
		this.topic = topic;
		this.remove_status = remove_status;
	}
	public SelectVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SelectVo [eid=" + eid + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
