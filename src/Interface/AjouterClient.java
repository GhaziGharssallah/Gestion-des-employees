package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.omg.CORBA.OMGVMCID;

import DAO.ClientDAO;
import DAO.FactureDAO;
import Entitée.Client;

public class AjouterClient  extends JInternalFrame
{
	JLabel jlnumCl,jlNom,jlPrenom,jlRaison,jlMatricule,jlNumTel,jlFax,jlAdr,jln,jEmail,jAjNaj;
	JTextField jtNom,jtPrenom,jtRaison,jtMatricule,jtNumTel,jtFax,jtAdr,jtEmail;
	Client c;
	JComboBox combo,comboA;
	JButton jbValider,jbAnnuler;
	JTable jt;
	 
	public AjouterClient(JTable jtb )
	{

		super("ajouter client",true,true,true,true);

		setLayout(null);
		jt=jtb;


		JLabel jl1= new JLabel(new ImageIcon("images/ajout.jpg"));
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

		jln=new JLabel(" N° ");
		Font font2 = new Font("Italique",Font.BOLD,22);
		jln.setFont(font2);
		jln.setForeground(Color.red);
		jln.setBounds(140,70, 100, 20);
		jln.setVisible(true);
		add(jln);


		jlnumCl=new JLabel(""+new ClientDAO().maxId());
		Font font3 = new Font("Italique",Font.BOLD,22);
		jlnumCl.setFont(font3);
		jlnumCl.setForeground(Color.red);
		jlnumCl.setBounds(200,70, 100, 20);
		jlnumCl.setVisible(true);
		add(jlnumCl);

		JPanel jp1=new JPanel();
		jp1.setBounds( 10, 60 ,500  , 50 );
		jp1.setBackground(Color.white);
		jp1.setVisible(true);
		add(jp1);

 

		String[] items={"Entreprise","Personne"};
		combo=new JComboBox<String> (items);
		combo.setBounds (70,130 , 100, 20);
		add(combo);



		JLabel j =new JLabel("type:");
		j.setForeground(Color.gray);
		j.setBounds(20, 130,100, 20);
		j.setVisible(true);
		add(j );


		combo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (combo.getSelectedItem().equals("Personne"))//mettre dans E_P la valeur 1
				{   
					c=new Client();

					jtNom.setEnabled(true);
					jtPrenom.setEnabled(true);
					jtRaison.setEditable(false);
					jtMatricule.setEditable(false);
					c.setE_P(true);
				}
				if(combo.getSelectedItem().equals("Entreprise")) 
				{
					c=new Client();
					jtRaison.setEnabled(true);
					jtMatricule.setEnabled(true);
					jtNom.setEditable(false);
					jtPrenom.setEditable(false);
					c.setE_P(false);
				}
			}
		}); 






		jlNom=new JLabel("Nom");
		jlNom.setForeground(Color.gray);
		jlNom.setBounds(200, 130,100, 20);
		jlNom.setVisible(true);
		add(jlNom);

		jtNom=new JTextField();
		jtNom.setBounds( 240,130 , 100 , 20 );
		jtNom.setEnabled(false);
		jtNom.setVisible(true);
		add(jtNom);


		jlPrenom=new JLabel("Prénom");
		jlPrenom.setForeground(Color.gray);
		jlPrenom.setBounds(200, 160,100, 20);
		jlPrenom.setVisible(true);
		add(jlPrenom);

		jtPrenom=new JTextField();
		jtPrenom.setBounds( 245, 160 , 100 , 20 );
		jtPrenom.setEnabled(false);
		jtPrenom.setVisible(true);
		add(jtPrenom);

		jlRaison=new JLabel("Raison");
		jlRaison.setForeground(Color.gray);
		jlRaison.setBounds(350, 130,100, 20);
		jlRaison.setVisible(true);
		add(jlRaison);

		jtRaison=new JTextField();
		jtRaison.setBounds( 400,130 , 100 , 20 );
		jtRaison.setEnabled(false);
		jtRaison.setVisible(true);
		add(jtRaison);


		jlMatricule=new JLabel("Matricule");
		jlMatricule.setForeground(Color.gray);
		jlMatricule.setBounds(350, 160,100, 20);
		jlMatricule.setVisible(true);
		add(jlMatricule);

		jtMatricule=new JTextField();
		jtMatricule.setBounds( 405, 160 , 100 , 20 );
		jtMatricule.setEnabled(false);
		jtMatricule.setVisible(true);
		add(jtMatricule);



		jlAdr=new JLabel("Adresse");
		jlAdr.setForeground(Color.gray);
		jlAdr.setBounds(20, 190,100, 20);
		jlAdr.setVisible(true);
		add(jlAdr);

		jtAdr=new JTextField();
		jtAdr.setBounds( 100,190 , 130 , 20 );
		jtAdr.setVisible(true);
		add(jtAdr);

		jlNumTel=new JLabel("N°_Tel");
		jlNumTel.setForeground(Color.gray);
		jlNumTel.setBounds(20,220,100, 20);
		jlNumTel.setVisible(true);
		add(jlNumTel);

		jtNumTel=new JTextField();
		jtNumTel.setBounds( 100,220 , 130 , 20 );
		jtNumTel.setVisible(true);
		add(jtNumTel);


		jlFax=new JLabel("fax");
		jlFax.setForeground(Color.gray);
		jlFax.setBounds(20, 250,100, 20);
		jlFax.setVisible(true);
		add(jlFax);

		jtFax=new JTextField();
		jtFax.setBounds(  100,250 , 130 , 20 );
		jtFax.setVisible(true);
		add(jtFax);



		jEmail=new JLabel("Email");
		jEmail.setForeground(Color.gray);
		jEmail.setBounds(20, 280,100, 20);
		jEmail.setVisible(true);
		add(jEmail);

		jtEmail=new JTextField();
		jtEmail.setBounds( 100,280 , 130, 20 );
		jtEmail.setVisible(true);
		add(jtEmail);


		jAjNaj=new JLabel("A_N");
		jAjNaj.setForeground(Color.gray);
		jAjNaj.setBounds( 20,310  , 100 , 20 );
		jAjNaj.setVisible(true);
		add(jAjNaj);

		String[] items1={"Ajusté","Non Ajusté"};
		comboA=new JComboBox<String>(items1);
		comboA.setBounds( 100, 310 , 130 ,20  );
		comboA.setVisible(true);
		add(comboA);

		jbValider=new JButton(new ImageIcon("images/valider.png"));
		jbValider.setBounds( 200, 380 , 100 , 20 );
		jbValider.setVisible(true);
		add(jbValider);

		jbAnnuler=new JButton(new ImageIcon("images/annuler.png"));
		jbAnnuler.setBounds(200, 420, 100, 20);
		jbAnnuler.setVisible(true);
		add(jbAnnuler);

		jbAnnuler.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				jtAdr.setText("");
				jtEmail.setText("");
				jtFax.setText("");
				jtMatricule.setText("");
				jtNom.setText("");
				jtPrenom.setText("");
				jtRaison.setText("");
				jtNumTel.setText("");





			}
		});
		jbValider.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				c=new Client();
				c.setNumClient(Integer.parseInt(jlnumCl.getText()));
				try{
					c.setAdresse(jtAdr.getText());
					c.setEmail(jtEmail.getText());
					c.setFax(jtFax.getText());
					c.setMatricule(jtMatricule.getText());
					c.setRaison(jtRaison.getText());
					c.setNom(jtNom.getText());
					c.setPrenom(jtPrenom.getText());
					c.setNumtel(Integer.parseInt(jtNumTel.getText()));
					if(combo.getSelectedItem()=="Personne")
					{
						c.setE_P(true); 
						c.getResultat() ;//return 1
					}else {c.setE_P(false);
					c.getResultat();}
					if(comboA.getSelectedItem()=="Asujté")
					{
						c.setA_N(true);
						c.getResultatA();
					}else{
						c.setA_N(false);
						c.getResultatA();
					}
					new ClientDAO().ajouter(c);
					jt.setModel(new ClientTableModel());
					JOptionPane.showConfirmDialog(null, "client ajouté avec succés", "message", JOptionPane.DEFAULT_OPTION);
					dispose();
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "vérifier tous les champs","Erreur",JOptionPane.ERROR_MESSAGE);

				}






			}
		});


	}






}
