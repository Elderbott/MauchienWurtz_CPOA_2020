package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.connexion.Connexion;
import dao.factory.DAOFactory;
import dao.factory.Persistance;
import dao.interfaces.ProduitDAO;
import metier.Categorie;
import metier.Produit;

public class MySQLProduitDAO implements ProduitDAO<Produit> {
	
	private static MySQLProduitDAO instance;
	private MySQLProduitDAO() {}
	
	public static MySQLProduitDAO getInstance() {
		if (instance==null) {
			instance = new MySQLProduitDAO();
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
	public Produit getById(int id) {
		Produit Prod2 = new Produit();
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit WHERE id_produit = '"+id+"'");
			while (res.next()) {
		        Prod2.setId(res.getInt("id_produit"));
		        Prod2.setNom(res.getString("nom"));
		        Prod2.setDescription(res.getString("description"));
		        Prod2.setTarif(res.getDouble("tarif"));
		        Prod2.setVisuel(res.getString("visuel"));
		        Categorie cat1 = daos.getCategorieDAO().getById(res.getInt("id_categorie"));
		        Prod2.setCategorie(cat1);
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Prod2;
	}

	@Override
	public boolean create(Produit objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
			Categorie cat1 = daos.getCategorieDAO().getByTitre(objet.getCategorie().getTitre());
			requete.executeUpdate("INSERT INTO Produit (nom, description, tarif, visuel,id_categorie) VALUES ('"+objet.getNom()+"','" +objet.getDescription()+"','"+objet.getTarif()+"','"+objet.getVisuel()+"','"+cat1.getId()+"')");
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean update(Produit objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
			Categorie cat1 = daos.getCategorieDAO().getByTitre(objet.getCategorie().getTitre());
			requete.executeUpdate("UPDATE Produit SET nom = '"+objet.getNom()+"', description ='"+objet.getDescription()+"', tarif = '"+objet.getTarif()+"', visuel ='"+objet.getVisuel()+"', id_categorie = '"+cat1.getId()+"'WHERE id_produit ="+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean delete(Produit objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Produit WHERE id_produit ="+objet.getId());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public ArrayList<Produit> getAll() {
		ArrayList<Produit> Prod1 = new ArrayList<>();
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit");
			
			while (res.next()) {
				Produit Prod2 = new Produit();
		        Prod2.setId(res.getInt("id_produit"));
		        Prod2.setNom(res.getString("nom"));
		        Prod2.setDescription(res.getString("description"));
		        Prod2.setTarif(res.getDouble("tarif"));
		        Prod2.setVisuel(res.getString("visuel"));
		        Categorie cat1 = daos.getCategorieDAO().getById(res.getInt("id_categorie"));
		        Prod2.setCategorie(cat1);
		        Prod1.add(Prod2);
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Prod1;
	}

	@Override
	public Produit getByNom(String nom) {
		Produit Prod2 = new Produit();
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit WHERE nom = '"+nom+"'");
			
			while (res.next()) {
		        Prod2.setId(res.getInt("id_produit"));
		        Prod2.setNom(res.getString("nom"));
		        Prod2.setDescription(res.getString("description"));
		        Prod2.setTarif(res.getDouble("tarif"));
		        Prod2.setVisuel(res.getString("visuel"));
		        Categorie cat1 = daos.getCategorieDAO().getById(res.getInt("id_categorie"));
		        Prod2.setCategorie(cat1);
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Prod2;
	}

	@Override
	public ArrayList<Produit> getByIdCateg(int id) {
		ArrayList<Produit> Prod1 = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit WHERE id_categorie = '"+id+"'");
			while (res.next()) {
				Produit Prod2 = new Produit();
		        Prod2.setId(res.getInt("id_produit"));
		        Prod2.setNom(res.getString("nom"));
		        Prod2.setDescription(res.getString("description"));
		        Prod2.setTarif(res.getDouble("tarif"));
		        Prod2.setVisuel(res.getString("visuel"));
		        Categorie cat1 = new Categorie();
		        cat1.setId(res.getInt("id_categorie"));
		        Prod2.setCategorie(cat1);
		        Prod1.add(Prod2);
			}
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return Prod1;
	}

}
