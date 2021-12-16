package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ScorePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ScorePanel() {
		JLabel gameOverLabel = new JLabel("");
		gameOverLabel.setIcon(new ImageIcon(ScorePanel.class.getResource("/resource/score.png")));
		add(gameOverLabel);

	}

}
