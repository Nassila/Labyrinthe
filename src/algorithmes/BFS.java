package algorithmes;

import java.util.ArrayList;
import java.util.List;

public class BFS {
	public static boolean chercherChemin(int[][] maze, int x, int y, List<Integer> chemin) {

		List<Integer> file = new ArrayList<Integer>();

		int premierX = x;
		int premierY = y;

		file.add(premierX);
		file.add(premierY);

		// marquer sommet
		if (maze[premierX][premierY] == 0) {
			maze[premierX][premierY] = 2;
		}

		while (!file.isEmpty()) {
			System.out.println(file);

			if (maze[premierX][premierY] == 3) {
				chemin.add(premierX);
				chemin.add(premierY);

				return true;

			} else {

				premierX = file.get(0);
				premierY = file.get(1);

				chemin.add(premierX);
				chemin.add(premierY);
				System.err.println(chemin);

				file.remove(1);
				file.remove(0);

				int dx = -1;
				int dy = 0;
				if (maze[premierX + dx][premierY + dy] != 2 && (premierX + dx) < maze.length - 1 && (premierX + dx) > 0
						&& (premierY + dy) < maze[0].length - 1 && (premierY + dy) > 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierX + dx][premierY + dy] = 2;
				}

				dx = 0;
				dy = -1;
				if (maze[premierX + dx][premierY + dy] != 2 && (premierX + dx) < maze.length - 1 && (premierX + dx) > 0
						&& (premierY + dy) < maze[0].length - 1 && (premierY + dy) > 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierX + dx][premierY + dy] = 2;
				}

				dx = 0;
				dy = 1;
				if (maze[premierX + dx][premierY + dy] != 2 && (premierX + dx) < maze.length - 1 && (premierX + dx) > 0
						&& (premierY + dy) < maze[0].length - 1 && (premierY + dy) > 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierX + dx][premierY + dy] = 2;
				}

				dx = 1;
				dy = 0;
				if (maze[premierX + dx][premierY + dy] != 2 && (premierX + dx) < maze.length - 1 && (premierX + dx) > 0
						&& (premierY + dy) < maze[0].length - 1 && (premierY + dy) > 0) {
					file.add(premierX + dx);
					file.add(premierY + dy);
					maze[premierX + dx][premierY + dy] = 2;
				}
			}
		}

		return false;
	}
}
