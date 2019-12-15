package algorithmes;

public class New {

	public static void clear(int[][] maze) {
		for (int index_mazeL = 0; index_mazeL < maze.length; index_mazeL++) {
			for (int index_mazeC = 0; index_mazeC < maze.length; index_mazeC++) {
				if (maze[index_mazeC][index_mazeL] == 2) {
					maze[index_mazeC][index_mazeL] = 0;
				}
			}
		}
	}
}
