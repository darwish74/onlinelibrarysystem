package libararysystem;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

public class User {

 private static final String Age = null;
public String name;
 private int age;
 private  int id;
 private String password;
 public void setId(int id) {
	this.id = id;
}
private String email;
 public static int count;
 public User()
 {   name=" ";
     age=0;
     password=" ";
     email=" "; 
 }
 public User(int id,String name,int age,String email,String password)
 {
	 this.name=name;
	 this.age=age;
	 this.email=email;
	 this.password=password;
	 
 }
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getId() {
	return id;
}
public void printinfo()
{ 
  System.out.println("UserId :"+id+"||"+"UserName :"+name+"||"+"Age :"+age+"||"+"UserEmail :"+email+"||"+"UserPassword :"+password);
}
public static  ArrayList<User> Displayusers()
{   Connection conn= getconnection();
	
	  
    ArrayList<User>userlist=new ArrayList<>(); 
    ResultSet rs =null;
    PreparedStatement stmt = null;
    try {
    	String sql="select*from users";
    	 stmt=conn.prepareStatement(sql);
   	 
   	 rs=stmt.executeQuery();
   	 while(rs.next())
   	 {User u=new User();
	       u.setId(rs.getInt("user_id"));
	       u.setName(rs.getString("user_name"));
	       u.setAge(rs.getInt("Age"));
	       u.setEmail(rs.getString("Email"));
	       u.setPassword(rs.getString("password"));
	       userlist.add(u);
   	 }}
   	 catch(SQLException ex)
   	   {
   		 System.out.print(ex);
   	   }
    finally {
   	 try {conn.close();
   	 stmt.close();
   	 rs.close();
   	 }
   	 catch(Exception ex)
   	 {
   		 System.out.println(ex);
   	 }
    }
   	 return userlist;
   	 
    } 

public static Connection  getconnection()
{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url ="jdbc:mysql://localhost:3306/";
		String databaseName="library";	
		String userName="root";
		String password="";
		Connection con=DriverManager.getConnection(url + databaseName , userName, password);
		System.out.println("connected successfully");
		return con;
    	}
	 catch(Exception e)
	{
		 System.out.print("could not connect to database");
		 e.printStackTrace();
	}
	return null;

}
public static void insertuser(User user)
{    int count=0;
	 Connection conn= getconnection();
	 try {
		 String sql="INSERT INTO users (user_id,user_name,Age,Email,Password) VALUES (null,?,?,?,?)";
		 PreparedStatement stmt=conn.prepareStatement(sql);
		 stmt.setString(1, user.getName());
		 stmt.setInt(2, user.getAge());
		 stmt.setString(3,user.getEmail());
		 stmt.setString(4,user.getPassword());
		 stmt.execute();
		 count++;
		 System.out.println("user inserted successfully");
		 conn.close();
	 }
	 catch(SQLException ex )
	 {
		System.out.println("could not insert data "); 
		ex.printStackTrace(); 
	 }
	 
}
public static int DeleteUser()
{   Scanner input=new Scanner(System.in);
    System.out.println("plz enter id of user :");
    int id=input.nextInt();
	Connection conn=getconnection();
	 PreparedStatement stmt;
	 try { 
		 stmt=conn.prepareStatement("delete from users where user_id=?");
		 stmt.setInt(1, id);
		 int i=stmt.executeUpdate();
		 conn.close();
		 System.out.println("User is deleted successfully");
		 count--;
		 return i;
	      }
	 catch(Exception e)
	 {
		 e.printStackTrace();
		 System.out.print("oooopsss error");
	 }
    return -1;
 }
public static void searchbyid() throws SQLException
{   Scanner input=new Scanner(System.in);
    System.out.println("plz enter id of user :");
    int id=input.nextInt();
    ResultSet rs=null;
    PreparedStatement stmt=null;
    try{Connection conn=getconnection();
    stmt=conn.prepareStatement("select* from users where user_id=?"); 
    rs=stmt.executeQuery();
    stmt.setInt(1, id);
    int ID=rs.getInt("user_id");
    String name=rs.getString("user_name");
    int age=rs.getInt("Age");
    String Email =rs.getString("Email");
    String password=rs.getString("password");
    System.out.print("id "+ID+"name "+name+"age "+age+"Email "+Email+"password "+password);
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }}
  

 }
 
 

