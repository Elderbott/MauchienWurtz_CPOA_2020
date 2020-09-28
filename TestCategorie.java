import java.util.ArrayList;

import com.sun.tools.javac.parser.Scanner;

import bdd.table.Categorie;
import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class TestCategorie {
	public static void main(String[] args) {
		//DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	
		//LISTE_MEMOIRE
		/*Create
		Categorie cat = new Categorie();
		cat.setTitre("test2");
		cat.setVisuel("test2.png");
		boolean bool1 = daos.getCategorieDAO().create(cat);
		*/
		
		/*GetAll
		ArrayList<Categorie> cat1 = daos.getCategorieDAO().getAll();
		System.out.println(cat1);
		*/
		
		/*Delete
		Categorie cat2 = new Categorie();
		cat.setId(3);
		boolean bool2 = daos.getCategorieDAO().delete(cat);
		*/
		
		/*Update
		Categorie cat6 = new Categorie();
		cat.setTitre("test1");
		cat.setVisuel("test1.png");
		cat.setId(3);
		boolean bool6 = daos.getCategorieDAO().update(cat);
		*/
		
		/*getByTitre
		Categorie cat3 = daos.getCategorieDAO().getByTitre("Bonnets");
		System.out.println(cat3);
		*/
		
		/*getById
		Categorie cat3 = daos.getCategorieDAO().getById(2);
		System.out.println(cat3);
		*/
		
		
		
		//MySQL
		/*Update
		Categorie cat = new Categorie();
		cat.setTitre("test1");
		cat.setVisuel("test1.png");
		cat.setId(11);
		boolean bool1 = daos.getCategorieDAO().update(cat);
		*/

		/*Delete
		Categorie cat = new Categorie();
		cat.setId(10);
		boolean bool1 = daos.getCategorieDAO().delete(cat);
		*/
		
		/*Create
		Categorie cat = new Categorie();
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
