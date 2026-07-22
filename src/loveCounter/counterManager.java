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

            configManager.setCoffeeCount(configManager.getBeatCount() - 1);
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
}