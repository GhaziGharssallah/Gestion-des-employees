package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.ClientDAO;
import Entitée.Client;

public class ModifierClient  extends JInternalFrame
{Client c;
JLabel jlnumCl,jlNom,jlPrenom,jlRaison,jlMatricule,jlNumTel,jlFax,jlAdr, jEmail ,jlA_N;
JTextField jtNom,jtPrenom,jtRaison,jtMatricule,jtNumTel,jtFax,jtAdr,jtEmail;
JRadioButton jr1,jr2; 
JButton jbValider;
JTable jt;

public ModifierClient( JTable jtb,int id)
{
	super("Modifier Client ",true,true,true,true);
	setLayout(null);
	c=new ClientDAO().rechercherParId(id);
	jt=jtb;
	
	JLabel jl1= new JLabel(new ImageIcon("images/modifi.jpg"));
	jl1.setBounds(20, 10, 50, 50);
	jl1.setVisible(true);add(jl1);
 
	JPanel jp=new JPanel();
	jp.setBounds( 10, 10 ,500  , 50 );
	jp.setBackground(Color.gray);
	jp.setVisible(true);
	add(jp);

	

	JLabel jl2= new JLabel("Client ");
	Font font1 = new Font("Italique",Font.BOLD,22);
	jl2.setFont(font1);
	jl2.setForeground(Color.red);
	jl2.setBounds(70,70, 150, 20);
	jl2.setVisible(true);

	add(jl2);
	
	JLabel jln=new JLabel(" N° ");
	Font font2 = new Font("Italique",Font.BOLD,22);
	jln.setFont(font2);
	jln.setForeground(Color.red);
	jln.setBounds(140,70, 100, 20);
	jln.setVisible(true);
	add(jln);
	
	jlnumCl=new JLabel(""+c.getNumClient());
	Font font3 = new Font("Italique",Font.BOLD,22);
	jlnumCl.setFont(font3);
	jlnumCl.setForeground(Color.red);
	jlnumCl.setBounds(180,70, 100, 20);
	 
	jlnumCl.setVisible(true);
	 add(jlnumCl);
	 JPanel jp1=new JPanel();
		jp1.setBounds( 10, 60 ,500  , 50 );
		jp1.setBackground(Color.white);
		jp1.setVisible(true);
		add(jp1);


	if (c.getResultat()==1)
	{
		jlNom=new JLabel("nom");
		jlNom.setBounds(20, 130, 120, 20);
		jlNom.setVisible(true);
		 add(jlNom);

		jtNom=new JTextField(c.getNom());
		jtNom.setBounds( 70,130 , 120 , 20 );
		jtNom.setVisible(true);
		 add(jtNom);


		jlPrenom=new JLabel("Prénom");
		jlPrenom.setBounds( 20, 160 ,120, 20);
		jlPrenom.setVisible(true);
		 add(jlPrenom);

		jtPrenom=new JTextField(c.getPrenom());
		jtPrenom.setBounds( 70,160 , 120 , 20 );

		jtPrenom.setVisible(true);
		 add(jtPrenom);
	}
	if (c.getResultat()==0){
		jlRaison=new JLabel("Raison");
		jlRaison.setBounds( 20, 130,120, 20);
		jlRaison.setVisible(true);
		 add(jlRaison);

		jtRaison=new JTextField(c.getRaison());
		jtRaison.setBounds( 70,130 , 120 , 20 );

		jtRaison.setVisible(true);
		 add(jtRaison);


		jlMatricule=new JLabel("Matricule");
		jlMatricule.setBounds(20, 160,120, 20);
		jlMatricule.setVisible(true);
		 add(jlMatricule);

		jtMatricule=new JTextField(c.getMatricule());
		jtMatricule.setBounds( 80,160 , 120 , 20 );

		jtMatricule.setVisible(true);
		 add(jtMatricule);


	}




	jlAdr=new JLabel("Adresse");
	jlAdr.setBounds(20, 190,120, 20);
	jlAdr.setVisible(true);
	 add(jlAdr);

	jtAdr=new JTextField(c.getAdresse());
	jtAdr.setBounds( 70,190 , 120, 20 );
	jtAdr.setVisible(true);
 add(jtAdr);

	jlNumTel=new JLabel("N°_Tel");
	jlNumTel.setBounds(20,220,120, 20);
	jlNumTel.setVisible(true);
	 add(jlNumTel);

	jtNumTel=new JTextField(""+c.getNumtel());
	jtNumTel.setBounds( 70,220 , 120 , 20 );
	jtNumTel.setVisible(true);
	 add(jtNumTel);


	jlFax=new JLabel("fax");
	jlFax.setBounds(20, 250,120, 20);
	jlFax.setVisible(true);
	 add(jlFax);

	jtFax=new JTextField(c.getFax());
	jtFax.setBounds( 70,250 , 120 , 20 );
	jtFax.setVisible(true);
	  add(jtFax);



	jEmail=new JLabel("Email");
	jEmail.setBounds(20, 280,120, 20);
	jEmail.setVisible(true);
	 add(jEmail);

	jtEmail=new JTextField(c.getEmail());
	jtEmail.setBounds(70,280 , 100 , 20 );
	jtEmail.setVisible(true);
	 add(jtEmail);

	jlA_N=new JLabel("A_N");
	jlA_N.setBounds(20, 310, 120,20);
	jlA_N.setVisible(true);
	 add(jlA_N);

	jr1=new JRadioButton("Ajusté");
	jr1.setSize(120,20);
	//jr1.setSelected(true);//jr1 est dés le debut selecter
	jr1.setLocation( 70,310  );
	jr1.setVisible(true);
	 add(jr1);

	jr2=new JRadioButton("Non Ajusté");
	jr2.setSize(100,20);
	jr2.setLocation(70, 330);
	jr2.setVisible(true);
	 add(jr2);
	ButtonGroup bg= new ButtonGroup(); // lorsque on selecte une boutton l'autre disparete
	bg.add(jr1);
	bg.add(jr2);
	if(c.isA_N()==true)
		jr1.setSelected(true);
	if(c.isA_N()==false)
		jr2.setSelected(true);     

	jbValider=new JButton(new ImageIcon("images/valid.jpg"));
	jbValider.setBounds( 160,381 ,80 ,25 );
	jbValider.setVisible(true);
	 add(jbValider);



	jbValider.addActionListener(new ActionListener() {


		public void actionPerformed(ActionEvent arg0) {
			if(c.isE_P()==true) 
			{
				c.setNom(jtNom.getText());
				c.setPrenom(jtPrenom.getText());
			}
			else
			{
				c.setRaison(jtRaison.getText());
				c.setMatricule(jtMatricule.getText());
			}
			c.setNumtel(Integer.parseInt(jtNumTel.getText()));
			c.setEmail(jtEmail.getText());
			c.setFax(jtFax.getText());
			c.setAdresse(jtAdr.getText());
			 if(c.isA_N()==true)
			 	c.setA_N(false);
			  
			 else c.setA_N(true);


			new ClientDAO().modifier(c);
			jt.setModel(new ClientTableModel());
			jt.updateUI();




		}
	});



}






}





