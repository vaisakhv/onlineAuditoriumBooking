package com.ust_global.user;

import java.util.List;
import java.util.Properties;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import com.ust_global.user.LoginCredentialsBeanRemote;
import com.ust_global.user.User;

public class Login {

	String userName;
	String passWord;
	String confirmPassword;

	public Login() {

	}

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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String login() throws NamingException {
		String msg = " ";
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		LoginCredentialsBeanRemote log = (LoginCredentialsBeanRemote) ctx.lookup("LoginCredentialsBean/remote");
		User user=log.Login(this.userName, this.passWord);
		if ( user!= null)// will return a User object
		{
			List<User> alluser=log.readAllUserNames();
			for(User usr:alluser)
			{
				System.out.println(usr.getUserName()+" "+usr.getPassWord());
			}
			if (this.passWord.equals(user.getPassWord())&& this.userName.equals(user.getUserName())) 
			{
				FacesContext fc = FacesContext.getCurrentInstance();
				ExternalContext ec = fc.getExternalContext();
				HttpSession session = (HttpSession) ec.getSession(false);
				session.setAttribute("userName", this.userName);
				msg = "SuccessLogin";
			} 
			else 
			{
				msg = "failurePassword";
			}
			// invalid password
		}
		else
		{
			msg = "failureUsername";// invalid username
		}
		return msg;
	}

	public String forgotPassword() throws NamingException {
		String msg = " ";
		Properties p = new Properties();
		p.put(Context.PROVIDER_URL, "localhost:1099");
		p.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		Context ctx;
		ctx = new InitialContext(p);
		LoginCredentialsBeanRemote log = (LoginCredentialsBeanRemote) ctx.lookup("LoginCredentialsBean/remote");
		if (this.passWord.equals(this.confirmPassword))
		{
			User forgetPass = log.forgotPassword(this.userName, this.passWord);
			if (forgetPass != null) 
			{
				forgetPass.setPassWord(passWord);
				msg = "passUpdated";
			} 
			else 
			{
				msg = "forgetusernamefailed";// username invalid
			}
		} 
		else 
		{
			msg = "forgetpasswordfailed";// passwords dont match
		}
		return msg;
	}
}
