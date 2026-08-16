package loveCounter;

import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.Interpolator;
import javafx.util.Duration;
import javafx.beans.binding.DoubleBinding;
import java.time.LocalTime;

public class UIManager {

	private Stage stage;
	private StackPane rootLayer;
	private String customFontFamily = "System";
	
	public UIManager(Stage stage) {
        this.stage = stage;
        this.rootLayer = new StackPane();
        this.rootLayer.setStyle("-fx-background-color: #FFD1DC;");
        
        String fontPath = "file:resources/fonts/Minecraftia-Regular.ttf";

        try {
            Font loadedFont = Font.loadFont(fontPath, 14);
            if (loadedFont != null) {
                customFontFamily = loadedFont.getFamily();
                System.out.println("Font has been uploaded successfuly: " + customFontFamily);
            } else {
                System.out.println("Font cannot be found: " + fontPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public Scene startApp() {

        rootLayer.getChildren().add(createMainMenu());

        Scene mainScene = new Scene(rootLayer);
        mainScene.setFill(Color.web("#FFD1DC"));

        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");

        return mainScene;
    }
	
	public StackPane createMainMenu() {
		
		StackPane baseLayout = new StackPane();
		baseLayout.prefWidthProperty().bind(stage.widthProperty());
		baseLayout.prefHeightProperty().bind(stage.heightProperty());
		
		GridPane mainPane = new GridPane();
		mainPane.setAlignment(Pos.CENTER);
		mainPane.setHgap(40);
		mainPane.setVgap(40);
		
		baseLayout.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/mainMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		Button coffeeButton = new Button();
		Button tripButton = new Button();
		Button catButton = new Button();
		Button beatButton = new Button();
		Button hugButton = new Button();
		Button waterButton = new Button();
		Button exitButton = new Button();
		
		Label coffeeLabel = new Label("Coffee Counter");
		Label tripLabel = new Label("Trip Counter");
		Label catLabel = new Label("Cat Counter");
		Label beatLabel = new Label("Beat Counter");
		Label hugLabel = new Label("Hug Counter");
		Label waterLabel = new Label("Water Counter");
		Label exitLabel = new Label("Çıkış");
		
		StackPane coffeePane = new StackPane();
		StackPane tripPane = new StackPane();
		StackPane catPane = new StackPane();
		StackPane beatPane = new StackPane();
		StackPane hugPane = new StackPane();
		StackPane waterPane = new StackPane();
		StackPane exitPane = new StackPane();
		
		coffeePane.getChildren().addAll(coffeeButton, coffeeLabel);
		tripPane.getChildren().addAll(tripButton, tripLabel);
		catPane.getChildren().addAll(catButton, catLabel);
		beatPane.getChildren().addAll(beatButton, beatLabel);
		hugPane.getChildren().addAll(hugButton, hugLabel);
		waterPane.getChildren().addAll(waterButton, waterLabel);
		exitPane.getChildren().addAll(exitButton, exitLabel);
		
		mainPane.add(coffeePane, 0, 0);
		mainPane.add(tripPane, 1, 0);
		mainPane.add(catPane, 2, 0);
		mainPane.add(beatPane, 0, 1);
		mainPane.add(hugPane, 1, 1);
		mainPane.add(waterPane, 2, 1);
		
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
		exitLabel.setMouseTransparent(true);
		
		coffeeButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		tripButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		catButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		beatButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		hugButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		waterButton.prefWidthProperty().bind(stage.widthProperty().divide(6));
		exitButton.prefWidthProperty().bind(stage.widthProperty().divide(6));

        coffeeButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        tripButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        catButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        beatButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        hugButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        waterButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        exitButton.prefHeightProperty().bind(stage.heightProperty().divide(10));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", coffeeButton.heightProperty().divide(3).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", tripButton.heightProperty().divide(3).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", catButton.heightProperty().divide(3).asString(), "px"));
        beatLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", coffeeButton.heightProperty().divide(3).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", hugButton.heightProperty().divide(3).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", waterButton.heightProperty().divide(3).asString(), "px"));
        exitLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", exitButton.heightProperty().divide(3).asString(), "px"));
        
        coffeeLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", coffeeButton.widthProperty().divide(10).asString(), "px"));
        tripLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", tripButton.widthProperty().divide(10).asString(), "px"));
        catLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", catButton.widthProperty().divide(10).asString(), "px"));
        beatLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", catButton.widthProperty().divide(10).asString(), "px"));
        hugLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", hugButton.widthProperty().divide(10).asString(), "px"));
        waterLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", waterButton.widthProperty().divide(10).asString(), "px"));
        exitLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", exitButton.widthProperty().divide(10).asString(), "px"));
		
        applyCountButtonStyle(coffeeButton, coffeeLabel, 8);
        applyCountButtonStyle(tripButton, tripLabel, 8);
        applyCountButtonStyle(catButton, catLabel, 8);
        applyCountButtonStyle(beatButton, beatLabel, 8);
        applyCountButtonStyle(hugButton, hugLabel, 8);
        applyCountButtonStyle(waterButton, waterLabel, 8);
        applyButton74Style(exitButton, exitLabel);

        StackPane.setMargin(exitLabel, new Insets(15, 0, 0, 0));
        
        Label timeLabel = new Label();

        timeLabel.styleProperty().bind(Bindings.concat(
            "-fx-text-fill: #422800; -fx-font-weight: bold; ",
            "-fx-font-family: '", customFontFamily, "'; -fx-font-size: 32px;"
        ));

        timeLabel.setTranslateY(18); 

        StackPane timePane = new StackPane(timeLabel);
        timePane.setStyle(
            "-fx-background-color: #fbeee0; -fx-border-color: #422800; -fx-border-width: 2px; " +
            "-fx-border-radius: 12px; -fx-background-radius: 12px;"
        );

        timePane.setPadding(new Insets(0, 15, 0, 15));
        timePane.setMaxHeight(45);
        timePane.setMaxWidth(StackPane.USE_PREF_SIZE);    
        
        StackPane.setAlignment(timePane, Pos.TOP_RIGHT);
        StackPane.setMargin(timePane, new Insets(40, 40, 0, 0));
        timePane.setPickOnBounds(false);

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime time = LocalTime.now();
            timeLabel.setText(String.format("%02d:%02d:%02d", time.getHour(), time.getMinute(), time.getSecond()));
        }), new KeyFrame(Duration.seconds(1)));
        
        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
        
		coffeeButton.setOnAction(e -> showLayer(coffeeMenu()));
		tripButton.setOnAction(e -> showLayer(tripMenu()));
		catButton.setOnAction(e -> showLayer(strokeCatMenu()));
		beatButton.setOnAction(e -> showLayer(beatMenu()));
		hugButton.setOnAction(e -> showLayer(hugMenu()));
		waterButton.setOnAction(e -> showLayer(waterMenu()));
		exitButton.setOnAction(e -> {
		    configManager.saveConfig();
		    System.exit(0);
		});
		
		stage.setFullScreen(true);
		stage.setFullScreenExitHint("");
		
		baseLayout.getChildren().addAll(mainPane, exitPane, timePane);
		
		return baseLayout;
	}
	
	public StackPane coffeeMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(75);
		layer.setHgap(75);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(300, 300);
		Label mainLab = new Label(""+configManager.getCoffeeCount());
		
		Label coffeeLab = new Label("Coffee Counter");
		coffeeLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(coffeeLab, Pos.TOP_CENTER);
		coffeeLab.setPadding(new Insets(175, 0, 0, 0));
		
		Button increase = new Button();
		Button decrease = new Button();
		
		Label incLabel = new Label("+");
		Label decLabel = new Label("-");
		
		incLabel.setMouseTransparent(true);
		decLabel.setMouseTransparent(true);
		
		StackPane incPane = new StackPane();
		StackPane decPane = new StackPane();
		
		incPane.getChildren().addAll(increase, incLabel);
		decPane.getChildren().addAll(decrease, decLabel);
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		applyCountButtonStyle(increase, incLabel, 8);
		applyCountButtonStyle(decrease, decLabel, 8);
		
		applyRectangleStyle(mainRec);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(incPane, 0, 0);
		layer.add(decPane, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		incLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(4).asString(), "px"));
		decLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(4).asString(), "px"));
		mainLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", mainRec.widthProperty().divide(4).asString(), "px"));
		mainLab.setTranslateY(30);
		
		StackPane coffeeLayer = new StackPane();
		coffeeLayer.setAlignment(Pos.CENTER);
		coffeeLayer.prefWidthProperty().bind(stage.widthProperty());
		coffeeLayer.prefHeightProperty().bind(stage.heightProperty());

		coffeeLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/coffeeMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);

		coffeeLayer.getChildren().addAll(returnMenu(), layer, coffeeLab);
		
		counterManager.coffeeCountManager(increase, decrease, mainLab);
		
		return coffeeLayer;
	}
	
	public StackPane tripMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(75);
		layer.setHgap(75);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(300, 300);
		Label mainLab = new Label(""+configManager.getTripCount());
		
		Label tripLab = new Label("Trip Counter");
		tripLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(tripLab, Pos.TOP_CENTER);
		tripLab.setPadding(new Insets(175, 0, 0, 0));
		
		Button increase = new Button();
		Button decrease = new Button();
		
		Label incLabel = new Label("+");
		Label decLabel = new Label("-");
		
		incLabel.setMouseTransparent(true);
		decLabel.setMouseTransparent(true);
		
		StackPane incPane = new StackPane();
		StackPane decPane = new StackPane();
		
		incPane.getChildren().addAll(increase, incLabel);
		decPane.getChildren().addAll(decrease, decLabel);
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		applyCountButtonStyle(increase, incLabel, 8);
		applyCountButtonStyle(decrease, decLabel, 8);
		
		applyRectangleStyle(mainRec);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(incPane, 0, 0);
		layer.add(decPane, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		incLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(4).asString(), "px"));
		decLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(4).asString(), "px"));
		mainLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", mainRec.widthProperty().divide(4).asString(), "px"));
		mainLab.setTranslateY(30);
		
		StackPane tripLayer = new StackPane();
		tripLayer.setAlignment(Pos.CENTER);

		tripLayer.prefWidthProperty().bind(stage.widthProperty());
		tripLayer.prefHeightProperty().bind(stage.heightProperty());
		
		tripLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/tripMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		tripLayer.getChildren().addAll(returnMenu(), layer, tripLab);
		
		counterManager.tripCountManager(increase, decrease, mainLab);
		
		return tripLayer;
	}
	
	public StackPane strokeCatMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(75);
		layer.setHgap(75);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(300, 300);
		Label mainLab = new Label(""+configManager.getStrokeCatCount());
		
		Label strokeCatLab = new Label("Cat Counter");
		strokeCatLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(strokeCatLab, Pos.TOP_CENTER);
		strokeCatLab.setPadding(new Insets(175, 0, 0, 0));
		
		Button increase = new Button();
		Button decrease = new Button();
		
		Label incLabel = new Label("+");
		Label decLabel = new Label("-");
		
		incLabel.setMouseTransparent(true);
		decLabel.setMouseTransparent(true);
		
		StackPane incPane = new StackPane();
		StackPane decPane = new StackPane();
		
		incPane.getChildren().addAll(increase, incLabel);
		decPane.getChildren().addAll(decrease, decLabel);
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		applyCountButtonStyle(increase, incLabel, 8);
		applyCountButtonStyle(decrease, decLabel, 8);
		
		applyRectangleStyle(mainRec);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(incPane, 0, 0);
		layer.add(decPane, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		incLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(4).asString(), "px"));
		decLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(4).asString(), "px"));
		mainLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", mainRec.widthProperty().divide(4).asString(), "px"));
		mainLab.setTranslateY(30);
		
		StackPane strokeCatLayer = new StackPane();
		strokeCatLayer.setAlignment(Pos.CENTER);

		strokeCatLayer.prefWidthProperty().bind(stage.widthProperty());
		strokeCatLayer.prefHeightProperty().bind(stage.heightProperty());
		
		strokeCatLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/catMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		strokeCatLayer.getChildren().addAll(returnMenu(), layer, strokeCatLab);
		
		counterManager.strokeCatCountManager(increase, decrease, mainLab);
		
		return strokeCatLayer;
	}
	
	public StackPane beatMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(75);
		layer.setHgap(75);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(300, 300);
		Label mainLab = new Label(""+configManager.getBeatCount());
		
		Label beatLab = new Label("Beat Counter");
		beatLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(beatLab, Pos.TOP_CENTER);
		beatLab.setPadding(new Insets(175, 0, 0, 0));
		
		Button increase = new Button();
		Button decrease = new Button();
		
		Label incLabel = new Label("+");
		Label decLabel = new Label("-");
		
		incLabel.setMouseTransparent(true);
		decLabel.setMouseTransparent(true);
		
		StackPane incPane = new StackPane();
		StackPane decPane = new StackPane();
		
		incPane.getChildren().addAll(increase, incLabel);
		decPane.getChildren().addAll(decrease, decLabel);
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		applyCountButtonStyle(increase, incLabel, 8);
		applyCountButtonStyle(decrease, decLabel, 8);
		
		applyRectangleStyle(mainRec);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(incPane, 0, 0);
		layer.add(decPane, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		incLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(4).asString(), "px"));
		decLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(4).asString(), "px"));
		mainLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", mainRec.widthProperty().divide(4).asString(), "px"));
		mainLab.setTranslateY(30);
		
		StackPane beatLayer = new StackPane();
		beatLayer.setAlignment(Pos.CENTER);

		beatLayer.prefWidthProperty().bind(stage.widthProperty());
		beatLayer.prefHeightProperty().bind(stage.heightProperty());
		beatLayer.setStyle("-fx-background-color: #FFD1DC;");
		
		beatLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/beatMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		beatLayer.getChildren().addAll(returnMenu(), layer, beatLab);
		
		counterManager.beatCountManager(increase, decrease, mainLab);
		
		return beatLayer;
	}
	
	public StackPane hugMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(75);
		layer.setHgap(75);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Rectangle mainRec = new Rectangle(300, 300);
		Label mainLab = new Label(""+configManager.getHugCount());
		
		Label hugLab = new Label("Hug Counter");
		hugLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(hugLab, Pos.TOP_CENTER);
		hugLab.setPadding(new Insets(175, 0, 0, 0));
		
		Button increase = new Button();
		Button decrease = new Button();
		
		Label incLabel = new Label("+");
		Label decLabel = new Label("-");
		
		incLabel.setMouseTransparent(true);
		decLabel.setMouseTransparent(true);
		
		StackPane incPane = new StackPane();
		StackPane decPane = new StackPane();
		
		incPane.getChildren().addAll(increase, incLabel);
		decPane.getChildren().addAll(decrease, decLabel);
		
		setButtonSizes(increase);
		setButtonSizes(decrease);
		
		applyCountButtonStyle(increase, incLabel, 8);
		applyCountButtonStyle(decrease, decLabel, 8);
		
		applyRectangleStyle(mainRec);
		
		mainLayout.getChildren().addAll(mainRec, mainLab);
		
		layer.add(incPane, 0, 0);
		layer.add(decPane, 2, 0);
		layer.add(mainLayout, 1, 0);
		
		incLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(4).asString(), "px"));
		decLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(4).asString(), "px"));
		mainLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", mainRec.widthProperty().divide(4).asString(), "px"));
		mainLab.setTranslateY(30);
		
		StackPane hugLayer = new StackPane();
		hugLayer.setAlignment(Pos.CENTER);

		hugLayer.prefWidthProperty().bind(stage.widthProperty());
		hugLayer.prefHeightProperty().bind(stage.heightProperty());
		
		hugLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/hugMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		hugLayer.getChildren().addAll(returnMenu(), layer, hugLab);
		
		counterManager.hugCountManager(increase, decrease, mainLab);
		
		return hugLayer;
	}
	
	public StackPane waterMenu() {
		
		GridPane layer = new GridPane();
		layer.setVgap(10);
		layer.setHgap(100);
		layer.setAlignment(Pos.CENTER);
		layer.setPickOnBounds(false);
		
		StackPane mainLayout = new StackPane();
		Label mainLab = new Label(""+configManager.getWaterCount());
		
		Label waterLab = new Label("Water Counter");
		waterLab.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", "48px"));
		StackPane.setAlignment(waterLab, Pos.TOP_CENTER);
		waterLab.setPadding(new Insets(175, 0, 0, 0));
		
		double baslangicHedefi = configManager.getDailyWaterAim();
		if (baslangicHedefi <= 0) {
		    baslangicHedefi = 2000.0;
		    configManager.setDailyWaterAim(2000.0); // Config'i de düzeltiyoruz
		}
		
		TextField aimInfo = new TextField();
		aimInfo.setText(String.valueOf(baslangicHedefi));
		aimInfo.setMaxWidth(80); // Kutunun genişliğini kısıtlıyoruz ki çok uzun olmasın
		aimInfo.setAlignment(Pos.CENTER); // Yazıyı ortalıyoruz
		aimInfo.setStyle("-fx-background-color: #ffffff; -fx-border-color: #b18597; -fx-border-width: 2px; -fx-border-radius: 10px; -fx-background-radius: 10px; -fx-font-weight: bold;");
		aimInfo.setTranslateY(-150);

		// Dinleyici: Kutudaki yazı her değiştiğinde tetiklenir
		aimInfo.textProperty().addListener((observable, oldValue, newValue) -> {
		    // Hem rakamlara hem de tek bir ondalık noktaya izin veren Regex kuralı
		    if (!newValue.matches("\\d*(\\.\\d*)?")) {
		        // Eğer geçersiz harf vs. girilirse, sadece rakam ve noktayı bırak
		        aimInfo.setText(newValue.replaceAll("[^\\d.]", ""));
		    } else if (!newValue.isEmpty() && !newValue.equals(".")) {
		        // Kutu tamamen boş değilse ve sadece "." girilmediyse config'i anında güncelle
		        configManager.setDailyWaterAim(Double.parseDouble(newValue));
		    }
		});

		// Bardağın Dış Çerçevesi
		Polygon glass = new Polygon(0.0, 0.0, 300.0, 0.0, 225.0, 400.0, 75.0, 400.0);
		glass.setFill(Color.web("#ffffff", 0.1));
		glass.setStroke(Color.web("#b18597"));
		glass.setStrokeWidth(3);

		// Suyun ve Maskenin Doğru Sıralaması
		Rectangle waterMask = new Rectangle(300, 400);
		Polygon water = new Polygon(0.0, 0.0, 300.0, 0.0, 225.0, 400.0, 75.0, 400.0);
		water.setFill(Color.web("#82c4ff"));
		water.setClip(waterMask);

		// GÜNCELLENMİŞ BINDING: Artık hem içilen suyu hem de hedefi dinliyor
		DoubleBinding targetYBinding = Bindings.createDoubleBinding(() -> {
		    try {
		        String temizSuMetni = mainLab.getText().replaceAll("[^\\d.]", "");
		        double availableWater = temizSuMetni.isEmpty() ? 0.0 : Double.parseDouble(temizSuMetni);
		        
		        double currentAim = aimInfo.getText().isEmpty() ? 1.0 : Double.parseDouble(aimInfo.getText());
		        if (currentAim == 0) currentAim = 1.0; 

		        double newYCoordinate = 400 - ((availableWater / currentAim) * 400);
		        return Math.max(0.0, newYCoordinate); 
		        
		    } catch (Exception e) {
		        return 400.0; 
		    }
		}, mainLab.textProperty(), aimInfo.textProperty());

		// 2. İLK AÇILIŞ: Menüye ilk girildiğinde su anında doğru hizada başlasın (Açılışta anlamsız animasyon olmasın)
		waterMask.setTranslateY(targetYBinding.get());

		// 3. ANİMASYON TETİKLEYİCİSİ: Hedef veya İçilen Su değiştiğinde animasyonu başlat
		targetYBinding.addListener((observable, oldValue, newValue) -> {
		    Timeline timeline = new Timeline();
		    
		    // KeyValue: Hangi özellik değişecek (translateY), Hangi değere gidecek (newValue), Nasıl gidecek (Yumuşak - EASE_BOTH)
		    KeyValue kv = new KeyValue(waterMask.translateYProperty(), newValue, Interpolator.EASE_BOTH);
		    
		    // KeyFrame: Bu değişim ne kadar sürecek? (500 milisaniye yani yarım saniye)
		    KeyFrame kf = new KeyFrame(Duration.millis(1000), kv);
		    
		    timeline.getKeyFrames().add(kf);
		    timeline.play(); // Animasyonu oynat!
		});
		
		StackPane plusPane = new StackPane();
		StackPane miniusPane = new StackPane();
		
		Rectangle increase = new Rectangle(150, 50);
		Rectangle decrease = new Rectangle(150, 50);
		
		applyRectangleStyle(increase);
		applyRectangleStyle(decrease);
		
		Label plus = new Label("+");
		Label minius = new Label("-");
		
		plusPane.getChildren().addAll(increase, plus);
		miniusPane.getChildren().addAll(decrease, minius);
		
		Button incml100 = new Button();
		Button incml200 = new Button();
		Button incml500 = new Button();
		Button incl1 = new Button();
		
		Button decml100 = new Button();
		Button decml200 = new Button();
		Button decml500 = new Button();
		Button decl1 = new Button();
		
		Label incLml100 = new Label("100 ml");
		Label incLml200 = new Label("200 ml");
		Label incLml500 = new Label("500 ml");
		Label incLl1 = new Label("1 L");
		
		Label decLml100 = new Label("100 ml");
		Label decLml200 = new Label("200 ml");
		Label decLml500 = new Label("500 ml");
		Label decLl1 = new Label("1 L");
		
		StackPane plusPane100 = new StackPane();
		StackPane plusPane200 = new StackPane();
		StackPane plusPane500 = new StackPane();
		StackPane plusPane1 = new StackPane();
		
		StackPane miniusPane100 = new StackPane();
		StackPane miniusPane200 = new StackPane();
		StackPane miniusPane500 = new StackPane();
		StackPane miniusPane1 = new StackPane();
		
		plusPane100.getChildren().addAll(incml100, incLml100);
		plusPane200.getChildren().addAll(incml200, incLml200);
		plusPane500.getChildren().addAll(incml500, incLml500);
		plusPane1.getChildren().addAll(incl1, incLl1);
		miniusPane100.getChildren().addAll(decml100, decLml100);
		miniusPane200.getChildren().addAll(decml200, decLml200);
		miniusPane500.getChildren().addAll(decml500, decLml500);
		miniusPane1.getChildren().addAll(decl1, decLl1);
		
		VBox pBox = new VBox(20);
		VBox mBox = new VBox(20);
		
		pBox.getChildren().addAll(plusPane, plusPane100, plusPane200,plusPane500, plusPane1);
		mBox.getChildren().addAll(miniusPane, miniusPane100, miniusPane200, miniusPane500, miniusPane1);
		
		incLml100.setMouseTransparent(true);
		incLml200.setMouseTransparent(true);
		incLml500.setMouseTransparent(true);
		incLl1.setMouseTransparent(true);
		decLml100.setMouseTransparent(true);
		decLml200.setMouseTransparent(true);
		decLml500.setMouseTransparent(true);
		decLl1.setMouseTransparent(true);
		
		
		setButtonSizes(incml100);
		setButtonSizes(incml200);
		setButtonSizes(incml500);
		setButtonSizes(incl1);
		setButtonSizes(decml100);
		setButtonSizes(decml200);
		setButtonSizes(decml500);
		setButtonSizes(decl1);
		
		applyCountButtonStyle(incml100, incLml100, 15);
		applyCountButtonStyle(incml200, incLml200, 15);
		applyCountButtonStyle(incml500, incLml500, 15);
		applyCountButtonStyle(incl1, incLl1, 15);
		applyCountButtonStyle(decml100, decLml100, 15);
		applyCountButtonStyle(decml200, decLml200, 15);
		applyCountButtonStyle(decml500, decLml500, 15);
		applyCountButtonStyle(decl1, decLl1, 15);
		
		mainLayout.getChildren().addAll(water, glass, mainLab, aimInfo);
		
		layer.add(pBox, 0, 0);
		layer.add(mBox, 2, 0);
		layer.add(mainLayout, 1, 0);
	
		plus.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", increase.heightProperty().divide(2).asString(), "px"));
		minius.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decrease.heightProperty().divide(2).asString(), "px"));
		incLml100.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", incml100.heightProperty().divide(4).asString(), "px"));
		incLml200.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", incml200.heightProperty().divide(4).asString(), "px"));
		incLml500.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", incml500.heightProperty().divide(4).asString(), "px"));
		incLl1.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", incl1.heightProperty().divide(4).asString(), "px"));
		decLml100.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decml100.heightProperty().divide(4).asString(), "px"));
		decLml200.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decml200.heightProperty().divide(4).asString(), "px"));
		decLml500.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decml500.heightProperty().divide(4).asString(), "px"));
		decLl1.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", decl1.heightProperty().divide(4).asString(), "px"));
		plus.setTranslateY(12);
		minius.setTranslateY(12);
		mainLab.setTranslateY(30);
		glass.setTranslateY(50);
		water.setTranslateY(50);
		
		StackPane waterLayer = new StackPane();
		waterLayer.setAlignment(Pos.CENTER);
		waterLayer.prefWidthProperty().bind(stage.widthProperty());
		waterLayer.prefHeightProperty().bind(stage.heightProperty());
		
		waterLayer.setStyle(
			    "-fx-background-color: #FFD1DC; " +
			    "-fx-background-image: url('file:resources/pictures/waterMenuBackground.png'); " +
			    "-fx-background-size: cover; " +
			    "-fx-background-position: center;"
			);
		
		waterLayer.getChildren().addAll(returnMenu(), layer, waterLab);
		
		counterManager.waterCountManager(incml100, incml200, incml500, incl1, decml100, decml200, decml500, decl1, mainLab);
		
		return waterLayer;
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
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", returnMainMenuButton.heightProperty().divide(3).asString(), "px"));
		returnMainMenuLabel.styleProperty().bind(Bindings.concat("-fx-font-family: '", customFontFamily,"'; -fx-font-size: ", returnMainMenuButton.widthProperty().divide(8).asString(), "px"));
		applyButton74Style(returnMainMenuButton, returnMainMenuLabel);
		StackPane.setMargin(returnMainMenuLabel, new Insets(20, 0, 0, 0));
		
		configManager.saveConfig();
		returnMainMenuButton.setOnAction(e -> {
		    configManager.saveConfig();
		    switchScene(startApp());
		});

		
		return returnMainMenuPane;
	}
	
	private void showLayer(StackPane newLayer) {
        rootLayer.getChildren().add(newLayer);
    }
	
	private void applyRetroStyle(Button button) {

	    String defaultStyle = "-fx-background-color: #E8F5E9; " +
	                          "-fx-border-color: #E91E63; " +
	                          "-fx-border-width: 3px; " +
	                          "-fx-text-fill: #E91E63; " +
	                          "-fx-font-weight: bold; " +
	                          "-fx-cursor: hand;";
	                          
	    String hoverStyle = "-fx-background-color: #FFFFFF; " +
	                        "-fx-border-color: #E91E63; " +
	                        "-fx-border-width: 3px; " +
	                        "-fx-text-fill: #E91E63; " +
	                        "-fx-font-weight: bold; " +
	                        "-fx-cursor: hand;";

	    button.setStyle(defaultStyle);
	    
	    DropShadow shadow = new DropShadow();
	    shadow.setRadius(0); // Bulanıklık 0
	    shadow.setOffsetX(6); // Sağa doğru 6 piksel gölge
	    shadow.setOffsetY(6); // Aşağı doğru 6 piksel gölge
	    shadow.setColor(Color.web("#E91E63")); // Gölge rengi
	    
	    button.setEffect(shadow);

	    // 3. Fare ile üzerine gelme (Hover) olayı
	    button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
	    button.setOnMouseExited(e -> button.setStyle(defaultStyle));

	    // 4. Tıklanma (Basılma) olayı
	    button.setOnMousePressed(e -> {
	        // Butonu aşağı ve sağa kaydır
	        button.setTranslateX(3);
	        button.setTranslateY(3);
	        // Gölgeyi küçült ki buton zemine yaklaşmış gibi görünsün
	        shadow.setOffsetX(3);
	        shadow.setOffsetY(3);
	    });

	    button.setOnMouseReleased(e -> {
	        // Butonu ve gölgeyi eski haline getir
	        button.setTranslateX(0);
	        button.setTranslateY(0);
	        shadow.setOffsetX(6);
	        shadow.setOffsetY(6);
	    });
	}

	private void applyButton74Style(Button button, Label label) {
	    String defaultStyle = "-fx-background-color: #fbeee0; " +
	                          "-fx-border-color: #422800; " +
	                          "-fx-border-width: 2px; " +
	                          "-fx-border-radius: 30px; " +
	                          "-fx-background-radius: 30px; " +
	                          "-fx-text-fill: #422800; " +
	                          "-fx-font-family: '" + customFontFamily + "'; " + 
	                          "-fx-font-weight: bold; " +
	                          "-fx-font-size: 18px; " +
	                          "-fx-cursor: hand;";
	                          
	    String hoverStyle =   "-fx-background-color: #ffffff; " +
	                          "-fx-border-color: #422800; " +
	                          "-fx-border-width: 2px; " +
	                          "-fx-border-radius: 30px; " +
	                          "-fx-background-radius: 30px; " +
	                          "-fx-text-fill: #422800; " +
	                          "-fx-font-family: '" + customFontFamily + "'; " + 
	                          "-fx-font-weight: bold; " +
	                          "-fx-font-size: 18px; " +
	                          "-fx-cursor: hand;";

	    button.setStyle(defaultStyle);
	    
	    DropShadow shadow = new DropShadow();
	    shadow.setRadius(0);
	    shadow.setOffsetX(4); 
	    shadow.setOffsetY(4); 
	    shadow.setColor(Color.web("#422800")); 
	    
	    button.setEffect(shadow);

	    // Çıkış butonu için de aynı font düzeltmesi
	    int fontOffset = 4;
	    label.setTranslateY(fontOffset);

	    button.setOnMouseEntered(e -> button.setStyle(hoverStyle));
	    
	    button.setOnMouseExited(e -> button.setStyle(defaultStyle));

	    button.setOnMousePressed(e -> {
	        button.setTranslateX(2);
	        button.setTranslateY(2);
	        label.setTranslateX(2); 
	        label.setTranslateY(2 + fontOffset); 
	        shadow.setOffsetX(2);
	        shadow.setOffsetY(2);
	    });

	    button.setOnMouseReleased(e -> {
	        button.setTranslateX(0);
	        button.setTranslateY(0);
	        label.setTranslateX(0);
	        label.setTranslateY(fontOffset); // Eski konumuna dönmesi için
	        shadow.setOffsetX(4);
	        shadow.setOffsetY(4);
	    });
	}


	private void applyCountButtonStyle(Button button, Label label, double fontOffset) {
	    String defaultStyle = "-fx-background-color: #fff0f0; " +
	                          "-fx-border-color: #b18597; " +
	                          "-fx-border-width: 2px; " +
	                          "-fx-border-radius: 12px; " +
	                          "-fx-background-radius: 12px; " +
	                          "-fx-text-fill: #382b22; " +
	                          "-fx-font-weight: bold; " +
	                          "-fx-font-size: 15px; " +
	                          "-fx-padding: 12 25 12 25; " +
	                          "-fx-cursor: hand;";
	                          
	    String hoverStyle =   "-fx-background-color: #ffe9e9; " +
	                          "-fx-border-color: #b18597; " +
	                          "-fx-border-width: 2px; " +
	                          "-fx-border-radius: 12px; " +
	                          "-fx-background-radius: 12px; " +
	                          "-fx-text-fill: #382b22; " +
	                          "-fx-font-weight: bold; " +
	                          "-fx-font-size: 15px; " +
	                          "-fx-padding: 12 25 12 25; " +
	                          "-fx-cursor: hand;";

	    button.setStyle(defaultStyle);

	    // Sorunu çözen kısım: Çift gölge yerine tek, net bir DropShadow 
	    DropShadow buttonShadow = new DropShadow();
	    buttonShadow.setRadius(0); // Bulanıklık yok, keskin hatlar
	    buttonShadow.setOffsetX(0);
	    buttonShadow.setOffsetY(10); // Butonun 3D derinliği
	    buttonShadow.setColor(Color.web("#b18597")); // Çerçeveyle aynı koyu pembe renk
	    
	    button.setEffect(buttonShadow);

	    label.setTranslateY(fontOffset);

	    button.setOnMouseEntered(e -> {
	        button.setStyle(hoverStyle);
	        button.setTranslateY(2);
	        label.setTranslateY(2 + fontOffset); 
	        buttonShadow.setOffsetY(8);
	    });

	    button.setOnMouseExited(e -> {
	        button.setStyle(defaultStyle);
	        button.setTranslateY(0);
	        label.setTranslateY(fontOffset); 
	        buttonShadow.setOffsetY(10);
	    });

	    button.setOnMousePressed(e -> {
	        button.setStyle(hoverStyle);
	        button.setTranslateY(10);
	        label.setTranslateY(10 + fontOffset);
	        buttonShadow.setOffsetY(0); // Basılınca gölge sıfırlanıp zemine oturuyor
	    });

	    button.setOnMouseReleased(e -> {
	        button.setTranslateY(2);
	        label.setTranslateY(2 + fontOffset);
	        buttonShadow.setOffsetY(8);
	    });
	}


	
	private void applyRectangleStyle(Rectangle rect) {
	    // 1. Arka Plan Gradient (Doğrusal Renk Geçişi)
	    LinearGradient gradient = new LinearGradient(
	            0, 0, 1, 1, true, CycleMethod.NO_CYCLE,
	            new Stop(0, Color.web("#ffe6e9")),
	            new Stop(1, Color.web("#ffb3c1"))
	    );
	    rect.setFill(gradient);

	    // 2. Köşe Yuvarlatma 
	    rect.setArcWidth(50);
	    rect.setArcHeight(50);

	    // 3. Çerçeve (Border)
	    rect.setStroke(Color.web("#ff8fa3"));
	    rect.setStrokeWidth(2);

	    // 4. Gölge Efekti (DropShadow)
	    DropShadow dropShadow = new DropShadow();
	    dropShadow.setBlurType(BlurType.THREE_PASS_BOX);
	    dropShadow.setColor(Color.web("rgba(255, 143, 163, 0.4)"));
	    dropShadow.setRadius(15);
	    dropShadow.setOffsetX(0);
	    dropShadow.setOffsetY(8);
	    rect.setEffect(dropShadow);
	}

}