package openassu.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import openassu.management.model.Assurance;
import openassu.management.utils.JDBCUtils;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 * 
 * @author Ramesh Fadatare
 *
 */

public class AssuranceImplDao  implements AssuranceDao {

		
	private static final String INSERT_ASSURANCE_SLQ = "INSERT INTO assurance" + "(nomAssureur, province,ville,assuranceCouvert,dateDebut,dateFin) VALUES " + "(?,?,?,?,?,?);";
	
	private static final String SELECT_ASSURANCE_BY_ID = "select assuranceID, nomAssureur, province,ville,assuranceCouvert,dateDebut,dateFin from assurance where assuranceID = ?";
	private static final String SELECT_ALL_ASSURANCE = "select * from assurance";
	private static final String DELETE_ASSURANCE_SQL = "delete from assurance where assuranceID = ?;";
	private static final String UPDATE_ASSURANCE_SQL = "update assurance set nomAssureur = ?, province = ?, ville = ?,assuranceCouvert = ?, dateDebut=?,dateFin=? where assuranceID = ?;";

	public AssuranceImplDao() {
	}


	public void insertAssurance(Assurance assurance) throws SQLException {
		System.out.println(INSERT_ASSURANCE_SLQ);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ASSURANCE_SLQ)) {
			preparedStatement.setString(1, assurance.getNomAssureur());
			preparedStatement.setString(2, assurance.getProvince());
			preparedStatement.setString(3, assurance.getVille());
			
			preparedStatement.setString(4, assurance.getAssuranceCouvert());
			preparedStatement.setDate(5, JDBCUtils.getSQLDate(assurance.getDateDebut()));
			preparedStatement.setDate(6, JDBCUtils.getSQLDate(assurance.getDateFin()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	

	public Assurance selectAssurance(long ID) {
		Assurance assurance = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ASSURANCE_BY_ID);) {
			preparedStatement.setLong(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long assuranceID = rs.getLong("assuranceID");
				String nomAssureur = rs.getString("nomAssureur");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				
				String assuranceCouvert = rs.getString("assuranceCouvert");
				LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
				LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
				assurance = new Assurance(assuranceID, nomAssureur, province, ville, assuranceCouvert,dateDebut,dateFin);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return assurance;
	}


	public List<Assurance> selectAllAssurance() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Assurance> assurance = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ASSURANCE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long assuranceID = rs.getLong("assuranceID");
				String nomAssureur = rs.getString("nomAssureur");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				
				String assuranceCouvert = rs.getString("assuranceCouvert");
				LocalDate dateDebut = rs.getDate("dateDebut").toLocalDate();
				LocalDate dateFin = rs.getDate("dateFin").toLocalDate();
				assurance.add(new Assurance(assuranceID, nomAssureur, province, ville, assuranceCouvert, dateDebut, dateFin));
			
				
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return assurance;
	}

	public boolean deleteAssurance(int assuranceID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ASSURANCE_SQL);) {
			statement.setInt(1, assuranceID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	public boolean updateAssurance(Assurance assurance) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ASSURANCE_SQL);) {
			statement.setString(1, assurance.getNomAssureur());
			statement.setString(2, assurance.getProvince());
			statement.setString(3, assurance.getVille());
			statement.setString(4, assurance.getAssuranceCouvert());
			statement.setDate(5, JDBCUtils.getSQLDate(assurance.getDateDebut()));
			statement.setDate(6, JDBCUtils.getSQLDate(assurance.getDateFin()));
			
			statement.setLong(7, assurance.getAssuranceID());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
