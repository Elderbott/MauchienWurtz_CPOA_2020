package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.connexion.Connexion;
import dao.interfaces.CommandeDAO;
import metier.Client;
import metier.Commande;
import metier.Produit;

public class MySQLCommandeDAO implements CommandeDAO<Commande>{

	private static MySQLCommandeDAO instance;
	private MySQLCommandeDAO() {}
	
	public static MySQLCommandeDAO getInstance() {
	if (instance==null) {
	instance = new MySQLCommandeDAO();
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
	public Commande getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Commande> getAll() {
		ArrayList<Commande> liste = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande");
			while (res.next()) {
				Commande commandes = new Commande();
				Map<Produit, Integer> produits = new HashMap<>();
		        commandes.setNum(res.getInt("id_commande"));
		        commandes.setDate(res.getDate("date_commande"));
		        Client clients = new Client();
		        clients.setId(res.getInt("id_client"));
		        commandes.setClient(clients);
		        produits = getLigneCommande(res.getInt("id_commande"));
		        commandes.setProduits(produits);
		        liste.add(commandes);
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return liste;
	}

	@Override
	public Map<Produit, Integer> getLigneCommande(int id) {
		Map<Produit, Integer> produits = new HashMap<>();
		Produit prod = new Produit();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Ligne_commande WHERE id_commande = "+id);
			while (res.next()) {
		        prod.setId(res.getInt("id_produit"));
		        prod.setTarif(res.getDouble("tarif_unitaire"));
		        produits.put(prod, res.getInt("quantite"));
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return produits;
	}

	@Override
	public List<Commande> getByClient(Client objet) {
		Commande commandes = new Commande();
		Map<Produit, Integer> produits = new HashMap<>();
		ArrayList<Commande> liste = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande WHERE id_client = "+objet.getId());
			while (res.next()) {
		        commandes.setNum(res.getInt("id_commande"));
		        commandes.setDate(res.getDate("date_commande"));
		        Client clients = new Client();
		        clients.setId(res.getInt("id_client"));
		        commandes.setClient(clients);
		        produits = getLigneCommande(res.getInt("id_commande"));
		        commandes.setProduits(produits);
		        liste.add(commandes);
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return liste;
	}
}
