import java.util.ArrayList;
import java.util.List;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Client;
import metier.Commande;

public class TestCommande {
public static void main(String[] args) {
		
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		//DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		
		/*GetAll
		ArrayList<Commande> com = daos.getCommandeDAO().getAll();
		for (Commande obj : com) {
			System.out.println(obj);
		}
		*/
		
		/*Create
		Commande com3 = new Commande();
		Client cl1 = new Client();
		cl1.setId(1);
		com3.setClient(cl1);
		boolean bool1 = daos.getCommandeDAO().create(com3);
		*/
		
		/*Update
		Commande com4 = new Commande();
		Client cl2 = new Client();
		cl2.setId(1);
		com4.setClient(cl1);
		com4.setNum(21);
		boolean bool2 = daos.getCommandeDAO().update(com4);
		*/
		
		/*GetById
		Commande com1 = daos.getCommandeDAO().getById(1);
		System.out.println(com1);
		//*/
		
		/*GetByClient
		Client cl = new Client();
		cl.setId(1);
		List<Commande> com2 = daos.getCommandeDAO().getByClient(cl);
		System.out.println(com2);
		*/
		
		/*Delete
		Commande com3 = new Commande();
		com3.setNum(20);
		boolean bool2 = daos.getCommandeDAO().delete(com3);
		*/
	}
}
