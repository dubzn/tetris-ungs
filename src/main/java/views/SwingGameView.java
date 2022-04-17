package views;

import javax.swing.JFrame;

import javax.swing.JPanel;

import dtos.SquareDTO;

import javax.swing.JLabel;

import java.util.List;

import javax.swing.ImageIcon;

import java.awt.Toolkit;
import java.util.Objects;

public class SwingGameView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private SwingBoardComponent board;
	private SwingGameOverComponent gameover;
	private SwingScorePanelComponent score;
	private SwingNextTetrominoComponent next;
	
	public SwingGameView() {
		setTitle("Tetris PP2 - UNGS");
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(SwingGameView.class.getResource("/frame_icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 960);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		gameover = new SwingGameOverComponent();
		gameover.setLocation(66, 150);	
		getContentPane().add(gameover);
		gameover.setVisible(false);
		gameover.setLayout(null);
		
		score =  new SwingScorePanelComponent();
		score.setLocation(450, 100);
		getContentPane().add(score);
		score.setLayout(null);

		board = new SwingBoardComponent();		
		getContentPane().add(board);
		board.setLayout(null);
		
		next = new SwingNextTetrominoComponent();	
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
		backgroundImage.setIcon(new ImageIcon(Objects.requireNonNull(SwingGameView.class.getResource("/background.png"))));
		background.add(backgroundImage);
	}

	public void showGameOver() {
		gameover.setVisible(true);
	}
	
	public void update(List<SquareDTO> actualTetromino, List<SquareDTO> nextTetromino, String scoreValue) {
		board.removeAll(); 
		board.addBackgroundImage();
		
		score.drawScoreValue(scoreValue);
		next.removeAll();
		next.addBackGroundImage();
		next.drawNextTetromino(nextTetromino);
		
		for(SquareDTO celda : actualTetromino) {
			JLabel swingSquare;
			if(celda.getY() == 1 || celda.getY() == 2) {
				swingSquare = celda.getOccupied() ? 
						new SwingSquareComponent((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "default") :
						new SwingSquareComponent((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "not_occupiable");
			}
			else
			{
				swingSquare = celda.getOccupied() ? 
						new SwingSquareComponent((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "default") :
						new SwingSquareComponent((celda.getX() * 40) - 30, (celda.getY() * 40) - 30, "empty");
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
