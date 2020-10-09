package test.ListeMemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Categorie;
import metier.Produit;

class TestProduitListeMemoire {

DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);

@Test
public void testCreateProduit () {
	//nombre de produit avant le nouveau
	int size = daoLM.getProduitDAO().getAll().size();
	Produit prod = new Produit();
	assertTrue(daoLM.getProduitDAO().create(prod));
	//on verifie qu'il existe un nouveau produit
	assertEquals(size + 1, daoLM.getProduitDAO().getAll().size());
}

	@Test
	public void testupdateProduit() {
		Produit prod = new Produit();
		Categorie categ = new Categorie();
		prod.setNom("produit");
		prod.setDescription("description");
		prod.setVisuel("visuel");
		prod.setCategorie(categ);
		daoLM.getProduitDAO().create(prod);
		Produit prod1 = daoLM.getProduitDAO().getById(prod.getId());
		assertEquals(prod, prod1);
		prod1.setNom("nom2");
		Produit prod2 = daoLM.getProduitDAO().getById(prod1.getId());
		assertNotNull(prod2);	
	}
	
	@Test
	public void testdeleteProduit() {
		Produit  prod = daoLM.getProduitDAO().getById(3);
		int size = daoLM.getProduitDAO().getAll().size();
        daoLM.getProduitDAO().delete(prod);
        assertEquals(size-1, daoLM.getProduitDAO().getAll().size());
	}
	
	@Test
	public void testGetByidProduit() {
		assertNotNull(daoLM.getProduitDAO().getById(2));
	}
	
	@Test
	public void testGetByNomProduit() {
		assertNotNull(daoLM.getProduitDAO().getByNom("Sonic te kiffe"));
	}
	@Test
	public void testgetAllProduit() {
		assertNotNull(daoLM.getProduitDAO().getAll());
	}
	
	@Test
	public void testGetByidcategProduit() {
		assertNotNull(daoLM.getProduitDAO(). getByIdCateg(1));
	}

}
