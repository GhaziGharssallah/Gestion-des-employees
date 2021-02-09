package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Entitée.Client;
import Entitée.Facture;
import Entitée.LigneFacture;
import Entitée.Service;

public class LigneFactureDAO 
{
	private String pass="";
	private String log="root";
	private String url="jdbc:mysql://localhost:3306/facturation";


	public void supprimer(LigneFacture lf)

	{
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps =con.prepareStatement("delete from lignefacture where numlgfactur=?");
			ps.setInt(1,lf.getNumLgFacture() );
			ps.executeUpdate();
			con.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}

	}


	public void ajouter(LigneFacture lg)
	{


		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("insert into lignefacture values (?,?,?,?,?,?)");
			ps.setInt(1,lg.getNumLgFacture() );
			ps.setInt (2, lg.getQte() );
			ps.setInt (3, lg.getPrix() );

			ps.setInt (4, lg.getRemise() );
			ps.setInt(5, lg.getService().getNumService());
			 ps.setInt(6, lg.getFacture().getNumFacture());
			ps.executeUpdate();
			con.close();ps.close();


		}catch(SQLException sd)
		{sd.printStackTrace();}
	}
	
	
	public void modifier(LigneFacture lf)
	{

		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("update lignefacture set quantité=?, =? ,prix=? , remise=?, numservice=? where numlgfactur =?");

			ps.setInt(1,lf.getQte());
			ps.setInt(2, lf.getPrix() );
			 
			ps.setInt(3, lf.getRemise());
			ps.setInt(5, lf.getService().getNumService());
			//ps.setInt(6, lf.getFacture().getNumFacture());
			ps.setInt(6, lf.getNumLgFacture());  
			ps.executeUpdate();
			con.close();ps.close();

		}catch(SQLException sd)
		{sd.printStackTrace();}
	}


	public Vector<LigneFacture> rechercherParFacture(Facture f)
	{

		Vector<LigneFacture> v=new Vector<LigneFacture>();

		Connection con;
		try{

			con=DriverManager.getConnection(url,log,pass);
			PreparedStatement ps=con.prepareStatement("select * from lignefacture where numfacture=? ");
			ps.setInt(1,f.getNumFacture());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				LigneFacture l=new LigneFacture();
				l.setNumLgFacture(rs.getInt(1));
				l.setQte(rs.getInt(2));
				l.setPrix(rs.getInt(3));
				l.setRemise(rs.getInt(4));
				Service s=new ServiceDAO().rechercherParId(rs.getInt(5)) ;
				l.setService(s);
				int i=rs.getInt(6) ;
				Facture f1=new FactureDAO().rechercherParId(i);
				l.setFacture(f1);


				v.addElement(l);



			}

		}catch(Exception e)
		{e.printStackTrace();}
		return v;

	}

	public Vector<LigneFacture> getListe()
	{ 
		Vector<LigneFacture> v=new Vector<LigneFacture>();

		try{ 
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from lignefacture ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{  LigneFacture  l=new LigneFacture();
			l.setNumLgFacture(rs.getInt(1));


			l.setQte(rs.getInt(2));
			l.setPrix(rs.getInt(3));
			l.setRemise(rs.getInt(4));
			Service s=new ServiceDAO().rechercherParId(rs.getInt(5)) ;
			l.setService(s);
			int i=rs.getInt(6) ;
			Facture f1=new FactureDAO().rechercherParId(i);
			l.setFacture(f1);
			v.addElement(l);
			}
			con.close();rs.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return v;
	}
	
	
	
 
	
	public LigneFacture rechercherParId(int id)
	{ 
		LigneFacture l=null;
		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from lignefacture where numlgfactur=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				l=new LigneFacture();
				l.setNumLgFacture (id);
				 l.setQte(rs.getInt(2));
				l.setPrix(rs.getInt(3));
				l.setRemise(rs.getInt(4));
				Service s1=new ServiceDAO().rechercherParId(rs.getInt(5)) ;
				l.setService(s1);
				int i=rs.getInt(6) ;
				Facture f1=new FactureDAO().rechercherParId(i);
				l.setFacture(f1);

 




			}
			con.close();ps.close();rs.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return l;
	}


	public Vector<LigneFacture> rechercherParService(Service s)
	{

		Vector<LigneFacture> v=new Vector<LigneFacture>();

		Connection con;
		try{

			con=DriverManager.getConnection(url,log,pass);
			PreparedStatement ps=con.prepareStatement("select * from lignefacture where numservice=? ");
			ps.setInt(1, s.getNumService());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{  LigneFacture l=new LigneFacture();
			l.setNumLgFacture(rs.getInt(1));
			l.setQte(rs.getInt(2));
			l.setPrix(rs.getInt(3));
			l.setRemise(rs.getInt(4));
			Service s1=new ServiceDAO().rechercherParId(rs.getInt(5)) ;
			l.setService(s1);
			int i=rs.getInt(6) ;
			Facture f1=new FactureDAO().rechercherParId(i);
			l.setFacture(f1);


			v.addElement(l);




			}

		}catch(Exception e)
		{e.printStackTrace();}
		return v;

	}


 
	




}
