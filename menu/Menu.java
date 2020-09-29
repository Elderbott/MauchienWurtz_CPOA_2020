package menu;
import java.util.Scanner;

import metier.Categorie;
import metier.Client;
import metier.Produit;

public class Menu {

	/*
	Scanner sc1 = new Scanner( System.in );
	private int Choix,retour;
	private boolean modif=true;
	
	public int choix() {
		 System.out.println("Que voulez vous faire ajouter(1), modifier(2), supprimer(3), afficher(4), retour(5)?");
		 int choixAction=sc1.nextInt();
		 if(choixAction<1 || choixAction>5)
			 System.out.println("Valeur mal saisie!!!!");
			return  choixAction;	
	}
	
	public void menu() {
		
		while(modif) {
		
		System.out.println("choisissez une table : categorie(1), client(2), produit(3) ou quitter(4)");
		int choixTab=sc1.nextInt();
		
		if (choixTab <1 || choixTab>4)
			 System.out.println("Valeur mal saisie!!!!!");
		
		
		switch(choixTab)
		 {
		                  case 1:
		                	  
		                	  			Choix = choix();
		                       				Categorie categ = new Categorie();
		                       			if(Choix==1)
		                       				categ.AjoutCateg();
		                       			if(Choix==2)
		                       				categ.ModifCateg();
		                       			if(Choix==3)
		                       				categ.SupprCateg();
		                       			if(Choix==4)
		                       				categ.TableCateg();
		                       			if(Choix==5)
		                       				menu();
		                  break;
		                       
		                  case 2:
		                	  		  Choix = choix();
                 				        Client cl = new Client();
                 				      if(Choix==1)
                 				    	  cl.AjoutClient();
                 				      if(Choix==2)
                 				    	  cl.ModifClient();
                 				      if(Choix==3)
                 				    	  cl.SupprClient();
                 				      if(Choix==4)
                 				    	  cl.TableClient();
                 				      if(Choix==5)
                 				    	  menu();
                 	      break;
                 	  
		                  case 3:
                	  		  		Choix = choix();
                	  		  			Produit pr = new Produit();
                	  		  	    if(Choix==1)
                	  		  	    	pr.AjoutProd();
                	  		  	    if(Choix==2)
                	  		  	    	pr.ModifProd();
                	  		  	    if(Choix==3)
                	  		  	    	pr.SupprProd();
                	  		  	    if(Choix==4)
                	  		  	    	pr.TableProd();
                	  		  	    if(Choix==5)
                	  		  	    	menu();
                	  	break;		  	
		                  case 4:
		                	  	break;
		                	  
		 }		
	
    if(choixTab !=4) {
	System.out.println("Voulez-vous refaire une modification ? si oui taper(1) sinon(0)");
	retour = sc1.nextInt();
	if (retour <0 || retour>1)
		 System.out.println("Valeur mal saisie!!!!!");
	if(retour == 1)
		modif=true;
	else
		modif=false;
    }
    else
    	modif=false;

}
}
*/
}

