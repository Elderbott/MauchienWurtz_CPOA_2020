package metier;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;

public class Commande {

	private int num;
	private Date date;
	private Client client; 
	private HashMap<Produit, Integer> produits;
	
	public Commande() {
		super();
	}
	
	public Double getMontantTotal() {
		Double resultat = 0d;
		for (Entry<Produit, Integer> entry : produits.entrySet()) {
			Produit produit = entry.getKey();
			Integer quantite = entry.getValue();
			resultat += (produit.getTarif() * quantite);
		}
		return resultat;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public HashMap<Produit, Integer> getProduits() {
		return produits;
	}

	public void setProduits(HashMap<Produit, Integer> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Commande [num=" + num + ", date=" + date + ", client=" + client + ", montant total="+getMontantTotal()+"]";
	}
	
	
}


