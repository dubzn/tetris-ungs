package views;

import javax.swing.JLabel;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SwingSquareComponent extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private List<String> colorNames = Arrays.asList("violeta", "verde", "azul", "roja", "amarilla");
	private List<String> colorNames = Arrays.asList("azul");
	
	public SwingSquareComponent(Integer x, Integer y, String color) {
		setBounds(x, y, 40, 40);
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(getIconColorAndSize(color, 40, 40));
	}
	
	public SwingSquareComponent(Integer x, Integer y, Integer width, Integer height, String color) {
		setBounds(x, y, width, height);
		setHorizontalAlignment(SwingConstants.CENTER);
		setIcon(getIconColorAndSize(color, width, height));
	}
	
	private ImageIcon getIconColorAndSize(String color, Integer width, Integer height) {
		String colorName = getRandomColor();
		if(color.equals("empty")) {
			return null;
			//return new ImageIcon(new ImageIcon(SwingSquareComponent.class.getResource("/celda_no_ocupada.png")).getImage().getScaledInstance(width, height, 4));
		}
		if(color.equals("not_occupiable")) {
			return new ImageIcon(new ImageIcon(SwingSquareComponent.class.getResource("/celda_no_ocupable.png")).getImage().getScaledInstance(width, height, 4));
		}
		return new ImageIcon( new ImageIcon(SwingSquareComponent.class.getResource("/"+colorName+".png")).getImage().getScaledInstance(width, height, 4));
	}

	private String getRandomColor() {
		Random random = new Random();
		return "celda_"+colorNames.get(random.nextInt(colorNames.size()));
	}

}
