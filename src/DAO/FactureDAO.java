package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Entitée.Client;
import Entitée.Facture;

public class FactureDAO 
{
	private String pass="";
	private String log="root";
	private String url="jdbc:mysql://localhost:3306/facturation";

	public void supprimer(Facture f)
	{ 
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("delete from facture where numfacture=?");
			ps.setInt(1,f.getNumFacture() );
			ps.executeUpdate();

			con.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}

	}
	public void ajouter(Facture f)
	{


		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("insert into facture values (?,?,?,?)");
			ps.setInt(1, f.getNumFacture());
			ps.setInt(2, f.getRemise());
			ps.setDate(3, f.getDate());
			ps.setInt(4, f.getClient().getNumClient());
			ps.executeUpdate();
			con.close();ps.close();


		}catch(SQLException sd)
		{sd.printStackTrace();}
	}

	public void modifier(Facture f)
	{

		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("update facture set remise =?,date=?,numcl=? where numfacture=?");

			ps.setInt(1, f.getRemise());
			ps.setDate(2, f.getDate());
			ps.setInt(3, f.getClient().getNumClient());
			ps.setInt(4, f.getNumFacture());
			ps.executeUpdate();
			con.close();ps.close();

		}catch(SQLException sd)
		{sd.printStackTrace();}
	}
	public Vector<Facture> getListe()
	{ 
		Vector<Facture> v=new Vector<Facture>();

		try{ 
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from facture ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{  Facture f=new Facture();


			f.setNumFacture(rs.getInt(1));
			f.setRemise(rs.getInt(2));
			f.setDate(rs.getDate(3));
			int i=rs.getInt(4);
			Client c=new ClientDAO().rechercherParId(i);
			f.setClient(c);
			v.addElement(f);
			}
			con.close();rs.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return v;
	}

	public Facture rechercherParId(int id)
	{
		Facture f=null;
		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from facture where numfacture=?");
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f=new Facture() ;
				f.setNumFacture(id);
				f.setRemise(rs.getInt(2));
				f.setDate(rs.getDate(3) );
				int i=rs.getInt(4);
				Client c=new ClientDAO().rechercherParId(i);
				f.setClient(c);

			}
			con.close();ps.close();rs.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return f;
	}


	public  Facture rechercherParClient(Client c)
	{
		Facture f=null;
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from facture where numcl=?");
			ps.setInt(1,c.getNumClient() );
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				f=new Facture();
				f.setNumFacture(rs.getInt(1));
				f.setRemise(rs.getInt(2));
				f.setDate(rs.getDate(3));
				Client cl=new ClientDAO().rechercherParId(rs.getInt(4));
				f.setClient(cl);
			}

		}catch(SQLException sd)
		{
			sd.printStackTrace();
		}
		return f;
	}


	public int getMaxId()
	{
		int i=0;
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select max(numfacture) from facture;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{i=rs.getInt(1);}
		}catch(Exception e)
		{e.printStackTrace();}
		i++;
		return i;
	}
	
	
	
	
	
	
}



