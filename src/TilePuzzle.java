import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TilePuzzle extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int TILE_WIDTH = 60;
	private static final int MENUBAR_WIDTH = 28;
	private final Table t;
	private final MyCanvas canvas;
	private static String board;

	public static void main(String[] args) {
		Table table = new Table();
		try {
			table.setSize(Integer.parseInt(args[0]));
		} catch(Exception e) {
			table.setSize(table.getDefaultSize());
		}
		table.shuffle();
		board = new ServletShuffle().doGet(new Request()).getBoard();
		table.resetNofMoves();
		new TilePuzzle(table);
	}

	TilePuzzle(Table table) {
		this.t = table;
		canvas = new MyCanvas();
		int size = table.getSize();
		setBounds(300, 300, size * TILE_WIDTH + 3, size * TILE_WIDTH + MENUBAR_WIDTH);
		setTitle("Tile Puzzle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		add(canvas, BorderLayout.CENTER);
		setVisible(true);
		setResizable(false);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x = e.getX() / TILE_WIDTH;
				int y = (e.getY() - MENUBAR_WIDTH) / TILE_WIDTH;
				int size = t.getSize();
				int move = y * size + x;
				t.swap(move);
				canvas.repaint();
				if (t.isDone()) {
					JOptionPane.showMessageDialog(canvas, 
							"You have done it with " + t.getNofMoves() + " moves!");
				}
			}
		});
	}

	class MyCanvas extends JComponent {

		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			Font font = new Font("Serif", Font.PLAIN, 32);
			g2.setFont(font);
			int[][] table = t.getTable();
			int size = t.getSize();
			for (int i = 0; i < size; i++) 
				for (int j = 0; j < size; j++) {
					String s;
					if (table[i][j] == 0) {
						s = " ";
					} else {
						s = "" + table[i][j];
					}
					int offset;
					if (table[i][j] > 9) {
						offset = 4;
					} else {
						offset = 3;
					}
					g2.drawString(s,
							TILE_WIDTH / offset + j * TILE_WIDTH, 
							2 * TILE_WIDTH / 3 + i * TILE_WIDTH);
					g2.drawRect(j * TILE_WIDTH, i * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
				}
		}
	}
}

