package com.saib.dto;

public class DetailsType {

	protected String bezeichnung;
	protected String bic;
	protected String ort;
	protected String plz;

	
	
	@Override
	public String toString() {
		return "DetailsType [bezeichnung=" + bezeichnung + ", bic=" + bic + ", ort=" + ort + ", plz=" + plz + "]";
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}

}