package com.d;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String uname,pass,country,gender;
	String query="SELECT uname,password FROM logindetails where uname=? AND password=?";

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		PrintWriter writer = response.getWriter();
		
		///ResultSet rs = null;
		PreparedStatement pst = null;
		Connection conection=null;
		//boolean flag;
		uname = request.getParameter("uname");
		System.out.println(uname);
		pass = request.getParameter("pass");
		System.out.println(pass);
		try {
		
			conection = Dbutil.createConnection("Reg");
			
			pst = conection.prepareStatement(query);
			pst.setString(1, uname);
			pst.setString(2, pass);
			ResultSet rs = pst.executeQuery();
			//System.out.println(rs);
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);
				System.out.println("Logged in Successfully!!");
				/*RequestDispatcher rd = request.getRequestDispatcher("LoginJSP.jsp");
				rd.include(request, response);*/
				response.sendRedirect("LoginJSP.jsp");
			}
			else
			{
				response.setContentType("text/html");
				writer.print("<script>alert('Login failed! try again');</script>");
				RequestDispatcher rd = request.getRequestDispatcher("/index.html");
				rd.include(request, response);
			}
				
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			
			System.out.println(uname+pass+country+gender);
			Dbutil.closeConection(conection);
		
	
	}

}
