package com.sayhanabi.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("GB2312");
		response.setContentType("text/html;charset=GB2312");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("user");
		if(username.compareTo("Season02")==0)
				username = "Season02";
		out.println("<html><head><title>");
		out.println("Art Sword Online");
		out.println("</title></head><body>");
		out.println("<h1>こにちわ、やっとあなたに会いました," + username + " !</h1>");
		String url = request.getRequestURL().toString();
		out.println("<h2>まだ会えましたね ! </h2>");
		out.println("<h2> getRequestURL: " + url + " </h2>");
		out.println("<button href='/ServletDemo'>Go Home!</button>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
