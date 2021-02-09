package Interface;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.LigneFactureDAO;
import DAO.ServiceDAO;
import Entitée.Facture;
import Entitée.LigneFacture;
import Entitée.Service;

public class LigneFactureTableModel implements TableModel {

	String[] t={"code","Désignation","Quantité","prix unitaire"," remise" ,"n° facture" };
	Class c[] =new Class[] {Integer.class,Service.class,Integer.class,Integer.class,Integer.class,Facture.class };

	Vector<LigneFacture> lf;

	public LigneFactureTableModel(Facture f)

	{ lf= new LigneFactureDAO().rechercherParFacture(f);}

	public LigneFactureTableModel()
	{   
		lf=new LigneFactureDAO().getListe();
	}
	  
	public void addTableModelListener(TableModelListener arg0) {

	}


	public Class<?> getColumnClass(int arg0) {

		return c[arg0];
	}


	public int getColumnCount() {

		return t.length;
	}


	public String getColumnName(int arg0) {

		return t[arg0];
	}


	public int getRowCount() {

		return lf.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		LigneFacture lf1=lf.elementAt(arg0);
		if(arg1==0)
			return lf1.getNumLgFacture();
		else if (arg1==1)
			return lf1.getService();
		else if(arg1==2)
			return lf1.getQte();
		else if(arg1==3)
			return lf1.getPrix();
		else  if(arg1==4) 
			return lf1.getRemise();
		else return lf1.getFacture();


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
