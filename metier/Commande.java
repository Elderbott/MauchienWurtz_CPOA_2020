package metier;
import java.util.Date;
import java.util.Map;

public class Commande {

	private int num;
	private Date date;
	private Client client; 
	private Map<Produit, Integer> produits;
	
	public Commande() {
		super();
	}
	
	public Commande(int num, Date date, Client client) {
		super();
		this.num = num;
		this.date = date;
		this.client = client;
	}

	public Double getMontantTotal() {
		Double resultat = 0d;
		for (Map.Entry<Produit, Integer> entry : produits.entrySet()) {
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

	public Map<Produit, Integer> getProduits() {
		return produits;
	}

	public void setProduits(Map<Produit, Integer> produits) {
		this.produits = produits;
	}

	@Override
	public String toString() {
		return "Commande [num=" + num + ", date=" + date + ", client=" + client.getId() + ", montant total="+getMontantTotal()+"]";
	}
	
	
}


