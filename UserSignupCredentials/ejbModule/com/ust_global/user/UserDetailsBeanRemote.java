package com.ust_global.user;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface UserDetailsBeanRemote {
	
	//method for adding a new user's details
	public  String addUser(UserDetails user);//'user' is the object reference variable for UserDetails class
	
	//to get a single user's details by name of the user
	public UserDetails readUserDetails(String name);
	
	//to update the user's details
	public UserDetails updateUserDetails(String name, String userName, String email,long mobileNumber);
	
	//to delete the user's details
	public void removeUserDetails(String name);
	
	//to view all the registered users details
	public List<UserDetails> viewAllDetails();
	
}

