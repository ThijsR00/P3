package P3;

import java.sql.SQLException;

public class Main2 {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		ReizigerOracleDaoImpl a = new ReizigerOracleDaoImpl();
//		AdresOracleDaoImpl b = new AdresOracleDaoImpl();
		OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();
		System.out.println(c.findAll());
	}
}
