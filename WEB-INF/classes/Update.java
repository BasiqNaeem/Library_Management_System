import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Update extends HttpServlet
 {
	 public static int beekID;
 public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	
	HttpSession session = request.getSession(false);
	response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		
		
		 String Bookid = request.getParameter("Updatebook");
		 
		 
		 int BID=Integer.parseInt(Bookid);  
		 
		 beekID = BID; //  seeting: beekid is a static varaible to use in update2
		 
	if ( session!= null )
	{
				RequestDispatcher dis=request.getRequestDispatcher("Dashboard.jsp");          
				dis.include(request, response);
				
				
				
		try
		{
			
			
		
			//Library obj = new Library();
			
			FirstDAO daoobj =new FirstDAO();
			
			
			MyPack.Library obj = daoobj.update1(BID);
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC'crossorigin='anonymous'>");
			out.println("</head>");
			out.println("<body>");
			
			
				
					out.println("<h1 style='color : white;'>Selected Book</h1>");
						out.println("<b><hr style='color: white; border: 4px '></b>");
						out.println("<div  style='margin-top:20px ; '> <div  class='container my-3'> <b>");
			
						out.println("<table class='table' style='color: white;'>");
						out.println("<thead ><tr><th scope='col'>#</th><th scope='col'>Book Name</th><th scope='col'>Book Description</th><th scope='col'>Author</th></tr></thead><tbody >");
						out.println("<tr><th scope='row'>"+obj.getBookID()+"</th><td>"+obj.getBookName()+"</td><td>"+obj.getBookdes()+"</td><td>"+obj.getauthor()+"</td>");
						out.println("</tbody></table></b></div></div>");
					out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' integrity='sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM' crossorigin='anonymous' >");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");	
					
					
					
					RequestDispatcher disp=request.getRequestDispatcher("Update.jsp");          
					disp.include(request, response);
						
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