package dao.mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dao.connexion.Connexion;
import dao.factory.DAOFactory;
import dao.factory.Persistance;
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
	
	Scanner sc1 = new Scanner(System.in);

	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}
	
	@Override
	public Commande getById(int id) {
		Map<Produit, Integer> produits = new HashMap<>();
		Commande commandes = new Commande();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande WHERE id_commande = "+id);
			while (res.next()) {
		        commandes.setNum(res.getInt("id_commande"));
		        commandes.setDate(res.getDate("date_commande"));
		        Client clients = new Client();
		        clients.setId(res.getInt("id_client"));
		        commandes.setClient(clients);
		        produits = getLigneCommande(res.getInt("id_commande"));
		        commandes.setProduits(produits);
			}
		}catch(SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		return commandes;
	}

	@Override
	public boolean create(Commande objet) {
		boolean verif = false;
		boolean nouveau = true;
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		String aujourdhui =  LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Commande (date_commande, id_client) VALUES ('"+aujourdhui+"','" +objet.getClient().getId()+"')");
			verif = true;
		} catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
		}
		while(nouveau) {
			int resultat = 0;
			try {
				Statement requete3 = Connexion();
				ResultSet res = requete3.executeQuery("SELECT MAX(id_commande) FROM Commande");
				while (res.next()) {
					resultat = res.getInt("MAX(id_commande)");
				}
			} catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
			}
			System.out.println("Selectionner un produit:");
			int prod1 = sc1.nextInt();
			Produit prod2 = daos.getProduitDAO().getById(prod1);
			System.out.println("Selectionner sa quantité:");
			int quant1 = sc1.nextInt();
			try {
				Statement requete2 = Connexion();
				requete2.executeUpdate("INSERT INTO Ligne_commande (id_commande, id_produit, quantite, tarif_unitaire) VALUES ('"+resultat+"','" +prod1+"','"+quant1+"','"+prod2.getTarif()+"')");
			} catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
			}
			int reponse = 0;
			System.out.println("Voulez-vous ajoutez un autre produit? oui(1) ou non(2)");
			reponse = sc1.nextInt();
			if (reponse == 1) {
				nouveau = true;
			}
			else {
				nouveau = false;
			}
		}
		return verif;
	}

	@Override
	public boolean update(Commande objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Commande SET id_client = '"+objet.getClient().getId()+"' WHERE id_commande ="+objet.getNum());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
		return verif;
	}

	@Override
	public boolean delete(Commande objet) {
		boolean verif = false;
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Commande WHERE id_commande ="+objet.getNum());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 }
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Ligne_commande WHERE id_commande ="+objet.getNum());
			verif = true;
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 }
		return verif;
	}

	@Override
	public ArrayList<Commande> getAll() {
		ArrayList<Commande> liste = new ArrayList<>();

		Map<Produit, Integer> produits = new HashMap<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande");
			while (res.next()) {
				Commande commandes = new Commande();
				
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
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Ligne_commande WHERE id_commande = "+id);
			while (res.next()) {
				Produit prod = new Produit();
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
		Map<Produit, Integer> produits = new HashMap<>();
		ArrayList<Commande> liste = new ArrayList<>();
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Commande WHERE id_client = "+objet.getId());
			while (res.next()) {
				Commande commandes = new Commande();
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
