package loveCounter;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class UIManager {

	private Stage stage;
	private StackPane rootLayer;
	
	public UIManager(Stage stage) {
		this.stage = stage;
		this.rootLayer = new StackPane();
	}
	
	public Scene startApp() {

        rootLayer.getChildren().add(createMainMenu());

        Scene mainScene = new Scene(rootLayer);

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");

        return mainScene;
    }
	
	public StackPane createMainMenu() {
		
		StackPane baseLayout = new StackPane();
		
		GridPane mainPane = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setHgap(10);
		mainPane.setVgap(10);
		
		Button coffeeButton = new Button();
		Button tripButton = new Button();
		Button catButton = new Button();
		Button beatButton = new Button();
		Button hugButton = new Button();
		Button waterButton = new Button();
		Button toDoButton = new Button();
		Button exitButton = new Button();
		
		Label coffeeLabel = new Label("Coffee Counter");
		Label tripLabel = new Label("Trip Counter");
		Label catLabel = new Label("Cat Counter");
		Label beatLabel = new Label("Beat Counter");
		Label hugLabel = new Label("Hug Counter");
		Label waterLabel = new Label("Water Counter");
		Label toDoLabel = new Label("To-Do List");
		Label exitLabel = new Label("Çıkış");
		
		StackPane coffeePane = new StackPane();
		StackPane tripPane = new StackPane();
		StackPane catPane = new StackPane();
		StackPane beatPane = new StackPane();
		StackPane hugPane = new StackPane();
		StackPane waterPane = new StackPane();
		StackPane toDoPane = new StackPane();
		StackPane exitPane = new StackPane();
		
		coffeePane.getChildren().addAll(coffeeButton, coffeeLabel);
		tripPane.getChildren().addAll(tripButton, tripLabel);
		catPane.getChildren().addAll(catButton, catLabel);
		beatPane.getChildren().addAll(beatButton, beatLabel);
		hugPane.getChildren().addAll(hugButton, hugLabel);
		waterPane.getChildren().addAll(waterButton, waterLabel);
		toDoPane.getChildren().addAll(toDoButton, toDoLabel);
		exitPane.getChildren().addAll(exitButton, exitLabel);
		
		mainPane.add(coffeePane, 0, 0);
		mainPane.add(tripPane, 1, 0);
		mainPane.add(catPane, 2, 0);
		mainPane.add(beatPane, 3, 0);
		mainPane.add(hugPane, 0, 1);
		mainPane.add(waterPane, 1, 1);
		mainPane.add(toDoPane, 2, 1);
		
		exitPane.setAlignment(Pos.CENTER);
		exitPane.setMaxWidth(StackPane.USE_PREF_SIZE);
		exitPane.setMaxHeight(StackPane.USE_PREF_SIZE);
		StackPane.setAlignment(exitPane, Pos.BOTTOM_RIGHT);
		StackPane.setMargin(exitPane, new Insets(20));
		exitPane.setPickOnBounds(false);
		
		coffeeLabel.setMouseTransparent(true);
		tripLabel.setMouseTransparent(true);
		catLabel.setMouseTransparent(true);
		beatLabel.setMouseTransparent(true);
		hugLabel.setMouseTransparent(true);
		waterLabel.setMouseTransparent(true);
		toDoLabel.setMouseTransparent(true);
		exitLabel.setMouseTransparent(true);
		
		coffeeButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		tripButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		catButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		beatButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		hugButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		waterButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		toDoButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		exitButton.prefWidthProperty().bind(stage.widthProperty().divide(6));

        coffeeButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        tripButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        catButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        beatButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        hugButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        waterButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        toDoButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        exitButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", coffeeButton.heightProperty().divide(3).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", tripButton.heightProperty().divide(3).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", catButton.heightProperty().divide(3).asString(), "px"));
        beatLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", coffeeButton.heightProperty().divide(3).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", hugButton.heightProperty().divide(3).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", waterButton.heightProperty().divide(3).asString(), "px"));
        toDoLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.heightProperty().divide(3).asString(), "px"));
        exitLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.heightProperty().divide(3).asString(), "px"));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", coffeeButton.widthProperty().divide(8).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", tripButton.widthProperty().divide(8).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", catButton.widthProperty().divide(8).asString(), "px"));
        beatLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", catButton.widthProperty().divide(8).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", hugButton.widthProperty().divide(8).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", waterButton.widthProperty().divide(8).asString(), "px"));
        toDoLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.widthProperty().divide(8).asString(), "px"));
        exitLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", toDoButton.widthProperty().divide(8).asString(), "px"));
        
		Scene mainMenuScene = new Scene(mainPane);
		
		coffeeButton.setOnAction(e -> showLayer(coffeeMenu()));
		tripButton.setOnAction(e -> showLayer(tripMenu()));
		catButton.setOnAction(e -> showLayer(strokeCatMenu()));
		beatButton.setOnAction(e -> showLayer(beatMenu()));
		hugButton.setOnAction(e -> showLayer(hugMenu()));
