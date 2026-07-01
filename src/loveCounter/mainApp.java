package loveCounter;

import javafx.application.Application;
import javafx.stage.Stage;

public class mainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		UIManager primaryScene = new UIManager(primaryStage);
		primaryStage.setScene(primaryScene.mainMenu());
		primaryStage.setTitle("LOVE APP");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}