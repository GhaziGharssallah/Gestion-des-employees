package Entitée;

public class Service {
private int numService ;
private String designation;
private String prix;
private String prixMax;
private String remise;
private boolean F_V;
private boolean R_NR;

public int getNumService() {
	return numService;
}
public void setNumService(int numService) {
	this.numService = numService;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
 
 
 
public String getPrix() {
	return prix;
}
public void setPrix(String prix) {
	this.prix = prix;
}
public String getPrixMax() {
	return prixMax;
}
public void setPrixMax(String prixMax) {
	this.prixMax = prixMax;
}
public boolean isF_V() {
	return F_V;
}
public void setF_V(boolean f_V) {
	F_V = f_V;
}
public boolean isR_NR() {
	return R_NR;
}
public void setR_NR(boolean r_NR) {
	R_NR = r_NR;
}
 
public String getRemise() {
	return remise;
}
public void setRemise(String remise) {
	this.remise = remise;
}
public String toString() {
	return   designation ;
}
 
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Service other = (Service) obj;
	if (numService != other.numService)
		return false;
	return true;
}
 
  
 
public Service(int numService, String designation, String prix, String prixMax,
		String remise, boolean f_V, boolean r_NR) {
	super();
	this.numService = numService;
	this.designation = designation;
	this.prix = prix;
	this.prixMax = prixMax;
	this.remise = remise;
	F_V = f_V;
	R_NR = r_NR;
}
public Service() {
	super();
}
public Service(int numService) {
	super();
	this.numService = numService;
}
 
public int getResultat()
{  int i=0;
 
	if( isR_NR()==true)
        i=1;//remisé
	else i=0;//nn remisé
	return i;
	
	
}
public int getResultatPrix()
{
	int i ;
	if(isF_V()==true)
		i=1;//prix
	else i=0;//prix max
	return i;
	
}

	
	
	
}
