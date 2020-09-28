package bdd.table;

import java.util.List;

public class Categorie {
	
	private int id;
	private String titre;
	private String visuel;
	private List<Produit> produits;


	public Categorie(int id_categ, String titre_categ, String visuel_categ) {
		super();
		this.id = id_categ;
		this.titre = titre_categ;
		this.visuel = visuel_categ;
	}

	public Categorie() {
		super();
	}



	public String toString() {
		return "ID: " + id + ", Titre: " + titre + ", Visuel:" + visuel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id_categ) {
		this.id = id_categ;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre_categ) {
		this.titre = titre_categ;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel_categ) {
		this.visuel = visuel_categ;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
}
