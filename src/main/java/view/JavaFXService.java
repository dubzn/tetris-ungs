package view;

import java.io.InputStream;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Celda;
import model.Juego;
import model.Tablero;
import service.DefaultMovement;


public class JavaFXService extends Application implements GameService {

	private GraphicsContext graphicsContext;
	private Group root;
	private Stage stage;
	
	@Override
	public void init(String... args) {
	    Application.launch(args);
	}

	@Override
	public void finish(Juego juego) {
		stage.close();
	}

	@Override
	public void update(Juego juego) {
		updateTablero(juego.getTablero());
	}

	@Override
	public void start(Stage stage) throws Exception {
	    this.stage = stage;
		setupStage(getClass().getResourceAsStream("../resource/frame_icon.png"), "Tetris");
	    setupScene();
	    updateTablero(new Tablero());
	    stage.show();
	}

	private void setupStage(InputStream icon, String title) {
	    stage.setTitle("Tetris");
	    Image image = new Image(icon);
	    stage.getIcons().add(image);
	    stage.setWidth(600);
	    stage.setHeight(1000);
	}
	
	private void setupScene() {
		root = new Group();
		stage.setScene(new Scene(root));
	
		Canvas canvas = new Canvas(600, 1000);
	    root.getChildren().add(canvas);
	         
	    graphicsContext = canvas.getGraphicsContext2D();
	 	Image background = new Image(getClass().getResourceAsStream("../resource/background.png"));
	 	graphicsContext.drawImage(background, 0, 0);
	 	
	 	Image tablero = new Image(getClass().getResourceAsStream("../resource/tablero_neon.png"));
	 	graphicsContext.drawImage(tablero, 40, 30);
	 }
	
	private void updateTablero(Tablero tablero) { 
		for(Celda celda : tablero.getCeldas()) {
			Image celdaImg = celda.estaOcupada() ? getImageByColor(celda) : new Image(getClass().getResourceAsStream("../resource/celda_no_ocupada.png"), 40.0, 0.0, true, true);
			graphicsContext.drawImage(celdaImg, 10 + celda.getX() * 40, celda.getY() * 40);
		}
	}

	private Image getImageByColor(Celda celda) {
		return new Image(getClass().getResourceAsStream("../resource/celda_verde.png"), 40.0, 0.0, true, true);
	}
	
}
