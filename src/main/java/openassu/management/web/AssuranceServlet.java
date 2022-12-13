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


import openassu.management.dao.AssuranceDao;
import openassu.management.dao.AssuranceImplDao;
import openassu.management.model.Assurance;




/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */


public class AssuranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AssuranceDao assuranceDAO;

	public void init() {
		assuranceDAO = new AssuranceImplDao();
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
			case "/newA":
				showNewForm(request, response);
				break;
			case "/insertA":
				insertAssurance(request, response);
				break;
			case "/deleteA":
				deleteAssurance(request, response);
				break;
			case "/editA":
				showEditForm(request, response);
				break;
			case "/updateA":
				updateAssurance(request, response);
				break;
			case "/listA":
				listAssurance(request, response);
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

	private void listAssurance(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Assurance> listAssurance = assuranceDAO.selectAllAssurance();
		request.setAttribute("listAssurance", listAssurance);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assurance.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("assurancecrud.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int assuranceID = Integer.parseInt(request.getParameter("assuranceID"));
		Assurance existingAssurance = assuranceDAO.selectAssurance(assuranceID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("assurancecrud.jsp");
		request.setAttribute("assurance", existingAssurance);
		dispatcher.forward(request, response);

	}
	


	private void insertAssurance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		


	
		
		String nomAssureur = request.getParameter("nomAssureur");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		
		/*DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		LocalDate targetDate = LocalDate.parse(request.getParameter("targetDate"),df);*/
		
		String assuranceCouvert = request.getParameter("assuranceCouvert");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		Assurance newAssurance = new Assurance(nomAssureur, province, ville, assuranceCouvert, dateDebut, dateFin );
		assuranceDAO.insertAssurance(newAssurance);
		response.sendRedirect("listA");
		
		
	}

	private void updateAssurance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int assuranceID = Integer.parseInt(request.getParameter("assuranceID"));
		
		String nomAssureur = request.getParameter("nomAssureur");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		
		
		String assuranceCouvert = request.getParameter("assuranceCouvert");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		
		Assurance updateAssurance =  new Assurance(assuranceID, nomAssureur, province, ville, assuranceCouvert,dateDebut,dateFin);
		
		assuranceDAO.updateAssurance(updateAssurance);
		
		response.sendRedirect("listA");
	}
	
		
	private void deleteAssurance(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int assuranceID = Integer.parseInt(request.getParameter("assuranceID"));
		assuranceDAO.deleteAssurance(assuranceID);
		response.sendRedirect("listA");
	}
}
