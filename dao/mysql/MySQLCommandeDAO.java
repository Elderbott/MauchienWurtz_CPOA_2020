package dao.mysql;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.connexion.Connexion;
import dao.interfaces.CommandeDAO;
import metier.Commande;

public class MySQLCommandeDAO implements CommandeDAO<Commande>{

	private static MySQLCommandeDAO instance;
	private MySQLCommandeDAO() {}
	
	public static MySQLCommandeDAO getInstance() {
	if (instance==null) {
	instance = new MySQLCommandeDAO();
	}
	return instance;
	}

	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}

	@Override
	public Commande getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Commande objet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Commande> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
