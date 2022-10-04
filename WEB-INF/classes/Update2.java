import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Update2 extends HttpServlet
 {

	    
		
		 
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{

		HttpSession session = request.getSession(false);
		
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		
		
		
		String bookname = request.getParameter("Bookname");
	
	
		String bookdes = request.getParameter("Bookdescription");
		
		String author = request.getParameter("author");
		
		
		int id=Update.beekID;
		
		String query;
		
		boolean  flag = false;
		
	if ( session!= null )
	{
		
		try
		{
			
			
			FirstDAO obj =new FirstDAO();
			
			obj.update2(id,bookname,bookdes,author,request,response);
			
			/*Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/Library";
			Connection con=DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();
			*/
			/*
			if(bookname!="" && bookdes!="" && author!="" )
			{
				query="UPDATE addbook SET Bookname = '"+bookname+"', Bookdes = '"+bookdes+"', author = '"+author+"' WHERE BookId = '"+id+"'";
				
				//UPDATE addbook SET Bookname = 'basiq' WHERE BookId = beekID;
				
				//query ="DELETE FROM AddBook WHERE BookId='"+Bookid+"';";// where username ='"+uname+"'";
				//flag =true;
				
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
				
				
			}
			else if(bookname=="" && bookdes!="" && author!="")
			{
				query="UPDATE addbook SET Bookdes = '"+bookdes+"', author = '"+author+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			else if(bookname!="" && bookdes=="" && author!="")
			{
				query="UPDATE addbook SET Bookname = '"+bookname+"',  author = '"+author+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			else if(bookname!="" && bookdes!="" && author=="")
			{
				query="UPDATE addbook SET Bookname = '"+bookname+"', Bookdes = '"+bookdes+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			else if(bookname=="" && bookdes=="" && author!="")
			{
				query="UPDATE addbook SET author = '"+author+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			else if(bookname=="" && bookdes!="" && author=="")
			{
				query="UPDATE addbook SET Bookdes = '"+bookdes+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			else if(bookname!="" && bookdes=="" && author=="")
			{
				query="UPDATE addbook SET Bookname = '"+bookname+"' WHERE BookId = '"+id+"'";
				int rs=st.executeUpdate(query);
					if(rs >= 0)
				{
					RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
				}
				else
				{
    	
					out.println("<h1>Record is not Updated</h1>");
				}
			}
			
			else if(bookname=="" && bookdes=="" && author=="")
			{
			
				RequestDispatcher disp=request.getRequestDispatcher("Home");          
					disp.forward(request, response);
			}
			*/
			
		}
		catch(ClassNotFoundException ex)
		{
				out.println("<h1>First error</h1>");
			
		}
		catch(SQLException ex)  
		{
			out.println("<h1>Db error</h1>");
		}
		
		catch(Exception ex)
		{
			out.println("<h1>Exception</h1>");
		}
	}
	
	else
	{
				out.print("<p style='color: red'> Your session was expired Login Again.... </p>");
					RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
					disp.include(request, response);
	}
    out.close(); 
	
	
		
}
		
 }