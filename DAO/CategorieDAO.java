package DAO;

import bdd.table.Categorie;

public interface CategorieDAO<T> extends DAO<T> {
	public abstract Categorie getByTitre(String Titre);
}
