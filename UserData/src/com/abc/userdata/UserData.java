package com.abc.userdata;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserData
 */
@WebServlet("/UserData")
public class UserData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String name =request.getParameter("name");
		String hight =request.getParameter("userH");
		String weight =request.getParameter("userW");
		ServletContext context= getServletContext();
		String hight_con=context.getInitParameter("hight");
		String weight_con=context.getInitParameter("weight");
		pw.println("加權後身高:"+Integer.parseInt(hight)*Integer.parseInt(hight_con));
		pw.println("<br><br>加權後體重:"+Integer.parseInt(weight)*Integer.parseInt(weight_con));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
