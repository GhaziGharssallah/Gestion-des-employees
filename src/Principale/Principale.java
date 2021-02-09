package Principale;

 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import Interface.AjouterClient;
import Interface.AjouterFacture;
import Interface.AjouterService;
import Interface.ClientTableModel;
import Interface.ConsulterClient;
import Interface.ConsulterService;

 
public class Principale  extends JFrame

{
	JMenuBar jmb;
	JMenu jmFichier, jmGfacture,jmGClient;
	JMenuItem jmiQuitter, jmiDeconnecter,jmAjouter,jmAjCl,jmConsulterCl;
	JDesktopPane jdp;
	public Principale()
	{ 
		jmb=new JMenuBar();
		jmFichier=new JMenu("Fichier");
		jmGClient=new JMenu("Gestion Client");
		jmGfacture=new JMenu("Gestion Facture");
		jmb.add(jmFichier);
		jmb.add(jmGClient);
		jmb.add(jmGfacture);
		
		
		setJMenuBar(jmb);
		
		jmiQuitter=new JMenuItem("Quitter");
		jmiDeconnecter=new JMenuItem("Déconnecter");
		
		jmFichier.add(jmiDeconnecter);
		jmFichier.add(jmiQuitter);
		 
		jmAjCl=new JMenuItem("ajouter client");
		jmGClient.add(jmAjCl);
		
		jmConsulterCl=new JMenuItem("consulter liste des clients");
		jmGClient.add(jmConsulterCl);
		
		jmAjouter=new JMenuItem("ajouter facture");
		jmGfacture.add(jmAjouter);
		
		jdp=new JDesktopPane();
		
		jmAjouter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AjouterFacture a=new AjouterFacture();
				a.setSize(900, 600);
				a.setVisible(true);
				jdp.add(a);
				
			}
		});
	
		jmAjCl.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				//AjouterClient aa=new AjouterClient();
				//aa.setSize(500, 500);
				//aa.setVisible(true);
				//jdp.add(aa);
				 
				
			}
		});
		
		 jmConsulterCl.addActionListener(new ActionListener() {
			
			 
			public void actionPerformed(ActionEvent arg0) {
				 ConsulterClient cc=new ConsulterClient();
				 cc.setSize(900, 900);
				 cc.setVisible(true);

				 jdp.add(cc);
			}
		});
		
		 
		 ConsulterService  as=new ConsulterService();
		 as.setSize(700, 700);
		 as.setVisible(true);
		//jdp.add(as);
		 
		 ImageIcon icon = new ImageIcon("images/facture.jpg");
		 final Image img = icon.getImage();
		 jdp= new JDesktopPane(){
		 	  @Override
		 	    public void paintComponent(Graphics g) {
		 	        super.paintComponent(g);
		 	        Graphics2D g2d = (Graphics2D) g;
		 	        g2d.drawImage(img, (getSize().width/2)-150, (getSize().height/2)-150, 300,300, this);
		 	    }
		 };
		 jdp.setVisible(true);
			add(jdp);
		 
	}
	
	  
	public static void main(String[] args)
	{
		 Principale p=new Principale();
		 p.setSize(880, 690);
			 p.setLocationRelativeTo(null);
			 p.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			 p.setVisible(true);
	 
		
		
	}
}
