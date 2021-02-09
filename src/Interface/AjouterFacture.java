package Interface;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import DAO.ClientDAO;
import DAO.FactureDAO;
import DAO.LigneFactureDAO;
import Entitée.Client;
import Entitée.Facture;
import Entitée.LigneFacture;

public class AjouterFacture extends JInternalFrame
{

	JLabel jlNumFacture,jlRemise,jlDate,jlClient,jln;
	JTextField jtRemise;
	JComboBox<Client> jcombCl;
	JButton jbValider,jbAjouterlf,jbmodifierLf,jbSupprimerLf;
	JTable jtLigneFacture;
	JScrollPane jsLigneFacture;
	JFormattedTextField jtfDate;
	Facture f;
	public AjouterFacture(){
		super("ajouter facture",true,true,true,true);
		setLayout(null);


		jln=new JLabel(" N° ");
		jln.setBounds(180,10, 100, 20);
		jln.setVisible(true);
		add(jln);

		jlNumFacture=new JLabel(""+new FactureDAO().getMaxId());
		jlNumFacture.setBounds(200, 10, 100, 20);
		jlNumFacture.setVisible(true);
		add(jlNumFacture);


		jlDate=new JLabel("date");
		jlDate.setBounds(10, 10,100, 20);
		jlDate.setVisible(true);
		add(jlDate);

		jtfDate=new JFormattedTextField(new Date(System.currentTimeMillis()));
		jtfDate.setBounds(60, 10,100, 20);
		jtfDate.setVisible(true);
		add(jtfDate);


		jlClient=new JLabel("client");
		jlClient.setBounds(240, 10,100, 20);
		jlClient.setVisible(true);
		add(jlClient);

		jcombCl=new JComboBox<Client>(new ClientDAO().getListe());
		jcombCl.setBounds( 300,10 , 100 , 20 );
		jcombCl.setVisible(true);
		add(jcombCl);





		// if((f.getNumFacture())==(int)(jtLigneFacture.getValueAt(1,5)))
		jtLigneFacture=new JTable(new LigneFactureTableModel()); //contenu du jtable//


		jsLigneFacture=new JScrollPane(jtLigneFacture);
		jsLigneFacture.setBounds( 20,50 ,300 , 300);
		jsLigneFacture.setVisible(true);
		add(jsLigneFacture);


		jbmodifierLf=new JButton("modifier lfct");
		jbmodifierLf.setBounds(330, 280, 100, 20);
		jbmodifierLf.setVisible(true);
		add(jbmodifierLf);


		jbSupprimerLf=new JButton("supprimerlf");
		jbSupprimerLf.setBounds(330, 310,100,20);
		jbSupprimerLf.setVisible(true);
		add(jbSupprimerLf);





		jbmodifierLf.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {

				int c=0;
				int l=jtLigneFacture.getSelectedRow();
				int i=(int)jtLigneFacture.getValueAt(l,c);
				ModifierLigneFacture ml=new ModifierLigneFacture(jtLigneFacture,i);
				ml.setSize(400, 400);
				ml.setVisible(true);
				getParent().add(ml);
				ml.toFront();


			}
		});

		jbSupprimerLf.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				int c=0;
				int l=jtLigneFacture.getSelectedRow();
				int m=JOptionPane.showConfirmDialog(null, "voulez-vous supprimer ?","message",JOptionPane.YES_NO_OPTION);
				if(m==0){
					int i=(int)jtLigneFacture.getValueAt(l, c);
					new LigneFactureDAO().supprimer(new LigneFacture(i));
					jtLigneFacture.setModel(new LigneFactureTableModel());
					jtLigneFacture.updateUI();
				}

			}
		});




		jbValider=new JButton("valider");//pour ajouter facture
		jbValider.setBounds(350  ,  350 , 100 ,20 );
		jbValider.setVisible(true);
		add(jbValider);


		//jtLigneFacture=new JTable(new LigneFactureTableModel());//contenu du jtable//


		jcombCl.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				f=new Facture();
				f.setNumFacture(Integer.parseInt(jlNumFacture.getText()));
				f.setClient((Client)jcombCl.getSelectedItem());
				//f.setDate(jtfDate.getFormatter());
				new FactureDAO().ajouter(f);

			}
		});

		jbAjouterlf=new JButton("->");
		jbAjouterlf.setBounds(330, 240, 100, 20);
		jbAjouterlf.setVisible(true);
		add(jbAjouterlf);

		jbAjouterlf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AjouterLigneFacture alf=new AjouterLigneFacture(jtLigneFacture);
				 jtLigneFacture.setModel(new LigneFactureTableModel());
				alf.setSize(400, 400);
				alf.setVisible(true);
				getParent().add(alf);
				alf.toFront();

			}
		});





	}





}
