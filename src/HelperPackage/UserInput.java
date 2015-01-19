package HelperPackage;

import java.util.Scanner;

@SuppressWarnings("resource")
public class UserInput 
{

	public static String getUserData()
	{
		//System.out.print("\nEnter Value : ");
		
		Scanner sc=new Scanner(System.in);
		String retVal=sc.nextLine();
		
		System.out.println("\n");
		return retVal;
		
	}
	
	public static Integer getUserInteger()
	{
		System.out.print("\nEnter Value : ");
		
		Scanner sc=new Scanner(System.in);
		Integer retVal=sc.nextInt();
		//sc.close();
		
		System.out.println("\n");
		return retVal;
		
	}
}
