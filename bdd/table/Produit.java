package bdd.table;
import bdd.connexion.Connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Produit {

	private int id;
	private String nom;
	private String description;
	private double tarif;
	private String visuel;
	private Categorie categorie;
	
	public String toString() {
		return "ID Produit: " + id + ", Nom: " + nom + ", Description: " + description + ", Tarif: "
				+ tarif + ", Visuel: " + visuel + ", ID Categorie: " + categorie;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTarif() {
		return tarif;
	}

	public void setTarif(double tarif) {
		this.tarif = tarif;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}
	
	Scanner sc1 = new Scanner(System.in);
	
	public void AjoutProd() {
		System.out.println("Veuillez saisir le titre du produit :");
		String nomprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir la description du produit :");
		String descprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir le tarif du produit :");
		double tarifprod = sc1.nextDouble();
		String x = sc1.nextLine();
		
		System.out.println("Veuillez saisir le visuel du produit :");
		String visuprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir l'id de la categorie du produit :");
		int idcatprod = sc1.nextInt();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Produit (nom, description, tarif, visuel,id_categorie) VALUES ('"+nomprod+"','" +descprod+"','"+tarifprod+"','"+visuprod+"','"+idcatprod+"')");
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void ModifProd() {

		System.out.println("Veuillez selectionner l'id du produit a modifier : ");
		int idprod = sc1.nextInt();
		String x = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau titre du produit :");
		String nomprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir la nouvelle description du produit :");
		String descprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau tarif du produit :");
		double tarifprod = sc1.nextDouble();
		String y = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau visuel du produit :");
		String visuprod = sc1.nextLine();
		
		System.out.println("Veuillez saisir la nouvelle id de la categorie du produit :");
		int idcatprod = sc1.nextInt();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Produit SET nom = '"+nomprod+"', description ='"+descprod+"', tarif = '"+tarifprod+"', visuel ='"+visuprod+"', id_categorie = '"+idcatprod+"'WHERE id_produit ="+idprod);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void SupprProd() {
		System.out.println("Veuillez selectionner l'id du produit a supprimer : ");
		int idprod = sc1.nextInt();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Produit WHERE id_produit ="+idprod);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void TableProd() {
		
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Produit");
			ArrayList<Produit> Prod1 = new ArrayList<>();
			while (res.next())
			{
				Produit Prod2 = new Produit();
		        Prod2.setId(res.getInt("id_produit"));
		        Prod2.setNom(res.getString("nom"));
		        Prod2.setDescription(res.getString("description"));
		        Prod2.setTarif(res.getDouble("tarif"));
		        Prod2.setVisuel(res.getString("visuel"));
		        Prod2.setCategorie(res.("id_categorie"));
		        Prod1.add(Prod2);
			}
			for (Produit obj : Prod1) {
		         System.out.println(obj);
		      }
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
}