//		toDoButton.setOnAction(e -> switchScene(hugMenu()));
		exitButton.setOnAction(e -> System.exit(0));
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		
		baseLayout.getChildren().addAll(mainPane, exitPane);
		
		return baseLayout;
	}
	
	public StackPane coffeeMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label(""+configManager.getCoffeeCount());
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		StackPane coffeeLayer = new StackPane();
		coffeeLayer.setAlignment(Pos.CENTER);

		coffeeLayer.prefWidthProperty().bind(stage.widthProperty());
		coffeeLayer.prefHeightProperty().bind(stage.heightProperty());
		coffeeLayer.setStyle("-fx-background-color: white;");
		coffeeLayer.getChildren().addAll(returnMenu(), layer);
		
		counterManager.coffeeCountManager(increase, decrease, mainLab);
		
		return coffeeLayer;
	}
	
	public StackPane tripMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label("Trip");
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		StackPane tripLayer = new StackPane();
		tripLayer.setAlignment(Pos.CENTER);

		tripLayer.prefWidthProperty().bind(stage.widthProperty());
		tripLayer.prefHeightProperty().bind(stage.heightProperty());
		tripLayer.setStyle("-fx-background-color: white;");
		tripLayer.getChildren().addAll(returnMenu(), layer);
		
		counterManager.tripCountManager(increase, decrease, mainLab);
		
		return tripLayer;
	}
	
	public StackPane strokeCatMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label("Cat");
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		StackPane strokeCatLayer = new StackPane();
		strokeCatLayer.setAlignment(Pos.CENTER);

		strokeCatLayer.prefWidthProperty().bind(stage.widthProperty());
		strokeCatLayer.prefHeightProperty().bind(stage.heightProperty());
		strokeCatLayer.setStyle("-fx-background-color: white;");
		strokeCatLayer.getChildren().addAll(returnMenu(), layer);
		
		counterManager.strokeCatCountManager(increase, decrease, mainLab);
		
		return strokeCatLayer;
	}
	
	public StackPane beatMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label("Beat");
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		StackPane beatLayer = new StackPane();
		beatLayer.setAlignment(Pos.CENTER);

		beatLayer.prefWidthProperty().bind(stage.widthProperty());
		beatLayer.prefHeightProperty().bind(stage.heightProperty());
		beatLayer.setStyle("-fx-background-color: white;");
		beatLayer.getChildren().addAll(returnMenu(), layer);
		
		counterManager.beatCountManager(increase, decrease, mainLab);
		
		return beatLayer;
	}
	
	public StackPane hugMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(20);
		layer.setHgap(20);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(200, 200);
		Label mainLab = new Label("Hug");
		
		Button increase = new Button("+");
		Button decrease = new Button("-");
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(increase, 0, 0);
		layer.add(decrease, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		StackPane hugLayer = new StackPane();
		hugLayer.setAlignment(Pos.CENTER);

		hugLayer.prefWidthProperty().bind(stage.widthProperty());
		hugLayer.prefHeightProperty().bind(stage.heightProperty());
		hugLayer.setStyle("-fx-background-color: white;");
		hugLayer.getChildren().addAll(returnMenu(), layer);
		
		counterManager.hugCountManager(increase, decrease, mainLab);
		
		return hugLayer;
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
		returnMainMenuLabel.setMouseTransparent(true);
		StackPane returnMainMenuPane = new StackPane();
		returnMainMenuPane.setAlignment(Pos.CENTER);
		returnMainMenuPane.setMaxWidth(StackPane.USE_PREF_SIZE);
		returnMainMenuPane.setMaxHeight(StackPane.USE_PREF_SIZE);

		StackPane.setAlignment(returnMainMenuPane, Pos.BOTTOM_RIGHT); 
		StackPane.setMargin(returnMainMenuPane, new Insets(20));

		returnMainMenuPane.getChildren().addAll(returnMainMenuButton, returnMainMenuLabel);
		
		returnMainMenuButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		returnMainMenuButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", returnMainMenuButton.heightProperty().divide(3).asString(), "px"));
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", returnMainMenuButton.widthProperty().divide(8).asString(), "px"));
		
		returnMainMenuButton.setOnAction(e -> switchScene(startApp()));
		
		return returnMainMenuPane;
	}
	
	private void showLayer(StackPane newLayer) {
        rootLayer.getChildren().add(newLayer);
    }

}