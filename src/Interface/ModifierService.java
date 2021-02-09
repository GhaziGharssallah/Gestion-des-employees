package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

import DAO.ServiceDAO;
import Entitée.Service;



public class ModifierService extends JInternalFrame
{
	Service s;
	JLabel jlNumService,jlDesignation,jlPrix,jlPrixMax,jlRemise,jlF_V,jlR_NR;
	JTextField jtNumService,jtDesignation,jtPrix,jtPrixMax,jtRemise;
	JRadioButton jr1,jr2,jr3,jr4; 
	JButton jbValider;
	JTable jt;

	public ModifierService( JTable jtb,int id)
	{
		super("modification du service ",true,true,true,true);
		setLayout(null);
		s=new ServiceDAO().rechercherParId(id);
		jt=jtb;
		jlNumService=new JLabel(""+s.getNumService());
		jlNumService.setBounds( 10, 10 , 100 ,20 );
		jlNumService.setVisible(true);
		add(jlNumService);

		//if (s.getResultat()==1)


		jlR_NR=new JLabel("R_NR");
		jlR_NR.setBounds(10, 210, 100,20);
		jlR_NR.setVisible(true);
		add(jlR_NR);

		jr1=new JRadioButton("remisé");
		jr1.setSize(100,20);
		//jr1.setSelected(true);//jr1 est dés le debut selecter
		jr1.setLocation( 110,210  );
		jr1.setVisible(true);
		add(jr1);

		jr2=new JRadioButton("Non remisé");
		jr2.setSize(100,20);
		jr2.setLocation(110, 230);
		jr2.setVisible(true);
		add(jr2);
		ButtonGroup bg= new ButtonGroup(); // lorsque on selecte une boutton l'autre disparete
		bg.add(jr1);
		bg.add(jr2);
		if(s.isR_NR()==true)
			jr1.setSelected(true);
		if(s.isR_NR()==false)
			jr2.setSelected(true);
jr1.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		jlRemise=new JLabel("Remise");
		jlRemise.setBounds( 240,  210, 100 ,20  );
		jlRemise.setVisible(true);
		add(jlRemise);

		jtRemise =new JTextField(s.getRemise());
		jtRemise.setBounds(300, 210, 100,20 );
		//jtRemise.setEnabled(false);
		jtRemise.setVisible(true);
		add(jtRemise);

		s.setR_NR(true);
        s.getResultat();
	}
});
	jr2.addActionListener(new ActionListener() {
		
		 
		public void actionPerformed(ActionEvent arg0) {
			 

			jtRemise =new JTextField("0");
			jtRemise.setBounds(300, 210, 100,20 );
			//jtRemise.setEnabled(false);
			jtRemise.setVisible(true);
			add(jtRemise);
           s.setR_NR(false);
           s.getResultat();
			
			
		}
	});	
		jlF_V=new JLabel("F_V");
		jlF_V.setBounds(20, 240, 100,20);
		jlF_V.setVisible(true);
		add(jlF_V);

		jr3=new JRadioButton("Prix");
		jr3.setBounds(110,  250,100 , 20 );
		jr3.setVisible(true);
		add(jr3);
		
 
		jr4=new JRadioButton("Prix Max");
		jr4.setBounds(110,  270,100 , 20 );
		jr4.setVisible(true);
		add(jr4);
		
		ButtonGroup bg1= new ButtonGroup(); // lorsque on selecte une boutton l'autre disparete
		bg1.add(jr3);
		bg1.add(jr4);
		if(s.isF_V()==true)
			{jr3.setSelected(true);
			jr3.addActionListener(new ActionListener() {
				
				 
				public void actionPerformed(ActionEvent arg0) {
					jlPrix=new JLabel("Prix");
					jlPrix.setBounds( 240,250, 100 ,20  );
					jlPrix.setVisible(true);
					add(jlPrix);

					jtPrix=new JTextField(s.getPrix());
					jtPrix.setBounds(300 , 250, 100,20 );
					 
					jtPrix.setVisible(true);
					add(jtPrix);
					
					 s.setF_V(true);
			       s.getResultatPrix();
				}
			});
			
			
			}
		if(s.isF_V()==false)
			{
			
			jr4.setSelected(true);
			
			jr4.addActionListener(new ActionListener() {
				
				 
				public void actionPerformed(ActionEvent arg0) {

					jlPrixMax=new JLabel("Prix Max");
					jlPrixMax.setBounds( 240,  270, 100 ,20  );
					jlPrixMax.setVisible(true);
					add(jlPrixMax);

					jtPrixMax=new JTextField(s.getPrixMax());
					jtPrixMax.setBounds(300 ,270, 100,20 );
					 
					jtPrixMax.setVisible(true);
					add(jtPrixMax);
					 s.setF_V(false);
			         s.getResultatPrix();
					
				}
			});
			
			
			
			
			
			}



		

		jlDesignation=new JLabel("designation");
		jlDesignation.setBounds(10, 90,100, 20);
		jlDesignation.setVisible(true);
		add(jlDesignation);

		jtDesignation=new JTextField(s.getDesignation());
		jtDesignation.setBounds( 110,90 , 100 , 20 );
		jtDesignation.setVisible(true);
		add(jtDesignation);







		jbValider=new JButton("Valider");
		jbValider.setBounds( 30,290 , 100 , 20 );
		jbValider.setVisible(true);
		add(jbValider);



		jbValider.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {
				
				s.setDesignation (jtDesignation.getText());
				  
				
				   
               if(s.isR_NR()==true)
				{s.setRemise(jtRemise.getText());
               
  
				}
               
				if(s.isR_NR()==false)
					{s.setRemise(jtRemise.getText());
				
					}
				
				 
				 
				new ServiceDAO().modifier(s);
				jt.setModel(new ServiceTableModel());
				jt.updateUI();




			}
		});



	}







}
