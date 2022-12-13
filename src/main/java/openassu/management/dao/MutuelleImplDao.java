package openassu.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import openassu.management.model.Mutuelle;
import openassu.management.utils.JDBCUtils;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 * 
 * @author Ramesh Fadatare
 *
 */

public class MutuelleImplDao  implements MutuelleDao {

	private static final String INSERT_MUTUELLE_SQL = "INSERT INTO mutuelle"
			+ "  (nomMutuelle, 	province, ville, mutuelleCouvert,  dateEntre) VALUES " + " (?, ?, ?, ?, ?);";

	private static final String SELECT_MUTUELLE_BY_ID = "select mutuelleID,nomMutuelle,province,ville,mutuelleCouvert,dateEntre from mutuelle where mutuelleID =?";
	private static final String SELECT_ALL_MUTUELLE = "select * from mutuelle";
	private static final String DELETE_MUTUELLE_BY_ID = "delete from mutuelle where mutuelleID = ?;";
	private static final String UPDATE_MUTUELLE= "update mutuelle set nomMutuelle = ?, province= ?, ville =?, mutuelleCouvert =?, dateEntre = ? where mutuelleID = ?;";

	public MutuelleImplDao() {
	}


	public void insertMutuelle(Mutuelle mutuelle) throws SQLException {
		System.out.println(INSERT_MUTUELLE_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MUTUELLE_SQL)) {
			preparedStatement.setString(1, mutuelle.getNomMutuelle());
			preparedStatement.setString(2, mutuelle.getProvince());
			preparedStatement.setString(3, mutuelle.getVille());
			
			preparedStatement.setString(4, mutuelle.getMutuelleCouvert());
			preparedStatement.setDate(5, JDBCUtils.getSQLDate(mutuelle.getDateEntre()));
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}


	public Mutuelle selectMutuelle(long ID) {
		Mutuelle mutuelle = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_MUTUELLE_BY_ID);) {
			preparedStatement.setLong(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long mutuelleID = rs.getLong("mutuelleID");
				String nomMutuelle = rs.getString("nomMutuelle");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				
				String mutuelleCouvert = rs.getString("mutuelleCouvert");
				LocalDate dateEntre = rs.getDate("dateEntre").toLocalDate();
				mutuelle = new Mutuelle(mutuelleID, nomMutuelle, province, ville, mutuelleCouvert, dateEntre);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return mutuelle;
	}


	public List<Mutuelle> selectAllMutuelle() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Mutuelle> mutuelle = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_MUTUELLE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long mutuelleID = rs.getLong("mutuelleID");
				String nomMutuelle = rs.getString("nomMutuelle");
				String province = rs.getString("province");
				String ville = rs.getString("ville");
				
				String mutuelleCouvert = rs.getString("mutuelleCouvert");
				LocalDate dateEntre = rs.getDate("dateEntre").toLocalDate();
				mutuelle.add(new Mutuelle(mutuelleID, nomMutuelle, province, ville, mutuelleCouvert, dateEntre));
			
				
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return mutuelle;
	}

	public boolean deleteMutuelle(int mutuelleID) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_MUTUELLE_BY_ID);) {
			statement.setInt(1, mutuelleID);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	public boolean updateMutuelle(Mutuelle mutuelle) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_MUTUELLE);) {
			statement.setString(1, mutuelle.getNomMutuelle());
			statement.setString(2, mutuelle.getProvince());
			statement.setString(3, mutuelle.getVille());
			statement.setString(4, mutuelle.getMutuelleCouvert());
			statement.setDate(5, JDBCUtils.getSQLDate(mutuelle.getDateEntre()));
			
			statement.setLong(6, mutuelle.getMutuelleID());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
