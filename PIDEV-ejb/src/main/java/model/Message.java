package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Message implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "VARCHAR(6000)")
	private String messageContent;
	private int senderId ;
	private boolean user1Deleted = false;
	private boolean user2Deleted = false;
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	@Temporal(TemporalType.TIMESTAMP)
	private Date Seen;
	@ManyToOne
	private Discussion discussion ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public int getSenderId() {
		return senderId;
	}
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Discussion getDiscussion() {
		return discussion;
	}
	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date getSeen() {
		return Seen;
	}
	public void setSeen(Date seen) {
		Seen = seen;
	}
	public boolean isUser1Deleted() {
		return user1Deleted;
	}
	public void setUser1Deleted(boolean user1Deleted) {
		this.user1Deleted = user1Deleted;
	}
	public boolean isUser2Deleted() {
		return user2Deleted;
	}
	public void setUser2Deleted(boolean user2Deleted) {
		this.user2Deleted = user2Deleted;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", messageContent=" + messageContent + ", senderId=" + senderId + ", user1Deleted="
				+ user1Deleted + ", user2Deleted=" + user2Deleted + ", created_at=" + created_at + ", updated_at="
				+ updated_at + ", Seen=" + Seen + ", discussion=" + discussion + "]";
	}
	
	

}
