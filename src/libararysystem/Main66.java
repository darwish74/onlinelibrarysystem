package libararysystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main66 {
	static final String JDBC_Driver="com.mysql.jdbc.Driver";
    static final String url ="jdbc:mysql://localhost:3306/";
    static final String databaseName="library";
    static final String user="root";
    static final String pass="";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		MainMenu();
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
			System.out.print("connected successfully");
			return con;
	    	}
		 catch(Exception e)
		{
			 System.out.print("could not connect to database");
			 e.printStackTrace();
		}
		return null;
	
	}


	public static void MainMenu() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		System.out.println("#### Welcome to you in libaray ####");
		System.out.println("Select one of the following choises : ");
		System.out.println("1- Books Menu ");
		System.out.println("2- users Menu ");
		System.out.println("3- Exit ");
		int choise = input.nextInt();
		switch (choise) {
		case 1:
			booksMenu();
			break;
		case 2:
			usersMenu();
			break;
		case 3:
			System.out.print("system is closed successfully");
			System.exit(choise);
			break;
		}

	}

	public static void searchOptions() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(" **** search Menu **** ");
			System.out.println("Select one of the following choises : ");
			System.out.println("1- Search by Id ");
			System.out.println("2- Back to user Menu ");
			int choise = input.nextInt();
			switch (choise) {
			case 1:
				Userlist.SearchById();
				break;
			case 2:
				usersMenu();
				break;
			}
		}

	}

	public static void usersMenu() throws ClassNotFoundException, SQLException {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println(" **** User Menu **** ");
			System.out.println("Select one of the following choises : ");
			System.out.println("1- Craete a user and add it to the list ");
			System.out.println("2- search for a user ");
			System.out.println("3- Display All Users ");
			System.out.println("4- How many users in the System? ");
			System.out.println("5- Delete user from system by id ");
			System.out.println("6- Back to Main Menu ");
			int choise = input.nextInt();
			switch (choise) {
			case 1:
				Userlist.AddUser();
				break;
			case 2:
				searchOptions();
				break;
			case 3:
				DisplayAllusers();
				break;
			case 4:
				Userlist.numOfusers();
				break;
			case 5:
				User.DeleteUser();
			    break;
			case 6:
				MainMenu();
				break;
			}
		}

	}

	public static void booksMenu() throws ClassNotFoundException, SQLException {
	while (true)
		{ 
		Scanner input = new Scanner(System.in);
		System.out.println("Select one of the following choises : ");
		System.out.println("1- Create a book and add it to the list ");
		System.out.println("2- Search for a book ");
		System.out.println("3- Display all books (with book rating) ");
		System.out.println("4- Delete Book  ");
		System.out.println("5- Back to the main menu ");
		int c = input.nextInt();
			switch (c) {
			case 1:
				Booklist.Addbook();
				break;
			case 2:
				searchOption();
				break;
			case 3:
				DisplayAllbooks();
				break;
			case 4:
				Book.Deletebook();
				break;
			case 5:
				MainMenu();
				break;
			}
		}
     }
public static void searchOption() throws ClassNotFoundException, SQLException
{ Scanner input = new Scanner(System.in);
  while(true)
  {	  
  System.out.println("plz enter your choise : ");
  System.out.println("1-search By title ");
  System.out.println("2-search BY Id  ");
  System.out.println("3-search BY ISBN  ");
  System.out.println("4-Back to Book Menu ");
  int c=input.nextInt();
  switch(c)
  {
  case 1:
	  Booklist.searchBytitle();
  break;
  case 2:
	  Booklist.searchById();
  break;
  case 3:
	  Booklist.searchByISBN();
  break;
  case 4:
	  booksMenu();
  break;
  
  }
  }
}
public static void DisplayAllusers() throws ClassNotFoundException, SQLException 
{
	Connection con=null;
	Statement  stmt=null;
	Class.forName(JDBC_Driver);
    con=DriverManager.getConnection(url+databaseName , user, pass);
    stmt=con.createStatement();
    String sql="SELECT* FROM users";
    stmt.executeQuery(sql);
    ResultSet rs=stmt.executeQuery(sql);
    while(rs.next())
    {
    int id=rs.getInt("user_id");
    String name=rs.getNString("user_name");
    int age=rs.getInt("Age");
    String email=rs.getNString("Email");
    String password=rs.getString("password");
    System.out.println("id is "+id);
    System.out.println("name is "+name);
    System.out.println("age is "+age);
    System.out.println("email is "+email);
    System.out.println("password is "+password);
   }
   rs.close();


}
public static void DisplayAllbooks() throws ClassNotFoundException, SQLException 
{
	Connection con=null;
	Statement  stmt=null;
	Class.forName(JDBC_Driver);
    con=DriverManager.getConnection(url+databaseName , user, pass);
    stmt=con.createStatement();
    String sql="SELECT* FROM books";
    stmt.executeQuery(sql);
    ResultSet rs=stmt.executeQuery(sql);
    while(rs.next())
    {
    int id =rs.getInt("Book_id");
    String title=rs.getNString("Book_title");
    String isbn=rs.getNString("Book_isbn");
    String cat=rs.getNString("Book_category");
    String author=rs.getString("Book_author");
    double avarageratting=rs.getDouble("Book_averageratting");
    System.out.println("Book_id : "+id);
    System.out.println("Book_title : "+title);
    System.out.println("Book_isbn : "+isbn);
    System.out.println("Book_category : "+cat);
    System.out.println("Book_author : "+author);
    System.out.println("Book_averageratting is : "+avarageratting);
   }
   rs.close();
}
@Override
public String toString() {
	return "Main66 [toString()=" + super.toString() + "]";
}}
