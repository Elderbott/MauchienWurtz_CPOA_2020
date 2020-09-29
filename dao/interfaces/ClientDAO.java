package dao.interfaces;

import metier.Client;

public interface ClientDAO<T> extends DAO<T> {
	public abstract Client getByNom(String nom);
	public abstract Client getByPrenom(String prenom);

}
