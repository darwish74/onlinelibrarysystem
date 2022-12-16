package libararysystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Userlist extends User{
	private static ArrayList<User>Users=new ArrayList();
	
	public static void AddUser()
	{  Scanner input=new Scanner(System.in);
	 System.out.println("How Many Users will be added ?");
	 int nou=input.nextInt();
	 for(int i=0;i<nou;i++) 
	 {
	  System.out.println("Plz enter user "+(i+1)+" :");	 
	  User e=new User();
	  System.out.println("plz enter User name : ");
	  String name=input.next();
	  e.setName(name);
	  System.out.println("plz enter User Age :");
	  int Age=input.nextInt();
	  e.setAge(Age);
	  System.out.println("plz enter User Email :");
	  String Email=input.next();
	  e.setEmail(Email);
	  System.out.println("plz enter User password :");
	  String password=input.next();
	  e.setPassword(password);
	  User.insertuser(e);
	 }}
	static int i=0;
	 public static void Display()
	 {
	  for(User element:Users)
	  {  
		 System.out.println("User <  " +  (++i)  + "  >  information ");  
	     element.printinfo();
	  }
	  i=0;
	 }
	 public static void SearchById()
	 {   boolean flag=false;
		 Scanner input=new Scanner(System.in);
		 System.out.println("Plz enter Id of user :");
		 int Id=input.nextInt();
		 for(User element:Users)
		 {
			 if(element.getId()==Id)
				{element.printinfo();
				flag=true;
			    break;}
		 }
		 if(flag==false)
		System.out.println("this user is not found");
	 }
	 public static void numOfusers()
	 {
		  System.out.println("Number of users are "+count);
	 }
}
