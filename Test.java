import java.util.ArrayList;

import com.sun.tools.javac.parser.Scanner;

import DAO.DAOFactory;
import DAO.Persistance;
import bdd.table.Categorie;

public class Test {
	public static void main(String[] args) {
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		
		/*Update
		Categorie cat = new Categorie();
		cat.setTitre_categ("test1");
		cat.setVisuel_categ("test1.png");
		cat.setId_categ(11);
		boolean bool1 = daos.getCategorieDAO().update(cat);
		*/

		/*Delete
		Categorie cat = new Categorie();
		cat.setId_categ(10);
		boolean bool1 = daos.getCategorieDAO().delete(cat);
		*/
		
		/*Create
		Categorie cat = new Categorie();
		cat.setTitre_categ("test");
		cat.setVisuel_categ("test.png");
		boolean bool1 = daos.getCategorieDAO().create(cat);
		*/
		
		/*GetByTitre
		Categorie cat1 = (Categorie) daos.getCategorieDAO().getByTitre("Pulls");
		System.out.println(cat1);
		*/
		
		/*GetAll
		ArrayList<Categorie> cat1 = daos.getCategorieDAO().getAll();
		for (Categorie obj : cat1) {
			System.out.println(obj);
		}*/

	}
}
