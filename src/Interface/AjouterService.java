package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.ClientDAO;
import DAO.ServiceDAO;
import Entitée.Client;
import Entitée.Service;

public class AjouterService extends JInternalFrame
{

	JLabel jlNumService,jlDesignation,jlPrix,jlPrixMax,jlRemise;
	JTextField jtNumService,jtDesignation,jtPrix,jtPrixMax,jtRemise;
	JComboBox<String> jcomboRemise,jcomboPrix;
	Service s;
	JTable jt;
	JButton jbValider;
	public AjouterService(JTable jtb)
	{

		super("Ajout Service",true,true,true,true);
		setLayout(null);
		jt=jtb;
		jlNumService=new JLabel(""+ new ServiceDAO().maxId());
		jlNumService.setBounds( 10,10  ,100  , 20 );
		jlNumService.setVisible(true);
		add(jlNumService);



		jlDesignation=new JLabel("designation");
		jlDesignation.setBounds( 10,  30, 100 ,20  );
		jlDesignation.setVisible(true);
		add(jlDesignation);

		jtDesignation=new JTextField();
		jtDesignation.setBounds(110 , 30, 100,20 );
		jtDesignation.setVisible(true);
		add(jtDesignation);


		String[] items={"Remisé","Non Remisé"};
		jcomboRemise=new JComboBox<String> (items);
		jcomboRemise.setBounds(10, 60, 100, 20);
		jcomboRemise.setVisible(true);
		add(jcomboRemise);

		jlRemise=new JLabel("Remise");
		jlRemise.setBounds( 130,  60, 100 ,20  );
		jlRemise.setVisible(true);
		add(jlRemise);

		jtRemise =new JTextField();
		jtRemise.setBounds(180 , 60, 100,20 );
		jtRemise.setEnabled(false);
		jtRemise.setVisible(true);
		add(jtRemise);



		String[] items1={"Prix Fixe","Prix Variable"};
		jcomboPrix=new JComboBox<String> (items1);
		jcomboPrix.setBounds(10, 90, 100, 20);
		jcomboPrix.setVisible(true);
		add(jcomboPrix);




		jlPrix=new JLabel("Prix");
		jlPrix.setBounds( 130, 90, 100 ,20  );
		jlPrix.setVisible(true);
		add(jlPrix);

		jtPrix=new JTextField();
		jtPrix.setBounds(180 , 90, 100,20 );
		jtPrix.setEnabled(false);
		jtPrix.setVisible(true);
		add(jtPrix);

		jlPrixMax=new JLabel("Prix Max");
		jlPrixMax.setBounds( 130,  120, 100 ,20  );
		jlPrixMax.setVisible(true);
		add(jlPrixMax);

		jtPrixMax=new JTextField();
		jtPrixMax.setBounds(180 ,120, 100,20 );
		jtPrixMax.setEnabled(false);
		jtPrixMax.setVisible(true);
		add(jtPrixMax);

		jbValider=new JButton("valider");
		jbValider.setBounds(200, 160 ,100, 20);
		jbValider.setVisible(true);
		add(jbValider);


		jcomboRemise.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				if (jcomboRemise.getSelectedItem().equals("Remisé"))
				{
					jtRemise.setEnabled(true);
					//s.setR_NR(true);
				}else {jtRemise.setEnabled(false);
				// s.setR_NR(false);
				}

			}
		});


		jcomboPrix.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(jcomboPrix.getSelectedItem().equals("Prix Fixe"))
				{
					jtPrix.setEnabled(true);
					//s.setF_V(true);
				}else{
					jtPrixMax.setEnabled(true);
					jtPrix.setEnabled(false);
					//s.setF_V(false);
				}



			}
		});

		jbValider.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {

				s=new Service();
				s.setNumService(Integer.parseInt(jlNumService.getText()));
				s.setDesignation(jtDesignation.getText());

                try{

				if(jcomboRemise.getSelectedItem()=="Remisé")
				{    s.setRemise(jtRemise.getText());
				s.setR_NR (true); 
				s.getResultat() ;//return 1
				}else {s.setR_NR(false); 
				s.getResultat();}
				if(jcomboPrix.getSelectedItem()=="Prix Fixe")
				{  s.setPrix(jtPrix.getText());
				s.setF_V(true); 
				s.getResultatPrix();
				}else{
					s.setPrixMax(jtPrixMax.getText());
					s.setF_V(false); 
					s.getResultatPrix();
				}
				new ServiceDAO().ajouter(s);
			 jt.setModel(new ServiceTableModel());
				JOptionPane.showConfirmDialog(null, "Service ajouté avec succés", "message", JOptionPane.DEFAULT_OPTION);
				//dispose();
}catch(Exception e){
	e.printStackTrace();
}




			}
		});




	}




}
