package loveCounter;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class UpdateManager {
    
    // Uygulamanın o anki mevcut sürümü
    private static final String CURRENT_VERSION = "v1.0.1";
    
    // GitHub'da tutacağın basit metin dosyasının kalıcı (raw) linki
    // (Bunu birazdan birlikte ayarlayacağız, şimdilik böyle kalabilir)
    private static final String VERSION_URL = "https://raw.githubusercontent.com/BurakHINGE/LoveCounter/refs/heads/main/version.txt";

    public static void checkForUpdates() {
        // İnternet kontrolü uygulamanın açılışını dondurmasın diye arka planda (Thread) çalıştırıyoruz
        new Thread(() -> {
            try {
            	String noCacheUrl = VERSION_URL + "?t=" + System.currentTimeMillis();
                
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(noCacheUrl))
                        .build();

                // İnternetteki dosyayı oku
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String onlineVersion = response.body().trim();

                // Eğer internetteki versiyon, bizimkiyle aynı değilse güncellemeyi haber ver
                if (!onlineVersion.equals(CURRENT_VERSION) && !onlineVersion.isEmpty()) {
                    
                    // JavaFX arayüzüne dışarıdan müdahale etmek için Platform.runLater kullanılır
                    Platform.runLater(() -> showUpdateAlert(onlineVersion));
                }

            } catch (Exception e) {
                System.out.println("Güncelleme kontrolü başarısız oldu (İnternet olmayabilir veya link hatalı).");
            }
        }).start();
    }

    private static void showUpdateAlert(String newVersion) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Yeni Güncelleme Mevcut!");
        alert.setHeaderText("Sürpriz! Uygulamanın yeni bir versiyonu bulundu (" + newVersion + ")");
        alert.setContentText("Aşkım, senin için yeni özellikler ekledim. Hemen güncellensin mi?");

        // Butonları Türkçeleştirip özelleştiriyoruz
        ButtonType buttonYes = new ButtonType("Evet, Güncelle!");
        ButtonType buttonNo = new ButtonType("Daha Sonra");
        alert.getButtonTypes().setAll(buttonYes, buttonNo);

        // Kullanıcının neye bastığını dinliyoruz
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonYes) {
            System.out.println("Onay verildi! İndirme scripti tetiklenecek...");
            startUpdateProcess();
        }

    }
    
    private static void startUpdateProcess() {
        // İndirilecek güncel zip dosyasının DOĞRUDAN linki (Bunu ayarlayacağız)
    	String zipUrl = "https://github.com/BurakHINGE/LoveCounter/releases/latest/download/LoveCounter-Windows-Paketi.zip";
        
        try {
            // Arka planda çalışacak Windows scriptini (Bat) oluşturuyoruz
            File batFile = new java.io.File("guncelle.bat");
            PrintWriter writer = new java.io.PrintWriter(batFile);
            
            writer.println("@echo off");
            writer.println("echo Guncelleme indiriliyor, lutfen bekleyin...");
            // Java'nın kapanması için 2 saniye bekle
            writer.println("timeout /t 2 /nobreak > NUL"); 
            // Yeni zip dosyasını indir
            writer.println("curl -L -o guncelleme.zip \"" + zipUrl + "\""); 
            writer.println("echo Dosyalar cikariliyor...");
            // Zip dosyasını klasöre çıkart (eski dosyaların üzerine yazar)
            writer.println("tar -xf guncelleme.zip"); 
            writer.println("echo Guncelleme tamamlandi! Yeniden baslatiliyor...");
            // Kalıntıları temizle
            writer.println("del guncelleme.zip");
            // Uygulamayı tekrar başlat
            writer.println("start LoveCounter.bat"); 
            // Kendi kendini sil
            writer.println("del \"%~f0\""); 
            
            writer.close();

            // Oluşturduğumuz bat dosyasını çalıştır
            Runtime.getRuntime().exec("cmd /c start guncelle.bat");
            
            // Programı anında kapat!
            System.exit(0);
            
        } catch (Exception e) {
            System.out.println("Güncelleme scripti oluşturulamadı: " + e.getMessage());
        }
    }
}

