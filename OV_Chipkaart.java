package P3;

import java.sql.SQLException;
import java.util.ArrayList;

public class OV_Chipkaart {
	OV_ChipkaartOracleDaoImpl c = new OV_ChipkaartOracleDaoImpl();
	private int kaartNummer;
	private String geldigTot;
	private int klasse;
	private double saldo;
	private int reizigerId;
	private Reiziger reiziger;
	private ArrayList<Product> producten = new ArrayList<Product>(); 
	
	public OV_Chipkaart(String geldigTot, int klasse, double saldo, Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reiziger = reiziger;
		this.reizigerId = reiziger.getReizigerID();
		c.save(this);
		System.out.println(this.getKaartNummer());
		reiziger.addKaart(this);
	}
	
	public OV_Chipkaart(int kaarNummer, String geldigTot, int klasse, double saldo, hibernate.Reiziger reiziger) {
		this.kaartNummer = kaarNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerId = reiziger.getReizigerID();
		this.reiziger = null;
	}


	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.geldigTot = geldigTot;
		c.update(this);
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.klasse = klasse;
		c.update(this);
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.saldo = saldo;
		c.update(this);
	}

	public Reiziger getReiziger() {
		return reiziger;
	}
	
	public int getReizigerID() {
		return reizigerId;
	}

	public void setReizigerID(Reiziger reiziger) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.reiziger = reiziger;
		c.update(this);
	}
	
	public ArrayList<Product> getProducten() {
		return producten;
	}

	public void setProducten(ArrayList<Product> producten) {
		this.producten = producten;

	}

	@Override
	public String toString() {
		return "OV_Chipkaart [kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot + ", klasse=" + klasse + ", saldo="
				+ saldo + ", reizigerId=" + reizigerId + ", reiziger=" + reiziger + ", producten=" + producten + "]";
	}

	
	
}
