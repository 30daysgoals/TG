package assertions;

import java.util.regex.Pattern;

public class StringAssertion 
{
	/*
	 Author : Sumit Kumar
	 This public class provides function that perform string based assertions.
	/*
	 Below function check if the given sub string is part of main source string or not. This search is case sensitive
	 */
	public boolean  assertContains(String sourceString,String content)
	{
		// TODO Auto-generated method stub
		System.out.println("*********************STARTING STRING ASSERTION**************************");
		if(sourceString.contains(content))
		{
			System.out.println(" AssertContains is TRUE.\n Main String is :"+sourceString +"\n" +" String Asserted is : " +content);
			System.out.println("*****************STRING ASSERTION COMPLETED**************************");
			return true;
		}
		
		else
		{
			System.out.println(" AssertContains is FALSE.\n Main String is :"+sourceString +"\n" +" String Asserted is : " +content);
			System.out.println("*****************STRING ASSERTION COMPLETED**************************");
			return false;
		}
	}
	
	 /*
	 Below function check if the given sub string is part of main source string or not. This search is case in-sensitive
	 */
	
	public boolean  assertContains_ignorecase(String sourceString,String content)
	{
		// TODO Auto-generated method stub
		System.out.println("*********************STARTING STRING ASSERTION**************************");
		if(Pattern.compile(Pattern.quote(content), Pattern.CASE_INSENSITIVE).matcher(sourceString).find())
		{
			System.out.println(" CASE_INSENSITIVE AssertContains is TRUE.\n Main String is :"+sourceString +"\n" +" String Asserted is : " +content);
			System.out.println("*****************STRING ASSERTION COMPLETED**************************");
			return true;
		}
		
		else
		{
			System.out.println(" CASE_INSENSITIVE AssertContains is FALSE.\n Main String is :"+sourceString +"\n" +" String Asserted is : " +content);
			System.out.println("*****************STRING ASSERTION COMPLETED**************************");
			return false;
		}
	}
}
