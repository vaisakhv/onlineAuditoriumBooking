package com.ust_global.user;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LoginCredentialsBeanRemote {

	//this can be done only if the user knows the username and the current password
	public void deleteAccount(String userName,String passWord);
	
	//this can done if the client is a registered user and the username and password matches with the entry in the db
	public User Login(String userName,String passWord);
	
	//this can be done only if the user know the current password
	public User updatePassword(String userName,String passWord);
	
	//this can be done if the user don't know the current password
	public User forgotPassword(String userName, String newPassWord);
	
	//will return a list of User objects the list can be used for selecting new username during sign-up
	public List<User> readAllUserNames();
}
