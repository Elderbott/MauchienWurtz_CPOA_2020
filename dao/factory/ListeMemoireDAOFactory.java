package dao.factory;

import bdd.table.Categorie;
import bdd.table.Client;
import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.liste_memoire.ListeMemoireCategorieDAO;
import dao.liste_memoire.ListeMemoireClientDAO;

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
