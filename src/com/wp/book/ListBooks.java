package com.wp.book;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListBooks
 */
@WebServlet("/ListBooks")
public class ListBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		File folder = new File("//Users//apple//eclipse-workspace//BookStore//Books");
		File[] files = folder.listFiles();
		out.print("<h1 align='center'>Download Books</h1><hr/>");

		for (File file : files) {
			String fileName = file.getName();
			out.print("<a href='FetchBook?path=" + file.getAbsolutePath() + "'>" + fileName + "</a><br>");

		}
		out.print("<hr/>");
		out.print("<a href='index.jsp'>" + "Go To Dashboard" + "</a>");

	}

}
