package menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Categorie;
import metier.Client;
import metier.Commande;
import metier.Produit;
import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class MenuSQL {

	Scanner sc1 = new Scanner( System.in );
	Scanner sc2 = new Scanner( System.in );

	private int Choix,retour, id, num;
	private boolean modif=true;
	private String titre,nom,prenom,description,visuel;
	private double tarif;
	DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	
	public int choixCateg() {
		 System.out.println("Que voulez vous faire ajouter(1), modifier(2), supprimer(3), tous afficher(4), afficher par id(5), afficher par titre(6), retour(7)?");
		 int choixAction=sc1.nextInt();
		 if(choixAction<1 || choixAction>7)
			 System.out.println("Valeur mal saisie!!!!");
			return  choixAction;	
	}
	
	public int choixClient() {
		 System.out.println("Que voulez vous faire ajouter(1), modifier(2), supprimer(3), tous afficher(4), afficher par id(5), afficher par nom (6) ou prenom(7), , retour(8)?");
		 int choixAction=sc1.nextInt();
		 if(choixAction<1 || choixAction>8)
			 System.out.println("Valeur mal saisie!!!!");
			return  choixAction;	
	}
	
	public int choixProduit() {
		 System.out.println("Que voulez vous faire ajouter(1), modifier(2), supprimer(3), tous afficher(4), afficher par id(5) ou id de cateorie(6), afficher par nom (7), retour(8)?");
		 int choixAction=sc1.nextInt();
		 if(choixAction<1 || choixAction>8)
			 System.out.println("Valeur mal saisie!!!!");
			return  choixAction;	
	}
	
	public int choixComm() {
		 System.out.println("Que voulez vous faire ajouter(1), modifier(2), supprimer(3), tous afficher(4), afficher par id(5), afficher par id client(6), retour(7)?");
		 int choixAction=sc1.nextInt();
		 if(choixAction<1 || choixAction>8)
			 System.out.println("Valeur mal saisie!!!!");
			return  choixAction;	
	}
	
	public void menu() {
		
		while(modif) {
		
		System.out.println("choisissez une table : categorie(1), client(2), produit(3), commande(4) ou quitter(5)");
		int choixTab=sc1.nextInt();
		
		if (choixTab <1 || choixTab>5)
			 System.out.println("Valeur mal saisie!!!!!");
		
		
		switch(choixTab)
		 {
		                  case 1:
		                	  			Choix = choixCateg();
		                	 
		                       			if(Choix == 1) {
		                       				Categorie cat = new Categorie();
		                       				System.out.println("Veuillez saisir un titre pour la nouvelle categorie:");
		                       				titre = sc2.nextLine();
		                       				System.out.println("Veuillez saisir un visuel pour la nouvelle categorie:");
		                       				String visuel = sc2.nextLine();
		                       				cat.setTitre(titre);
		                       				cat.setVisuel(visuel);
		                       				boolean bool1 = daos.getCategorieDAO().create(cat);	
		                       			}
		                       				 if(Choix == 2) {
		                       					System.out.println("Veuillez selectionner l'id de la categorie a modifier :");
		                       					id = sc1.nextInt();
		                       					System.out.println("Veuillez saisir le nouveau titre de la categorie :");
			                       				titre = sc2.nextLine();
			                       				System.out.println("Veuillez saisir un nouveau visuel pour la nouvelle categorie:");
			                       				String visuel = sc2.nextLine();
			                       				Categorie cat = new Categorie(id, titre, visuel);
		                       					boolean bool1 = daos.getCategorieDAO().update(cat);
		                       				}
		                       				 if(Choix == 3) {
		                       					System.out.println("Veuillez selectionner l'id de la categorie a supprimer :");
		                       					id = sc1.nextInt();
		                       					Categorie cat = new Categorie();
		                       					cat.setId(id);
		                       					boolean bool1 = daos.getCategorieDAO().delete(cat);
		                       				}
		                       				 if(Choix == 4) {
		                       					ArrayList<Categorie> cat = daos.getCategorieDAO().getAll();
		                       					for (Categorie obj : cat) {
		                       						System.out.println(obj);
		                       					}
		                       				}
		                       				 if(Choix == 5) {
		                       					System.out.println("Veuillez selectionner l'id de la categorie a afficher :");
		                       					id = sc1.nextInt();
		                       					Categorie cat1 = daos.getCategorieDAO().getById(id);
		                       					System.out.println(cat1);
		                       				}
		                       				else if(Choix == 6) {
		                       					System.out.println("Veuillez selectionner le titre de la categorie a afficher :");
		                       					titre = sc2.nextLine();
		                       					Categorie cat1 = daos.getCategorieDAO().getByTitre(titre);
		                       					System.out.println(cat1);
		                       				}
		                       				 if(Choix == 7)
		                       					menu();   
		                  break;
		                       
		                  case 2:
		                	  		  Choix = choixClient();
                 				      if(Choix==1) {
                 				    	System.out.println("Veuillez saisir le nom du nouveau client :");
		                	  			nom = sc2.nextLine();
		                	  			System.out.println("Veuillez saisir le prenom du nouveau client :");
		                	  			prenom = sc2.nextLine();
		                	  			Client cl = new Client();
		                	  			cl.setNom(nom);
		                				cl.setPrenom(prenom);
                 						boolean bool1 = daos.getClientDAO().create(cl);
                 				      }
                 				       if(Choix==2) {
                 				    	 System.out.println("Veuillez selectionner l'id du client a modifier :");
	                       					id = sc1.nextInt();
	                       					String x = sc1.nextLine();
	                       					System.out.println("Veuillez saisir le nouveau nom du la client :");
		                       				nom = sc2.nextLine();
		                       				System.out.println("Veuillez saisir le nouveau prenom du client :");
		                       				prenom = sc2.nextLine();
			                	  			Client cl = new Client(id,nom,prenom);
			                				boolean bool1 = daos.getClientDAO().update(cl);  
                 				      }
                 				    	  
                 				       if(Choix == 3) {
                 				    	 Client cl = new Client();
			                	  			System.out.println("Veuillez selectionner l'id du client a supprimer :");
	                       					id = sc1.nextInt();
			                				cl.setId(id);
			                				boolean bool1 = daos.getClientDAO().delete(cl);
                 				      }
                 				       if(Choix == 4) {
                 				    	  ArrayList<Client> cl = daos.getClientDAO().getAll();
                 							for (Client obj : cl) {
                 								System.out.println(obj);
                 							}  
                 				      }
                 				      if(Choix == 5) {
                 				    	 System.out.println("Veuillez selectionner l'id du client a afficher :");
	                       				  id = sc1.nextInt();
                 				    	 Client cat = daos.getClientDAO().getById(id);
                 						System.out.println(cat);
                 				      }
                 				      if(Choix == 6) {
                 				    	  System.out.println("Veuillez selectionner le nom du client a afficher :");
                 				    	  titre = sc2.nextLine();
                 				    	  ArrayList<Client> cat = daos.getClientDAO().getByNom(titre);
                 						  System.out.println(cat);
                 				      }
                 				      if(Choix == 7) {
                 				    	  System.out.println("Veuillez selectionner le prénom du client a afficher :");
                				    	  titre = sc2.nextLine();
                				    	  ArrayList<Client> cat = daos.getClientDAO().getByPrenom(titre);
                						  System.out.println(cat);
                 				      }
                 				      if(Choix == 8) 
                 				    	 menu();
                 				      
                 				      
                 				    	 
                 	      break;
                 	  
		                  case 3:
                	  		  		Choix = choixProduit();
                	  		  			Produit pr = new Produit();
                	  		  	    if(Choix == 1 ) {
                	  		  	    	System.out.println("Veuillez-saisir le nom du nouveau produit :");
                	  		  	    	nom = sc2.nextLine();
                	  		  	    	pr.setNom(nom);
                	  		  	    	System.out.println("Veuillez-saisir la description du nouveau produit :");
                	  		  	        description = sc2.nextLine();
                	  		  	        pr.setDescription(description);
                	  			        System.out.println("Veuillez-saisir le visuel du nouveau produit :");
                	  			        visuel = sc2.nextLine();
                	  			        pr.setVisuel(visuel);
                	  			        System.out.println("Veuillez-saisir le tarif du nouveau produit :");
                	  			        tarif = sc1.nextDouble();
                	  			        pr.setTarif(tarif);
                	  			        Categorie obj = new Categorie();
                	  			        System.out.println("Veuillez-saisir l'id de la categorie :");
                	  			        id = sc1.nextInt();
                	  			        obj.setId(id);
                	  			        pr.setCategorie(obj);
                	  				    boolean bool = daos.getProduitDAO().create(pr);	
                	  		  	    }
                	  		  	    	
                	  		  	    if(Choix == 2 ) {
                	  		  	    System.out.println("Veuillez selectionner l'id du produit a modifier :");
                   					id = sc1.nextInt();
                   					String x = sc1.nextLine();
                   					System.out.println("Veuillez-saisir le nom du nouveau produit :");
            	  		  	    	nom = sc2.nextLine();
            	  		  	    	pr.setNom(nom);
            	  		  	    	System.out.println("Veuillez-saisir la description du nouveau produit :");
            	  		  	        description = sc2.nextLine();
            	  		  	        pr.setDescription(description);
            	  			        System.out.println("Veuillez-saisir le visuel du nouveau produit :");
            	  			        visuel = sc2.nextLine();
            	  			        pr.setVisuel(visuel);
            	  			        System.out.println("Veuillez-saisir le tarif du nouveau produit :");
            	  			        tarif = sc1.nextDouble();
            	  			        pr.setTarif(tarif);
            	  			        Categorie obj = new Categorie();
            	  			        System.out.println("Veuillez-saisir l'id de la categorie :");
            	  			        titre = sc2.nextLine();
            	  			        obj.setTitre(titre);
            	  			        Produit pr1 = new Produit(id,nom,description,tarif,visuel,obj);
            	  			        pr1.setCategorie(obj);
            	  				    boolean bool = daos.getProduitDAO().update(pr1);	
                   					
                	  		  	    }
                	  		  	    	
                	  		  	    if(Choix ==3 ) {
                	  		  	    System.out.println("Veuillez selectionner l'id du produit a supprimer :");
                	  		  	    id = sc1.nextInt();
                	  		  	    pr.setId(id);
                	  		  	    boolean bool = daos.getProduitDAO().delete(pr);	
                	  		  	    }
                	  		  	    	
                	  		  	    if(Choix ==4 ) {
                	  		  	    ArrayList<Produit> prod1 = daos.getProduitDAO().getAll();
                	  				for (Produit obj : prod1) {
                	  					System.out.println(obj);
                	  				}
                	  		  	    }
                	  		  	    if(Choix==5) {
                	  		  	    System.out.println("Veuillez selectionner l'id du produit a afficher :");	
                	  		  	    id = sc1.nextInt();
                	  		  	    Produit prod1 = daos.getProduitDAO().getById(id);
                	  		  	    System.out.println(prod1);
                	  		  	    }
                	  		  	    if(Choix==6) {
                	  		  	    System.out.println("Veuillez selectionner l'id de la categorie du produit a afficher :");	
                	  		  	    id = sc1.nextInt();
                	  		  	    ArrayList<Produit> prod1 = daos.getProduitDAO().getByIdCateg(id);
                	  		  	    for (Produit obj : prod1) {
                	  		  	    	System.out.println(obj);
            	  				    }
                	  		  	    }
                	  		  	    
                	  		  	    if(Choix == 7) {
                	  		  	    System.out.println("Veuillez selectionner le nom du produit a afficher :");	
                	  		  	    nom = sc2.nextLine();
                	  		  	    Produit prod = daos.getProduitDAO().getByNom(nom);
                	  				System.out.println(prod);
                	  		  	    }
                	  		  	    
                	  		  	    
                	  		  	    if (Choix == 8) 
                	  		  	    	menu();
                	  	break;		  	
		                  case 4:
		                	  		Choix = choixComm();
		                	        Commande cmd = new Commande();
		                	        Client cl1 = new Client();
		                	  		if(Choix == 1) {
		                	  			System.out.println("Veuillez selectionner votre identifiant client :");
		                	  			id = sc1.nextInt();
		                	  			cl1.setId(id);
		                	  			cmd.setClient(cl1);
		                	  			boolean bool = daos.getCommandeDAO().create(cmd);
		                	  		}
		                	  		
		                	  		if(Choix == 2) {
		                	  			System.out.println("Veuillez selectionner l'identifiant du client qui souhaite modifier ca commande :");
		                	  			id = sc1.nextInt();
		                	  			cl1.setId(id);
		                	  			cmd.setClient(cl1);
		                	  			System.out.println("Veuillez selectionner l'identifiant de la commande a modifier :");
		                	  			num = sc1.nextInt();
		                	  			cmd.setNum(num);
		                	  			boolean bool = daos.getCommandeDAO().update(cmd);
		                	  		}
		                	  		
		                	  		if (Choix == 3) {
		                	  			System.out.println("Veuillez selectionner l'identifiant de la commande a supprimer :");
		                	  			num = sc1.nextInt();
		                	  			cmd.setNum(num);
		                	  			boolean bool = daos.getCommandeDAO().delete(cmd);
		                	  		}
		                	  		
		                	  		if(Choix == 4) {
		                	  			ArrayList<Commande> com = daos.getCommandeDAO().getAll();
		                	  			for (Commande obj : com) {
		                	  				System.out.println(obj);
		                	  			}
		                	  		}
		                	  		
		                	  		if(Choix == 5) {
		                	  			System.out.println("Veuillez selectionner l'id de la commande a afficher :");	
	                	  		  	    id = sc1.nextInt();
	                	  		  	    cmd = daos.getCommandeDAO().getById(id);
	                	  		  	    System.out.println(cmd);
		                	  		}
		                	  		
		                	  		if(Choix == 6) {
		                	  			System.out.println("Veuillez selectionner l'identifiant du client pour pouvoir afficher ces commandes :");
		                	  			id = sc1.nextInt();
		                	  			cl1.setId(id);
		                	  			List<Commande> cmd1 = daos.getCommandeDAO().getByClient(cl1);
		                	  			System.out.println(cmd1);	
		                	  		}
		                	  		if(Choix == 7) 
		                	  			menu();
		                	  
		                	  	break;
		                  case 5:
		                	  break;
		                	  
		 }		
	
    if(choixTab != 5) {
    	System.out.println("Voulez-vous refaire une modification ? si oui taper(1) sinon(0)");
    	retour = sc1.nextInt();
    	if (retour <0 || retour>1)
    		System.out.println("Valeur mal saisie!!!!!");
    	else if(retour == 1)
		modif=true;
    	else
		modif=false;
    }
    else
    	modif=false;
	}
}
}