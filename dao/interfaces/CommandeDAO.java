package dao.interfaces;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.Client;
import metier.Commande;
import metier.Produit;

public interface CommandeDAO<T> extends DAO<T> {
	public abstract Map<Produit, Integer> getLigneCommande(int id);
	public abstract List<Commande> getByClient(Client objet);
}
