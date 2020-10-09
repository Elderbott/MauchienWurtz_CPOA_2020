package test.MySQL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Categorie;

class TestCategorieSQL {
	
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);

	@Test
	public void testCreateCategorie() {
		
	     Categorie categ = daos.getCategorieDAO().getById(1);
	     daos.getCategorieDAO().delete(categ);
		int size = daos.getCategorieDAO().getAll().size();
		assertTrue(daos.getCategorieDAO().create(categ));
		//on verifie qu'il existe un nouveau produit
		assertEquals(size + 1, daos.getProduitDAO().getAll().size());
		
	}
	
	@Test
	public void testdeleteCategorie() {
	//lecture du produit
	Categorie categ = daos.getCategorieDAO().getById(12);
	Categorie categ1 = new Categorie();
	
	categ1.setId(categ.getId());
	categ1.setProduits(categ.getProduits());
	categ1.setTitre(categ.getTitre());
	categ1.setVisuel(categ.getVisuel());
	assertTrue(daos.getCategorieDAO().delete(categ));
	daos.getCategorieDAO().create(categ1);
	}
	@Test
	public void testupdateCategorie() {
		Categorie categ = new Categorie();
		categ.setId(22);
		categ.setTitre("nouveau titre");
		categ.setVisuel("visuel");
		Categorie categ1 = daos.getCategorieDAO().getById(55);
		assertTrue(daos.getCategorieDAO().update(categ));
		assertNotEquals(categ1, daos.getProduitDAO().getById(categ.getId()));
		//on remet la categorie dorigine pour ne pas modifier la bdd
		daos.getCategorieDAO().update(categ1);	
	}
	@Test
	public void testGetByidCategorie() {
		assertNotNull(daos.getCategorieDAO().getById(2));
	}
	
	@Test
	public void testGetByNomCategorie() {
		assertNotNull(daos.getCategorieDAO().getByTitre("Pulls"));
	}
	@Test
	public void testgetAllCategorie() {
		assertNotNull(daos.getCategorieDAO().getAll());
	}
	
	
	
}
