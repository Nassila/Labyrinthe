package outils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener {

	private int[][] maze = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }

	};

	private List<Integer> chemin = new ArrayList<Integer>();
	private JButton DFS, BFS, NEW;
	private JPanel pannelSud;

	public Fenetre() {
		// titre de la fenetre
		setTitle("Labyrinthe");
		// taille de la fenetre
		setSize(500, 400);
		// centrer l'affichage de la fenetre à l'ecran
		setLocationRelativeTo(this);
		// empecher de redimensionner la fenetre
		setResizable(false);
		// arreter l'execution lors de la fermeture de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pannelSud = new JPanel();
		pannelSud.setBackground(Color.BLUE);
		add(pannelSud, "South");

		DFS = new JButton("DFS");
		pannelSud.add(DFS);
		DFS.addActionListener(this);

		BFS = new JButton("BFS");
		pannelSud.add(BFS);
		BFS.addActionListener(this);

		NEW = new JButton("New");
		pannelSud.add(NEW);
		NEW.addActionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.translate(50, 50);

		for (int index_mazeL = 0; index_mazeL < maze.length; index_mazeL++) {
			for (int index_mazeC = 0; index_mazeC < maze[0].length; index_mazeC++) {
				Color couleur;
				switch (maze[index_mazeL][index_mazeC]) {
				case 1:
					couleur = Color.black;
					break;

				case 3:
					couleur = Color.red;
					break;
				default:
					couleur = Color.WHITE;
				}
				g.setColor(couleur);
				g.fillRect(30 * index_mazeC, 30 * index_mazeL, 30, 30);
				g.setColor(Color.black);
				g.drawRect(30 * index_mazeC, 30 * index_mazeL, 30, 30);
			}
		}

		for (int i = 0; i < chemin.size(); i += 2) {
			int cheminX = chemin.get(i);
			int cheminY = chemin.get(i + 1);
			g.setColor(Color.GREEN);
			g.fillRect(cheminX * 30, cheminY * 30, 30, 30);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == DFS) {
			algorithmes.DFS.chercherChemin(maze, 1, 1, chemin);

			repaint();
		}

		if (e.getSource() == BFS) {
			algorithmes.BFS.chercherChemin(maze, 1, 1, chemin);
			repaint();
		}

		if (e.getSource() == NEW) {
			chemin.clear();
			repaint();
		}

	}

}
