package dao.interfaces;

import metier.Categorie;

public interface CategorieDAO<T> extends DAO<T> {
	public abstract Categorie getByTitre(String Titre);
}
