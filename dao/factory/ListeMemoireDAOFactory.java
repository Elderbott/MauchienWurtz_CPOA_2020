package dao.factory;

import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.liste_memoire.ListeMemoireCategorieDAO;
import dao.liste_memoire.ListeMemoireClientDAO;
import metier.Categorie;
import metier.Client;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public CategorieDAO<Categorie> getCategorieDAO() {
		return ListeMemoireCategorieDAO.getInstance();
	}

	@Override
	public ClientDAO<Client> getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}
}
