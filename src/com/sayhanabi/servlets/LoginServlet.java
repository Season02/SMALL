package com.sayhanabi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sayhanabi.factory.DaoFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 110L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		response.setContentType("text/html;charset=utf-8") ;
//		request.setCharacterEncoding("utf-8") ;
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        int id = -1;
        
        if(( id = DaoFactory.getManager().authenticationManager(username, password) ) > -1)
        {
        	request.setAttribute("id",id);
            response.sendRedirect("pages/manager/manager.jsp") ;
        }
        else
        {
        	// 登录失败
			request.getSession().setAttribute("message", "帐户名或登录密码不正确，请重新输入");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
        }
	}

}
