package dao.liste_memoire;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.interfaces.CommandeDAO;

import metier.Client;
import metier.Commande;
import metier.Produit;

public class ListeMemoireCommandeDAO implements CommandeDAO<Commande>{
	
	private static ListeMemoireCommandeDAO instance;
	private List<Commande> donnees;
	
	public static ListeMemoireCommandeDAO getInstance() {
		if (instance == null) {
			instance = new ListeMemoireCommandeDAO();
		}
		return instance;
	}
	
	private ListeMemoireCommandeDAO() {
		Client cl1 = new Client(1,"","");
		this.donnees.add(new Commande(1, new Date(), cl1));
		this.donnees.add(new Commande(2, new Date(), cl1));

	}

	@Override
	public Commande getById(int id) {
		if (this.donnees != null && !this.donnees.isEmpty()) {
            for (Commande commande : this.donnees) {
                if (commande.getNum() == id) {
                    return commande;
                }
            }
        }
        return null ;
        
	}

	@Override
	public boolean create(Commande objet) {
		objet.setNum(2);
		while (this.donnees.contains(objet)) {

			objet.setNum(objet.getNum() + 1);
		}
		boolean ok = this.donnees.add(objet);
		
		return ok;
	}

	@Override
	public boolean update(Commande objet) {
		int id = objet.getNum();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Commande commandes : this.donnees) {
				if (commandes.getNum() == id) {
					this.donnees.set(id, objet);
				}
			}
		}
		return true;
	}

	@Override
	public boolean delete(Commande objet) {
		Commande supprime = null;
		int id = objet.getNum();
		if (this.donnees != null && !this.donnees.isEmpty()) {
			for (Commande commandes : this.donnees) {
				if (commandes.getNum() == id) {
					supprime = this.donnees.remove(id);
				}
			}
		}
		return objet.equals(supprime);
	}

	@Override
	public ArrayList<Commande> getAll() {
		return (ArrayList<Commande>) this.donnees;
	}

	@Override
	public Map<Produit, Integer> getLigneCommande(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Commande> getByClient(Client objet) {
		ArrayList<Commande> commandes = new ArrayList<>();
		if (this.donnees != null && !this.donnees.isEmpty()) {
            for (Commande commande : this.donnees) {
                if (commande.getClient().getId() == objet.getId()) {
                    commandes.add(commande);
                }
            }
            return commandes;
        }
        return null ;
	}
}
