package dao.factory;

import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.mysql.MySQLCategorieDAO;
import dao.mysql.MySQLClientDAO;
import metier.Categorie;
import metier.Client;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public CategorieDAO<Categorie> getCategorieDAO() {
		return MySQLCategorieDAO.getInstance();
	}

	@Override
	public ClientDAO<Client> getClientDAO() {
		return MySQLClientDAO.getInstance();
	}
	
	

}
