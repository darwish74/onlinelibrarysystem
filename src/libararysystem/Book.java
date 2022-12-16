package libararysystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Book {
	private String title;
	private String isbn;
	private int id;
	private String category;
	private double avarageRatting;
    private String author;
	public static int count = 0;
	private int numrate;
	private double sumrate;

	public Book() {
		this.title = "";
		this.isbn = "";
		count++;
		id = count;
		this.category = "";
		avarageRatting = 0.0;
		numrate = 0;
		sumrate = 0.0;
	}

	public Book(String title, String isbn, String category) {
		this.title = title;
		this.isbn = isbn;
		this.category = category;
		count++;
		id = count;
		avarageRatting = 0.0;
		numrate = 0;
		sumrate = 0.0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getAvarageRatting() {
		return avarageRatting;
	}

	public void setAvarageRatting(double avarageRatting) {
		this.avarageRatting = avarageRatting;
	}

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String name) {
		this.author = name;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Book.count = count;
	}

	public void rateBook(double rating) {
		numrate++;
		sumrate += rating;
		avarageRatting = sumrate / numrate;
	}


	public void printinfo() {
		System.out.println( "Book [title=" + title + ", isbn=" + isbn + ", id=" + id + ", category=" + category + ", avarageRatting="
				+ avarageRatting + ", author=" + author + "]");
	}
	public static void insertBook(Book book)
	{
		 Connection conn= getconnection();
		 try {
			 String sql="INSERT INTO books (Book_id,Book_title,Book_isbn,Book_category,Book_author,Book_averageratting) VALUES (null,?,?,?,?,?)";
			 PreparedStatement stmt=conn.prepareStatement(sql);
			 stmt.setString(1, book.getTitle());
			 stmt.setString(2,book.getIsbn());
			 stmt.setString(3,book.getCategory());
			 stmt.setString(4,book.getAuthor());
			 stmt.setDouble(5,book.getAvarageRatting());
			 stmt.execute();
			 System.out.println("user inserted successfully");
			 conn.close();
		 }
		 catch(SQLException ex )
		 {
			System.out.println("could not insert data "); 
			ex.printStackTrace(); 
		 }
		 
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
	public static int Deletebook()
	{   Scanner input=new Scanner(System.in);
	    System.out.println("plz enter id of book :");
	    int id=input.nextInt();
		Connection conn=getconnection();
		 PreparedStatement stmt;
		 try { 
			 stmt=conn.prepareStatement("delete from books where book_id=?");
			 stmt.setInt(1, id);
			 int i=stmt.executeUpdate();
			 conn.close();
			 System.out.println("book is deleted successfully");
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

}
