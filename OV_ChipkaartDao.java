,package P3;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OV_ChipkaartDao {
	public ArrayList<OV_Chipkaart> findAll() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public ArrayList<OV_Chipkaart> findByReiziger(Reiziger reiziger) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public OV_Chipkaart save(OV_Chipkaart ov_chipkaart) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	public boolean delete(OV_Chipkaart ov_chipkaart) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
	public OV_Chipkaart update(OV_Chipkaart ov_chipkaart) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException;
}
