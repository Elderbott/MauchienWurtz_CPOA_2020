package dao.liste_memoire;

import java.util.ArrayList;
import java.util.List;

import dao.interfaces.CategorieDAO;
import metier.Categorie;
import metier.Produit;

public class ListeMemoireCategorieDAO implements CategorieDAO<Categorie> {

	private static ListeMemoireCategorieDAO instance;
	private List<Categorie> donnees;
	
	public static ListeMemoireCategorieDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireCategorieDAO();
		}
		return instance;
	}
	
	private ListeMemoireCategorieDAO() {

		this.donnees = new ArrayList<Categorie>();

		this.donnees.add(new Categorie(1, "Pulls", "pulls.png"));
		this.donnees.add(new Categorie(2, "Bonnets", "bonnets.png"));
	}
	
	@Override
	public Categorie getById(int id) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Categorie categories : this.donnees) {
				if (categories.getId() == id) {
					return categories;
				}
			}
		}
		return null;
	}

	@Override
	public boolean create(Categorie objet) {
		objet.setId(3);
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Categorie objet) {
		int id = objet.getId();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Categorie categories : this.donnees) {
				if (categories.getId() == id) {
					this.donnees.set(id, objet);
				}
			}
		}
		return true;
	}

	@Override
	public boolean delete(Categorie objet) {
		Categorie supprime = null;
		int id = objet.getId();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Categorie categories : this.donnees) {
				if (categories.getId() == id) {
					supprime = this.donnees.remove(id);
				}
			}
		}
		return objet.equals(supprime);
	}

	@Override
	public ArrayList<Categorie> getAll() {
		return (ArrayList<Categorie>) this.donnees;
	}

	@Override
	public Categorie getByTitre(String Titre) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Categorie categories : this.donnees) {
				if (categories.getTitre() == Titre) {
					return categories;
				}
			}
		}
		return null;
	}
	
}
