package outils;

public class Mase {

	private static int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 3, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

	};

	public static int[][] getMase() {

		return maze;

	}

	public static int[][] reinitialiserMase() {
		for (int index_mazeL = 0; index_mazeL < maze.length; index_mazeL++) {
			for (int index_mazeC = 0; index_mazeC < maze[0].length; index_mazeC++) {
				if (maze[index_mazeL][index_mazeC] == 2) {
					maze[index_mazeL][index_mazeC] = 0;
				}

			}
		}
		return maze;
	}
}
