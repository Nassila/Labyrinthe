package algorithmes;

import java.util.ArrayList;
import java.util.List;

public class BFS {
	public static boolean chercherChemin(int[][] maze, int x, int y, List<Integer> chemin) {

		// 0 : non visité
		// 1 : mur
		// 3 : cible
		// 2 : visité

		List<Integer> file = new ArrayList<Integer>();

		int premierX = x;
		int premierY = y;

		// verifier si on a trouvé la cible
		if (maze[premierY][premierX] == 3) {

			return true;
		}

		file.add(premierX);
		file.add(premierY);

		// marquer sommet
		if (maze[premierY][premierX] == 0) {
			maze[premierY][premierX] = 2;
			// tant que la file n'est pas vide et qu'on a pas trouvé la cible
			while (!file.isEmpty() && maze[premierY][premierX] != 3) {
				// defiler
				premierX = file.get(0);
				premierY = file.get(1);

				chemin.add(premierX);
				chemin.add(premierY);

				file.remove(1);
				file.remove(0);

				// pour tout voisin non visité
				int dx = -1;
				int dy = 0;
				// verifier le voisin de gauche
				if (maze[premierY + dy][premierX + dx] == 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierY][premierX] = 2;

				}

				dx = 0;
				dy = -1;
				// verifier le voisin du haut
				if (maze[premierY + dy][premierX + dx] == 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierY][premierX] = 2;

				}

				dx = 0;
				dy = 1;
				// verifier le voisin du bas
				if (maze[premierY + dy][premierX + dx] == 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierY][premierX] = 2;
				}

				dx = 1;
				dy = 0;
				// verifier le voisin de droite
				if (maze[premierY + dy][premierX + dx] == 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierY][premierX] = 2;
				}

				// verifier si on a trouvé la cible
				if (maze[premierY + dy][premierX + dx] == 3) {

					return true;
				}
			}
		}

		return false;
	}
}
