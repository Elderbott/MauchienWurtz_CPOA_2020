package bdd.table;
import bdd.connexion.Connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Client {

	private int id;
	private String nom;
	private String prenom;
	private List<Commande> commandes; //Un client réalise 0 ou plusieurs commandes
	
	public String toString() {
		return "ID: " + id + ", Nom: " + nom + ", Prenom: " + prenom;
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
	
	public String getPrenom() {
		return prenom;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public Statement Connexion() throws SQLException {
		Connexion co = new Connexion();
		Connection laConnexion =  co.creeConnexion();
		Statement requete = laConnexion.createStatement();
		return requete ;
	}
	
	Scanner sc1 = new Scanner(System.in);
	
	public void AjoutClient() {
		System.out.println("Veuillez saisir le nom du client :");
		String nom = sc1.nextLine();
		
		System.out.println("Veuillez saisir le prenom du client :");
		String prenom = sc1.nextLine();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("INSERT INTO Client (nom, prenom, identifiant, mot_de_passe, adr_numero, adr_voie, adr_code_postal, adr_ville, adr_pays) VALUES ('"+nom+"','" +prenom+"',' ',' ',' ',' ',' ',' ',' ')");
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void ModifClient() {
		System.out.println("Veuillez selectionner l'id du client a modifier : ");
		int id = sc1.nextInt();
		String x = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau nom du client :");
		String nom = sc1.nextLine();
		
		System.out.println("Veuillez saisir le nouveau prenom du client :");
		String prenom = sc1.nextLine();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("UPDATE Client SET nom = '"+nom+"', prenom ='"+prenom+"'WHERE id_client ="+id);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void SupprClient() {
		System.out.println("Veuillez selectionner l'id du client a supprimer : ");
		int id = sc1.nextInt();
		
		try {
			Statement requete = Connexion();
			requete.executeUpdate("DELETE FROM Client WHERE id_client ="+id);
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
	
	public void TableClient() {
		
		try {
			Statement requete = Connexion();
			ResultSet res = requete.executeQuery("SELECT * FROM Client");
			ArrayList<Client> Client1 = new ArrayList<>();
			while (res.next())
			{
				Client Client2 = new Client();
		        Client2.setId(res.getInt("id_client"));
		        Client2.setNom(res.getString("nom"));
		        Client2.setPrenom(res.getString("prenom"));
		        Client1.add(Client2);
			}
			for (Client obj : Client1) {
		         System.out.println(obj);
		      }
			
			 } catch (SQLException sqle) {
			System.out.println("Pb select" + sqle.getMessage());
			 } 
	}
}
