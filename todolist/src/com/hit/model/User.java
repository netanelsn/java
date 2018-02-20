package com.hit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Netanel & Shoval
 * User class mapped by Hibernate into a table witch called "USERS"
 *
 */
@Entity
@Table(name = "USERS")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")	
	private long id;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="FIRSTNAME")
	private String firstname;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LASTLOGIN")
	private Date dateTime;
	
	public User() {
		this("default-username", "default-password", "default-firstname", "default-lastname", new Date());
	}
	
	/**
	 * User constructor with arguments
	 * @param username
	 * @param password
	 * @param firstname
	 * @param lastname
	 * @param dateTime
	 */
	public User(String username, String password, String firstname, String lastname, Date dateTime) {
		setUsername(username);
		setPassword(password);
		setUsername(username);
		setLastname(lastname);
		setDateTime(dateTime);
	}
	
	/**
	 * get user ID
	 * @return user ID
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * set user ID
	 * @param id
	 */
	public void setId(long id) {
		
		if(id <= 0) {
			throw new IllegalArgumentException("id cannot be zero or negative number");
		}
		
		this.id = id;
	}
	
	/**
	 * get username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * set username
	 * @param username
	 */
	public void setUsername(String username) {
		if(username == null || username.isEmpty()){
            throw new NullPointerException("Username cannot be empty");
        }
		this.username = username;
	}
	
	/**
	 * get password
	 * @return
	 */
	public String getPassword() 
	{
		return password;
	}
	
	/**
	 * set password
	 * @param password
	 */
	public void setPassword(String password) 
	{
		if(password == null || password.isEmpty()){
            throw new NullPointerException("Password cannot be null");
        }
		this.password = password;
	}
	
	/**
	 * get firstname
	 * @return firstname
	 */
	public String getFirstname() 
	{
		return firstname;
	}
	
	/**
	 * set firstname
	 * @param firstname
	 */
	public void setFirstname(String firstname) 
	{
		if(firstname == null || firstname.isEmpty()){
            throw new NullPointerException("Firstname cannot be empty");
        }
		this.firstname = firstname;
	}
	
	/**
	 * get lastname
	 * @return lastname
	 */
	public String getLastname() 
	{
		return lastname;
	}
	
	/**
	 * set lastname
	 * @param lastname
	 */
	public void setLastname(String lastname) 
	{
		if(lastname == null || lastname.isEmpty()){
            throw new NullPointerException("Lastname cannot be empty");
        }
		this.lastname = lastname;
	}
	
	/**
	 * get login time
	 * @return dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}
	
	/**
	 * set login time
	 * @param dateTime
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}

