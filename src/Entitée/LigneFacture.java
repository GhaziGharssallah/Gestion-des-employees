package Entitée;

public class LigneFacture
{
private int numLgFacture;
private int qte;
private int prix;
private int remise;
private Service service;
private Facture facture;
public int getNumLgFacture() {
	return numLgFacture;
}
public void setNumLgFacture(int numLgFacture) {
	this.numLgFacture = numLgFacture;
}
public int getQte() {
	return qte;
}
public void setQte(int qte) {
	this.qte = qte;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
public int getRemise() {
	return remise;
}
public void setRemise(int remise) {
	this.remise = remise;
}
public Service getService() {
	return service;
}
public void setService(Service service) {
	this.service = service;
}
public Facture getFacture() {
	return facture;
}
public void setFacture(Facture facture) {
	this.facture = facture;
}
@Override
public String toString() {
	return "LigneFacture [numLgFacture=" + numLgFacture + ", qte=" + qte
			+ ", prix=" + prix + ", remise=" + remise + ", service=" + service
			+ ", facture=" + facture + "]";
}
public LigneFacture(int numLgFacture, int qte, int prix, int remise,
		Service service, Facture facture) {
	super();
	this.numLgFacture = numLgFacture;
	this.qte = qte;
	this.prix = prix;
	this.remise = remise;
	this.service = service;
	this.facture = facture;
}
public LigneFacture(int numLgFacture) {
	super();
	this.numLgFacture = numLgFacture;
}
 
public LigneFacture() {
	super();
}

}
