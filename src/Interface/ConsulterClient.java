package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import DAO.ClientDAO;
import Entitée.Client;

public class ConsulterClient extends JInternalFrame 
{ 
	JLabel jlbValeur,jlbChercher,jlListeClients;
	JTextField jtfValeur;
	JButton jbSupprimer,jbModifier,jbAjouter;
	JTable jt;
	JScrollPane jsp;
	JPanel pane1;
	JComboBox<String> jcbChamp;

	public ConsulterClient()
	{
		 super("consulter client",true,true,true,true);
		 setLayout(null);
		jt=new JTable(new ClientTableModel());

		jsp=new JScrollPane(jt);
		jsp.setBounds(64,220,750, 300);
		jsp.setVisible(true);
		add(jsp);


 
		
		
		
		
		
		  pane1 = new JPanel();
		Border  blackline1;
		blackline1 = BorderFactory.createRaisedSoftBevelBorder() ;
		TitledBorder title1;
		title1 = BorderFactory.createTitledBorder(blackline1, "liste des clients");
		Font font2 = new Font("Serif",Font.BOLD,18);
		 
		title1.setTitleFont(font2);
		title1.setTitleJustification(TitledBorder.LEFT);
		title1.setTitleColor(Color.red);
		pane1.setBorder(title1);
		pane1.setBounds( 60, 200 ,770 ,325 );
		pane1.setVisible(true);
		add(pane1);
		
		


		JPanel j=new JPanel();
		j.setBounds( 10,10  , 900 ,30 );
		j.setBackground(Color.pink);

		j.setVisible(true);
		add(j);
		JLabel jl=new JLabel("Liste Des Clients");
		jl.setForeground(Color.GRAY);
		Font font3 = new Font("Arial Black",Font.ITALIC,20);
		jl.setFont(font3);
		jl.setBounds(100, 20, 150, 30);
		jl.setVisible(true);
		j.add(jl);


		JPanel j1=new JPanel();
		j1.setBounds( 10,40  , 900 ,10 );
		j1.setBackground(Color.gray);
		j1.setVisible(true);
		add(j1);



		JPanel j2=new JPanel();
		j2.setBounds( 10,40  , 10 ,800);
		j2.setBackground(Color.gray);
		j2.setVisible(true);
		add(j2);


		JPanel j3=new JPanel();
		j3.setBounds( 900,40  , 10 ,800);
		j3.setBackground(Color.gray);
		j3.setVisible(true);
		add(j3);




		String [] items={"numcl","nom","prenom","matricule","raison"};


		 
		 JLabel jl1=new JLabel(new ImageIcon("images/recherche.png"));
		 jl1.setBounds(70, 90 ,  40, 40);
		 jl1.setVisible(true);
		 add(jl1);

		jlbChercher=new JLabel(" Chercher par :");
		Font font = new Font("Serif",Font.BOLD,14);
		jlbChercher.setFont(font);
		//jlbChercher.setForeground(Color.magenta);
		jlbChercher.setBounds(100,100,120,20);
		jlbChercher.setVisible(true);
		add(jlbChercher);
		 
		

		jcbChamp=new JComboBox<String>(items);
		jcbChamp.setBounds(100,130,120,20);
		jcbChamp.setVisible(true);
		add(jcbChamp);

		jtfValeur=new JTextField();
		jtfValeur.setBounds(250,130,120,20);
		jtfValeur.setVisible(true);
		add(jtfValeur);



		JPanel pane = new JPanel();
		Border  blackline;
		blackline = BorderFactory.createRaisedBevelBorder();
		TitledBorder title;
		title = BorderFactory.createTitledBorder(blackline, "Moteur de recherche");
		 
		title.setTitleJustification(TitledBorder.LEFT);
		title.setTitleColor(Color.red);
		Font font1 = new Font("Serif",Font.BOLD,18);
		 
		title.setTitleFont(font1);
		pane.setBorder(title);
		pane.setBounds(60, 60, 400, 100);
		pane.setVisible(true);
		add(pane);

		
		

		JPanel j4=new JPanel();
		j4.setBounds( 50,67 , 10 ,90 );
		j4.setBackground(Color.gray);
		j4.setVisible(true);
		add(j4);
		
		
		
		
		jlListeClients=new JLabel("Listes des Clients:");
		jlListeClients.setBounds( 50, 300 ,120, 20);
		jlListeClients.setVisible(true);
		//(jlListeClients);


		
		 
		jbAjouter=new JButton(new ImageIcon("images/ajouter.jpg"));
		jbAjouter.setBounds(420 ,530 ,50,50 );
		jbAjouter.setVisible(true);
		add(jbAjouter );
		
		jbModifier=new JButton(new ImageIcon("images/modifier.jpg"));
		jbModifier.setBounds(360, 580 ,50 ,50 );
		jbModifier.setVisible(true);
		add(jbModifier );



		jbSupprimer=new JButton(new ImageIcon("images/supprimer.jpg"));
		jbSupprimer.setBounds(480 ,580 ,50 ,50 );
		jbSupprimer.setVisible(true);
		add(jbSupprimer );

		

		//les actions : 


		jbAjouter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				AjouterClient ac=new AjouterClient(jt);
				jt.setModel(new ClientTableModel());
				ac.setSize(500, 500);
				ac.setVisible(true);
				getParent().add(ac);
				ac.toFront();


			}
		});
		jtfValeur.getDocument().addDocumentListener(new DocumentListener() 
		{


			public void removeUpdate(DocumentEvent arg0) 
			{

				String champ=jcbChamp.getSelectedItem().toString();//return string
				String valeur=jtfValeur.getText();

				jt.setModel(new ClientTableModel(champ, valeur));
				jt.updateUI(); 
			}

			public void insertUpdate(DocumentEvent arg0)
			{
				String champ=jcbChamp.getSelectedItem().toString();//return string
				String valeur=jtfValeur.getText();

				jt.setModel(new ClientTableModel(champ, valeur));
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
					int i=(int)	jt.getValueAt(l, c);
					new ClientDAO().supprimer(new Client(i));
					jt.setModel(new ClientTableModel());
					jt.updateUI();
				}

			}
		});

		jbModifier.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				int c=0;
				int l=jt.getSelectedRow();
				int i=(int)jt.getValueAt(l,c);
				ModifierClient mc=new ModifierClient(jt,i);
				mc.setSize(400, 500);
				mc.setVisible(true);
				getParent().add(mc);
				mc.toFront();



			}
		});





	}




}
