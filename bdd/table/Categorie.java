package bdd.table;

import java.util.List;

public class Categorie {
	
	private int id_categ;
	private String titre_categ;
	private String visuel_categ;
	private List<Produit> produits;

	public Categorie() {
		super();
	}

	public String toString() {
		return "ID: " + id_categ + ", Titre: " + titre_categ + ", Visuel:" + visuel_categ;
	}

	public int getId_categ() {
		return id_categ;
	}

	public void setId_categ(int id_categ) {
		this.id_categ = id_categ;
	}

	public String getTitre_categ() {
		return titre_categ;
	}

	public void setTitre_categ(String titre_categ) {
		this.titre_categ = titre_categ;
	}

	public String getVisuel_categ() {
		return visuel_categ;
	}

	public void setVisuel_categ(String visuel_categ) {
		this.visuel_categ = visuel_categ;
	}
}
