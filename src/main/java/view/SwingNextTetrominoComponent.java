package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.util.List;

import dto.SquareDTO;

public class SwingNextTetrominoComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel background;
	
	public SwingNextTetrominoComponent() {
		setBounds(0, 0, 120, 120);
		setOpaque(false);
		setLayout(null);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/next.png")));
		background.setBounds(0, 0, 120, 119);
		this.add(background);
		
		setVisible(true);
	}
	
	public void drawNextTetromino(List<SquareDTO> squares) {

		for(SquareDTO celda : squares) {
			JLabel swingSquare = celda.getOccupied() ? 
					new SwingSquareComponent((celda.getX() * 20) + 30, (celda.getY() * 20) + 55, 20, 20, "default") :
					new SwingSquareComponent((celda.getX() * 20) + 30, (celda.getY() * 20) + 55, 20, 20, "empty");
			this.add(swingSquare);
		}
		this.repaint();
	}

	public void addBackGroundImage() {
		this.add(background);
	}
	

}
