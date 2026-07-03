package loveCounter;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UIManager {

	private Stage stage;
	
	public UIManager(Stage stage) {
		this.stage = stage;
	}
	
	public Scene mainMenu() {
		
		GridPane mainPane = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		
		Button coffeeButton = new Button();
		Button tripButton = new Button();
		Button catButton = new Button();
		Button hugButton = new Button();
		Button waterButton = new Button();
		Button toDoButton = new Button();
		
		Label coffeeLabel = new Label("Coffee Counter");
		Label tripLabel = new Label("Trip Counter");
		Label catLabel = new Label("Cat Counter");
		Label hugLabel = new Label("Hug Counter");
		Label waterLabel = new Label("Water Counter");
		Label toDoLabel = new Label("To-Do List");
		
		StackPane coffeePane = new StackPane();
		StackPane tripPane = new StackPane();
		StackPane catPane = new StackPane();
		StackPane hugPane = new StackPane();
		StackPane waterPane = new StackPane();
		StackPane toDoPane = new StackPane();
		
		coffeePane.getChildren().addAll(coffeeButton, coffeeLabel);
		tripPane.getChildren().addAll(tripButton, tripLabel);
		catPane.getChildren().addAll(catButton, catLabel);
		hugPane.getChildren().addAll(hugButton, hugLabel);
		waterPane.getChildren().addAll(waterButton, waterLabel);
		toDoPane.getChildren().addAll(toDoButton, toDoLabel);
		
		mainPane.add(coffeePane, 0, 0);
		mainPane.add(tripPane, 1, 0);
		mainPane.add(catPane, 2, 0);
		mainPane.add(hugPane, 3, 0);
		mainPane.add(waterPane, 0, 1);
		mainPane.add(toDoPane, 1, 1);
		
		coffeeLabel.setMouseTransparent(true);
		tripLabel.setMouseTransparent(true);
		catLabel.setMouseTransparent(true);
		hugLabel.setMouseTransparent(true);
		waterLabel.setMouseTransparent(true);
		toDoLabel.setMouseTransparent(true);
		
		coffeeButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		tripButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		catButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		hugButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		waterButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		toDoButton.prefWidthProperty().bind(stage.widthProperty().divide(6));

        coffeeButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        tripButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        catButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        hugButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        waterButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        toDoButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", coffeeButton.heightProperty().divide(3).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", tripButton.heightProperty().divide(3).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", catButton.heightProperty().divide(3).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", hugButton.heightProperty().divide(3).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", waterButton.heightProperty().divide(3).asString(), "px"));
        toDoLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.heightProperty().divide(3).asString(), "px"));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", coffeeButton.widthProperty().divide(8).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", tripButton.widthProperty().divide(8).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", catButton.widthProperty().divide(8).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", hugButton.widthProperty().divide(8).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", waterButton.widthProperty().divide(8).asString(), "px"));
        toDoLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.widthProperty().divide(8).asString(), "px"));
		
		Scene mainMenuScene = new Scene(mainPane);
		
		coffeeButton.setOnAction(e -> switchScene(coffeeMenu()));
		tripButton.setOnAction(e -> switchScene(tripMenu()));
		catButton.setOnAction(e -> switchScene(catMenu()));
		hugButton.setOnAction(e -> switchScene(hugMenu()));
//		toDoButton.setOnAction(e -> switchScene(hugMenu()));
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		
		return mainMenuScene;
	}
	
	public Scene coffeeMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label("Coffee");
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		Scene coffeeScene = new Scene(layer);
		
		return coffeeScene;
	}
	
	public Scene tripMenu() {
		
		GridPane layer = new GridPane();
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle();
		Label mainLab = new Label();
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		
		
		Scene tripScene = new Scene(layer);
		
		return tripScene;
	}
	
	public Scene catMenu() {
		
		GridPane layer = new GridPane();
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle();
		Label mainLab = new Label();
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		
		
		Scene catScene = new Scene(layer);
		
		return catScene;
	}
	
	public Scene hugMenu() {
		
		GridPane layer = new GridPane();
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle();
		Label mainLab = new Label();
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		
		
		Scene hugScene = new Scene(layer);
		
		return hugScene;
	}
	
	private void switchScene(Scene scene) {
	    stage.setScene(scene);
	    stage.setFullScreen(true);
	    stage.setFullScreenExitHint("");
	}
	
	private void setButtonSizes(Button button) {
		button.prefHeightProperty().bind(stage.heightProperty().divide(10));
		button.prefWidthProperty().bind(stage.widthProperty().divide(10));
	}
	
	private StackPane returnMenu() {
		
		Button returnMainMenuButton = new Button();
		Label returnMainMenuLabel = new Label("Ana Menü");
		StackPane returnMainMenuPane = new StackPane();
		returnMainMenuPane.setAlignment(Pos.BOTTOM_RIGHT);
		returnMainMenuPane.getChildren().addAll(returnMainMenuButton, returnMainMenuLabel);
		
		
		
		returnMainMenuButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		returnMainMenuButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", returnMainMenuButton.heightProperty().divide(3).asString(), "px"));
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", returnMainMenuButton.widthProperty().divide(8).asString(), "px"));
		
		returnMainMenuButton.setOnAction(e -> switchScene(mainMenu()));
		
		return returnMainMenuPane;
	}
}