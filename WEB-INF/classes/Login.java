import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Login extends HttpServlet
 {

	    
		
		 
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{        
	
	
	
	response.setContentType("text/html");
	
    PrintWriter out = response.getWriter();

    String uname = request.getParameter("Username");
    String pass = request.getParameter("Password");
	
	try
	{
		
		FirstDAO object= new FirstDAO();
			//object.login(uname,pass,request,response);
			
			
			boolean[] array=new boolean[2];
			
			array =object.login(uname,pass);
			
			
			
			if(array[0]==true)
			{
				
				
				if(array[1]==true)
				{
					
					//out.print("<p style='color: white; font-size:30px ;'>Welcome " + uname +  "</p>");
					//yahan pe html k buttons wale home page ko request dispatch karni ha include karke
					HttpSession session = request.getSession();
					session.setAttribute("username",uname);
					RequestDispatcher dis=request.getRequestDispatcher("Home");          
					dis.forward(request, response);
					
				
				}
				else
				{
					//out.print("Password is incorrect!");
					out.print("<p style='color: White'> Password is incorrect! </p>");
					RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
					disp.include(request, response);
					 					
					
				}
				
			}	
			else
			{
				out.print("<p style='color: White'> User name is incorrect!.... </p>");
				//out.print("User name or password is incorrect!");          
				RequestDispatcher di=request.getRequestDispatcher("Login.html");          
				di.include(request, response);
			}
			
		
		/*Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/signup";
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();*/
		
		/*
		
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
					
					//out.print("<p style='color: white; font-size:30px ;'>Welcome " + uname +  "</p>");
					//yahan pe html k buttons wale home page ko request dispatch karni ha include karke
					HttpSession session = request.getSession();
					session.setAttribute(uname,pass);
					RequestDispatcher dis=request.getRequestDispatcher("Home");          
					dis.forward(request, response);
					
				
				}
				else
				{
					//out.print("Password is incorrect!");
					out.print("<p style='color: White'> Password is incorrect! </p>");
					RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
					disp.include(request, response);
					 					
					
				}
				
			}
			
			
		}
					
				
			if(flag==false)
			{
				out.print("<p style='color: White'> User name or password is incorrect!.... </p>");
				//out.print("User name or password is incorrect!");          
				RequestDispatcher di=request.getRequestDispatcher("Login.html");          
				di.include(request, response);
			}
					  
					
		*/
	
	}
	catch(ClassNotFoundException ex)
	{
			out.println("<h1>Not loggedin</h1>");
			
	}catch(SQLException ex)  
	{
		out.println("<h1>Not loggedin</h1>");
	}
	catch(Exception ex)
	{
			out.println("<h1> login Exception</h1>");
	}

    out.close(); 
}
 }