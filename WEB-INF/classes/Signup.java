import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class Signup extends HttpServlet
 {

	    
		
		 
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
{        
	
	
	
	response.setContentType("text/html");
	
    PrintWriter out = response.getWriter();

    String uname = request.getParameter("uname");
    String pass = request.getParameter("password");
	
	String confirmpass = request.getParameter("confirm_password");
	
	
   
	
	String city = request.getParameter("city");
	
	String phone = request.getParameter("phone");
	
	
	String email = request.getParameter("email");
	
	boolean flag=true;
	
	boolean check=true;
	
	boolean email1=false;
	
	try
	{
		
		
		
		/*Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1/signup";
		Connection con=DriverManager.getConnection(url,"root","root");
		Statement st=con.createStatement();*/
		
		
			if(uname=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Username is empty Please Enter username</h3>");
			
			
			}
			if(pass=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Password is empty Please Enter Password</h3>");
			
			}
		
			if(confirmpass=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Confirm Password is empty Please enter Confirm password</h3>");
			
			}
			if(!(pass.equals(confirmpass)))
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Password and Confirm Password doesn't match!</h3>");
			}
			if(city=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>City is empty Please Enter City</h3>");
			
			}
			if(phone=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Phone Number is empty Please Enter Phone Number</h3>");
			
			}
			if(email=="")
			{
				flag=false;
				check=false;
				out.println("<h3 style=' color: white'>Email Number is empty Please Enter Email</h3>");
			}
			else
			{
				
				if((email).indexOf("@")>-1 && (email).indexOf("@")!=0 )
				{
					String []myarray=email.split("@");

					if((myarray[1]).indexOf(".")>-1 && (myarray[1]).indexOf(".") !=0  )
					{
						String part2= myarray[1];
						if(((myarray[1]).indexOf(".") < (part2.length())-1))
						{
							email1=true; 
						}
						else
						{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Email Format is incorrect DOT ERROR!!</h3>");
						//document.getElementById("email").innerHTML = "Email Format is incorrect DOT ERROR!!";
						
						}
				
					}
					else
					{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Email Format is incorrect DOT ERROR!!</h3>");
					//document.getElementById("email").innerHTML = "Email Format is incorrect DOT ERROR!!";
					//return false;
					}
				}
				else
				{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Email Format is incorrect @ ERROR!!</h3>");
		
				}
	
			}
		
				FirstDAO object= new FirstDAO();
				//object.signup(uname,pass,city,phone,email,request,response);
		
				boolean[] array=new boolean[3];
			
		
				array =object.signup(uname,pass,city,phone,email);
		
				if(array[0]==false)
				{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Username '"+uname +"' already Exists try a different username!!</h3>");
				}
				if(array[2]==false)
				{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Email '"+email +"' already Exists try a different Email!!</h3>");
				}
				if(array[1]==false)
				{
						flag=false;
						check=false;
						out.println("<h3 style=' color: white'>Phone Number '"+ phone+ "' already Exists try a different Phone Number!!</h3>");
				}
			
	
			if(check==false)
			{
			
			RequestDispatcher disp=request.getRequestDispatcher("Signup.html");          
			disp.include(request, response);
			}
		
			else
			{
			
				out.print("<h style='color: white'>Account created successfully Please Login</h3>");
				RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
				disp.include(request, response);
		 
				//System.out.println("Record inserted successfully.");
			}
		
		
			/*
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
							check=false;
							out.println("<h3 style=' color: white'>Username '"+uname +"' already Exists try a different username!!</h3>");
				}
				if(emailchk.equals(email))
				{
							flag=false;
							check=false;
							out.println("<h3 style=' color: white'>Email '"+email +"' already Exists try a different Email!!</h3>");
				}
				if(phonechk.equals(phone))
				{
						flag=false;
						check=false;
						out.println("<h3 style=' color: white'>Phone Number '"+ phone+ "' already Exists try a different Phone Number!!</h3>");
				}
			}
	
			if(check==false)
			{
			
			RequestDispatcher disp=request.getRequestDispatcher("Signup.html");          
			disp.include(request, response);
			}
		
		
		
		
			if(flag==true)
			{
		
				String query="insert into createaccount(username,password,city,telephone,email) values('"+uname+"', '"+pass+"', '"+city+"' , '"+phone+"' , '"+email+"')";
				//System.out.println(query);
		
				//out.println("<h1>"+query+"</h1>");
				int rs = st.executeUpdate(query);
		
			if(rs >= 0)
			{
			
				out.print("<h style='color: white'>Account created successfully Please Login</h3>");
				RequestDispatcher disp=request.getRequestDispatcher("Login.html");          
				disp.include(request, response);
		 
				//System.out.println("Record inserted successfully.");
			}
     
			else
			{
			
					out.println("Record could not inserted.");
			}
		}
		
		*/
		
	}
	catch(ClassNotFoundException ex)
	{
			out.println("<h1>Not inserted</h1>");
	}catch(SQLException ex)  
	{
		out.println("<h1>db error</h1>");
	}
	catch(Exception ex)
	{
			out.println("<h1>Exception</h1>");
	}
	
   
     
    
    out.close(); 

}


}