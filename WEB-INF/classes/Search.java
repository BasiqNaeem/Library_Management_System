import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Search extends HttpServlet
 {
 public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{
	
	HttpSession session = request.getSession(false);
		response.setContentType("text/html");
	
		PrintWriter out = response.getWriter();
		
		String find = request.getParameter("search");
		
	if ( session!= null )
	{ 
				request.getRequestDispatcher("Dashboard.jsp").include(request, response);
	
		try
		{
		
			ArrayList librarySystem = new ArrayList();
			
			FirstDAO Booklist =new FirstDAO();
			
			
			librarySystem=Booklist.Search(find);
			
			
			int i=0;
			
			int size = librarySystem.size();
		
		
			/*Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1/Library";
			Connection con=DriverManager.getConnection(url,"root","root");
			Statement st=con.createStatement();
		
			String query ="SELECT * from AddBook";// where username ='"+uname+"'";
		
			ResultSet obj = st.executeQuery(query);
			*/
			boolean flag=false;
			
			boolean flag1=true;
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet' integrity='sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC'crossorigin='anonymous'>");
			out.println("</head>");
			out.println("<body>");
			
		if(size!=0)
			{
				while(i<size)
				{
					MyPack.Library obj = (MyPack.Library) librarySystem.get(i);
					
		
					
					if(flag1==true)
					
					{
						out.println("<h1 style='color : white;'>Search Result For '"+find+"'</h1>");
						out.println("<b><hr style='color: white; border: 4px '></b>");
						out.println("<div  style='margin-top:60px ; '> <div  class='container my-3'> <b>");
			
						out.println("<table class='table' style='color: white;'>");
						out.println("<thead ><tr><th scope='col'>#</th><th scope='col'>Book Name</th><th scope='col'>Book Description</th><th scope='col'>Author</th> <th scope='col'>Delete Book</th>  <th scope='col'>Update Book</th></tr></thead><tbody >");
						flag1=false;
					}
					out.println("<tr><th scope='row'>"+obj.getBookID()+"</th><td>"+obj.getBookName()+"</td><td>"+obj.getBookdes()+"</td><td>"+obj.getauthor()+"</td>");
					out.println("<td><form class='d-flex' method='post' action='Delete'><input  value="+obj.getBookID()+" name='deletebook' style='width: 0%; height: 0%; border: none' class='form-control me-2'  type='hidden' autocomplete='off'  ><button  class='btn btn-danger' type='submit'>Delete Book</button></form></td>");
					
					out.println("<td><form class='d-flex' method='post' action='Update'><input  value="+obj.getBookID()+" name='Updatebook' style='width: 0%; height: 0%; border: none' class='form-control me-2'  type='hidden' autocomplete='off'  ><button  class='btn btn-warning' type='submit'>Update Book</button></form></td></tr>");
					
					flag= true;
			
					i++;
		
				}
				
				if(flag1==false)
					{
						out.println("</tbody></table></b></div></div>");
						out.println("<div style='margin-top: 300px'><hr style='color: white;'><footer style='text-align: center; color: white; '>&copy; Copyright 2021 Malik Basiq</footer></div>");
					}
				
				
			}
			else
			{
				
					out.println("<h1 style='color : white; margin-top:20px'>Search Result For '"+find+"'</h1>");
					//out.println("<p style='color: White; margin-top: 30px'> no record found! </p>");
					//out.print("no record found");          
					//RequestDispatcher disp=request.getRequestDispatcher("Dashboard.html");          
					//disp.forward(request, response);
					out.println("<div style='margin-top: 380px'><hr style='color: white;'><footer style='text-align: center; color: white; '>&copy; Copyright 2021 Malik Basiq</footer></div>");
				
				
			}
			
				out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' integrity='sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM' crossorigin='anonymous' >");
					out.println("</script>");
					out.println("</body>");
					out.println("</html>");	
		
	}
		catch(ClassNotFoundException ex)
		{
				out.println("<h1>Class not found error error</h1>");
			
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