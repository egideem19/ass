package openassu.management.dao;

import java.sql.SQLException;
import java.util.List;

import openassu.management.model.Assurance;

public interface AssuranceDao {

	void insertAssurance(Assurance assurance) throws SQLException;

	Assurance selectAssurance(long ID );

	List<Assurance> selectAllAssurance();

	boolean deleteAssurance(int  assuranceID) throws SQLException;

	boolean updateAssurance(Assurance assurance) throws SQLException;

}

