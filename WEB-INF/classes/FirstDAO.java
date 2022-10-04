import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class FirstDAO 
{
	Connection con;
	Statement st;
	
	public FirstDAO() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/signup";
		con=DriverManager.getConnection(url,"root","root");
		st=con.createStatement();
	}
	
	
	boolean[] signup(String uname,String pass, String city,String phone, String email)throws Exception
	{
		
		boolean[] array=new boolean[3];
		array[0]=true;
		array[1]=true;
		array[2]=true;
		
		
		boolean flag=true;
	
		boolean check=true;
	
		boolean email1=false;
		
			
			
			
			String query1 ="SELECT * from createaccount";// where username ='"+uname+"'";
		
			ResultSet obj = st.executeQuery(query1);
			
			while(obj.next())
			{
				String pname =obj.getString("username");
				String emailchk =obj.getString("email");
				String phonechk =obj.getString("telephone");
			
			
				if(pname.equals(uname))
				{
							flag=false;
							//check=false;
							array[0]=false;
							//out.println("<h3 style=' color: white'>Username '"+uname +"' already Exists try a different username!!</h3>");
				}
				if(emailchk.equals(email))
				{
							flag=false;
							//check=false;
							array[2]=false;
							//out.println("<h3 style=' color: white'>Email '"+email +"' already Exists try a different Email!!</h3>");
				}
				if(phonechk.equals(phone))
				{
						flag=false;
						//check=false;
						array[1]=false;
						//out.println("<h3 style=' color: white'>Phone Number '"+ phone+ "' already Exists try a different Phone Number!!</h3>");
				}
			}
	
		/*if(check==false)
		{
			
			RequestDispatcher disp=request.getRequestDispatcher("Signup.html");          
			disp.include(request, response);
		}*/
		
		
		
		
		if(flag==true)
		{
		
				String query="insert into createaccount(username,password,city,telephone,email) values('"+uname+"', '"+pass+"', '"+city+"' , '"+phone+"' , '"+email+"')";
				//System.out.println(query);
		
				//out.println("<h1>"+query+"</h1>");
				int rs = st.executeUpdate(query);
		
			if(rs >= 0)
			{
			
				//out.print("<h style='color: white'>Account created successfully Please Login</h3>");
				array[0]=true;
				array[1]=true;
				array[2]=true;
				//RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
				//disp.include(request, response);
		 
				//System.out.println("Record inserted successfully.");
			}
     
			else
			{
			
					array[0]=false;
					array[1]=false;
					array[2]=false;
			}
		}
		
	
		
		
		
		return array;
	
		
	}
	
	
	
	boolean[] login(String uname,String pass) throws Exception
	{
		
		
		
		boolean[] array=new boolean[2];
		array[0]=true;
		array[1]=true;
		
	
			
				String query ="SELECT * from createaccount";// where username ='"+uname+"'";
		
				ResultSet obj = st.executeQuery(query);
		
		
				boolean flag=false;
			
			while(obj.next())
			{
				String pname =obj.getString("username");
			
			if(pname.equals(uname))
			{
				String password =obj.getString("password");
				flag= true;
				if(password.equals(pass))
				{
					
					array[0]=true;
					array[1]=true;
					//out.print("<p style='color: white; font-size:30px ;'>Welcome " + uname +  "</p>");
					//yahan pe html k buttons wale home page ko request dispatch karni ha include karke
					//HttpSession session = request.getSession();
					//session.setAttribute(uname,pass);
					//RequestDispatcher dis=request.getRequestDispatcher("Home");  //forwarding to a java file named Home.java        
					//dis.forward(request, response);
					
				
				}
				else
				{
					
					
					array[1]=false;
					/*//out.print("Password is incorrect!");
					out.print("<p style='color: White'> Password is incorrect! </p>");
					RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
					disp.include(request, response);*/
					 					
					
				}
				
			}
			
			
		}
					
				
			if(flag==false)
			{
				
				array[0]=false;
				//array[1]=false;
				
				/*out.print("<p style='color: White'> User name or password is incorrect!.... </p>");
				//out.print("User name or password is incorrect!");          
				RequestDispatcher di=request.getRequestDispatcher("Login.html");          
				di.include(request, response);*/
			}
			
			
		
		
		
		
		
		return array;
	}



	void delete(String Bookid,HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		try
		{
			String query ="DELETE FROM AddBook WHERE BookId='"+Bookid+"';";// where username ='"+uname+"'";
			int rs=st.executeUpdate(query);
			
			if(rs >= 0)
			{
				RequestDispatcher disp=request.getRequestDispatcher("Home");          
				disp.forward(request, response);
			}
			else
			{
    	
				out.println("<h1>Record were not Deleted</h1>");
			}
			
			
			
			
		}
		catch(SQLException ex)  
		{
			out.println("<h1>db error</h1>");
		}
		
		
		
	}
	
	
	
	void addbook(String bookname,String bookdes,String author, HttpServletRequest request, HttpServletResponse response)throws Exception
	{
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		String query="insert into AddBook(Bookname,Bookdes,author) values(UPPER('"+bookname+"'), UPPER('"+bookdes+"'),UPPER( '"+author+"'))";
		System.out.println(query);
		int rs = st.executeUpdate(query);
		
		if(rs >= 0)
		{
		
		
		
			RequestDispatcher disp=request.getRequestDispatcher("Home");          
			disp.forward(request, response);
		}
	    
     
		else
		{
    	
			out.println("Record could not inserted.");
		}

		
		
		
	}
	
	public ArrayList home() throws Exception 
	{
        
        String query = "SELECT * FROM AddBook" ;
        
		String BookName, Bookdes;
		String author;
		
        int BookID; 
		
        ResultSet obj = st.executeQuery(query);
        
       
        ArrayList Booklist = new ArrayList();
		
            while (obj.next()) 
			{
                BookID =obj.getInt("BookId");
                BookName = obj.getString("Bookname");
                Bookdes = obj.getString("Bookdes");
                author = obj.getString("author");
				
				//MyPack.Library temp=new MyPack.Library(BookID,BookName,Bookdes,author);
				
				MyPack.Library temp=new MyPack.Library();
				
				temp.setBookID(BookID);
				
				temp.setBookName(BookName);
				
				temp.setBookdes(Bookdes);
				
				temp.setauthor(author);
				
				Booklist.add(temp);
            }
			
		return Booklist;
    }
	
	public ArrayList Search(String find) throws Exception 
	{
        
        String query = "SELECT * FROM AddBook" ;
        
		String BookName, Bookdes;
		String author;
		
        int BookID; 
		
        ResultSet obj = st.executeQuery(query);
        
       
        ArrayList Booklist = new ArrayList();
		
            while (obj.next()) 
			{
                BookID =obj.getInt("BookId");
                BookName = obj.getString("Bookname");
                Bookdes = obj.getString("Bookdes");
                author = obj.getString("author");
				
				String uppercase = find.toUpperCase();
				
			
				
				int result=(Bookdes).indexOf(find);
			
				int result1 =(Bookdes).indexOf(uppercase);
				
				
				int bfind=(BookName).indexOf(find);
				
				int bfind1 =(BookName).indexOf(uppercase);
				
				
				
				int Afind=(author).indexOf(find);
				
				int Afind1 =(author).indexOf(uppercase);
				
				
				if((BookName.equals(find))|| (BookName.equals(uppercase))|| (author.equals(find))|| (author.equals(uppercase))||  (bfind>-1) ||  (bfind1>-1) ||  (Afind>-1) ||  (Afind1>-1) ||  (result>-1)||(result1>-1) )
				{
					
					
					
					MyPack.Library temp=new MyPack.Library();
				
					temp.setBookID(BookID);
				
					temp.setBookName(BookName);
				
					temp.setBookdes(Bookdes);
				
					temp.setauthor(author);
				
					Booklist.add(temp); 
					
				
					//Library temp=new Library(BookID,BookName,Bookdes,author);
					
					
				}
            }
			
		return Booklist;
    }
	




	public MyPack.Library update1(int BID)throws Exception
	{	
		
	
			String query ="SELECT * from AddBook"; 
			
			
		
			ResultSet obj = st.executeQuery(query);
			
			
		//Library temp=new Library();
		
		MyPack.Library temp=new MyPack.Library();
				
				
		
		
		String BookName,Bookdes,author;
		int BookID;
		while(obj.next())
			{
				 BookID =obj.getInt("BookId");
				
				if(BookID==BID)
				{
					
					 BookName =obj.getString("Bookname");
					
				
					 Bookdes =obj.getString("Bookdes");
					
					 author =obj.getString("author");
					
					
					 //temp=new Library(BookID,BookName,Bookdes,author);
					 
					temp.setBookID(BookID);
				
					temp.setBookName(BookName);
				
					temp.setBookdes(Bookdes);
				
					temp.setauthor(author);
				
					
					
					return temp;
					
				}
			}	

				
		return temp;
		
	}

