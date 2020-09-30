package dao.liste_memoire;

import java.util.ArrayList;
import java.util.List;

import dao.interfaces.CommandeDAO;
import metier.Commande;

public class ListeMemoireCommandeDAO implements CommandeDAO<Commande>{
	
	private static ListeMemoireCommandeDAO instance;
	private List<Commande> donnees;
	
	public static ListeMemoireCommandeDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireCommandeDAO();
		}
		return instance;
	}
	
	private ListeMemoireCommandeDAO() {


	}

	@Override
	public Commande getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Commande> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
