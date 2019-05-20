package P3;

public class Adres {
	private int AdresID;
	private String postcode;
	private String huisnummer;
	private String straat;
	private String woonplaats;
	private Reiziger reiziger;
	
	public Adres(String postcode, String huisnummer, String straat, String woonplaats, Reiziger reiziger) {
		this.postcode = postcode;
		this.huisnummer = huisnummer;
		this.straat = straat;
		this.woonplaats = woonplaats;
		this.reiziger = reiziger;
	}

	public int getAdresID() {
		return AdresID;
	}

	public void setAdresID(int adresID) {
		AdresID = adresID;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHuisnummer() {
		return huisnummer;
	}

	public void setHuisnummer(String huisnummer) {
		this.huisnummer = huisnummer;
	}

	public String getStraat() {
		return straat;
	}

	public void setStraat(String straat) {
		this.straat = straat;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public Reiziger getReiziger() {
		return reiziger;
	}

	public void setReiziger(Reiziger reiziger) {
		this.reiziger = reiziger;
	}

	public String toString() {
		return "Adres [AdresID=" + AdresID + ", postcode=" + postcode + ", huisnummer=" + huisnummer + ", straat="
				+ straat + ", woonplaats=" + woonplaats;
	}

	
}
