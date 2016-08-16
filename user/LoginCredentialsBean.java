package com.ust_global.user;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class LoginCredentialsBean
 */
@Stateless
public class LoginCredentialsBean implements LoginCredentialsBeanRemote
{

    /**
     * Default constructor. 
     */
    public LoginCredentialsBean()
    {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(name="LoginCredentialsUnit")
    EntityManager entityManager;
    

	@Override
	public void signUp(User user) 
	{
		if(user!=null)//if the user submits the form with out filling any values it will go to the else block
		{
			try
			{
				entityManager.persist(user);
			}
			catch (Exception e) //if the selected username already exists in the db it will throw an exception 
			{
				System.out.println("The username is unvailable");
			}
		}
	}

	@Override
	public void deleteAccount(String userName, String passWord) 
	{
		User user=entityManager.find(User.class, userName);
		if(user!=null)//if the username is null no such user exists
		{
			//the user will only be able to delete the acount if the enetered username and password is valid
			if(user.getUserName().equals(userName)&& user.getPassWord().equals(passWord))
			{
				entityManager.remove(user);
			}
			else
				System.out.println("invalid password");
		}
		else
			System.out.println("invalid username");
		
	}

	@Override
	public User Login(String userName, String passWord) 
	{
		User user=entityManager.find(User.class, userName);			
		return user;
	}

	@Override
	public User updatePassword(String userName,String passWord)
	{
		User user=entityManager.find(User.class, userName);
		
		if(user!=null)
		{
			//the user will only be able to update the password if the entered username and password is valid
			if(user.getUserName().equals(userName)&& user.getPassWord().equals(passWord))
			{
				user.setUserName(userName);
				user.setPassWord(passWord);	
				entityManager.merge(user);
			}
			else
				System.out.println("invalid password");
		}
		else
			System.out.println("invalid username");
		
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAllUserNames() 
	{
		//when using this method always set the value of the property "passWord" as null
		List<User> allUserNames=entityManager.createQuery("From LoginCredentials").getResultList();
		return allUserNames;
	}

	@Override
	public User forgotPassword(String userName, String newPassWord)
	{
		User user=entityManager.find(User.class, userName);
		if(user!=null)
		{
			user.setUserName(userName);
			user.setPassWord(newPassWord);
			entityManager.merge(user);
		}
		return null;
	}

}
