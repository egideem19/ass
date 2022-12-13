package openassu.management.dao;

import java.sql.SQLException;
import java.util.List;

import openassu.management.model.User;

public interface UserDao {

	void insertUser(User user) throws SQLException;

	User selectUser(long ID );

	List<User> selectAllUser();

	boolean deleteUser(int  idUser) throws SQLException;

	boolean updateUser(User user) throws SQLException;

}

