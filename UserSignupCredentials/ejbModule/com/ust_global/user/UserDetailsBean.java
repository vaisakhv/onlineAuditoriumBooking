package com.ust_global.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import oracle.net.aso.e;


@Stateless
public class UserDetailsBean implements UserDetailsBeanRemote {

	@PersistenceContext(name="UserUnit")
	EntityManager entityManager;
    public UserDetailsBean() {
        
    }
    
    @Override
	public String addUser(UserDetails user) {
		//Implemented method for adding a new user's details
		entityManager.persist(user);//'user' is the object reference variable for UserDetails class
		return "Your registration was successfull";
	}
	
	@Override
	public UserDetails readUserDetails(String userName) {
	//Implemented method for getting single user's details
		UserDetails user=entityManager.find(UserDetails.class, userName);
		
		return user;
	}
	@Override
	//Implemented method for updating the user's details
	public UserDetails updateUserDetails(String name, String userName,
			String email, long mobileNumber) {
		
		UserDetails user=entityManager.find(UserDetails.class, userName);
		
		if (user!=null)
			
		{
			user.setUserName(userName);
			user.setName(name);
			user.setEmail(email);
			user.setMobileNumber(mobileNumber);
			
			entityManager.merge(user);
		}
		else
		{
			user=null;
		}
		
		return user;
	}
	@Override
	//Implemented method for deleting a user's details 
	public void removeUserDetails(String userName) {
		
		UserDetails user=entityManager.find(UserDetails.class, userName);
		entityManager.remove(user);		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	// Implemented method to view all registered users details
	public List<UserDetails> viewAllDetails() {
		
		List<UserDetails>allUsers=entityManager.createQuery("FROM UserDetails").getResultList();
		
		return allUsers;
	}

}
