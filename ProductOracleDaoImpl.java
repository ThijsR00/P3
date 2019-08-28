package P3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductOracleDaoImpl extends OracleBaseDao implements ProductDao {
	public ArrayList<Product> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM Product";
		ResultSet rs = stmt.executeQuery(queryText);
		ArrayList<Product> alleProducten = new ArrayList<Product>();
		OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();
		while (rs.next()) {
			ArrayList<Integer> tijdelijk= c.findByProductnummer(rs.getInt(1));
			alleProducten.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), tijdelijk));
		}
		rs.close();
		stmt.close();
		conn.close();
		return alleProducten;
	}
	
	
	public ArrayList<Product> findByKaartnummer(int kaartnummer) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "SELECT * FROM product WHERE productnummer IN ("
				+ "select productnummer from ov_chipkaart_product where kaartnummer = " + kaartnummer + ")";
		ResultSet rs = stmt.executeQuery(queryText);
		ArrayList<Product> producten = new ArrayList<Product>();
		OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();
		while(rs.next()) {
			ArrayList<Integer> tijdelijk= c.findByProductnummer(rs.getInt(1));
			producten.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), tijdelijk));
		}
		rs.close();
		stmt.close();
		conn.close();
		return producten;
	}
	public Product save(Product product) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText = "INSERT INTO product(productnaam, beschrijving,prijs) values('"
				+ product.getProductNaam() + "', '" + product.getBeschrijving()
				+ "'," + product.getPrijs() + " )";
		stmt.executeQuery(queryText);
		String queryText2 = "SELECT productnummer FROM product WHERE productnummer = (SELECT MAX(productnummer) FROM product)";
		ResultSet rs = stmt.executeQuery(queryText2);
		while (rs.next()) {
			product.setProductNummer(rs.getInt(1));
		}
		stmt.close();
		conn.close();
		return product;
	}
	public boolean delete(Product product) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText1 = "DELETE FROM ov_chipkaart_product WHERE productnummer = " + product.getProductNummer();
		stmt.executeQuery(queryText1);
		String queryText2 = "DELETE FROM product WHERE productnummer = " + product.getProductNummer();
		stmt.executeQuery(queryText2);
		stmt.close();
		conn.close();
		return true;
	}
	public Product update(Product product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		OracleBaseDao.getConnection();
		Statement stmt = conn.createStatement();
		String queryText1 = "UPDATE product SET productnaam = '" + product.getProductNaam() + "', beschrijving = '" + product.getBeschrijving() + "', prijs = " + product.getPrijs() + " WHERE productnummer = " + product.getProductNummer(); 
		stmt.executeQuery(queryText1);
		String queryText2 = "SELECT * FROM product WHERE productnummer = " + product.getProductNummer();
		ResultSet rs = stmt.executeQuery(queryText2);
		Product returnproduct = new Product(0, queryText2, queryText2, 0, null);
		OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();
		while (rs.next()) {
			ArrayList<Integer> tijdelijk= c.findByProductnummer(rs.getInt(1));
			returnproduct = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), tijdelijk);
		}
		rs.close();
		stmt.close();
		conn.close();
		return returnproduct;
	}
}
