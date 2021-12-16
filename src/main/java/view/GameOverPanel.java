package view;

import javax.swing.JPanel;
import javax.swing.JLabel;

import javax.swing.ImageIcon;

public class GameOverPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel background;
	
	public GameOverPanel() {
		setBounds(0, 0, 300, 200);
		setOpaque(false);
		setLayout(null);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/gameover.png")));
		background.setBounds(0, 0, 300, 200);
		this.add(background);	
	}

}
