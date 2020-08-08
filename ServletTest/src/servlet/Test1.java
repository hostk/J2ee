package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet implementation class Test1
 */
@WebServlet("/Test1")
public class Test1 implements Servlet {
	ServletConfig config =null;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
		System.out.println("Servlet is initialized");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Servlet is destroyed");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "copyright 2007-1010"; 
	}
	public void service(ServletRequest req,ServletResponse resp) throws IOException,ServletException{
		resp.setContentType("text/html");
		
		PrintWriter out= resp.getWriter();
		
		out.print("<html><body><b>Hello Servlet</b></body></html>");	
	}
}
