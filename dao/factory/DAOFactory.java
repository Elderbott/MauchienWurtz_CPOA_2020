package dao.factory;

import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.interfaces.CommandeDAO;
import dao.interfaces.ProduitDAO;
import metier.Categorie;
import metier.Client;
import metier.Produit;
import metier.Commande;

public abstract class DAOFactory {
	
	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
			case MYSQL :
				daoF = new MySQLDAOFactory();
				break;
			case LISTE_MEMOIRE :
				daoF = new ListeMemoireDAOFactory();
				break;
		}
		return daoF;
	}
		
	public abstract CategorieDAO<Categorie> getCategorieDAO();
	public abstract ClientDAO<Client> getClientDAO();
	public abstract ProduitDAO<Produit> getProduitDAO();
	public abstract CommandeDAO<Commande> getCommande();

}
