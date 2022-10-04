import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class AddBook extends HttpServlet
 {

	    
		
		 
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{

		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		
		
		
		String bookname = request.getParameter("bookname");
	
	
		String bookdes = request.getParameter("description");
		String author = request.getParameter("author");
	
	
	if ( session!= null )
	{
		
		try
		{
		
		
			FirstDAO object= new FirstDAO();
			object.addbook(bookname,bookdes,author,request,response);
		
		
		
		}
		catch(ClassNotFoundException ex)
		{
				out.println("<h1>Not inserted</h1>");
		}
		catch(SQLException ex)  
		{
			out.println("<h1>DB ERROR</h1>");
		}
		catch(Exception ex)  
		{
			out.println("<h1>DB ERROR</h1>");
		}
		// session retrieved, continue with servlet operations
	}
	else
	{
					
					out.print("<p style='color: red'> Your session was expired Login Again.... </p>");
					RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
					disp.include(request, response);
					
	}





	
 }
 
 }