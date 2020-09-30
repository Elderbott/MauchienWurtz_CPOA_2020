package dao.factory;

import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.interfaces.CommandeDAO;
import dao.interfaces.ProduitDAO;
import dao.mysql.MySQLCategorieDAO;
import dao.mysql.MySQLClientDAO;
import dao.mysql.MySQLCommandeDAO;
import dao.mysql.MySQLProduitDAO;
import metier.Categorie;
import metier.Client;
import metier.Commande;
import metier.Produit;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public CategorieDAO<Categorie> getCategorieDAO() {
		return MySQLCategorieDAO.getInstance();
	}

	@Override
	public ClientDAO<Client> getClientDAO() {
		return MySQLClientDAO.getInstance();
	}

	@Override
	public ProduitDAO<Produit> getProduitDAO() {
		return MySQLProduitDAO.getInstance();

	}

	@Override
	public CommandeDAO<Commande> getCommande() {
		return MySQLCommandeDAO.getInstance();
	}
	
	

}
