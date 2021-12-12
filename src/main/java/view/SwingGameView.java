package view;

import javax.swing.JFrame;

import model.Celda;
import model.Juego;
import javax.swing.JPanel;

import javafx.scene.input.KeyCode;

import javax.swing.JLabel;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

public class SwingGameView extends JFrame implements GameViewService {
	
	private JPanel tablero;
	
	public SwingGameView() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch (e.getKeyCode()) {
				case 32:
					System.out.println("SPACE");
				case 37:
					System.out.println("IZQUIERDA");
					break;
				case 39:
					System.out.println("DERECHA");
					break;
				case 40:
					System.out.println("ABAJO");
					break;
					
				default:
					break;
				}
			}
		});
		
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
		
		this.setVisible(true);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init(String... args) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finish(Juego juego) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Juego juego) {
		tablero.removeAll();
		JLabel tableroImage = new JLabel("");
		tableroImage.setBounds(20, 25, 420, 900);
		tableroImage.setIcon(new ImageIcon(SwingGameView.class.getResource("/resource/tablero_neon.png")));
		tablero.add(tableroImage);
		System.out.println("update juego swing");
		for(Celda celda : juego.getTablero().getCeldas()) {
			JLabel celdaSwing;
			if(!celda.estaOcupada()) {
				celdaSwing = new SwingCeldaLabel((celda.getX() * 40) - 10, (celda.getY() * 40) - 5, "empty");
				
			} else {
				celdaSwing = new SwingCeldaLabel((celda.getX() * 40) - 10, (celda.getY() * 40) - 5, "verde");		
			}
			tablero.add(celdaSwing);
		}
		tablero.repaint();
	}

}
