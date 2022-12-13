package openassu.management.dao;

import java.sql.SQLException;
import java.util.List;

import openassu.management.model.Client;

public interface ClientDao {

	void insertClient(Client client) throws SQLException;

	Client selectClient(long ID );

	List<Client> selectAllClient();

	boolean deleteClient(int  clientID) throws SQLException;

	boolean updateClient(Client client) throws SQLException;

}

