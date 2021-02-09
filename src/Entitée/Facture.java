package Entitée;

import java.sql.Date;

 

public class Facture
{
private int numFacture;
private int remise;
private Date date;
private Client	client;
public int getNumFacture() {
	return numFacture;
}
public void setNumFacture(int numFacture) {
	this.numFacture = numFacture;
}
public int getRemise() {
	return remise;
}
public void setRemise(int remise) {
	this.remise = remise;
}
 
 
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
 
  
public Facture(int numFacture, int remise, Date date, Client client) {
	super();
	this.numFacture = numFacture;
	this.remise = remise;
	this.date = date;
	this.client = client;
}
 
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Facture other = (Facture) obj;
	if (numFacture != other.numFacture)
		return false;
	return true;
}
@Override
public String toString() {
	return ""+numFacture;
}
public Facture() {
	super();
}
public Facture(int numFacture) {
	super();
	this.numFacture = numFacture;
}
 


}
