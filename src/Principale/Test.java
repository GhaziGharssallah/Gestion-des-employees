package Principale;

import DAO.LigneFactureDAO;
import Entitée.Facture;
import Entitée.LigneFacture;
import Entitée.Service;

public class Test 
{
	public static void main(String[] args)
	{
		// pour client
		// new ClientDAO().ajouter(new Client(1,"hana","gharssallah","" ,"" ,21781519,"hana-gha@gmail.com","refefe","eezeerze",false,false)) ;
		//System.out.println(new ClientDAO().rechercherParId(1));
		//new ClientDAO().supprimer(new Client(1));
		//pour facture
		//new FactureDAO().supprimer(new Facture(2));
		//new FactureDAO().ajouter(new Facture(2,4,"25/58/5284",new Client(1)));
		// System.out.println( new FactureDAO().rechercherParClient(new Client(1)));
		//new FactureDAO().modifier(new Facture(2,8,"58/74/2145",new Client(1)));
		//new FactureDAO().ajouter(new Facture(3,5,"25/552/5284",new Client(3)));
		// new FactureDAO().ajouter(new Facture(5, 4,"85/58/5284",new Client(4)));
		// System.out.println(new FactureDAO().getListe());
		// for(Facture f:new FactureDAO().getListe()) 
		//{
		//	System.out.println(f.getNumFacture()+" "+f.getRemise()+" "+f.getDate()+" " +f.getClient());
		// }
		//System.out.println(new FactureDAO().rechercherParId(2));
		//pour service
		//new ServiceDAO().supprimer(new Service(1));
		//new ServiceDAO().ajouter(new Service(2,"mecanique","125","4528","5",false,false));
		//for(Service s:new ServiceDAO().getListe()) 
		//{
			//System.out.println(s.getNumService()+" "+s.getDesignation()+" "+s.getPrix()+" " +s.getPrixMax()+" "+s.getRemise()+" "+s.isF_V()+" "+s.isR_NR());
		//}
	//	 System.out.println(new ServiceDAO().rechercherParId(2));
//
		//new ServiceDAO().supprimer(new Service(1));
		//new ServiceDAO().modifier(new Service(1,"electri","528","85" ,"8",true,true));
		// pour  lignefacture
		//new LigneFactureDAO().supprimer(new LigneFacture(1));
		//new LigneFactureDAO().ajouter(new LigneFacture(2,85,25,6,new Service(5),new Facture(8)));
		
		
		System.out.println(new LigneFactureDAO().rechercherParFacture(new Facture(2)));
		System.out.println(new LigneFactureDAO().getListe());

		System.out.println(new LigneFactureDAO().rechercherParService (new Service(5)));
		
	}
}
