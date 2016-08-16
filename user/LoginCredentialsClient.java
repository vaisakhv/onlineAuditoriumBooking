package com.ust_global.user;

import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LoginCredentialsClient 
{
	public static void main(String[] args) throws NamingException 
	{
		Properties p=new Properties();
		p.put(Context.PROVIDER_URL,"localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
		Context ctx=new InitialContext(p);
		
		LoginCredentialsBeanRemote loginCredentials=(LoginCredentialsBeanRemote) ctx.lookup("LoginCredentialsBean/remote");
		User user = new User();
		
		user.setUserName("hari");
		user.setPassWord("pass123");
//		loginCredentials.signUp(user);
		List<User> allUserNames=loginCredentials.readAllUserNames();
		for (User usr:allUserNames) 
		{
			usr.setPassWord(null);
			System.out.println(usr.getUserName()+" and "+usr.getPassWord());
		}
//		loginCredentials.deleteAccount("vaisakh","pass124" );
		
	}
}
