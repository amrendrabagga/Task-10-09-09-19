package com.wp.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveUser
 */
@WebServlet("/SaveUser")
public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement psRegister;
	
	
	public void init(){
		try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root123@");
		String sql="insert into users values(?,?,?,?,?,?)";
		psRegister=con.prepareStatement(sql);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void destroy(){
		try{
			con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//reads-request
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String username=request.getParameter("username");
		String address=request.getParameter("address");
		String mobile=request.getParameter("mobile");
		String email=request.getParameter("email");
		//process
		try{
			psRegister.setString(1, userid);
			psRegister.setString(2, password);
			psRegister.setString(3, username);
			psRegister.setString(4, address);
			psRegister.setString(5, mobile);
			psRegister.setString(6, email);
			int n=psRegister.executeUpdate();
			RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
			if(n!=0) {
				out.println("Registration Completed");
				rd.include(request, response);
			}
				
			else {
				out.println("Error, TRY AGAIN");
				rd.include(request, response);
			}
			
			
		}catch(Exception e){
			out.println(e);
		}
		
		
	}


}
