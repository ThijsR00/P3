package P3;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDao {
	public ArrayList<Product> findAll() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public ArrayList<Product> findByKaartnummer(int kaartnummer) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Product save(Product product) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public boolean delete(Product product) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public Product update(Product product) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
