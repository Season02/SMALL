package com.sayhanabi.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sayhanabi.common.factory.DaoFactory;
import com.sayhanabi.framework.vo.Manager;
import com.sayhanabi.framework.vo.PagePointer;

/**
 * Manager.jsp logic
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	int list_manager_limit = 5;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		List<Manager> list;
		PagePointer pp;
		switch((String)request.getParameter("action"))
		{
			case "data_gather":
				int data_count = DaoFactory.getManager().getCounct();
				int page_count = data_count/list_manager_limit;
				if(data_count/list_manager_limit > 0) page_count++;
				pp = new PagePointer(
						page_count, 1, list_manager_limit);
				list = DaoFactory.getManager().get(0,list_manager_limit);
				request.setAttribute("message","data_gather");
				request.getSession().setAttribute("page_pointer", pp);
				request.setAttribute("all_manager", list);
	        	request.getRequestDispatcher("pages/manager/manager.jsp").forward(request,response);
		        
				break;
				
			case "data_gather_next":
				pp = (PagePointer)request.getSession().getAttribute("page_pointer");
				int current_page = Integer.parseInt(request.getParameter("page"));
				pp.current = current_page;
				list = DaoFactory.getManager().get(
						(current_page - 1) * list_manager_limit,list_manager_limit);
				request.setAttribute("message","data_gather");
				request.setAttribute("all_manager", list);
				request.getSession().setAttribute("page_pointer", pp);
	        	request.getRequestDispatcher("pages/manager/manager.jsp").forward(request,response);
		        
				break;

			default:
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
