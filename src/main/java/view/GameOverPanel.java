package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GameOverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public GameOverPanel() {
		
		JLabel gameOverLabel = new JLabel("");
		gameOverLabel.setIcon(new ImageIcon(GameOverPanel.class.getResource("/resource/gameover.png")));
		add(gameOverLabel);

	}

}
