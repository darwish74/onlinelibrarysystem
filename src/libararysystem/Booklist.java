package libararysystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Booklist extends Book {
private static ArrayList<Book>Books=new ArrayList();	
public static void Addbook()
{   Scanner input=new Scanner(System.in);
	System.out.println("How many books will be added?");
	int num=input.nextInt();
	for(int i=0;i<num;i++)
	{try {
	 System.out.println("Enter Book < "+(i+1)+" > information");
	 Book b=new Book();
	 System.out.println("Plz enter Book's title : ");
	 String title=input.next();
	 b.setTitle(title);
	 System.out.println("plz enter Book's ISBN : ");
	 String isbn=input.next();
	 b.setIsbn(isbn);
	 System.out.println("plz enter Book's category : ");
	 String cat=input.next();
	 b.setCategory(cat);
	 System.out.println("plz enter Book's avarageRatting outof 5 : ");
	 int rate=input.nextInt();
	 b.setAvarageRatting(rate);
	 System.out.println("plZ enter Book's author : ");
	 String name=input.next();
	 b.setAuthor(name);
     Book.insertBook(b);}
	catch(Exception e)
	{
		System.out.print("error, plz try again ");
		Addbook();
	}
	}
}
 public static void DisplayAllbooks()
 {
	 for(Book element:Books) 
	 {
	 System.out.print("Book info : ");
	 element.printinfo();
	 }
	 
 }
 public static void searchBytitle()
 {
	 boolean flag=false;
	 Scanner input=new Scanner(System.in);
	 System.out.println("Plz enter Title of BOOK :");
	 String title=input.next();
	 for(Book element:Books)
	 {
		 if(element.getIsbn()==title)
			{element.printinfo();
			flag=true;
		    break;}
	 }
	 if(flag==false)
	System.out.println("this Book is not found");
	 
 }
 public static void searchById()
 {
	 boolean flag=false;
	 Scanner input=new Scanner(System.in);
	 System.out.println("Plz enter Id of Book :");
	 int Id=input.nextInt();
	 for(Book element:Books)
	 {
		 if(element.getId()==Id)
			{element.printinfo();
			flag=true;
		    break;}
	 }
	 if(flag==false)
	System.out.println("this Book is not found");
 }
 public static void searchByISBN()
 {
	 boolean flag=false;
	 Scanner input=new Scanner(System.in);
	 System.out.println("Plz enter ISBN of BOOK :");
	 String ISBN=input.next();
	 for(Book element:Books)
	 {
		 if(element.getIsbn()==ISBN)
			{element.printinfo();
			flag=true;
		    break;}
	 }
	 if(flag==false)
	System.out.println("this Book is not found");
 }
 /*public static void Deletebook()
 {   boolean flag=false;
	 Scanner input=new Scanner(System.in);
	 System.out.println("Plz Enter Book id you are want to delete it ");
	 int in=input.nextInt();
	 int index;
	 index = in - 1;
	 for(Book element:Books)
	 {
		if(element.getId()==in) 
		 {Books.remove(index);
		  index-=1;
		 flag=true;
	     break;}
	 }
	 if(flag==false)
			System.out.println("this Book is not found already");
 } */
}
