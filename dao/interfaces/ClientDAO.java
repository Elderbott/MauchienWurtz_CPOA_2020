package dao.interfaces;

import java.util.ArrayList;

import metier.Client;

public interface ClientDAO<T> extends DAO<T> {
	public abstract ArrayList<Client> getByNom(String nom);
	public abstract ArrayList<Client> getByPrenom(String prenom);

}
