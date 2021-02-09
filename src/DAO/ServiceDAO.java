package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Entitée.Client;
import Entitée.Service;

public class ServiceDAO 
{
	private String pass="";
	private String log="root";
	private String url="jdbc:mysql://localhost:3306/facturation";

	public void supprimer(Service s)

	{
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps =con.prepareStatement("delete from service where numservice=?");
			ps.setInt(1,s.getNumService());
			ps.executeUpdate();
			con.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}

	}

	public void ajouter(Service s)
	{


		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("insert into service values (?,?,?,?,?,?,?)");
			ps.setInt(1,s.getNumService() );
			ps.setString (2, s.getDesignation() );
			ps.setString (3, s.getPrix() );
			ps.setString (4, s.getPrixMax() );
			ps.setString (5, s.getRemise() );
			ps.setBoolean (6, s.isF_V() );
			ps.setBoolean (7, s.isR_NR() );

			ps.executeUpdate();
			con.close();ps.close();


		}catch(SQLException sd)
		{sd.printStackTrace();}
	}
	public void modifier(Service s)
	{

		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("update service set designation =?, prix=?,prixmax=? ,remise=? , F_V=?, R_NR=? where numservice=?");

			ps.setString (1, s.getDesignation());
			ps.setString(2, s.getPrix() );
			ps.setString(3, s.getPrixMax());
			ps.setString(4, s.getRemise());
			ps.setBoolean (5, s.isF_V());
			ps.setBoolean (6, s.isR_NR());

			ps.setInt(7, s.getNumService());
			//if(s.getResultat()==1)
				 
			ps.executeUpdate();
			con.close();ps.close();

		}catch(SQLException sd)
		{sd.printStackTrace();}
	}


	public Vector<Service> getListe()
	{ 
		Vector<Service> v=new Vector<Service>();

		try{ 
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from service ;");
			ResultSet rs=ps.executeQuery();
			while (rs.next())
			{  Service s=new Service();


			s.setNumService(rs.getInt(1));
			s.setDesignation(rs.getString(2));
			s.setPrix (rs.getString(3));
			s.setPrixMax (rs.getString(4));
			s.setRemise(rs.getString(5));
			s.setF_V(rs.getBoolean(6));
			s.setR_NR (rs.getBoolean(7));
			v.addElement(s);
			}
			con.close();rs.close();ps.close();
			
			}catch(SQLException sd)
			{sd.printStackTrace();}
			return v;
		}
	public Service rechercherParId(int id)
	{
		Service s=null;
		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from service where numservice=?");
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Service() ;
				s.setNumService(id);
				s.setDesignation(rs.getString(2));
				s.setPrix (rs.getString(3));
				s.setPrixMax (rs.getString(4));
				s.setRemise(rs.getString(5));
				s.setF_V(rs.getBoolean(6));
				s.setR_NR (rs.getBoolean(7));

			}
			con.close();ps.close();rs.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return s;
	}
	
	public int maxId()
	{
		int i=0;
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select max(numservice) from service;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{i=rs.getInt(1);}
		}catch(Exception e)
		{e.printStackTrace();}
		i++;
		return i;
	}
	
	
	public Vector<Service>  getChercherService( String champ,String valeur)
	{   
		Vector<Service> v = new Vector<Service>();
		try {
			Connection con = DriverManager.getConnection(url, log , pass );
			PreparedStatement ps = con.
					prepareStatement("Select * from service where "+champ+" like '%"+valeur+"%';");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Service s= new Service();
				s.setNumService(rs.getInt(1));
				s.setDesignation(rs.getString(2));
				s.setPrix(rs.getString (3));
				s.setPrixMax(rs.getString(4));
				s.setRemise(rs.getString (5));
				 
				s.setF_V(rs.getBoolean(6));
				s.setR_NR(rs.getBoolean(7));
				v.addElement(s);
			}
		} catch (SQLException e) {
			System.out.println("erreur!!!");
			e.printStackTrace();
		}
		return v;
	}
	
	

	}
