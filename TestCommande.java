import java.util.ArrayList;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Commande;

public class TestCommande {
public static void main(String[] args) {
		
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		//DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		
		//GetAll
		ArrayList<Commande> com = daos.getCommandeDAO().getAll();
		System.out.println(com);
		//*/

	}
}
