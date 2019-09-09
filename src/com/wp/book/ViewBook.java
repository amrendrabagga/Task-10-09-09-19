package com.wp.book;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewBook
 */
@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement psSearch;

	@Override
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book", "root", "root123@");
			psSearch = con.prepareStatement("Select title,subject,price from books where subject like ?");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String subjectName = request.getParameter("subjectName");
		String search = subjectName + "%";
		PrintWriter out = response.getWriter();
		try {
			psSearch.setString(1, search);
			ResultSet rsSearch = psSearch.executeQuery();

			out.print("<h1 align='center'>SUBJECT WISE BOOKS</h1>");
			out.print("<hr/>");
			out.print("<div align='center'>");
			out.print("<table border=1 cellpadding=0 cellspacing=0>");
			out.print("<tr>");
			out.print("<th>");
			out.print("title");
			out.print("</th>");
			out.print("<th>");
			out.print("subject");
			out.print("</th>");
			out.print("<th>");
			out.print("price");
			out.print("</th>");
			out.print("</tr>");

			while (rsSearch.next()) {

				out.print("<tr>");
				out.print("<td>");
				out.print(rsSearch.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.print(rsSearch.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.print(rsSearch.getString(3));
				out.print("</td>");
				out.print("</tr>");

			}
			out.print("</table>");
			out.print("</div>");
			out.print("<hr/>");
			out.print("<a href='ViewBook.jsp'>View Other Book</a>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
