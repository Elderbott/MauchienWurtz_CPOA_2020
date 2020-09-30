package metier;

public class Produit {

	private int id;
	private String nom;
	private String description;
	private double tarif;
	private String visuel;
	private Categorie categorie;
	
	
	
	public Produit(int id, String nom, String description, double tarif, String visuel, Categorie categorie) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.categorie = categorie;
	}

	public Produit() {
		super();
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

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", description=" + description + ", tarif=" + tarif + ", visuel="
				+ visuel + ", categorie=" + categorie.getTitre() + "]";
	}	
}
