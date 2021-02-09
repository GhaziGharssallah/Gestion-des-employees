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

import DAO.FactureDAO;
import DAO.LigneFactureDAO;
import DAO.ServiceDAO;
import Entit�e.Facture;
import Entit�e.LigneFacture;
import Entit�e.Service;

public class AjouterLigneFacture extends JInternalFrame
{
	JLabel jlNum,jlDes,jlQte,jlRemise,jlPrix,jlFac;
	JComboBox<Facture> f;
	JComboBox<Service> s;
	JButton jValider;
	LigneFacture lf;
	JTable jt;
	JTextField jtNum,jtQte,jtPrix,jtRemise,jtnumfacture;

	public AjouterLigneFacture(JTable jtb)
	{
		super("ajouter ligne facture",true,true,true,true);
		setLayout(null);
		 jt=jtb;
		jlNum=new JLabel("code");
		jlNum.setBounds(10, 10, 100, 20);
		jlNum.setVisible(true);
		add(jlNum);

		jtNum=new JTextField();
		jtNum.setBounds(110,10 , 100, 20);
		jtNum.setVisible(true);
		add(jtNum);


		jlQte=new JLabel("qte");
		jlQte.setBounds(10, 30, 100, 20);
		jlQte.setVisible(true);add(jlQte);

		jtQte=new JTextField();
		jtQte.setBounds(110,30 , 100, 20);
		jtQte.setVisible(true);
		add(jtQte);


		jlPrix=new JLabel("prix");
		jlPrix.setBounds(10, 60, 100, 20);
		jlPrix.setVisible(true);add(jlPrix);

		jtPrix=new JTextField();
		jtPrix.setBounds(110,60 , 100, 20);
		jtPrix.setVisible(true);
		add(jtPrix);


		jlRemise=new JLabel("remise");
		jlRemise.setBounds(10, 90, 100, 20);
		jlRemise.setVisible(true);
		add(jlRemise);

		jtRemise=new JTextField();
		jtRemise.setBounds(110,90 , 100, 20);
		jtRemise.setVisible(true);
		add(jtRemise);

		s=new JComboBox<Service>(new ServiceDAO().getListe());
		s.setBounds(10, 120, 100, 20);
		s.setVisible(true);
		add(s);

		f=new JComboBox<Facture>(new FactureDAO().getListe());
		f.setBounds(10, 150, 100, 20);
		f.setVisible(true);
		add(f);

		// jtnumfacture=new JTextField(""+new FactureDAO().getMaxId());
		//jtnumfacture.setEnabled(false);
		//	 jtnumfacture.setBounds(10,150 , 100, 20);
		//	 jtnumfacture.setVisible(true);
		//	 add(jtnumfacture);


		jValider=new JButton("valider");
		jValider.setBounds(10, 180, 100, 20);
		jValider.setVisible(true);
		add(jValider);




		jValider.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				lf=new LigneFacture();
				lf.setNumLgFacture(Integer.parseInt(jtNum.getText()));

				lf.setQte(Integer.parseInt(jtQte.getText()));

				lf.setPrix(Integer.parseInt(jtPrix.getText()));
				lf.setRemise(Integer.parseInt(jtRemise.getText()));
				lf.setFacture((Facture)f.getSelectedItem());
				lf.setService((Service)s.getSelectedItem());

				new LigneFactureDAO().ajouter(lf);
				// if(new Facture().getNumFacture()==lf.getFacture().getNumFacture()) ???
				  jt.setModel(new LigneFactureTableModel());
				jt.updateUI();
				 
				 
			}
		});




	}




}
