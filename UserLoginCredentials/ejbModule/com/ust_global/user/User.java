package com.ust_global.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="LoginCredentials")
@Table(name="LoginCredentials")
public class User implements Serializable
{
	//variable should be the same across all platforms
	private String userName;
	private String passWord;
	
	@Id
	@Column(name="userName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
}
