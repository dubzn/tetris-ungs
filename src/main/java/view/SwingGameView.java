package view;

import javax.swing.JFrame;

import javax.swing.JPanel;

import dto.CeldaDTO;

import javax.swing.JLabel;

import java.util.List;

import javax.swing.ImageIcon;

public class SwingGameView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel tablero;
	
	public SwingGameView() {
		setBounds(100, 100, 600, 1000);
		getContentPane().setLayout(null);
		
		tablero = new JPanel();
		tablero.setOpaque(false);
		tablero.setBounds(0, 0, 584, 963);
		getContentPane().add(tablero);
		tablero.setLayout(null);
		
		JPanel background = new JPanel();
		background.setBounds(0, 0, 584, 963);
		getContentPane().add(background);
		background.setLayout(null);
		
		JLabel backgroundImage = new JLabel("");
		backgroundImage.setBounds(0, 0, 1920, 1080);
		backgroundImage.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/background.png")));
		background.add(backgroundImage);
	}

	public void update(List<CeldaDTO> celdas) {
		tablero.removeAll(); 
		JLabel tableroImage = new JLabel("");
		tableroImage.setBounds(20, 25, 420, 900);
		tableroImage.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/tablero_neon.png")));
		tablero.add(tableroImage);
		for(CeldaDTO celda : celdas) {
			JLabel celdaSwing;
			if(!celda.getOcupada()) {
				celdaSwing = new SwingCeldaLabel((celda.getX() * 40) - 10, (celda.getY() * 40) - 5, "empty");
				
			} else {
				celdaSwing = new SwingCeldaLabel((celda.getX() * 40) - 10, (celda.getY() * 40) - 5, "verde");		
			}
			tablero.add(celdaSwing);
		}
		tablero.repaint();
	}

	public void close() {
		setVisible(false); 
		dispose(); 
	}

}
