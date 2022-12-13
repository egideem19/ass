package openassu.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import openassu.management.model.Client;
import openassu.management.utils.JDBCUtils;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 * 
 * @author Ramesh Fadatare
 *
 */

public class ClientImplDao  implements ClientDao {

		

	private static final String INSERT_CLIENT_SLQ = "INSERT INTO client" + "(nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement,dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin) VALUES " + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_CLIENT_BY_ID = "select clientID, nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement,dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin from client where clientID = ?";
	private static final String SELECT_ALL_CLIENT = "select * from client";
	private static final String DELETE_CLIENT_SQL = "delete from client where clientID = ?;";
	private static final String UPDATE_CLIENT_SQL = "update client set nationalID = ?, medicalID = ?, nom = ?,prenom = ?,pays = ?, province = ?, ville = ?,quartier= ?,territoire= ?,groupement = ?,dateNaissance = ?,lieuNaissance = ?,genre = ?,etatCivil = ?,typeAssurance = ?,nomAssureur = ?,dateDebut = ?, dateFin= ?  where clientID = ?;";

	public ClientImplDao() {
	}


	public void insertClient(Client client) throws SQLException {
		System.out.println(INSERT_CLIENT_SLQ);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLIENT_SLQ)) {
			
			preparedStatement.setString(1, client.getNationalID());
			preparedStatement.setString(2, client.getMedicalID());
			preparedStatement.setString(3, client.getNom());
			preparedStatement.setString(4, client.getPrenom());
			preparedStatement.setString(5, client.getPays());
			preparedStatement.setString(6, client.getProvince());
			preparedStatement.setString(7, client.getVille());
			preparedStatement.setString(8, client.getQuartier());
			preparedStatement.setString(9, client.getTerritoire());
			preparedStatement.setString(10, client.getGroupement());
			preparedStatement.setDate(11, JDBCUtils.getSQLDate(client.getDateNaissance()));
			preparedStatement.setString(12, client.getLieuNaissance());
			preparedStatement.setString(13, client.getGenre());
			preparedStatement.setString(14, client.getEtatCivil());
			preparedStatement.setString(15, client.getTypeAssurance());
			preparedStatement.setString(16, client.getNomAssureur());
			preparedStatement.setDate(17, JDBCUtils.getSQLDate(client.getDateDebut()));
			preparedStatement.setDate(18, JDBCUtils.getSQLDate(client.getDateFin()));
			
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	

	public Client selectClient(long ID) {
		Client client = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLIENT_BY_ID);) {
			preparedStatement.setLong(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long clientID = rs.getLong("clientID");
				String nationalID = rs.getString("nationalID");
				String medicalID = rs.getString("medicalID");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String pays = rs.getString("pays");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				String quartier = rs.getString("quartier");
				String territoire = rs.getString("territoire");
				String groupement = rs.getString("groupement");
				LocalDate dateNaissance = rs.getDate("dateNaissance").toLocalDate();
				String lieuNaissance = rs.getString("lieuNaissance");
				String genre = rs.getString("genre");
				String etatCivil = rs.getString("etatCivil");
				String typeAssurance = rs.getString("typeAssurance");
				String nomAssureur = rs.getString("nomAssureur");
				LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
				LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
				
				client = new Client(clientID, nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement, dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return client;
	}


	public List<Client> selectAllClient() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Client> client = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CLIENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				
				long clientID = rs.getLong("clientID");
				String nationalID = rs.getString("nationalID");
				String medicalID = rs.getString("medicalID");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String pays = rs.getString("pays");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				String quartier = rs.getString("quartier");
				String territoire = rs.getString("territoire");
				String groupement = rs.getString("groupement");
				LocalDate dateNaissance = rs.getDate("dateNaissance").toLocalDate();
				String lieuNaissance = rs.getString("lieuNaissance");
				String genre = rs.getString("genre");
				String etatCivil = rs.getString("etatCivil");
				String typeAssurance = rs.getString("typeAssurance");
				String nomAssureur = rs.getString("nomAssureur");
				LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
				LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
				
				client.add(new Client(clientID, nationalID, medicalID,nom,prenom,pays,province,ville,quartier,territoire,groupement, dateNaissance,lieuNaissance,genre,etatCivil,typeAssurance,nomAssureur,dateDebut,dateFin));
				
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return client;
	}

	public boolean deleteClient(int clientID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CLIENT_SQL);) {
			statement.setInt(1, clientID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	public boolean updateClient(Client client) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CLIENT_SQL);) {
			statement.setString(1, client.getNationalID());
			statement.setString(2, client.getMedicalID());
			statement.setString(3, client.getNom());
			statement.setString(4, client.getPrenom());
			statement.setString(5, client.getPays());
			statement.setString(6, client.getProvince());
			statement.setString(7, client.getVille());
			statement.setString(8, client.getQuartier());
			statement.setString(9, client.getTerritoire());
			statement.setString(10, client.getGroupement());
			statement.setDate(11, JDBCUtils.getSQLDate(client.getDateNaissance()));
			statement.setString(12, client.getLieuNaissance());
			statement.setString(13, client.getGenre());
			statement.setString(14, client.getEtatCivil());
			statement.setString(15, client.getTypeAssurance());
			statement.setString(16, client.getNomAssureur());
			statement.setDate(17, JDBCUtils.getSQLDate(client.getDateDebut()));
			statement.setDate(18, JDBCUtils.getSQLDate(client.getDateFin()));
			statement.setLong(19, client.getClientID());
			
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
