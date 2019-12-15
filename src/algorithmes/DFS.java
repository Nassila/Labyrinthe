package algorithmes;

import java.util.List;

public class DFS {

	public static boolean chercherChemin(int[][] maze, int x, int y, List<Integer> chemin) {

		if (maze[y][x] == 3) {
			chemin.add(x);
			chemin.add(y);
			return true;
		}

		if (maze[y][x] == 0) {
			maze[y][x] = 2;

			int dx = -1;
			int dy = 0;
			if (chercherChemin(maze, x + dx, y + dy, chemin)) {
				chemin.add(x);
				chemin.add(y);
				return true;
			}

			dx = 1;
			dy = 0;
			if (chercherChemin(maze, x + dx, y + dy, chemin)) {
				chemin.add(x);
				chemin.add(y);
				return true;
			}

			dx = 0;
			dy = -1;
			if (chercherChemin(maze, x + dx, y + dy, chemin)) {
				chemin.add(x);
				chemin.add(y);
				return true;
			}

			dx = 0;
			dy = 1;
			if (chercherChemin(maze, x + dx, y + dy, chemin)) {
				chemin.add(x);
				chemin.add(y);
				return true;
			}
		}

		return false;
	}
}
