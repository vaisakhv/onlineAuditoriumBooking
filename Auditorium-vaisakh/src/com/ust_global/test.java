package com.ust_global;

public class test 
{
	String msg="";
	String[] testString;

	
	public String[] getTestString() {
		return testString;
	}

	public String testMethod()
	{
		for (int i = 0; i < testString.length; i++)
		{
			System.out.println(testString[i]);
		}
		return msg;
	}
	
	public void setTestString(String[] testString) {
		this.testString = testString;
	}
	


}
