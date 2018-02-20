package com.hit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Netanel & Shoval
 * Item class mapped by Hibernate into a table witch called "ITEMS",
 * item presenting a task that the client created.
 * 
 */

@Entity
@Table(name = "ITEMS")
public class Item {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="USER_ID")
	private long userId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_DATETIME")
	private Date createdDateTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DATETIME")
	private Date dateTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	
	public Item() {}
	
	
	/**
	 * Item constructor with arguments
	 * @param task
	 * @param title
	 * @param memberId
	 * @param createdDateTime
	 * @param dateTime
	 * @param status
	 */
	public Item(String content, String title, long userId, Date dateTime, Status status) {
		setContent(content);
		setTitle(title);
		setUserId(userId);
		setDateTime(dateTime);
		setStatus(status);
	}
	
	/**
	 * get item ID
	 * @return item ID
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set item ID
	 * @param id
	 */
	public void setId(long id) {
		if(id <= 0) {
			throw new IllegalArgumentException("id cannot be zero or negative number");
		}
		this.id = id;
	}
	
	/**
	 * get the content
	 * @return content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * set content
	 * @param content
	 */
	public void setContent(String content) {
		if(content == null || content.isEmpty()){
            throw new NullPointerException("Content cannot be empty");
        }
		this.content = content;
	}
	
	/**
	 * get title
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * set title
	 * @param title
	 */
	public void setTitle(String title) {
		if(title == null || title.isEmpty()){
            throw new NullPointerException("Title cannot be empty");
        }
		this.title = title;
	}
	
	/**
	 * get the user ID
	 * @return user id
	 */
	public long getUserId() {
		return userId;
	}
	
	/**
	 * set the user ID
	 * @param userId
	 */
	public void setUserId(long userId) {
		if(userId <= 0) {
			throw new IllegalArgumentException("user ID cannot be zero or negative number");
		}
		this.userId = userId;
	}
	
	
	/**
	 * get the task date time
	 * @return date time
	 */
	public Date getDateTime() {
		return dateTime;
	}
	
	/**
	 * set the date time of the task
	 * @param dateTime
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	/**
	 * get status
	 * @return status
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * set status of task (Completed/Pending)
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}	
	
}
