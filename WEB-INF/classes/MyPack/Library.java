package MyPack;
import java.io.*;

import java.util.*;


public class Library  implements java.io.Serializable
{
	private int BookID =0;
	private String BookName="";
	private String Bookdes="";
	private String author="";
	
	public Library()  //zero argument ctor
	{
		
	}
	
	public int getBookID()
	{
		return BookID;
	}

	public void setBookID(int s)
	{
		BookID = s;
	}
	
	
	
	public String getBookName() 
	{
		return BookName;
	}

	public void setBookName(String s) 
	{
		BookName = s;
	}
	
	
	
	
	
	
	public String getBookdes() 
	{
		return Bookdes;
	}

	public void setBookdes(String s) 
	{
		Bookdes = s;
	}
	
	
	
	
	
	public String getauthor() 
	{
		return author;
	}

	public void setauthor(String s) 
	{
		author = s;
	}
	
	
}