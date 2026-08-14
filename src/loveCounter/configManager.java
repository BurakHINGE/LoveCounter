package loveCounter;

import java.io.File;
import java.util.Locale;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class configManager {

	public static int coffeeCount;
	public static int tripCount;
	public static int beatCount;
	public static int strokeCatCount;
	public static int hugCount;
	public static int waterCount;
	public static double dailyWaterAim;
	
	public void loadConfig() {
		try {
			
			File config = new File("data/config.txt");
			Scanner output = new Scanner(config);
			output.useLocale(Locale.US);
			
			while (output.hasNext()) {
				String configName = output.next();
				
				if (configName.equals("coffee_count:")) {
					coffeeCount = output.nextInt();
				}
				else if (configName.equals("trip_count:")) {
					tripCount = output.nextInt();
				}
				else if (configName.equals("beat_count:")) {
					beatCount = output.nextInt();
				}
				else if (configName.equals("stroke_cat_count:")) {
					strokeCatCount = output.nextInt();
				}
				else if (configName.equals("hug_count:")) {
					hugCount = output.nextInt();
				}
				else if (configName.equals("water_count:")) {
					waterCount = output.nextInt();
				}
				else if (configName.equals("daily_water_aim:")) {
					dailyWaterAim = output.nextDouble();
				}
			}
			System.out.println("config.txt başarıyla okundu.");
		}
		catch (FileNotFoundException e) {
			System.out.println("Warning: config.txt file cannot find! Please check the file path.");
		}
	}
	
	public static void saveConfig() {
        try {
        	
            FileWriter fileWriter = new FileWriter("data/config.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            
            printWriter.println("coffee_count: " + coffeeCount);
            printWriter.println("trip_count: " + tripCount);
            printWriter.println("beat_count: " + beatCount);
            printWriter.println("stroke_cat_count: " + strokeCatCount);
            printWriter.println("hug_count: " + hugCount);
            printWriter.println("water_count: " + waterCount);
            printWriter.println("daily_water_aim: " + dailyWaterAim);
            
            printWriter.close();
            System.out.println("Veriler config.txt dosyasına başarıyla kaydedildi.");
            
        } catch (IOException e) {
            System.out.println("Warning: config.txt file cannot write! Please check permissions.");
            e.printStackTrace();
        }
    }

	public static int getCoffeeCount() {
		return coffeeCount;
	}

	public static int getTripCount() {
		return tripCount;
	}

	public static int getBeatCount() {
		return beatCount;
	}

	public static int getStrokeCatCount() {
		return strokeCatCount;
	}

	public static int getHugCount() {
		return hugCount;
	}
	
	public static int getWaterCount() {
		return waterCount;
	}

	public static double getDailyWaterAim() {
		return dailyWaterAim;
	}
	
	public static void setCoffeeCount(int coffeeCount) {
		configManager.coffeeCount = coffeeCount;
	}

	public static void setTripCount(int tripCount) {
		configManager.tripCount = tripCount;
	}

	public static void setBeatCount(int beatCount) {
		configManager.beatCount = beatCount;
	}

	public static void setStrokeCatCount(int strokeCatCount) {
		configManager.strokeCatCount = strokeCatCount;
	}

	public static void setHugCount(int hugCount) {
		configManager.hugCount = hugCount;
	}
	
	public static void setWaterCount(int waterCount) {
		configManager.waterCount = waterCount;
	}
	
	public static void setDailyWaterAim(double dailyWaterAim) {
		configManager.dailyWaterAim = dailyWaterAim;
	}
}