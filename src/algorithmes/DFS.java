package algorithmes;

import java.util.List;

public class DFS {

	public static boolean chercherChemin(int[][] maze, int index_ligne, int index_colonne, List<Integer> chemin) {

		// 0 : non visité
		// 1 : mur
		// 3 : cible
		// 2 : visité

		// verifier si on a trouvé la cible
		if (maze[index_colonne][index_ligne] == 3) {

			return true;
		}
		// si non visité
		if (maze[index_colonne][index_ligne] == 0) {
			// marquer comme visité
			maze[index_colonne][index_ligne] = 2;

			int dl = -1;
			int dc = 0;
			// verifer le voisin de gauche
			if (chercherChemin(maze, index_ligne + dl, index_colonne + dc, chemin)) {
				chemin.add(index_ligne);
				chemin.add(index_colonne);
				return true;
			}

			dl = 1;
			dc = 0;
			// verifier le voisin de droite
			if (chercherChemin(maze, index_ligne + dl, index_colonne + dc, chemin)) {
				chemin.add(index_ligne);
				chemin.add(index_colonne);
				return true;
			}

			dl = 0;
			dc = -1;
			// verifier le voisin du haut
			if (chercherChemin(maze, index_ligne + dl, index_colonne + dc, chemin)) {
				chemin.add(index_ligne);
				chemin.add(index_colonne);
				return true;
			}

			dl = 0;
			dc = 1;
			// verifier le voisin du bas
			if (chercherChemin(maze, index_ligne + dl, index_colonne + dc, chemin)) {
				chemin.add(index_ligne);
				chemin.add(index_colonne);
				return true;
			}
		}

		return false;
	}
}
