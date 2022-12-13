package openassu.management.dao;

import java.sql.SQLException;
import java.util.List;

import openassu.management.model.Mutuelle;

public interface MutuelleDao {

	void insertMutuelle(Mutuelle mutuelle) throws SQLException;

	Mutuelle selectMutuelle(long ID );

	List<Mutuelle> selectAllMutuelle();

	boolean deleteMutuelle(int  mutuelleID) throws SQLException;

	boolean updateMutuelle(Mutuelle mutuelle) throws SQLException;

}