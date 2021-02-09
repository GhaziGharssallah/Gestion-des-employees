package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

 
import Entitée.Client;

public class ClientDAO 
{

	private String pass="";
	private String log="root";
	private String url="jdbc:mysql://localhost:3306/facturation";


	public void supprimer (Client c)
	{
		try{
			Connection con;
			con=DriverManager.getConnection(url,log,pass);
			PreparedStatement ps=con.prepareStatement("delete from client where numcl =? ");
			ps.setInt(1,c.getNumClient());
			ps.executeUpdate();
			con.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
	}

	public void ajouter(Client c)
	{
		try{
			Connection con;
			con=DriverManager.getConnection(url,log,pass);
			PreparedStatement ps=con.prepareStatement("insert into client values (?,?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1,c.getNumClient());
			ps.setString(2, c.getNom());
			ps.setString(3, c.getPrenom());
			ps.setString(4,c.getRaison() );
			ps.setString(5,c.getMatricule() );
			ps.setInt(6,c.getNumtel());
			ps.setString(7,c.getEmail()  );
			ps.setString(8,c.getFax() );

			ps.setString(9,c.getAdresse()  );
			ps.setBoolean(10, c.isE_P());
			ps.setBoolean(11,c.isA_N() );
			ps.executeUpdate();
			con.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
	}



	public Vector<Client> getListe()
	{
		Vector<Client> v=new Vector<Client>();

		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from client;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Client c =new Client();
				c.setNumClient(rs.getInt("numcl"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setRaison(rs.getString("raison"));
				c.setMatricule(rs.getString("matricule"));
				c.setNumtel(rs.getInt("numtel"));
				c.setEmail(rs.getString("email"));
				c.setFax(rs.getString("fax"));
				c.setAdresse(rs.getString("adresse"));
				c.setE_P(rs.getBoolean("E_P"));
				c.setA_N(rs.getBoolean("A_N"));
				v.addElement(c);
			}
			con.close();rs.close();ps.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}

		return v;
	}
	
	public void modifier(Client c)
	{
		
		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("update client set nom=?, prenom=?,raison=?,matricule=?,numtel=?,email=?,fax=?,adresse=?,A_N=? where numcl=?");
			 
			 ps.setString(1, c.getNom());
			 ps.setString(2, c.getPrenom());
			 ps.setString(3, c.getRaison());
			 ps.setString(4, c.getMatricule());
			 ps.setInt(5, c.getNumtel());
			 ps.setString(6, c.getEmail());
			 ps.setString(7, c.getFax());
			 ps.setString(8, c.getAdresse());
			 ps.setBoolean(9, c.isA_N());
			 //ps.setBoolean(10, c.isE_P());
			 ps.setInt(10,c.getNumClient());
			 ps.executeUpdate();
			 con.close();ps.close();
			  
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	

	public Client rechercherParId(int id)
	{ 
		Client c=null;
		try
		{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select * from client where numcl=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{ 
				c=new Client();
				c.setNumClient(id);
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setRaison(rs.getString("raison"));
				c.setMatricule(rs.getString("matricule"));
				c.setNumtel(rs.getInt("numtel"));
				c.setEmail(rs.getString("email"));
				c.setFax(rs.getString("fax"));
				c.setAdresse(rs.getString("adresse"));
				c.setE_P(rs.getBoolean("E_P"));
				c.setA_N(rs.getBoolean("A_N"));


			}
			con.close();ps.close();rs.close();
		}catch(SQLException sd)
		{sd.printStackTrace();}
		return c;
	}


	public int maxId()
	{
		int i=0;
		try{
			Connection con=DriverManager.getConnection(url, log, pass);
			PreparedStatement ps=con.prepareStatement("select max(numcl) from client;");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{i=rs.getInt(1);}
		}catch(Exception e)
		{e.printStackTrace();}
		i++;
		return i;
	}

	public Vector<Client>  getChercherClient( String champ,String valeur)
	{   
		Vector<Client> v = new Vector<Client>();
		try {
			Connection con = DriverManager.getConnection(url, log , pass );
			PreparedStatement ps = con.
					prepareStatement("Select * from client where "+champ+" like '%"+valeur+"%';");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Client p = new Client();
				p.setNumClient (rs.getInt(1));
				p.setNom(rs.getString(2));
				p.setPrenom (rs.getString (3));
				p.setRaison (rs.getString(4));
				p.setMatricule  (rs.getString (5));
				p.setNumtel (rs.getInt(6));
				p.setEmail  (rs.getString(7));
				p.setFax  (rs.getString (8));
				p.setAdresse  (rs.getString(9));
				p.setE_P  (rs.getBoolean  (10));
				p.setA_N (rs.getBoolean  (11));
				v.addElement(p);
			}
		} catch (SQLException e) {
			System.out.println("erreur!!!");
			e.printStackTrace();
		}
		return v;
	}

	
	
}





 
