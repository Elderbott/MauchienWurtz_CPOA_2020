package test.MySQL;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Client;
import metier.Commande;

class TestCommandeMySQL {

	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	@Test
	public void testCommandeGetById() {
		assertNotNull(daos.getCommandeDAO().getById(3));
	}
	@Test
	public void testCommandeCreate() {
		Commande cmd = daos.getCommandeDAO().getById(1);
		Client cl = new Client();
		daos.getCommandeDAO().delete(cmd);
		int size = daos.getClientDAO().getAll().size();
		cmd.setClient(cl);
		daos.getCommandeDAO().create(cmd);
		assertEquals(size + 1, daos.getClientDAO().getAll().size());
		
	}
	@Test
	public void testCommandeDelete() {
		Commande cmd = daos.getCommandeDAO().getById(1);
		Commande cmd1 = new Commande();
		cmd1.setClient(cmd.getClient());
		cmd1.setDate(cmd.getDate());
		cmd1.setNum(cmd.getNum());
		cmd1.setProduits(cmd.getProduits());
	    assertTrue(daos.getCommandeDAO().delete(cmd));
		daos.getCommandeDAO().create(cmd1);
	}
	@Test
	public void testCommandeUpdate() {
		Commande cmd = new Commande();
		Client cl = new Client(18,"Leo","Paul");
		cl.setNom("nom2");
		cmd.setClient(cl);
		int size = daos.getCategorieDAO().getAll().size();
		Commande cmd1 = daos.getCommandeDAO().getById(1);
		assertTrue(daos.getCommandeDAO().update(cmd));
		daos.getCommandeDAO().update(cmd1);
		assertEquals(size-1, daos.getCommandeDAO().getAll().size());
	}
	@Test
	public void testCommandegetall() {
	daos.getCommandeDAO().getAll();	
	}
	
	@Test
	public void testCommandegetByclient() {
		Client cl = new Client(6,"nom","prenom");
		daos.getCommandeDAO().getByClient(cl);
	}
}
