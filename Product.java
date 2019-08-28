package P3;

import java.sql.SQLException;
import java.util.ArrayList;

public class Product {
	ProductOracleDaoImpl d = new ProductOracleDaoImpl();

	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<Integer> kaarten = new ArrayList<Integer>();
	public Product(int productNummer, String productNaam, String beschrijving, double prijs, ArrayList<Integer> kaarten) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
		this.kaarten = kaarten;
		
	}
	public Product(String productNaam, String beschrijving, double prijs) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
		d.save(this);
	}
	public int getProductNummer() {
		return productNummer;
	}
	public void setProductNummer(int productNummer) {
		this.productNummer = productNummer;
	}
	public String getProductNaam() {
		return productNaam;
	}
	public void setProductNaam(String productNaam) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.productNaam = productNaam;
		d.update(this);

	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.beschrijving = beschrijving;
		d.update(this);
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.prijs = prijs;
		d.update(this);
	}
	public ArrayList<Integer> getKaarten() {
		return kaarten;
	}
	public void setKaarten(ArrayList<Integer> kaarten) {
		this.kaarten = kaarten;
	}
	@Override
	public String toString() {
		return "Product [productNummer=" + productNummer + ", productNaam="
				+ productNaam + ", beschrijving=" + beschrijving + ", prijs="
				+ prijs + ", kaarten=" + kaarten + "]";
	}
	
}
