package openassu.management.web;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import openassu.management.dao.MutuelleDao;
import openassu.management.dao.MutuelleImplDao;
import openassu.management.model.Mutuelle;

/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */


public class MutuelleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MutuelleDao mutuelleDAO;

	public void init() {
		mutuelleDAO = new MutuelleImplDao();
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
			case "/newM":
				showNewForm(request, response);
				break;
			case "/insertM":
				insertMutuelle(request, response);
				break;
			case "/deleteM":
				deleteMutuelle(request, response);
				break;
			case "/editM":
				showEditForm(request, response);
				break;
			case "/updateM":
				updateMutuelle(request, response);
				break;
			case "/listM":
				listMutuelle(request, response);
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

	private void listMutuelle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Mutuelle> listMutuelle = mutuelleDAO.selectAllMutuelle();
		request.setAttribute("listMutuelle", listMutuelle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mutuelle.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("mutuellecrud.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int mutuelleID = Integer.parseInt(request.getParameter("mutuelleID"));
		Mutuelle existingMutuelle = mutuelleDAO.selectMutuelle(mutuelleID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("mutuellecrud.jsp");
		request.setAttribute("mutuelle", existingMutuelle);
		dispatcher.forward(request, response);

	}

	private void insertMutuelle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		


	
		
		String nomMutuelle = request.getParameter("nomMutuelle");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		
		String mutuelleCouvert = request.getParameter("mutuelleCouvert");
		Mutuelle newMutuelle = new Mutuelle(nomMutuelle, province, ville, mutuelleCouvert,LocalDate.now());
		mutuelleDAO.insertMutuelle(newMutuelle);
		response.sendRedirect("listM");
		
		
	}

	private void updateMutuelle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int mutuelleID = Integer.parseInt(request.getParameter("mutuelleID"));
		
		String nomMutuelle = request.getParameter("nomMutuelle");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		
		String mutuelleCouvert = request.getParameter("mutuelleCouvert");
		LocalDate dateEntre = LocalDate.parse(request.getParameter("dateEntre"));
		
		Mutuelle updateMutuelle =  new Mutuelle(mutuelleID, nomMutuelle, province, ville, mutuelleCouvert,dateEntre);
		
		mutuelleDAO.updateMutuelle(updateMutuelle);
		
		response.sendRedirect("listM");
	}
	
		
	private void deleteMutuelle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int mutuelleID = Integer.parseInt(request.getParameter("mutuelleID"));
		mutuelleDAO.deleteMutuelle(mutuelleID);
		response.sendRedirect("listM");
	}
}
