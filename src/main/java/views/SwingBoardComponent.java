package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class SwingBoardComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel background;
	
	public SwingBoardComponent() {
		setBounds(10, 10, 420, 900);
		setOpaque(false);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(SwingGameView.class.getResource("/tablero_neon.png")));
		background.setBounds(0, 0, 420, 900);
		this.add(background);
		
		setVisible(true);
	}
	
	public void addBackgroundImage() {
		this.add(background);
	}

}
