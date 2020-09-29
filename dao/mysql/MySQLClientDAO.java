package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.connexion.Connexion;
import dao.interfaces.ClientDAO;
import metier.Client;

public class MySQLClientDAO implements ClientDAO<Client> {
	
	private static MySQLClientDAO instance;
	private MySQLClientDAO() {}
	
	public static MySQLClientDAO getInstance() {
	if (instance==null) {
	instance = new MySQLClientDAO();
	}
	return instance;
	}

	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}

	@Override
	public Client getById(int id) {
		Client Cl = new Client();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE id_client = "+id);
			while (res.next()) {
		        Cl.setId(res.getInt("id_client"));
		        Cl.setNom(res.getString("nom"));
		        Cl.setPrenom(res.getString("prenom"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Cl;
	}

	@Override
	public boolean create(Client objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Client (nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES ('"+objet.getNom()+"','" +objet.getPrenom()+"',' ',' ',' ',' ',' ',' ',' ')");
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean update(Client objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Client SET nom = '"+objet.getNom()+"', prenom ='"+objet.getPrenom()+"'WHERE id_client ="+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean delete(Client objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Client WHERE id_client ="+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public ArrayList<Client> getAll() {
		ArrayList<Client> ClList = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie");
			while (res.next()) {
				Client Cl = new Client();
		        Cl.setId(res.getInt("id_categorie"));
		        Cl.setNom(res.getString("nom"));
		        Cl.setPrenom(res.getString("prenom"));
		        ClList.add(Cl);
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return ClList;
	}

	@Override
	public Client getByNom(String nom) {
		Client Cl = new Client();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE nom = "+nom);
			while (res.next()) {
		        Cl.setId(res.getInt("id_client"));
		        Cl.setNom(res.getString("nom"));
		        Cl.setPrenom(res.getString("prenom"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Cl;
	}

	@Override
	public Client getByPrenom(String prenom) {
		Client Cl = new Client();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Client WHERE prenom = "+prenom);
			while (res.next()) {
		        Cl.setId(res.getInt("id_client"));
		        Cl.setNom(res.getString("nom"));
		        Cl.setPrenom(res.getString("prenom"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Cl;
	}
}
