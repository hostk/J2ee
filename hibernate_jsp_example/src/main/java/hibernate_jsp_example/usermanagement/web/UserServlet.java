package hibernate_jsp_example.usermanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hibernate_jsp_example.usermanagement.model.User;
import hibernate_jsp_example.usermanagement.dao.UserDao;

@SuppressWarnings("serial")
@WebServlet("/")
public class UserServlet extends HttpServlet{
	private static final long serialVersionID = 1;
	private UserDao userDao;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(req,resp);
				break;
			case "/insert":
				insertUser(req,resp);
				break;
			case "/delete":
				deleteUser(req,resp);
				break;
			case "/edit":
				showEditForm(req,resp);
				break;
			case "/update":
				updateUser(req,resp);
				break;
			default:
				listUser(req,resp);
				break;
			}
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	private void listUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		List<User> listUser= userDao.getAllUser();
		
		req.setAttribute("userList", listUser);
		RequestDispatcher rd = req.getRequestDispatcher("user_list.jsp");
		rd.forward(req, resp);
		

	}

	private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException,IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		User user = new User(id,name,email,country);
		userDao.updateUser(user);
		resp.sendRedirect("userList");
	}

	private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException,IOException,ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userDao.getUser(id);
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("user_form.jsp");
		rd.forward(req, resp);
		
	}

	private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException,IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		userDao.deleteUser(id);
		resp.sendRedirect("userList");
	}

	private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException,SQLException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String country = req.getParameter("country");
		
		User user = new User(name,email,country);
		userDao.saveUser(user);
		resp.sendRedirect("userList");		
		
	}

	private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException,IOException,ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("user_form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	@Override
	public void init() throws ServletException {
		userDao = new UserDao();
	}

}
