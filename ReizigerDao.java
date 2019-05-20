package P3;

import java.sql.SQLException;
import java.util.ArrayList;


public interface ReizigerDao {
	public ArrayList<Reiziger> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Reiziger> findByGBdatum(String GBdatum) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Reiziger save(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public Reiziger update(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public boolean delete(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	
	public Reiziger reizigerById(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	/*
	 * public void closeConnection();
	 */}
