package openassu.management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import openassu.management.dao.UserDao;
import openassu.management.dao.UserImplDao;
import openassu.management.model.User;




/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */


public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDAO;

	public void init() {
		userDAO = new UserImplDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/newU":
				showNewForm(request, response);
				break;
			case "/insertU":
				insertUser(request, response);
				break;
			case "/deleteU":
				deleteUser(request, response);
				break;
			case "/editU":
				showEditForm(request, response);
				break;
			case "/updateU":
				updateUser(request, response);
				break;
			case "/listU":
				listUser(request, response);
				break;
			default:
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				dispatcher.forward(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUser();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("utilisateur.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrer.jsp");
		dispatcher.forward(request, response);
	}
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int idUser  = Integer.parseInt(request.getParameter("idUser"));
		User existingAssurance = userDAO.selectUser(idUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registrer.jsp");
		request.setAttribute("user", existingAssurance);
		dispatcher.forward(request, response);

	}
	


	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String categorie = request.getParameter("categorie");
		String telephone = request.getParameter("telephone");
		User newUser = new User(prenom, nom, email, password, categorie, telephone );
		userDAO.insertUser(newUser);
		response.sendRedirect("listU");
		
		
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		int idUser  = Integer.parseInt(request.getParameter("idUser"));
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String categorie = request.getParameter("categorie");
		String telephone = request.getParameter("telephone");
		
		User updateUser =  new User(idUser, prenom, nom, email, password,categorie,telephone);
		
		userDAO.updateUser(updateUser);
		
		response.sendRedirect("listU");
	}
	
		
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		userDAO.deleteUser(idUser);
		response.sendRedirect("listU");
	}
}
