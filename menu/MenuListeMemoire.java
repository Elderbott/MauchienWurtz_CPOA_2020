package menu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import metier.Categorie;
import metier.Client;
import metier.Commande;
import metier.Produit;
import dao.factory.DAOFactory;
import dao.factory.Persistance;

public class MenuListeMemoire {
	Scanner sc1 = new Scanner( System.in );
	Scanner sc2 = new Scanner( System.in );

	private int Choix,retour, id, num;
	private boolean modif=true;
	private String titre,nom,prenom,description,visuel;
	private double tarif;
	DAOFactory daoLM = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	
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
                     					boolean bool1 = daoLM.getCategorieDAO().create(cat);
			                	   }
			                	    if(Choix == 2) {
			                			System.out.println("Veuillez selectionner l'id de la categorie a modifier :");
                       					id = sc1.nextInt();
                       					System.out.println("Veuillez saisir le nouveau titre de la categorie :");
	                       				titre = sc2.nextLine();
	                       				System.out.println("Veuillez saisir un nouveau visuel pour la nouvelle categorie:");
	                       				String visuel = sc2.nextLine();
	                       				Categorie cat = new Categorie(id, titre, visuel);
                       					boolean bool1 = daoLM.getCategorieDAO().update(cat);
			                	   }
			                	    if(Choix == 3) {
			                		   System.out.println("Veuillez selectionner l'id de la categorie a supprimer :");
                      					id = sc1.nextInt();
                      					Categorie cat = new Categorie();
                      					cat.setId(id);
                      					boolean bool1 = daoLM.getCategorieDAO().delete(cat);
			                	   }
			                	    if( Choix == 4) {
			                			ArrayList<Categorie> cat = daoLM.getCategorieDAO().getAll();
                       					System.out.println(cat);
			                	   }
			                	    if(Choix == 5 ) {
                      					System.out.println("Veuillez selectionner l'id de la categorie a afficher :");
                      					id = sc1.nextInt();
                      					Categorie cat1 = daoLM.getCategorieDAO().getById(id);
                      					System.out.println(cat1);
                      				}
			                	    if(Choix == 6) {
                      					System.out.println("Veuillez selectionner le titre de la categorie a afficher :");
                      					titre = sc2.nextLine();
                      					Categorie cat1 = daoLM.getCategorieDAO().getByTitre(titre);
                      					System.out.println(cat1);
                      				}
                      				 if(Choix == 7)
                      					menu();
			                	   
			                break;
			                
			                  case 2:
			                	  Choix = choixClient();
			                	  
			                	  		if(Choix == 1) {
			                	  			Client cl = new Client();
			                	  			System.out.println("Veuillez saisir le nom du nouveau client :");
			                	  			nom = sc2.nextLine();
			                	  			System.out.println("Veuillez saisir le prenom du nouveau client :");
			                	  			prenom = sc2.nextLine();
			                				cl.setNom(nom);
			                				cl.setPrenom(prenom);
			                				boolean bool1 = daoLM.getClientDAO().create(cl);
			                	  		}
			                	  		 if(Choix == 2) {
			                	  			System.out.println("Veuillez selectionner l'id du client a modifier :");
	                       					id = sc1.nextInt();
	                       					String x = sc1.nextLine();
	                       					System.out.println("Veuillez saisir le nouveau nom du la client :");
		                       				nom = sc2.nextLine();
		                       				System.out.println("Veuillez saisir le nouveau prenom du client :");
		                       				prenom = sc2.nextLine();
			                	  			Client cl = new Client(id,nom,prenom);
			                				boolean bool6 = daoLM.getClientDAO().update(cl);
			                	  		}
			                	  		if (Choix == 3) {
			                	  			Client cl = new Client();
			                	  			System.out.println("Veuillez selectionner l'id du client a supprimer :");
	                       					id = sc1.nextInt();
			                				cl.setId(id);
			                				boolean bool5 = daoLM.getClientDAO().delete(cl);
			                	  		}
			                	  		 if (Choix == 4) {
			                	  			ArrayList<Client> cl = daoLM.getClientDAO().getAll();
			                				System.out.println(cl);
			                	  		}
			                	  		 if(Choix == 5) {
			                	  			System.out.println("Veuillez selectionner l'id du client a afficher :");
	                       					id = sc1.nextInt();
			                	  			Client cl = daoLM.getClientDAO().getById(id);
			                				System.out.println(cl);
			                	  		}
			                	  		 if(Choix == 6) {
			                	  		System.out.println("GetByNom(1) ou getByPrenom(2) ? ");
			                	  		int get = sc1.nextInt();
			                	  		 if(get<1 || get>2)
			                				 System.out.println("Valeur mal saisie!!!!");
			                	  		 if(get == 1) {
			                	  			System.out.println("Veuillez saisir le nom du client a afficher :");
		                       				nom = sc2.nextLine();
			                	  			ArrayList<Client> cl = daoLM.getClientDAO().getByNom(nom);
			                				System.out.println(cl);
			                	  		 }
			                	  		 else {
			                	  			System.out.println("Veuillez saisir le prenom du client a afficher :");
		                       				prenom = sc2.nextLine();
			                	  			ArrayList<Client> cl = daoLM.getClientDAO().getByPrenom(prenom);
			                				System.out.println(cl); 
			                	  		 }
			                	  		}
			                	  		 if(Choix == 7)
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
          	  		  	        		System.out.println("Veuillez-saisir le titre de la categorie :");
          	  		  	        		titre = sc2.nextLine();
          	  		  	        		obj.setTitre(titre);
          	  		  	        		pr.setCategorie(obj);
          	  		  	        		boolean bool = daoLM.getProduitDAO().create(pr);	
          	  		  	    }
          	  		  			 if(Choix == 2 ) {
                 	  		  	    System.out.println("Veuillez selectionner l'id du produit a modifier :");
                    					id = sc1.nextInt();
                    					System.out.println("Veuillez-saisir le nom du nouveau produit :");
             	  		  	    	nom = sc1.nextLine();
             	  		  	    	pr.setNom(nom);
             	  		  	    	System.out.println("Veuillez-saisir la description du nouveau produit :");
             	  		  	        description = sc2.nextLine();
             	  		  	        pr.setDescription(description);
             	  			        System.out.println("Veuillez-saisir le visuel du nouveau produit :");
             	  			        visuel = sc2.nextLine();
             	  			        pr.setVisuel(visuel);
             	  			        System.out.println("Veuillez-saisir le tarif du nouveau produit :");
             	  			        tarif = sc1.nextDouble();
             	  			        String y = sc2.nextLine();
             	  			        pr.setTarif(tarif);
             	  			        Categorie obj = new Categorie();
             	  			        System.out.println("Veuillez-saisir le titre de la categorie :");
             	  			        titre = sc2.nextLine();
             	  			        obj.setTitre(titre);
             	  			        Produit pr1 = new Produit(id,nom,description,tarif,visuel,obj);
             	  			        pr1.setCategorie(obj);
             	  				    boolean bool = daoLM.getProduitDAO().update(pr1);	
                 	  		  	    }
          	  		  			 
          	  		  			 	if(Choix ==3 ) {
          	  		  			 		System.out.println("Veuillez selectionner l'id du produit a supprimer :");
          	  		  			 		id = sc1.nextInt();
          	  		  			 		pr.setId(id);
          	  		  			 		boolean bool = daoLM.getProduitDAO().delete(pr);	
          	  		  			 	}
          	  		  		 
          	  		  			 	if(Choix ==4 ) {
          	  		  			 		ArrayList<Produit> prod1 = daoLM.getProduitDAO().getAll();
          	  		  			 		for (Produit obj : prod1) {
          	  		  			 			System.out.println(obj);
          	  		  			 		}
          	  		  			 	}
          	  		  			 	if(Choix==5) {
          	  		  			 		System.out.println("Veuillez selectionner l'id de la categorie du produit a afficher :");	
          	  		  			 		id = sc1.nextInt();
          	  		  			 		ArrayList<Produit> prod1 = daoLM.getProduitDAO().getByIdCateg(id);
          	  		  			 		for (Produit obj : prod1) {
          	  		  			 			System.out.println(obj);
          	  		  			 		}
          	  		  			 	}
          	  		  			 	if(Choix == 6) {
          	  		  			 		System.out.println("Veuillez selectionner le nom du produit a afficher :");	
          	  		  			 		nom = sc2.nextLine();
          	  		  			 		Produit prod = daoLM.getProduitDAO().getByNom("Sonic te kiffe");
          	  		  			 		System.out.println(prod);
          	  		  			 	}
    	  		  	    
          	  		  			 	if (Choix == 7) 
          	  		  			 		menu();
			                	  	break;
			                  case 4:
			                	  Choix = choixComm();
			                	  Commande cmd = new Commande();
			                	  Client cl = new Client();
			                	  if(Choix == 1) {
			                		 System.out.println("Veuillez sasir votre identifiant client :");
			                		 id = sc1.nextInt();
			                		 Date date = new Date();
			                		 cl.setId(id);
			                		 cmd.setClient(cl);
			                		 cmd.setDate(date);
			                		 boolean bool = daoLM.getCommandeDAO().create(cmd);
			                		 
			                	  }
			                	  if(Choix == 2) {
			                		  System.out.println("Veuillez selectionner la commande a modifier :");
		                	  			id = sc1.nextInt();
		                	  			cl.setId(id);
		                	  			cmd.setClient(cl);
		                	  			System.out.println("Veuillez selectionner le nouvelle id client :");
		                	  			 num = sc1.nextInt();
		                	  			cmd.setNum(num);
		                	  			boolean bool = daoLM.getCommandeDAO().update(cmd);  
			                	  }
			                	  if(Choix == 3) {
			                		  System.out.println("Veuillez selectionner l'identifiant de la commande a supprimer :");
		                	  			num = sc1.nextInt();
		                	  			cmd.setNum(num);
		                	  			boolean bool = daoLM.getCommandeDAO().delete(cmd);
			                	  }
			                	  if(Choix == 4) {
			                		  ArrayList<Commande> com = daoLM.getCommandeDAO().getAll();
		                	  			for (Commande obj : com) {
		                	  				System.out.println(obj);
		                	  			}  
			                	  }
			                	  if(Choix == 5) {
			                		  System.out.println("Veuillez selectionner l'id de la commande a afficher :");	
	                	  		  	    id = sc1.nextInt();
	                	  		  	    cmd = daoLM.getCommandeDAO().getById(id);
	                	  		  	    System.out.println(cmd);
			                	  }
			                	  if(Choix == 6) {
			                		  System.out.println("Veuillez selectionner l'identifiant du client pour pouvoir afficher ces commandes :");
		                	  			id = sc1.nextInt();
		                	  			cl.setId(id);
		                	  			List<Commande> cmd1 = daoLM.getCommandeDAO().getByClient(cl);
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


