package outils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Fenetre extends JFrame implements ActionListener {

	private int[][] maze;
	private Mase mazee;
	private List<Integer> chemin = new ArrayList<Integer>();

	private JButton DFS, BFS, A, NEW;
	private JPanel pannelSud, pannelNord;
	private JLabel Lmessage;

	public Fenetre(Mase mazee) {
		this.mazee = mazee;
		this.maze = mazee.getMase();

		// titre de la fenetre
		setTitle("Labyrinthe");
		// taille de la fenetre
		setSize(420, 410);
		// centrer l'affichage de la fenetre à l'ecran
		setLocationRelativeTo(this);
		// empecher de redimensionner la fenetre
		setResizable(false);
		// arreter l'execution lors de la fermeture de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pannelSud = new JPanel();
		pannelSud.setBackground(new Color(0, 162, 232));
		add(pannelSud, "South");

		pannelNord = new JPanel();
		pannelNord.setBackground(new Color(0, 162, 232));
		add(pannelNord, "North");

		Lmessage = new JLabel("Trouvez la sortie !!");
		pannelNord.add(Lmessage);

		DFS = new JButton("DFS");
		pannelSud.add(DFS);
		DFS.addActionListener(this);

		BFS = new JButton("BFS");
		pannelSud.add(BFS);
		BFS.addActionListener(this);

		A = new JButton("A*");
		pannelSud.add(A);
		A.addActionListener(this);

		NEW = new JButton("New");
		pannelSud.add(NEW);
		NEW.addActionListener(this);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.translate(14, 60);

		for (int index_mazeL = 0; index_mazeL < maze.length; index_mazeL++) {
			for (int index_mazeC = 0; index_mazeC < maze[0].length; index_mazeC++) {
				Color couleur;
				switch (maze[index_mazeL][index_mazeC]) {
				case 1:
					couleur = Color.black;
					break;

				case 3:
					couleur = Color.MAGENTA;
					break;
				default:
					couleur = Color.WHITE;
				}
				g.setColor(couleur);
				g.fillRect(30 * index_mazeC, 30 * index_mazeL, 30, 30);
				g.setColor(new Color(0, 162, 232));
				g.drawRect(30 * index_mazeC, 30 * index_mazeL, 30, 30);
			}
		}
		if (chemin.size() != 0) {
			for (int i = 0; i < chemin.size(); i += 2) {
				int cheminX = chemin.get(i);
				int cheminY = chemin.get(i + 1);
				g.setColor(Color.yellow);
				g.fillRect(cheminX * 30, cheminY * 30, 30, 30);

			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == DFS) {
			Lmessage.setText("Algorithme de parcours en profondeur DFS");
			algorithmes.DFS.chercherChemin(maze, 1, 1, chemin);

			repaint();
		} else

		if (e.getSource() == BFS) {
			Lmessage.setText("Algorithme de parcours en largeur BFS");
			algorithmes.BFS.chercherChemin(maze, 1, 1, chemin);

			repaint();
		} else if (e.getSource() == A) {

		} else

		if (e.getSource() == NEW) {
			chemin.clear();
			this.maze = mazee.reinitialiserMase();
			repaint();
			Lmessage.setText("Réinitialisation du labyrinthe");
		}

	}

}
