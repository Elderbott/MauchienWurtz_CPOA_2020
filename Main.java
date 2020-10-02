import java.util.Scanner;

import menu.MenuSQL;
import menu.MenuListeMemoire;

public class Main {

	public static void main(String[] args) {
 
		System.out.println("Voulez-vous utiliser MySQL(1) ou ListeMemoire(2) ?");
		Scanner sc1 = new Scanner(System.in);
		int choix = sc1.nextInt();
		if (choix == 1) {
			MenuSQL menusql = new MenuSQL();
			menusql.menu();
		}
		else if (choix == 2) {
			MenuListeMemoire menulm = new MenuListeMemoire();
			menulm.menu();
		}
		else {
			System.out.println("Mauvaise saisie !");
		
		}
	}
}
