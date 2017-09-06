package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conection = null;
		//ArrayList<String> errors = new ArrayList<String>();
		String uname="",conpass="",pass="",gender="",country="",query1="INSERT INTO userdetails VALUES(?,?,?,?,?)",query2="INSERT INTO logindetails VALUES(?,?)";
		int flag=0,a=0;
		PrintWriter writer = response.getWriter();
		PreparedStatement pst = null;
		response.setContentType("text/html");
		
		try {
			
			uname = request.getParameter("uname");
			gender = request.getParameter("gender");
			country = request.getParameter("country");
			pass = request.getParameter("pass");
			conpass = request.getParameter("conpass");
			
		if(uname == null || uname == " ") {
			writer.print("Invalid Username! try again");
			a++;
		}
		else if(pass == null || pass == " ") {
			writer.print("Password cannot be null");
			a++;
		}
		
		else if(!pass.equals(conpass)) {
			writer.print("Password and Confirm password do not match");
			a++;
		}
		
		else {
			conection = Dbutil.createConnection("Reg");
			pst = conection.prepareStatement(query1);
			pst.setString(1, uname);
			pst.setString(2, gender);
			pst.setString(3, country);
			pst.setString(4, pass);
			pst.setString(5, conpass);
			a=0;
			flag = pst.executeUpdate();
			
		}
		
		if(flag != 0 && a==0) {
			pst = conection.prepareStatement(query2);
			pst.setString(1,uname);
			pst.setString(2,pass);
			pst.execute();
			System.out.println("Inserted Successfully!!");
			RequestDispatcher rd = request.getRequestDispatcher("SignupJSP.jsp");
			rd.include(request, response);
		}
		else
		{
			writer.print("<br>Signup failed! try again");
			RequestDispatcher rd = request.getRequestDispatcher("signuphtml.html");
			rd.include(request, response);
		}
			
		}
		catch (NumberFormatException e) {
			//writer.print("Age should not be null or contain a character<br>");
			writer.print("<a href=\"signup.html\">Back</a>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		System.out.println(uname+pass+country+gender);
		
		
		
		
		
		
		
	}

}
