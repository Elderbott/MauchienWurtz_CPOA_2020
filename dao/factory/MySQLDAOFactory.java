package dao.factory;

import bdd.table.Categorie;
import bdd.table.Client;
import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;
import dao.mysql.MySQLCategorieDAO;
import dao.mysql.MySQLClientDAO;

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
