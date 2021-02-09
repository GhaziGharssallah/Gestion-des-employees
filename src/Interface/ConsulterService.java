package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

 
import DAO.ClientDAO;
import DAO.ServiceDAO;
import Entitée.Client;
import Entitée.Service;

public class ConsulterService extends JInternalFrame
{
	JLabel jlbValeur,jlbChercher,jlListeServices;
JTextField jtfValeur;
JButton jbSupprimer,jbModifier,jbAjouter;
JTable jt;
JScrollPane jsp;
JComboBox<String> jcbChamp;
	public ConsulterService()
	{
		super("consulter service",true,true,true,true);
		setLayout(null);
		jt=new JTable(new ServiceTableModel());
		jsp=new JScrollPane(jt);
		jsp.setBounds(50,100 , 500,300);
		jsp.setVisible(true);
		add(jsp);
		
		String [] items={"numservice","designation"};


		jlbValeur=new JLabel("Valeur:");
		jlbValeur.setBounds(150,10,120,20);
		jlbValeur.setVisible(true);
		add(jlbValeur);



		jcbChamp=new JComboBox<String>(items);
		jcbChamp.setBounds(10,40,120,25);
		jcbChamp.setVisible(true);
		add(jcbChamp);

		jlbChercher=new JLabel(" Chercher par :");
		jlbChercher.setBounds(10,10,120,20);
		jlbChercher.setVisible(true);
		add(jlbChercher);

		jtfValeur=new JTextField();
		jtfValeur.setBounds(150,40,120,25);
		jtfValeur.setVisible(true);
		add(jtfValeur);

		jlListeServices=new JLabel("Listes des Services:");
		jlListeServices.setBounds( 50, 75 ,120, 20);
		jlListeServices.setVisible(true);
		add(jlListeServices);


		jbModifier=new JButton("Modifier");
		jbModifier.setBounds(600 , 150 ,100 ,20  );
		jbModifier.setVisible(true);
		add(jbModifier );



		jbSupprimer=new JButton("Supprimer");
		jbSupprimer.setBounds(600 , 180 ,100 ,20  );
		jbSupprimer.setVisible(true);
		add(jbSupprimer );


		jbAjouter=new JButton("Ajouter");
		jbAjouter.setBounds(600 , 110 ,100 ,20  );
		jbAjouter.setVisible(true);
		add(jbAjouter );

		 jbAjouter.addActionListener(new ActionListener() {
			 
				public void actionPerformed(ActionEvent arg0) {
					AjouterService as=new AjouterService(jt);
					  jt.setModel(new ServiceTableModel());
					as.setSize(500, 500);
					as.setVisible(true);
					getParent().add(as);
					as.toFront();
					
					
				}
			});
				jtfValeur.getDocument().addDocumentListener(new DocumentListener() 
				{


					public void removeUpdate(DocumentEvent arg0) 
					{
						String champ=jcbChamp.getSelectedItem().toString();//return string
						String valeur=jtfValeur.getText();

						jt.setModel(new ServiceTableModel(champ, valeur));
						//if(jtfValeur.getText().equals(""))
						//{//jt .setModel(new ServiceTableModel());
						jt.updateUI(); 
					}

					public void insertUpdate(DocumentEvent arg0)
					{
						String champ=jcbChamp.getSelectedItem().toString();//return string
						String valeur=jtfValeur.getText();

						jt.setModel(new ServiceTableModel(champ, valeur));
						jt.updateUI();

					}


					public void changedUpdate(DocumentEvent arg0) 
					{ 

					}
				});

				jbSupprimer.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {

						int c=0;
						int l=jt.getSelectedRow();
						int m=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ?","message",JOptionPane.YES_NO_OPTION);
						if(m==0){
							int i=(int)	jt.getValueAt(l,c);
							 
							new ServiceDAO().supprimer(new Service(i));
							jt.setModel(new ServiceTableModel());
							jt.updateUI();
						}

					}
				});
				 
				jbModifier.addActionListener(new ActionListener() {
					
					 
					public void actionPerformed(ActionEvent arg0) {
						int c=0;
						int l=jt.getSelectedRow();
						int i=(int)jt.getValueAt(l,c);
						ModifierService ms=new ModifierService(jt,i);
						ms.setSize(500, 600);
						ms.setVisible(true);
						getParent().add(ms);
						ms.toFront();
						
						
						
					}
				});


		
		
		
		
	}
	
	
	

}
