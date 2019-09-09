package com.wp.book;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FetchBook
 */
@WebServlet("/FetchBook")
public class FetchBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = request.getParameter("path");
		if (path.substring(path.lastIndexOf('.') + 1).equals("docx"))
			response.setContentType("application/msword");
		else
			response.setContentType("application/pdf");

		FileInputStream fis = new FileInputStream(path);
		ServletOutputStream sos = response.getOutputStream();

		int i;
		while ((i = fis.read()) != -1) {
			sos.write(i);
			sos.flush();
		}
		fis.close();
		sos.close();
	}

}