public void update2(int id,String bookname,String bookdes,String author,HttpServletRequest request, HttpServletResponse response)throws Exception
{
		String query;
		if(bookname!="" && bookdes!="" && author!="" )
			{
				query="UPDATE addbook SET Bookname = UPPER('"+bookname+"'), Bookdes = UPPER('"+bookdes+"'), author = UPPER('"+author+"') WHERE BookId = '"+id+"'";
				
				//UPDATE addbook SET Bookname = 'basiq' WHERE BookId = beekID;
				
				//query ="DELETE FROM AddBook WHERE BookId='"+Bookid+"';";// where username ='"+uname+"'";
				//flag =true;
				
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
				
				
			}
			else if(bookname=="" && bookdes!="" && author!="")
			{
				query="UPDATE addbook SET Bookdes = UPPER('"+bookdes+"'), author = UPPER('"+author+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			else if(bookname!="" && bookdes=="" && author!="")
			{
				query="UPDATE addbook SET Bookname = UPPER('"+bookname+"'),  author = UPPER('"+author+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			else if(bookname!="" && bookdes!="" && author=="")
			{
				query="UPDATE addbook SET Bookname = UPPER('"+bookname+"'), Bookdes = UPPER('"+bookdes+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			else if(bookname=="" && bookdes=="" && author!="")
			{
				query="UPDATE addbook SET author = UPPER('"+author+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			else if(bookname=="" && bookdes!="" && author=="")
			{
				query="UPDATE addbook SET Bookdes = UPPER('"+bookdes+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			else if(bookname!="" && bookdes=="" && author=="")
			{
				query="UPDATE addbook SET Bookname = UPPER('"+bookname+"') WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				
			}
			
			else if(bookname=="" && bookdes=="" && author=="")
			{
			
				RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
			}

	}

}