import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Logout extends HttpServlet
 {

	    
		
		 
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{

		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
	if ( session!= null )
	{
		session.invalidate();
		RequestDispatcher dis=request.getRequestDispatcher("Login.html");          
			dis.include(request, response);
	}
	else
	{
		RequestDispatcher dis=request.getRequestDispatcher("Home.html");          
			dis.include(request, response);
	}
		
}}