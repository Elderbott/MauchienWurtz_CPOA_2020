package DAO;

import java.util.ArrayList;
import java.util.List;

import bdd.table.Categorie;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Categorie objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Categorie objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Categorie objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Categorie> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getByTitre(String Titre) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
