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


import openassu.management.dao.ClientDao;
import openassu.management.dao.ClientImplDao;
import openassu.management.model.Client;




/**
 * ControllerServlet.java This servlet acts as a page controller for the
 * application, handling all requests from the todo.
 * 
 * @email Ramesh Fadatare
 */


public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClientDao clientDAO;

	public void init() {
		clientDAO = new ClientImplDao();
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
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertClient(request, response);
				break;
			case "/delete":
				deleteClient(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateClient(request, response);
				break;
			case "/list":
				listClient(request, response);
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

	private void listClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listClient = clientDAO.selectAllClient();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("client.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutclient.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int clientID = Integer.parseInt(request.getParameter("clientID"));
		Client existingClient = clientDAO.selectClient(clientID);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ajoutclient.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);

	}
	


	private void insertClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		
		
		String nationalID = request.getParameter("nationalID");
		String medicalID = request.getParameter("medicalID");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pays = request.getParameter("pays");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		String quartier = request.getParameter("quartier");
		String territoire = request.getParameter("territoire");
		String groupement = request.getParameter("groupement");
		LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));
		String lieuNaissance = request.getParameter("lieuNaissance");
		String genre = request.getParameter("genre");
		String etatCivil = request.getParameter("etatCivil");
		String typeAssurance = request.getParameter("typeAssurance");
		String nomAssureur = request.getParameter("nomAssureur");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		
		Client newClient = new Client (nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement, dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin);

		clientDAO.insertClient(newClient);
		response.sendRedirect("list");
		
		
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int clientID = Integer.parseInt(request.getParameter("clientID"));
		String nationalID = request.getParameter("nationalID");
		String medicalID = request.getParameter("medicalID");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String pays = request.getParameter("pays");
		String province = request.getParameter("province");
		String ville = request.getParameter("ville");
		String quartier = request.getParameter("quartier");
		String territoire = request.getParameter("territoire");
		String groupement = request.getParameter("groupement");
		LocalDate dateNaissance = LocalDate.parse(request.getParameter("dateNaissance"));
		String lieuNaissance = request.getParameter("lieuNaissance");
		String genre = request.getParameter("genre");
		String etatCivil = request.getParameter("etatCivil");
		String typeAssurance = request.getParameter("typeAssurance");
		String nomAssureur = request.getParameter("nomAssureur");
		LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
		LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
		
		Client updateClient = new Client (clientID,nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement, dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin);
		
		clientDAO.updateClient(updateClient);
		
		response.sendRedirect("list");
	}
	
		
	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int clientID = Integer.parseInt(request.getParameter("clientID"));
		clientDAO.deleteClient(clientID);
		response.sendRedirect("list");
	}
}
