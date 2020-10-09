package test.MySQL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Client;

class TestClientMySQL {
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	@Test
	public void testClientGetById() {
		assertNotNull(daos.getClientDAO().getById(3));
	}
    @Test
	public void testclientCreate() {
		Client cl = daos.getClientDAO().getById(6);
		daos.getClientDAO().delete(cl);
		int size = daos.getClientDAO().getAll().size();
		assertTrue(daos.getClientDAO().create(cl));
		assertEquals(size + 1, daos.getClientDAO().getAll().size());
	}
	
	@Test
	public void testclientdelete() {
		Client cl = daos.getClientDAO().getById(6);
		Client cl2 = new Client();
		cl2.setId(cl.getId());
		cl2.setNom(cl.getNom());
		cl2.setPrenom(cl.getPrenom());
		assertTrue(daos.getClientDAO().delete(cl));
		daos.getClientDAO().create(cl2);
	}
	
	@Test
	public void testClientUpdate() {
		Client cl = new Client();
		cl.setId(6);
		cl.setNom("nom2");
		cl.setPrenom("prenom2");
		Client cl1 = daos.getClientDAO().getById(6);
		assertTrue(daos.getClientDAO().update(cl));
		assertNotEquals(cl1, daos.getClientDAO().getById(6));
		daos.getClientDAO().update(cl1);
	}

	@Test
	public void testClientgetall() {
		assertNotNull(daos.getClientDAO().getAll());
	}
	
	@Test
	public void testClientgetbynom() {
		assertNotNull(daos.getClientDAO().getByNom("nom"));
	}
}
