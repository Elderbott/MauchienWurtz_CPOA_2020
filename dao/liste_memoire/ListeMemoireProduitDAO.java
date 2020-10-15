package dao.liste_memoire;

import java.util.ArrayList;
import java.util.List;

import dao.factory.DAOFactory;
import dao.factory.Persistance;
import dao.interfaces.ProduitDAO;
import metier.Categorie;
import metier.Produit;

public class ListeMemoireProduitDAO implements ProduitDAO<Produit> {

	private static ListeMemoireProduitDAO instance;
	private List<Produit> donnees;
	
	public static ListeMemoireProduitDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireProduitDAO();
		}
		return instance;
	}
	
	private ListeMemoireProduitDAO() {

		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
		this.donnees = new ArrayList<Produit>();
		Categorie obj1 = new Categorie();
		obj1.setId(1);
		Categorie cat1 = daos.getCategorieDAO().getById(obj1.getId());
		obj1.setTitre(cat1.getTitre());
		this.donnees.add(new Produit(1, "Sonic te kiffe", "Inspiré par la saga Séga (c'est plus fort que toi !), un pull 100% gamer qui te permettra de faire baver d'envie tes petits camarades de jeu.", 41.5, "pull1.png", obj1));
		Categorie obj2 = new Categorie();
		obj2.setId(2);
		Categorie cat2 = daos.getCategorieDAO().getById(obj2.getId());
		obj2.setTitre(cat2.getTitre());
		this.donnees.add(new Produit(2, "La chaleur des rennes", "Classique mais efficace, un bonnet dont l'élégance n'est pas à souligner, il vous grattera comme il faut !", 15, "bonnet0.png", obj2));
		Categorie obj3 = new Categorie();
		obj3.setId(2);
		Categorie cat3 = daos.getCategorieDAO().getById(obj3.getId());
		obj3.setTitre(cat3.getTitre());
		this.donnees.add(new Produit(3, "Dall", "Joyeux Noël avec nos petits lutins dansants !", 35, "bonnet1.png", obj3));
	}
	
	@Override
	public Produit getById(int id) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Produit produits : this.donnees) {
				if (produits.getId() == id) {
					return produits;
				}
			}
		}
		return null;
	}

	@Override
	public boolean create(Produit objet) {
		objet.setId(4);
		while (this.donnees.contains(objet)) {

			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Produit objet) {
		int id = objet.getId();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Produit produits : this.donnees) {
				if (produits.getId() == id) {
					this.donnees.set(id, objet);
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean delete(Produit objet) {
		Produit supprime = null;
		int id = objet.getId();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Produit produits : this.donnees) {
				if (produits.getId() == id) {
					supprime = this.donnees.remove(id);
				}
			}
		}
		return objet.equals(supprime);
	}

	@Override
	public ArrayList<Produit> getAll() {
		return (ArrayList<Produit>) this.donnees;
	}

	@Override
	public Produit getByNom(String nom) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Produit produits : this.donnees) {
				if (produits.getNom() == nom) {
					return produits;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Produit> getByIdCateg(int id) {
		ArrayList<Produit> Prod1 = new ArrayList<>();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Produit produits : this.donnees) {
				if (produits.getCategorie().getId() == id) {
					Prod1.add(produits);
				}
			}
			return Prod1;
		}
		return null;
	}

}
