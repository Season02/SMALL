package com.sayhanabi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSTLTest
 */
@WebServlet("/JSTLTest")
public class JSTLTest extends HttpServlet 
{
	private static final long serialVersionUID = 1111L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSTLTest() 
    {
        super();        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("doGet");
		request.setAttribute("request", "请求");
		request.getSession().setAttribute("session","会话");
		request.getServletContext().setAttribute("application","应用");
		String[] list = {"a","b","hi","d"};
		request.getSession().setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pages/test/jstl.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
