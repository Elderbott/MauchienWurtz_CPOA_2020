package dao.factory;

import bdd.table.Categorie;
import bdd.table.Client;
import dao.interfaces.CategorieDAO;
import dao.interfaces.ClientDAO;

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

}