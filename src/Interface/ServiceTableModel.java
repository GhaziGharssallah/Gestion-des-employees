package Interface;

import java.util.Vector;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import DAO.ClientDAO;
import DAO.ServiceDAO;
import Entitée.Client;
import Entitée.Service;

public class ServiceTableModel implements TableModel {

	String[] t={"NumService","Désignation","Prix","PrixMax","Remise","F_V","R_NR"};
	 Class c[] =new Class[] {Integer.class,String.class,String.class,String.class,String.class, Boolean.class,Boolean.class};
	 Vector<Service> s= new ServiceDAO().getListe();
	 
	
	
	public ServiceTableModel(){
		
	}
	public ServiceTableModel(String champ,String valeur)
	{
		s = new ServiceDAO().getChercherService(champ, valeur);
	}
	@Override
	public void addTableModelListener(TableModelListener arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		// TODO Auto-generated method stub
		return c[arg0];
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return t.length;
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return t[arg0];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return  s.size();
	}

	@Override
	public Object getValueAt(int i,int j) {
		 Service se= s.elementAt(i);
		 if(j==0)
				return se.getNumService();
			else if (j==1)
				return se.getDesignation();
			else if(j==2)
				return se.getPrix();
			else if(j==3)
				return se.getPrixMax();
			else if(j==4)
				return se.getRemise();
			else if(j==5)
				return se.isF_V();
			else  
				return se.isR_NR();
			 
  
				 
		 
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
