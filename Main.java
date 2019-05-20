package P3;

import java.sql.SQLException;

//De PKs worden gemaakt door Oracle.

public class Main {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		ReizigerOracleDaoImpl a = new ReizigerOracleDaoImpl();
//		AdresOracleDaoImpl b = new AdresOracleDaoImpl();
		OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();		
		
		Reiziger r1 = new Reiziger("J", "van", "Vermeer", "1999-2-12");
		Reiziger r2 = new Reiziger("K", null, "Kazen", "1999-6-22");
		Reiziger r3 = new Reiziger("P", "de", "Mol", "2000-12-10");
		
		System.out.println(r1);
		
		System.out.println(a.findAll());
		
		System.out.println(a.findByGBdatum("1999-2-12"));
		
		r2.setAchternaam("Kaas");
		
		a.delete(r3);
		
		System.out.println(a.findAll());

		OV_Chipkaart k1 = new OV_Chipkaart("2021-4-14", 2, 30.00, r2);
		OV_Chipkaart k2 = new OV_Chipkaart("2021-4-15", 1, 0.00, r1);
		System.out.println(k1);
		
		k1.setKlasse(1);
		System.out.println(k1);
		
		c.delete(k1);
		
		System.out.println("Joe");
		System.out.println(r2);
		System.out.println(c.findAll());
		
		System.out.println(c.findByReiziger(r1));
		Reiziger re = a.reizigerById(4);
		System.out.println(re);
	} 
}
