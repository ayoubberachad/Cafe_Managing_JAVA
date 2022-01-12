package com.cafe.managing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	
	private long code ;
	private LocalDateTime  dateTime;
	private double total;
	private String serveur;
	private String table ;
	List<Consommation> consommations = new ArrayList<>();
	
	public List<Consommation> getConsommations() {		
		return consommations;
	}
	public int getNbrArticle() {		
		return consommations.size();
	}

	public Ticket(long code) {
 		this.code = code;
		this.dateTime = LocalDateTime.now(); 
	}


	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	public void addConsommation(Consommation consommation) {
		consommations.add(consommation);
		total=total+consommation.getPrix()*consommation.getQte();
	 	
	}
	

}
