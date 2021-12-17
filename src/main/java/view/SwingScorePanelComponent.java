package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SwingScorePanelComponent extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel background;
	private JLabel score;
	
	public SwingScorePanelComponent() {
		setBounds(0, 0, 120, 120);
		setOpaque(false);
		setLayout(null);
		
		background = new JLabel("");
		background.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/score.png")));
		background.setBounds(0, 0, 120, 119);
		this.add(background);

		score = new JLabel("0");
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setForeground(new Color(255, 255, 255));
		score.setFont(new Font("Lucida Console", Font.BOLD, 30));
		score.setBounds(10, 56, 100, 41);
		this.add(score);
		
		setVisible(true);
	}
	
	public void setScoreValue(String value) {
		score.setText(value);
		score.repaint();
	}

}
