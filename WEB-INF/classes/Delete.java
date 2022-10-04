import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Delete extends HttpServlet
 {
 public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	
	HttpSession session = request.getSession(false);
	response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		
		
		 String Bookid = request.getParameter("deletebook");
		 
		 //out.println("<h1>"+Bookid +"</h1>");
	if ( session!= null )
	{ 
		try
		{
			
			/*Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/Library";
			Connection con=DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();*/
			
			FirstDAO object= new FirstDAO();
			object.delete(Bookid,request,response);
			
		
			/*String query ="DELETE FROM AddBook WHERE BookId='"+Bookid+"';";// where username ='"+uname+"'";
			int rs=st.executeUpdate(query);
			
			if(rs >= 0)
			{
				RequestDispatcher disp=request.getRequestDispatcher("Home");          
				disp.forward(request, response);
			}
			else
			{
    	
				out.println("<h1>Record is not Deleted</h1>");
			}
			*/
			
		}
		catch(ClassNotFoundException ex)
		{
				out.println("<h1>class not found error</h1>");
			
		}
		catch(SQLException ex)  
		{
			out.println("<h1>couldnot delete</h1>");
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