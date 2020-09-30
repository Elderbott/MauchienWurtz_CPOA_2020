package dao.liste_memoire;

import java.util.ArrayList;
import java.util.List;

import dao.interfaces.ClientDAO;
import metier.Client;

public class ListeMemoireClientDAO implements ClientDAO<Client> {

	private static ListeMemoireClientDAO instance;
	private List<Client> donnees;
	
	public static ListeMemoireClientDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}
		return instance;
	}
	
	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();
		Client cl1 = new Client();
		cl1.setId(1);
		cl1.setNom("LAROCHE");
		cl1.setPrenom("Pierre");
		this.donnees.add(cl1);
	}
	
	@Override
	public Client getById(int id) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Client clients : this.donnees) {
				if (clients.getId() == id) {
					return clients;
				}
			}
		}
		return null;
	}

	@Override
	public boolean create(Client objet) {
		objet.setId(2);
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Client objet) {
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un client inexistant");
		} 
		else {			
			this.donnees.set(idx, objet);
		}		
		return true;
	}

	@Override
	public boolean delete(Client objet) {
		Client supprime;
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un client inexistant");
		} 
		else {
			supprime = this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	@Override
	public ArrayList<Client> getAll() {
		return (ArrayList<Client>) this.donnees;
	}

	@Override
	public ArrayList<Client> getByNom(String nom) {
		ArrayList<Client> ClList = new ArrayList<>();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Client clients : this.donnees) {
				if (clients.getNom() == nom) {
					ClList.add(clients);
				}
			}
			return ClList;
		}
		return null;
	}

	@Override
	public ArrayList<Client> getByPrenom(String prenom) {
		ArrayList<Client> ClList = new ArrayList<>();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Client clients : this.donnees) {
				if (clients.getPrenom() == prenom) {
					ClList.add(clients);
				}
			}
			return ClList;
		}
		return null;
	}

}
