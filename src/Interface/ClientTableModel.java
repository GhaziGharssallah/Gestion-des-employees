package Interface;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import DAO.ClientDAO;
import Entitée.Client;

public class ClientTableModel implements TableModel {

	 String t[] ={"Numcl","Nom","Prenom","Raison","Matricule","Numtel","Email","Fax","Adresse","A_N","E_P"};
	 Class c[] =new Class[] {Integer.class,String.class,String.class,String.class,String.class,Integer.class,String.class,String.class,String.class,Boolean.class,Boolean.class};
	 Vector<Client> v= new ClientDAO().getListe();
	 public ClientTableModel(){
		 
		 Vector<Client> v= new ClientDAO().getListe();
	 }
	 
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}
	public ClientTableModel(String champ,String valeur)
	{
		v = new ClientDAO().getChercherClient(champ, valeur);
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		 
		return c[arg0];
	}

	@Override
	public int getColumnCount() {
		 
		return t.length;
	}

	@Override
	public String getColumnName(int arg0) {
		  
		return t[arg0];
	}

	@Override
	public int getRowCount() {
		 
		return v.size();
	}

	@Override
	public Object getValueAt(int i, int j) {
		 
	Client c=v.elementAt(i);
		if(j==0)
			return c.getNumClient();
		else if (j==1)
			return c.getNom();
		else if(j==2)
			return c.getPrenom();
		else if(j==3)
			return c.getRaison();
		else if(j==4)
			return c.getMatricule();
		else if(j==5)
			return c.getNumtel();
		else if(j==6)
			return c.getEmail();
		else if(j==7)

			return c.getFax();
		else if(j==8)
			return c.getAdresse();
		else if(j==9)
			return c.isA_N();
		else return c.isE_P();

	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
