package P3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OV_ChipkaartOracleDaoImpl extends OracleBaseDao implements OV_ChipkaartDao {
	public ArrayList<OV_Chipkaart> findAll()throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ArrayList<OV_Chipkaart> alleOV_Chipkaarten = new ArrayList<OV_Chipkaart>();
		OracleBaseDao.getConnection();
		ReizigerOracleDaoImpl a = new ReizigerOracleDaoImpl();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM OV_chipkaart";
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {
			Reiziger tijdelijk = a.reizigerById(rs.getInt(5));
			alleOV_Chipkaarten.add(new OV_Chipkaart(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), tijdelijk));
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleOV_Chipkaarten;
	}

	public ArrayList<OV_Chipkaart> findByReiziger(Reiziger reiziger)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		ArrayList<OV_Chipkaart> alleOV_ChipkaartenVanReiziger = new ArrayList<OV_Chipkaart>();
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM OV_CHIPKAART WHERE reizigerid = " + reiziger.getReizigerID();
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {
			alleOV_ChipkaartenVanReiziger
					.add(new OV_Chipkaart(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), reiziger));
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleOV_ChipkaartenVanReiziger;
	}
	public ArrayList<Integer> findByProductnummer(int productnummer)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM OV_CHIPKAART_PRODUCT WHERE productnummer = " + productnummer;
		ResultSet rs = stmt.executeQuery(queryText);
		ArrayList<Integer> kaarten = new ArrayList<Integer>();
		while (rs.next()) {
			kaarten.add(rs.getInt(1));
		}
		rs.close();
		stmt.close();
		conn.close();
		return kaarten;
	}

	public OV_Chipkaart save(OV_Chipkaart ov_chipkaart)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "INSERT INTO OV_CHIPKAART(geldigtot, klasse, saldo, reizigerid) VALUES(TO_DATE('"
				+ java.sql.Date.valueOf(ov_chipkaart.getGeldigTot()) + "','yyyy-mm-dd'), " + ov_chipkaart.getKlasse()
				+ ", " + ov_chipkaart.getSaldo() + ", " + ov_chipkaart.getReizigerID() + ")";
		stmt.executeQuery(queryText);
		queryText = "SELECT kaartnummer FROM OV_CHIPKAART WHERE geldigtot = TO_DATE('"
				+ java.sql.Date.valueOf(ov_chipkaart.getGeldigTot()) + "','yyyy-mm-dd') AND klasse = "
				+ ov_chipkaart.getKlasse() + " AND saldo = " + ov_chipkaart.getSaldo() + " AND reizigerid = "
				+ ov_chipkaart.getReizigerID();
		ResultSet rs = stmt.executeQuery(queryText);
		while (rs.next()) {
			ov_chipkaart.setKaartNummer(rs.getInt("kaartnummer"));
		}
		rs.close();
		stmt.close();
		conn.close();
		return ov_chipkaart;
	}

	public OV_Chipkaart update(OV_Chipkaart ov_chipkaart)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "UPDATE OV_CHIPKAART SET geldigtot = TO_DATE('"
				+ java.sql.Date.valueOf(ov_chipkaart.getGeldigTot()) + "', 'yyyy-mm-dd'), klasse = "
				+ ov_chipkaart.getKlasse() + ", saldo = " + ov_chipkaart.getSaldo() + ", reizigerid = "
				+ ov_chipkaart.getReizigerID() + " WHERE kaartnummer = " + ov_chipkaart.getKaartNummer();
		stmt.executeQuery(queryText);
		stmt.close();
		conn.close();
		return ov_chipkaart;
	}

	public boolean delete(OV_Chipkaart ov_chipkaart)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		ov_chipkaart.getReiziger().deleteKaart(ov_chipkaart);
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "DELETE FROM ov_chipkaart_product WHERE kaartnummer = " + ov_chipkaart.getKaartNummer();
		stmt.executeQuery(queryText);
		String queryText2 = "DELETE FROM OV_CHIPKAART WHERE kaartnummer = " + ov_chipkaart.getKaartNummer();
		stmt.executeQuery(queryText2);
		
		stmt.close();
		conn.close();
		return true;
	}
}
