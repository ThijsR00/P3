package P3;

import java.sql.SQLException;
import java.util.ArrayList;

public class Reiziger {
	ReizigerOracleDaoImpl a = new ReizigerOracleDaoImpl();
	private int reizigerID;
	private String voorletters;
	private String tussenvoegsel;
	private String achternaam;
	private String gbdatum;
	private ArrayList<OV_Chipkaart> kaarten = new ArrayList<OV_Chipkaart>();

	
	public Reiziger(String voorletters, String tussenvoegsel, String achternaam, String gbdatum) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
		a.save(this);
	}
	
	public Reiziger(int reizigerID, String voorletters, String tussenvoegsel, String achternaam, String gbdatum) {

		this.reizigerID = reizigerID;
		this.voorletters = voorletters;
		this.tussenvoegsel = tussenvoegsel;
		this.achternaam = achternaam;
		this.gbdatum = gbdatum;
	}

	public int getReizigerID() {
		return reizigerID;
	}
	public void setReizigerID(int reizigerID) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.reizigerID = reizigerID;
	}
	public String getVoorletters() {
		return voorletters;
	}
	public void setVoorletters(String voorletters) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.voorletters = voorletters;
		a.update(this);
	}
	public String getTussenvoegsel() {
		return tussenvoegsel;
	}
	public void setTussenvoegsel(String tussenvoegsel) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.tussenvoegsel = tussenvoegsel;
		a.update(this);
	}
	public String getAchternaam() {
		return achternaam;
	}
	public void setAchternaam(String achternaam) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.achternaam = achternaam;
		a.update(this);
	}
	public String getGbdatum() {
		return gbdatum;
	}
	public void setGbdatum(String gbdatum) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.gbdatum = gbdatum;
		a.update(this);
	}
	
	public ArrayList<OV_Chipkaart> getKaarten() {
		return kaarten;
	}

	public void setKaarten(ArrayList<OV_Chipkaart> kaarten) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.kaarten = kaarten;
	}
	
	public void addKaart(OV_Chipkaart ov) {
		System.out.println(ov);
		
		OV_Chipkaart ovc = new OV_Chipkaart(ov.getKaartNummer(), ov.getGeldigTot(), ov.getKlasse(), ov.getSaldo(), ov.getReiziger());
		kaarten.add(ovc);
	}
	
	public void deleteKaart(OV_Chipkaart ov) {
		System.out.println("joe");
		System.out.println(ov);
		for (int i = 0; i<kaarten.size(); i++) {
			if(kaarten.get(i).getKaartNummer() == ov.getKaartNummer()) {
				this.kaarten.remove(i);
				System.out.println(this.getKaarten());
			}
		}
		
		
	}

	@Override
	public String toString() {
		return "GEBRUIKER: " + reizigerID + ", " + voorletters + ", "
				+ tussenvoegsel + ", " + achternaam + ", " + gbdatum + ", " + kaarten;
	}


	

}
