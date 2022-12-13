package openassu.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;


import openassu.management.model.User;
import openassu.management.utils.JDBCUtils;


/**
 * This DAO class provides CRUD database operations for the table todos in the
 * database.
 * 
 * @author Ramesh Fadatare
 *
 */

public class UserImplDao  implements UserDao {

		
	private static final String INSERT_USER_SLQ = "INSERT INTO users	" + "(prenom,nom,email,password,categorie,telephone) VALUES " + "(?,?,?,?,?,?);";
	
	private static final String SELECT_USER_BY_ID = "select idUser,prenom,nom,email,password,categorie,telephone from users where idUser = ?";
	private static final String SELECT_ALL_USER = "select * from users";
	private static final String DELETE_USER_SQL = "delete from users where idUser = ?;";
	private static final String UPDATE_USER_SQL = "update users set prenom = ?, nom = ?, email = ?,password = ?, categorie=?,telephone=? where idUser = ?;";

	public UserImplDao() {
	}


	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USER_SLQ);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SLQ)) {
			preparedStatement.setString(1, user.getPrenom());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setString(3, user.getEmail());
			
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getCategorie());
			preparedStatement.setString(6, user.getTelephone());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
	}

	

	public User selectUser(long ID) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setLong(1, ID);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long idUser = rs.getLong("idUser");
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				
				String password = rs.getString("password");
				String categorie = rs.getString("categorie");
				String telephone = rs.getString("telephone");
				user = new User(idUser, prenom, nom, email, password,categorie,telephone);
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return user;
	}


	public List<User> selectAllUser() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> user = new ArrayList<>();

		// Step 1: Establishing a Connection
		try (Connection connection = JDBCUtils.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				long idUser = rs.getLong("idUser");
				String prenom = rs.getString("prenom");
				String nom = rs.getString("nom");
				String email = rs.getString("email");
				
				String password = rs.getString("password");
				String categorie = rs.getString("categorie");
				String telephone = rs.getString("telephone");
				user.add(new User(idUser, prenom, nom, email, password, categorie, telephone));
			
				
			}
		} catch (SQLException exception) {
			JDBCUtils.printSQLException(exception);
		}
		return user;
	}

	public boolean deleteUser(int idUser) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USER_SQL);) {
			statement.setInt(1, idUser);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}


	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = JDBCUtils.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USER_SQL);) {
			statement.setString(1, user.getPrenom());
			statement.setString(2, user.getNom());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());
			statement.setString(5, user.getCategorie());
			statement.setString(6, user.getTelephone());
			
			statement.setLong(7, user.getIdUser());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
}
