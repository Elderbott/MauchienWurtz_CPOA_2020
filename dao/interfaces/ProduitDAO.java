package dao.interfaces;

import java.util.ArrayList;

import metier.Produit;

public interface ProduitDAO<T> extends DAO<T> {
	public abstract Produit getByNom(String nom);
	public abstract ArrayList<Produit> getByIdCateg(int id);
}
