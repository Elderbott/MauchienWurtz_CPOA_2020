package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.connexion.Connexion;
import dao.interfaces.CategorieDAO;
import metier.Categorie;

public class MySQLCategorieDAO implements CategorieDAO<Categorie> {
	
	private static MySQLCategorieDAO instance;
	private MySQLCategorieDAO() {}
	
	public static MySQLCategorieDAO getInstance() {
	if (instance==null) {
	instance = new MySQLCategorieDAO();
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
	public Categorie getById(int id) {
		Categorie Cat = new Categorie();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie WHERE id_categorie = "+id);
			while (res.next()) {
		        Cat.setId(res.getInt("id_categorie"));
		        Cat.setTitre(res.getString("titre"));
		        Cat.setVisuel(res.getString("visuel"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Cat;
	}

	@Override
	public boolean create(Categorie objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Categorie (titre, visuel) VALUES ('"+objet.getTitre()+"','" +objet.getVisuel()+"')");
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean update(Categorie objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Categorie SET titre = '"+objet.getTitre()+"', visuel ='"+objet.getVisuel()+"'WHERE id_categorie ="+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean delete(Categorie objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Categorie WHERE id_categorie = "+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}
	
	@Override
	public Categorie getByTitre(String Titre) {
		Categorie Cat = new Categorie();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie WHERE titre = '"+Titre+"'");
			while (res.next()) {
		        Cat.setId(res.getInt("id_categorie"));
		        Cat.setTitre(res.getString("titre"));
		        Cat.setVisuel(res.getString("visuel"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Cat;
	}

	@Override
	public ArrayList<Categorie> getAll() {
		ArrayList<Categorie> CatList = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie");
			while (res.next()) {
				Categorie Cat = new Categorie();
		        Cat.setId(res.getInt("id_categorie"));
		        Cat.setTitre(res.getString("titre"));
		        Cat.setVisuel(res.getString("visuel"));
		        CatList.add(Cat);
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return CatList;
	}
}
