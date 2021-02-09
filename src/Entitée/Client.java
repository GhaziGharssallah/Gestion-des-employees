package Entitée;

public class Client
{

	private int numClient;
	private String nom;
	private String prenom;
	private String raison;
	private String matricule ;
	private int numtel;
	private String email;
	private String fax;
	private String adresse ;
	private boolean E_P;
	private boolean A_N;
	public int getNumClient() {
		return numClient;
	}
	public void setNumClient(int numclient) {
		this.numClient = numclient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRaison() {
		return raison;
	}
	public void setRaison(String raison) {
		this.raison = raison;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public int getNumtel() {
		return numtel;
	}
	public void setNumtel(int numtel) {
		this.numtel = numtel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isE_P() {
		return E_P;
	}
	public void setE_P(boolean e_P) {
		E_P = e_P;
	}
	public boolean isA_N() {
		return A_N;
	}
	public void setA_N(boolean a_N) {
		A_N = a_N;
	}
	public Client(int numclient, String nom, String prenom, String raison,
			String matricule, int numtel, String email, String fax,
			String adresse, boolean e_P, boolean a_N) {
		super();
		this.numClient = numclient;
		this.nom = nom;
		this.prenom = prenom;
		this.raison = raison;
		this.matricule = matricule;
		this.numtel = numtel;
		this.email = email;
		this.fax = fax;
		this.adresse = adresse;
		E_P = e_P;
		A_N = a_N;
	}
	public Client() {
		super();
	}
	public Client(int numclient) {
		super();
		this.numClient = numclient;
	}
	 
	public String toString() {
		return " nucl=" + numClient ;  
				  
	}
	 
	 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (numClient != other.numClient)
			return false;
		return true;
	}

	public int getResultat()
	{  int i=0;
	 
		if( isE_P()==true)
            i=1;//personne
		else i=0;//entreprise
		return i;
		
		
	}
	public int getResultatA()
	{
		int i=0;
		if(isA_N()==true)
			i=1;
		else i=0;
		return i;
		
	}



}
