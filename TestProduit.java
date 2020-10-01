import java.util.ArrayList;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Categorie;
import metier.Produit;

public class TestProduit {

	public static void main(String[] args) {
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		//DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		
		//ListeMemoire
		/*GetAll
		ArrayList<Produit> prod2 = daos.getProduitDAO().getAll();
		System.out.println(prod2);
		*/
		
		/*getById
		Produit prod = daos.getProduitDAO().getById(2);
		System.out.println(prod);
		*/
		
		/*getByNom
		Produit prod1 = daos.getProduitDAO().getByNom("Sonic te kiffe");
		System.out.println(prod1);
		*/
		
		/*getByCateg
		ArrayList<Produit> prod3 = daos.getProduitDAO().getByIdCateg(2);
		System.out.println(prod3);
		*/
		
		/*Create
		Categorie obj2 = new Categorie();
		obj2.setTitre("Bonnets");
		Categorie cat2 = daos.getCategorieDAO().getByTitre(obj2.getTitre());
		obj2.setId(cat2.getId());
		Produit prod4 = new Produit(2, "La chaleur des rennes", "Classique mais efficace, un bonnet dont l'élégance n'est pas à souligner, il vous grattera comme il faut !", 15, "bonnet0.png", obj2);
		boolean bool1 = daos.getProduitDAO().create(prod4);
		*/

		/*Delete
		Produit prod6 = new Produit();
		prod6.setId(3);
		boolean bool2 = daos.getProduitDAO().delete(prod6);
		*/
		
		/*Update
		Categorie obj = new Categorie();
	    obj.setTitre("Pulls");
	    Categorie cat3 = daos.getCategorieDAO().getByTitre(obj.getTitre());
		obj.setId(cat3.getId());
		Produit prod5 = new Produit(3, "Luigi je te kiff", "Inspiré par la sage Nintendo", 41.5, "pull2.png", obj);
		boolean bool2 = daos.getProduitDAO().update(prod5);
		*/

		
		//MySQL
		/*Create
		Produit prod4 = new Produit();
	    prod4.setNom("Mario je te kiff");
	    prod4.setDescription("Inspiré par la sage Nintendo");
	    prod4.setTarif(41.5);
	    prod4.setVisuel("pull2.png");
	    Categorie obj = new Categorie();
	    obj.setTitre("Pulls");
	    prod4.setCategorie(obj);
		boolean bool1 = daos.getProduitDAO().create(prod4);
		*/
		
		/*Update
		Produit prod5 = new Produit();
	    prod5.setNom("Luigi je te kiff");
	    prod5.setDescription("Inspiré par la sage Nintendo");
	    prod5.setTarif(41.5);
	    prod5.setVisuel("pull2.png");
	    Categorie obj = new Categorie();
	    obj.setTitre("Pulls");
	    prod5.setCategorie(obj);
	    prod5.setId(17);
		boolean bool2 = daos.getProduitDAO().update(prod5);
		*/
		
		/*Delete
		Produit prod5 = new Produit();
		prod5.setId(16);
		boolean bool2 = daos.getProduitDAO().delete(prod5);
		*/
		
		
		/*GetByIdCateg
		ArrayList<Produit> prod3 = daos.getProduitDAO().getByIdCateg(2);
		System.out.println(prod3);
		*/
		
		//GetByNom
		Produit prod2 = daos.getProduitDAO().getByNom("Sonic te kiffe");
		System.out.println(prod2);
		//
		
		//GetById
		Produit prod3 = daos.getProduitDAO().getById(2);
		System.out.println(prod3);
		//
		
		//GetAll
		ArrayList<Produit> prod1 = daos.getProduitDAO().getAll();
		for (Produit obj : prod1) {
			System.out.println(obj);
		}
		//
	}
}
