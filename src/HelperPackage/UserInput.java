package HelperPackage;

import java.util.Scanner;

public class UserInput 
{
	@SuppressWarnings("resource")
	public static String getUserData()
	{
		//System.out.print("\nEnter Value : ");
		
		Scanner sc=new Scanner(System.in);
		String retVal=sc.nextLine();
		
		System.out.println("\n");
		return retVal;
		
	}
}
