package test.ListeMemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Client;

class TestClientListeMemoire {

	DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	@Test
	public void testGetById() {
		assertNotNull(daoLM.getClientDAO().getById(1));
	}

	public void testclientCreate() {
		int size = daoLM.getClientDAO().getAll().size();
		Client cl = new Client();
		assertTrue(daoLM.getClientDAO().create(cl));
		//on verifie qu'il existe un nouveau produit
		assertEquals(size + 1, daoLM.getClientDAO().getAll().size());
	}
	
	@Test
	public void testclientdelete() {
		Client  cl = daoLM.getClientDAO().getById(1);
		int size = daoLM.getClientDAO().getAll().size();
        daoLM.getClientDAO().delete(cl);
        assertEquals(size-1, daoLM.getClientDAO().getAll().size());
	}
	
	@Test
	public void testClientUpdate() {
		Client cl = new Client();
		cl.setNom("nom2");
		cl.setPrenom("prenom2");
		daoLM.getClientDAO().create(cl);
		Client cl1 = daoLM.getClientDAO().getById(cl.getId());
		assertEquals(cl, cl1);
		cl1.setNom("monsieur");
		daoLM.getClientDAO().update(cl1);
		Client cl2 = daoLM.getClientDAO().getById(cl1.getId());
        assertNotNull(cl2);
	}

	@Test
	public void testClientgetall() {
		assertNotNull(daoLM.getClientDAO().getAll());
	}
	
	@Test
	public void testClientgetbynom() {
		assertNotNull(daoLM.getClientDAO().getByNom("LAROCHE"));
	}
}
