import java.util.ArrayList;

import bdd.table.Client;

import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class TestClient {

	public static void main(String[] args) {
		//DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
				DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
			
				//LISTE_MEMOIRE
				//Create
				Client cl = new Client();
				cl.setNom("MAUCHIEN");
				cl.setPrenom("Thomas");
				boolean bool1 = daos.getClientDAO().create(cl);
				//
				
				//GetAll
				ArrayList<Client> cl1 = daos.getClientDAO().getAll();
				System.out.println(cl1);
				//
				
				/*Delete
				Client cl5 = new Client();
				cl.setId(2);
				boolean bool5 = daos.getClientDAO().delete(cl5);
				*/
				
				/*Update
				Client cl6 = new Client();
				cat.setNom("MAUCHIEN");
				cat.setPrenom("Loic");
				cat.setId(2);
				boolean bool6 = daos.getClientDAO().update(cl6);
				*/
				
				//getByNom
				Client cl2 = daos.getClientDAO().getByNom("MAUCHIEN");
				System.out.println(cl2);
				//
				
				//getById
				Client cl3 = daos.getClientDAO().getById(2);
				System.out.println(cl3);
				//
				
				//getByPreom
				Client cl4 = daos.getClientDAO().getByPrenom("Thomas");
				System.out.println(cl4);
				//
				
				
				
				//MySQL
				/*Update
				Client cl = new Client(11, "test1", "test1.png");
				boolean bool1 = daos.getClientDAO().update(cl);
				*/

				/*Delete
				Client cl1 = new Client();
				cat.setId(10);
				boolean bool1 = daos.getClientDAO().delete(cl1);
				*/
				
				/*Create
				Client ccl = new Client();
				cat.setTitre("test2");
				cat.setVisuel("test2.png");
				boolean bool1 = daos.getCategorieDAO().create(cat);
				*/
				
				/*GetByTitre
				Categorie cat1 = daos.getCategorieDAO().getByTitre("Pulls");
				System.out.println(cat1);
				*/
				
				/*GetAll
				ArrayList<Categorie> cat1 = daos.getCategorieDAO().getAll();
				for (Categorie obj : cat1) {
					System.out.println(obj);
				}*/

			}
	}

