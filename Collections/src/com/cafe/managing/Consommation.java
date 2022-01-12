package com.cafe.managing;

public class Consommation {
	private String designiation ;
	private double prix;
	private int qte;	
	public double getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}
	public Consommation(String designiation, int qte ,double prix) {
		super();
		this.designiation = designiation;
		this.prix = prix;
		this.qte = qte;
	}
	public String getDesigniation() {
		return designiation;
	}
	public void setDesigniation(String designiation) {
		this.designiation = designiation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	
	
	

}
