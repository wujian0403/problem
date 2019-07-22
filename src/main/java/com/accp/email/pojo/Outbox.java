package com.accp.email.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Outbox implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.outbox_id
     *
     * @mbggenerated
     */
    private Integer outboxId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.topic
     *
     * @mbggenerated
     */
    private String topic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.createTime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.remove_status
     *
     * @mbggenerated
     */
    private Integer removeStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.receipt_status
     *
     * @mbggenerated
     */
    private Integer receiptStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.outbox_eid
     *
     * @mbggenerated
     */
    private String outboxEid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.inbox_eid
     *
     * @mbggenerated
     */
    private String inboxEid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.draft_status
     *
     * @mbggenerated
     */
    private Integer draftStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.outbox_name
     *
     * @mbggenerated
     */
    private String outboxName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column outbox.inbox_name
     *
     * @mbggenerated
     */
    private String inboxName;
    
    private List<String> strs;
    
    private List<String> abox;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table outbox
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.outbox_id
     *
     * @return the value of outbox.outbox_id
     *
     * @mbggenerated
     */
    
    
    public Integer getOutboxId() {
        return outboxId;
    }

    public List<String> getAbox() {
		return abox;
	}

	public void setAbox(List<String> abox) {
		this.abox = abox;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.outbox_id
     *
     * @param outboxId the value for outbox.outbox_id
     *
     * @mbggenerated
     */
    public void setOutboxId(Integer outboxId) {
        this.outboxId = outboxId;
    }
    
    

    public List<String> getStrs() {
		return strs;
	}

	public void setStrs(List<String> strs) {
		this.strs = strs;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.content
     *
     * @return the value of outbox.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.content
     *
     * @param content the value for outbox.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.topic
     *
     * @return the value of outbox.topic
     *
     * @mbggenerated
     */
    public String getTopic() {
        return topic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.topic
     *
     * @param topic the value for outbox.topic
     *
     * @mbggenerated
     */
    public void setTopic(String topic) {
        this.topic = topic == null ? null : topic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.createTime
     *
     * @return the value of outbox.createTime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.createTime
     *
     * @param createtime the value for outbox.createTime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.remove_status
     *
     * @return the value of outbox.remove_status
     *
     * @mbggenerated
     */
    public Integer getRemoveStatus() {
        return removeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.remove_status
     *
     * @param removeStatus the value for outbox.remove_status
     *
     * @mbggenerated
     */
    public void setRemoveStatus(Integer removeStatus) {
        this.removeStatus = removeStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.receipt_status
     *
     * @return the value of outbox.receipt_status
     *
     * @mbggenerated
     */
    public Integer getReceiptStatus() {
        return receiptStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.receipt_status
     *
     * @param receiptStatus the value for outbox.receipt_status
     *
     * @mbggenerated
     */
    public void setReceiptStatus(Integer receiptStatus) {
        this.receiptStatus = receiptStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.outbox_eid
     *
     * @return the value of outbox.outbox_eid
     *
     * @mbggenerated
     */
    public String getOutboxEid() {
        return outboxEid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.outbox_eid
     *
     * @param outboxEid the value for outbox.outbox_eid
     *
     * @mbggenerated
     */
    public void setOutboxEid(String outboxEid) {
        this.outboxEid = outboxEid == null ? null : outboxEid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.inbox_eid
     *
     * @return the value of outbox.inbox_eid
     *
     * @mbggenerated
     */
    public String getInboxEid() {
        return inboxEid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.inbox_eid
     *
     * @param inboxEid the value for outbox.inbox_eid
     *
     * @mbggenerated
     */
    public void setInboxEid(String inboxEid) {
        this.inboxEid = inboxEid == null ? null : inboxEid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.draft_status
     *
     * @return the value of outbox.draft_status
     *
     * @mbggenerated
     */
    public Integer getDraftStatus() {
        return draftStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.draft_status
     *
     * @param draftStatus the value for outbox.draft_status
     *
     * @mbggenerated
     */
    public void setDraftStatus(Integer draftStatus) {
        this.draftStatus = draftStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.outbox_name
     *
     * @return the value of outbox.outbox_name
     *
     * @mbggenerated
     */
    public String getOutboxName() {
        return outboxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.outbox_name
     *
     * @param outboxName the value for outbox.outbox_name
     *
     * @mbggenerated
     */
    public void setOutboxName(String outboxName) {
        this.outboxName = outboxName == null ? null : outboxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column outbox.inbox_name
     *
     * @return the value of outbox.inbox_name
     *
     * @mbggenerated
     */
    public String getInboxName() {
        return inboxName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column outbox.inbox_name
     *
     * @param inboxName the value for outbox.inbox_name
     *
     * @mbggenerated
     */
    public void setInboxName(String inboxName) {
        this.inboxName = inboxName == null ? null : inboxName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outbox
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Outbox other = (Outbox) that;
        return (this.getOutboxId() == null ? other.getOutboxId() == null : this.getOutboxId().equals(other.getOutboxId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getCreatetime() == null ? other.getCreatetime() == null : this.getCreatetime().equals(other.getCreatetime()))
            && (this.getRemoveStatus() == null ? other.getRemoveStatus() == null : this.getRemoveStatus().equals(other.getRemoveStatus()))
            && (this.getReceiptStatus() == null ? other.getReceiptStatus() == null : this.getReceiptStatus().equals(other.getReceiptStatus()))
            && (this.getOutboxEid() == null ? other.getOutboxEid() == null : this.getOutboxEid().equals(other.getOutboxEid()))
            && (this.getInboxEid() == null ? other.getInboxEid() == null : this.getInboxEid().equals(other.getInboxEid()))
            && (this.getDraftStatus() == null ? other.getDraftStatus() == null : this.getDraftStatus().equals(other.getDraftStatus()))
            && (this.getOutboxName() == null ? other.getOutboxName() == null : this.getOutboxName().equals(other.getOutboxName()))
            && (this.getInboxName() == null ? other.getInboxName() == null : this.getInboxName().equals(other.getInboxName()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table outbox
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOutboxId() == null) ? 0 : getOutboxId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getCreatetime() == null) ? 0 : getCreatetime().hashCode());
        result = prime * result + ((getRemoveStatus() == null) ? 0 : getRemoveStatus().hashCode());
        result = prime * result + ((getReceiptStatus() == null) ? 0 : getReceiptStatus().hashCode());
        result = prime * result + ((getOutboxEid() == null) ? 0 : getOutboxEid().hashCode());
        result = prime * result + ((getInboxEid() == null) ? 0 : getInboxEid().hashCode());
        result = prime * result + ((getDraftStatus() == null) ? 0 : getDraftStatus().hashCode());
        result = prime * result + ((getOutboxName() == null) ? 0 : getOutboxName().hashCode());
        result = prime * result + ((getInboxName() == null) ? 0 : getInboxName().hashCode());
        return result;
    }

    @Override
	public String toString() {
		return "Outbox [outboxId=" + outboxId + ", content=" + content + ", topic=" + topic + ", createtime="
				+ createtime + ", removeStatus=" + removeStatus + ", receiptStatus=" + receiptStatus + ", outboxEid="
				+ outboxEid + ", inboxEid=" + inboxEid + ", draftStatus=" + draftStatus + ", outboxName=" + outboxName
				+ ", inboxName=" + inboxName + ", strs=" + strs + "]";
	}
}