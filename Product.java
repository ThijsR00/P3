package P3;

import java.util.ArrayList;

public class Product {
	private int productNummer;
	private String productNaam;
	private String beschrijving;
	private double prijs;
	private ArrayList<Integer> kaarten = new ArrayList<Integer>();
	public Product(int productNummer, String productNaam, String beschrijving, double prijs, ArrayList<Integer> kaarten) {
		this.productNummer = productNummer;
		this.productNaam = productNaam;
		this.beschrijving = beschrijving;
		this.prijs = prijs;
		this.kaarten = kaarten;
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
	public void setProductNaam(String productNaam) {
		this.productNaam = productNaam;
	}
	public String getBeschrijving() {
		return beschrijving;
	}
	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
	public double getPrijs() {
		return prijs;
	}
	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	public ArrayList<Integer> getKaarten() {
		return kaarten;
	}
	public void setKaarten(ArrayList<Integer> kaarten) {
		this.kaarten = kaarten;
	}
	@Override
	public String toString() {
		return "Product [productNummer=" + productNummer + ", productNaam=" + productNaam + ", beschrijving="
				+ beschrijving + ", prijs=" + prijs + "]";
	}
}
