package loveCounter;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UIManager {

	private Stage stage;
	
	public UIManager(Stage stage) {
		this.stage = stage;
	}
	
	public Scene mainMenu() {
		
		StackPane mainPane = new StackPane();
		
		Button coffeeButton = new Button("Coffee Count");
		Button tripButton = new Button("Trip Count");
		Button catButton = new Button("Petting Cat Count");
		Button hugButton = new Button("Hug Count");
		Button waterButton = new Button("Water Counter");
		
		HBox firstLine = new HBox(20);
		HBox secondLine = new HBox(20);
		
		VBox lineLayer = new VBox(20);
		
		firstLine.getChildren().addAll(tripButton, catButton, hugButton);
		secondLine.getChildren().addAll(coffeeButton, waterButton);
		lineLayer.getChildren().addAll(firstLine, secondLine);
		
		mainPane.getChildren().add(lineLayer);
		
		Scene mainMenuScene = new Scene(mainPane);
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		
		return mainMenuScene;
	}
	
}
