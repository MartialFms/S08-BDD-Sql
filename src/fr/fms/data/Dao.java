package fr.fms.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public interface Dao<T> {
	public Connection connection = BddConnection.getConnection();
	public void create(T obj) throws SQLException;
	public void read(T obj) throws SQLException;
	public void update(T obj); 
	public void delete(T obj) throws SQLException;
	public ArrayList<T> readAll() throws SQLException;
}
