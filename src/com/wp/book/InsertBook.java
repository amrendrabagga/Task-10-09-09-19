package com.wp.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertBook
 */
@WebServlet("/InsertBook")
public class InsertBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement insert;
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root123@");
			insert = con.prepareStatement("insert into books(title,subject,price) values(?,?,?)");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// out.print(con.hashCode());
			String bookTitle = request.getParameter("bookTitle");
			String bookSubject = request.getParameter("bookSubject");
			String bookPrice = request.getParameter("price");

			insert.setString(1, bookTitle);
			insert.setString(2, bookSubject);
			insert.setString(3, bookPrice);
			
			int n = insert.executeUpdate();
			if (n != 0) {
				out.print("BOOK ADDED SUCCESSFULLY");
				RequestDispatcher rd = request.getRequestDispatcher("/AddBook.jsp");
				rd.include(request,response);
				
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("/AddBook.jsp");
				rd.include(request,response);
				out.print("TRY AGAIN");
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
