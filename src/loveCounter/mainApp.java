package loveCounter;

import javafx.application.Application;
import javafx.stage.Stage;

public class mainApp extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		configManager config = new configManager();
		config.loadConfig();
		
		UIManager primaryScene = new UIManager(primaryStage);
		primaryStage.setScene(primaryScene.startApp());
		primaryStage.setTitle("LOVE APP");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}