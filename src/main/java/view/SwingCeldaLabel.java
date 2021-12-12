package view;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SwingCeldaLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SwingCeldaLabel(Integer x, Integer y, String color) {
		setBounds(x, y, 40, 40);
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(getColor(color));
	}
	
	private ImageIcon getColor(String color) {
		switch (color) {
		case "violeta":
			return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/celda_violeta.png"));
		case "verde":
			return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/celda_verde.png"));
		case "empty":
			return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/celda_no_ocupada.png"));
		default:
			return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/celda_gris.png"));
		}
	}

}
