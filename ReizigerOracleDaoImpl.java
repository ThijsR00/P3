package P3;

import java.util.ArrayList; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao{
	public ArrayList<Reiziger> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		ArrayList<Reiziger> alleReizigers = new ArrayList<Reiziger>();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM reiziger";
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {
			alleReizigers.add(new Reiziger(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleReizigers;
		
	}
	public ArrayList<Reiziger> findByGBdatum(String GBdatum) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		ArrayList<Reiziger> alleReizigersMetGd = new ArrayList<Reiziger>();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM reiziger WHERE gebortedatum = TO_DATE('" + java.sql.Date.valueOf(GBdatum) + "','yyyy-mm-dd')";
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {
			alleReizigersMetGd.add(new Reiziger(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleReizigersMetGd;
	}
	public Reiziger save(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "INSERT INTO REIZIGER(voorletters, tussenvoegsel, achternaam, gebortedatum) VALUES('" + reiziger.getVoorletters() + "', '" + reiziger.getTussenvoegsel() + "', '" + reiziger.getAchternaam() + "', TO_DATE('" + java.sql.Date.valueOf(reiziger.getGbdatum()) + "','yyyy-mm-dd'))";
		stmt.executeQuery(queryText);
		queryText = "SELECT REIZIGERID FROM REIZIGER WHERE REIZIGERID = (SELECT MAX(REIZIGERID) FROM REIZIGER)";
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {   
			reiziger.setReizigerID(rs.getInt("reizigerID"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return reiziger;
	}
	public Reiziger update(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "UPDATE REIZIGER SET voorletters = '" + reiziger.getVoorletters() + "', tussenvoegsel = '" + reiziger.getTussenvoegsel() + "', achternaam = '" + reiziger.getAchternaam() + "', gebortedatum = TO_DATE('" + java.sql.Date.valueOf(reiziger.getGbdatum()) + "','yyyy-mm-dd') WHERE reizigerID= " + reiziger.getReizigerID();
		stmt.executeQuery(queryText);
		queryText = "SELECT * FROM REIZIGER WHERE reizigerID = " + reiziger.getReizigerID();
		ResultSet rs = stmt.executeQuery(queryText);
		Reiziger returnReiziger = null;
		while (rs.next()) {
			returnReiziger = new Reiziger(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		rs.close();
		stmt.close();
		conn.close();
		return returnReiziger;
	}
	public boolean delete(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "DELETE FROM REIZIGER WHERE reizigerID = " + reiziger.getReizigerID();
		stmt.executeQuery(queryText);
		stmt.close();
		conn.close();
		return true;
	}
	public Reiziger reizigerById(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM REIZIGER WHERE reizigerID = " + id;
		ResultSet rs = stmt.executeQuery(queryText);
		Reiziger reiziger = null;
		while (rs.next()) {
			reiziger = new Reiziger(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
		}
		rs.close();
		stmt.close();
		conn.close();
		return reiziger;
	}
}
