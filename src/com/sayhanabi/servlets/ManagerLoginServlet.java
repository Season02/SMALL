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
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 110L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerLoginServlet() 
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
		System.out.println((String)request.getParameter("action"));
		switch((String)request.getParameter("action"))
		{
			
			case "login":
				System.out.println("login");
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
					request.setAttribute("message", "帐户名或登录密码不正确，请重新输入");
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
		        }
				break;
			
			case "register":
				System.out.println("register");
				String user_code = request.getParameter("user_code");
				System.out.println(user_code);
				if(!user_code.equals("sayhanabi"))
				{
					request.setAttribute("login_err", "code");
					request.getRequestDispatcher("pages/manager/register.jsp").forward(request, response);
				}
				break;
			
			default:
				break;
		}
		
		
	}

}
