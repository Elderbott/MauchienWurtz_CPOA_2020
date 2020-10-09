package test.ListeMemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Categorie;

class TestCategorieListeMemoire {
	DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	
	@Test
	public void testCreateCategorie () {
		//nombre de produit avant le nouveau
		int size = daoLM.getCategorieDAO().getAll().size();
		Categorie categ = new Categorie();
		assertTrue(daoLM.getCategorieDAO().create(categ));
		//on verifie qu'il existe un nouveau produit
		assertEquals(size + 1, daoLM.getCategorieDAO().getAll().size());
	}

		@Test
		public void testupdateCategorie() {
			Categorie categ = new Categorie();
	        categ.setTitre("Untitre");
	        categ.setVisuel("visuel");
	        daoLM.getCategorieDAO().create(categ);
	        Categorie categ1 = daoLM.getCategorieDAO().getById(categ.getId());
	        assertEquals(categ, categ1);
	        categ1.setTitre("Un");
	        daoLM.getCategorieDAO().update(categ);
	        Categorie categ2 = daoLM.getCategorieDAO().getById(categ1.getId());
	        assertNotNull(categ2);
		}
		
		@Test
		public void testdeleteCategorie() {
		//lecture du produit
			Categorie categ = daoLM.getCategorieDAO().getById(1);
			int size = daoLM.getCategorieDAO().getAll().size();
	        daoLM.getCategorieDAO().delete(categ);
	        assertEquals(size-1, daoLM.getCategorieDAO().getAll().size());
		}
		
		@Test
		public void testGetByidCategorie() {
			assertNotNull(daoLM.getCategorieDAO().getById(1));
		}
		
		@Test
		public void testGetByTitreCategorie() {
			assertNotNull(daoLM.getCategorieDAO().getByTitre("Pulls"));
		}
		@Test
		public void testgetAllCategorie() {
			assertNotNull(daoLM.getCategorieDAO().getAll());
		}
		
		

	}
