package test.ListeMemoire;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import metier.Client;
import metier.Commande;

class TestCommandeListeMemoire {

	DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.MYSQL);
	@Test
	public void testCommandeGetById() {
		assertNotNull(daoLM.getCommandeDAO().getById(1));
	}
	@Test
	public void testCommandeCreate() {
				//nombre de produit avant le nouveau
				int size = daoLM.getCommandeDAO().getAll().size();
				Commande cmd = new Commande();
				Client cl = new Client();
				cmd.setClient(cl);
				assertTrue(daoLM.getCommandeDAO().create(cmd));
				//on verifie qu'il existe un nouveau produit
				assertEquals(size + 1, daoLM.getCommandeDAO().getAll().size());
		
	}
	@Test
	public void testCommandeDelete() {
		Commande cmd = daoLM.getCommandeDAO().getById(1);
		int size = daoLM.getCommandeDAO().getAll().size();
        daoLM.getCommandeDAO().delete(cmd);
        assertEquals(size-1, daoLM.getCommandeDAO().getAll().size());
	}
	@Test
	public void testCommandeUpdate() {
		Commande cmd = new Commande();
		Client cl = new Client();
		cl.setNom("nom2");
		cmd.setClient(cl);
		Commande cmd1 = daoLM.getCommandeDAO().getById(cmd.getNum());
		assertEquals(cmd,cmd1);
		cmd1.setClient(cmd.getClient());
		Commande cmd2 = daoLM.getCommandeDAO().getById(cmd1.getNum());
		assertNotNull(cmd2);
	}
	@Test
	public void testCommandegetall() {
	daoLM.getCommandeDAO().getAll();	
	}
	
	@Test
	public void testCommandegetByclient() {
		Client cl = new Client(1,"LAROCHE","pierre");
		daoLM.getCommandeDAO().getByClient(cl);
	}

}
