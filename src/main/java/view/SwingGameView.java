package view;

import javax.swing.JFrame;

import javax.swing.JPanel;

import dto.SquareDTO;

import javax.swing.JLabel;

import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Toolkit;

public class SwingGameView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private BoardPanel board;
	private GameOverPanel gameover;
	private ScorePanel score;
	private NextTetrominoPanel next;
	
	public SwingGameView() {
		setTitle("Tetris PP2 - UNGS");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SwingGameView.class.getResource("/resource/frame_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 960);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		gameover = new GameOverPanel();
		gameover.setLocation(66, 150);	
		getContentPane().add(gameover);
		gameover.setVisible(false);
		gameover.setLayout(null);
		
		score =  new ScorePanel();
		score.setLocation(450, 100);
		getContentPane().add(score);
		score.setLayout(null);

		board = new BoardPanel();		
		getContentPane().add(board);
		board.setLayout(null);
		
		next = new NextTetrominoPanel();	
		next.setLocation(450, 230);	
		getContentPane().add(next);
		next.setLayout(null);

		addGameBackground();
	}

	private void addGameBackground() {
		JPanel background = new JPanel();
		background.setBounds(0, 0, 584, 963);
		getContentPane().add(background);
		background.setLayout(null);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(0, 0, 1920, 1080);
		backgroundImage.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/background.png")));
		background.add(backgroundImage);
	}

	public void showGameOver() {
		gameover.setVisible(true);
	}
	
	public void update(List<SquareDTO> actualTetromino, List<SquareDTO> nextTetromino, String scoreValue) {
		board.removeAll(); 
		board.addBackgroundImage();
		
		score.setScoreValue(scoreValue);
		next.removeAll();
		next.addBackGroundImage();
		next.setNextTetromino(nextTetromino);
		
		for(SquareDTO celda : actualTetromino) {
			JLabel swingSquare;
			if(celda.getY() == 1 || celda.getY() == 2) {
				swingSquare = celda.getOccupied() ? 
						new SwingCeldaLabel((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "default") :
						new SwingCeldaLabel((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "not_occupiable");
			}
			else
			{
				swingSquare = celda.getOccupied() ? 
						new SwingCeldaLabel((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "default") :
						new SwingCeldaLabel((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "empty");
			}

			board.add(swingSquare);
		}
		board.repaint();
	}
	
	public void close() {
		setVisible(false); 
		dispose(); 
	}
}
