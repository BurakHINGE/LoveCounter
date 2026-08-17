package loveCounter;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class counterManager {

	public static void coffeeCountManager(Button increase, Button decrease, Label count) {
		
		increase.setOnMouseClicked(e -> {

            configManager.setCoffeeCount(configManager.getCoffeeCount() + 1);
            count.setText(String.valueOf(configManager.getCoffeeCount()));
        });
		decrease.setOnMouseClicked(e -> {

            configManager.setCoffeeCount(configManager.getCoffeeCount() - 1);
            count.setText(String.valueOf(configManager.getCoffeeCount()));
        });
	}
	
	public static void tripCountManager(Button increase, Button decrease, Label count) {
		
		increase.setOnMouseClicked(e -> {

            configManager.setTripCount(configManager.getTripCount() + 1);
            count.setText(String.valueOf(configManager.getTripCount()));
        });
		decrease.setOnMouseClicked(e -> {

            configManager.setTripCount(configManager.getTripCount() - 1);
            count.setText(String.valueOf(configManager.getTripCount()));
        });
	}

	public static void strokeCatCountManager(Button increase, Button decrease, Label count) {
	
		increase.setOnMouseClicked(e -> {

            configManager.setStrokeCatCount(configManager.getStrokeCatCount() + 1);
            count.setText(String.valueOf(configManager.getStrokeCatCount()));
        });
		decrease.setOnMouseClicked(e -> {

            configManager.setStrokeCatCount(configManager.getStrokeCatCount() - 1);
            count.setText(String.valueOf(configManager.getStrokeCatCount()));
        });
	}

	public static void beatCountManager(Button increase, Button decrease, Label count) {
	
		increase.setOnMouseClicked(e -> {

            configManager.setBeatCount(configManager.getBeatCount() + 1);
            count.setText(String.valueOf(configManager.getBeatCount()));
        });
		decrease.setOnMouseClicked(e -> {

			configManager.setBeatCount(configManager.getBeatCount() - 1);
            count.setText(String.valueOf(configManager.getBeatCount()));
        });
	}
	
	public static void hugCountManager(Button increase, Button decrease, Label count) {
		
		increase.setOnMouseClicked(e -> {

            configManager.setHugCount(configManager.getHugCount() + 1);
            count.setText(String.valueOf(configManager.getHugCount()));
        });
		decrease.setOnMouseClicked(e -> {

            configManager.setHugCount(configManager.getHugCount() - 1);
            count.setText(String.valueOf(configManager.getHugCount()));
        });
	}
	
	public static void waterCountManager(Button inc1, Button inc2, Button inc3, Button inc4, Button dec1, Button dec2, Button dec3, Button dec4, Label count) {
		
		inc1.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() + 100);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		dec1.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() - 100);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		inc2.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() + 200);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		dec2.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() - 200);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		inc3.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() + 500);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		dec3.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() - 500);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		inc4.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() + 1000);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
		dec4.setOnMouseClicked(e -> {

            configManager.setWaterCount(configManager.getWaterCount() - 1000);
            count.setText(String.valueOf(configManager.getWaterCount()));
        });
	}
}