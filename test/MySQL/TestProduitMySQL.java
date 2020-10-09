package test.MySQL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Categorie;
import metier.Produit;

class TestProduitSQL{

	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);

	@Test
	public void testCreateProduit () {
		//nombre de produit avant le nouveau
		int size = daos.getProduitDAO().getAll().size();
		Categorie categ = new Categorie();
		categ.setId(2);
	    Produit prod = new Produit();
	    prod.setCategorie(categ);
		assertTrue(daos.getProduitDAO().create(prod));
		//on verifie qu'il existe un nouveau produit
		assertEquals(size + 1, daos.getProduitDAO().getAll().size());
		daos.getProduitDAO().delete(prod);
		
	}

	@Test
	public void testupdateProduit() {
		Produit prod = new Produit();
		prod.setId(55);
		Categorie categ = new Categorie();
		categ.setId(2);
		prod.setCategorie(categ);
		Produit prod1 = daos.getProduitDAO().getById(prod.getId());
		prod1.setDescription("Jeux video sur la playstation2");
		prod1.setNom("Silent hill 2");
		prod1.setVisuel("silenthill2.png");
		prod1.setTarif(12);
		prod1.setCategorie(categ);
		assertTrue(daos.getProduitDAO().update(prod));
		assertNotEquals(prod, daos.getProduitDAO().getById(prod.getId()));
		daos.getProduitDAO().update(prod1);	
	}
	
	@Test
	public void testdeleteProduit() {
	//lecture du produit
	Produit prod = daos.getProduitDAO().getById(62);
	Produit prod1 = new Produit();
	prod1.setCategorie(prod.getCategorie());
	prod1.setDescription(prod.getDescription());
	prod1.setId(prod.getId());
	prod1.setNom(prod.getNom());
	prod1.setTarif(prod.getTarif());
	prod1.setVisuel(prod.getVisuel());
	prod1.setCategorie(prod.getCategorie());
	assertTrue(daos.getProduitDAO().delete(prod));
	//on reccreer le produit supprimer pour ne pas changer la bdd
	daos.getProduitDAO().create(prod1);
	}
	
	@Test
	public void testGetByidProduit() {
		assertNotNull(daos.getProduitDAO().getById(2));
	}
	
	@Test
	public void testGetByNomProduit() {
		assertNotNull(daos.getProduitDAO().getByNom("Sonic te kiffe"));
	}
	@Test
	public void testgetAllProduit() {
		assertNotNull(daos.getProduitDAO().getAll());
	}
	
	@Test
	public void testGetByidcategProduit() {
		assertNotNull(daos.getProduitDAO(). getByIdCateg(1));
	}
	

}
