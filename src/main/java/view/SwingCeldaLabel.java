package view;

import javax.swing.JLabel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SwingCeldaLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private List<String> colorNames = Arrays.asList("violeta", "verde", "azul", "roja", "amarilla");
	private List<String> colorNames = Arrays.asList("azul");
	
	public SwingCeldaLabel(Integer x, Integer y, String color) {
		setBounds(x, y, 40, 40);
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(getColor(color));
	}
	
	private ImageIcon getColor(String color) {
		if(color.equals("empty")) {
			return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/celda_no_ocupada.png"));		
		}
		
		String colorName = getColorAleatorio(color);
		

		return new ImageIcon(SwingCeldaLabel.class.getResource("/resource/"+colorName+".png"));
	}

	private String getColorAleatorio(String color) {
		Random random = new Random();
		return "celda_"+colorNames.get(random.nextInt(colorNames.size()));
	}

}
