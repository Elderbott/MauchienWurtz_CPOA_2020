package dao.factory;

import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.interfaces.CommandeDAO;
import dao.interfaces.ProduitDAO;
import dao.liste_memoire.ListeMemoireCategorieDAO;
import dao.liste_memoire.ListeMemoireClientDAO;
import dao.liste_memoire.ListeMemoireCommandeDAO;
import dao.liste_memoire.ListeMemoireProduitDAO;
import metier.Categorie;
import metier.Client;
import metier.Commande;
import metier.Produit;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public CategorieDAO<Categorie> getCategorieDAO() {
		return ListeMemoireCategorieDAO.getInstance();
	}

	@Override
	public ClientDAO<Client> getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public ProduitDAO<Produit> getProduitDAO() {
		return ListeMemoireProduitDAO.getInstance();

	}

	@Override
	public CommandeDAO<Commande> getCommandeDAO() {
		return ListeMemoireCommandeDAO.getInstance();
	}
}
