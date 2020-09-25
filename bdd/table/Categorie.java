package bdd.table;
import bdd.connexion.Connexion;
import java.sql.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categorie {
	
	private int id_categ;
	private String titre_categ;
	private String visuel_categ;
	private List<Produit> produits;

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

	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}
	
	Scanner sc1 = new Scanner(System.in);
	
	public void AjoutCateg() {
		System.out.println("Veuillez saisir le titre de la categorie :");
		String titrecateg = sc1.nextLine();
		
		System.out.println("Veuillez saisir le visuel de la categorie :");
		String visuelcateg = sc1.nextLine();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Categorie (titre, visuel) VALUES ('"+titrecateg+"','" +visuelcateg+"')");
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void ModifCateg() {
		System.out.println("Veuillez selectionner l'id de la categorie a modifier : ");
		int idcateg = sc1.nextInt();
		String x = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau titre de la categorie :");
		String titrecateg = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau visuel de la categorie :");
		String visuelcateg = sc1.nextLine();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Categorie SET titre = '"+titrecateg+"', visuel ='"+visuelcateg+"'WHERE id_categorie ="+idcateg);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	public void SupprCateg() {
		System.out.println("Veuillez selectionner l'id de la categorie a supprimer : ");
		int idcateg = sc1.nextInt();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Categorie WHERE id_categorie ="+idcateg);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	public void TableCateg() {
		
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Categorie");
			ArrayList<Categorie> Categ = new ArrayList<>();
			while (res.next())
			{
				Categorie Cat = new Categorie();
		        Cat.setId_categ(res.getInt("id_categorie"));
		        Cat.setTitre_categ(res.getString("titre"));
		        Cat.setVisuel_categ(res.getString("visuel"));
		        Categ.add(Cat);
			}
			for (Categorie obj : Categ) {
		         System.out.println(obj);
		      }
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
}
