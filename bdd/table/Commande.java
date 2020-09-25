package bdd.table;
import java.util.Date;
import java.util.HashMap;

public class Commande {

	private int num;
	private Date date;
	private Client client; //Une commande est réalisée par un client
	
	// Ligne de commande : liste des produits
	// Une commande contient '1 ou n' produits
	private HashMap<Produit, Integer> produits;
	
	// Méthode qui permet d'ajouter un produit 
	public void addProduit(Produit produit, Integer quantite) {
		if (produits == null) {
			produits = new HashMap<>();	
		}
		produits.put(produit, quantite);
	}
}


