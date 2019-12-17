package main;

import outils.Fenetre;
import outils.Mase;

public class Main {

	public static void main(String[] args) {
		Mase mase = new Mase();

		Fenetre fenetre = new Fenetre(mase);
		fenetre.setVisible(true);

	}
}
