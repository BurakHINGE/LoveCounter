package loveCounter;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.time.LocalTime;
import java.util.function.Consumer;

public class WaterReminderManager {
    
    // Her dilim için ayrı bayraklar
    private boolean afternoonReminderSent = false;
    private boolean eveningReminderSent = false;
    private boolean nightReminderSent = false;
    
    // Mesajı UI tarafına iletmek için kullanacağımız köprü
    private Consumer<String> reminderAction;

    // Kurucu metot (Constructor)
    public WaterReminderManager(Consumer<String> reminderAction) {
        this.reminderAction = reminderAction;
    }

    public void startWaterCheckTimer() {
        // Döngüsel asıl kontrol (Her 30 dakikada bir çalışır)
        Timeline timeline = new Timeline(
            new KeyFrame(Duration.minutes(30), event -> checkWaterStatus())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        // DÜZELTİLEN KISIM: İlk açılış kontrolünü anında değil, 
        // uygulama ekrana geldikten 2 saniye sonra yap!
        Timeline initialDelay = new Timeline(
            new KeyFrame(Duration.seconds(2), event -> checkWaterStatus())
        );
        initialDelay.play();
    }


    private void checkWaterStatus() {
        LocalTime now = LocalTime.now();
        
        // Gece yarısı (00:00 - 00:30 arası) yeni gün için tüm bayrakları sıfırla
        if (now.getHour() == 0 && now.getMinute() < 30) {
            afternoonReminderSent = false;
            eveningReminderSent = false;
            nightReminderSent = false;
        }

        // Sıfıra bölünme hatasını önlemek için güvenlik kontrolü
        double dailyAim = configManager.getDailyWaterAim();
        if (dailyAim <= 0) dailyAim = 2000.0; 
        
        double percentage = (configManager.getWaterCount() / dailyAim) * 100;
        // 1. DİLİM: 14:00 - 18:00 (Hedef en az %50)
        if (now.isAfter(LocalTime.of(14, 0)) && now.isBefore(LocalTime.of(18, 0))) {
            if (percentage < 30.0 && !afternoonReminderSent) {
                showReminderMessage("Bol su içmeyi unutma aşkımmm️");
                afternoonReminderSent = true; 
            }
        }
        // 2. DİLİM: 18:00 - 22:00 (Hedef en az %80)
        if (now.isAfter(LocalTime.of(18, 0)) && now.isBefore(LocalTime.of(22, 0))) {
            if (percentage < 60.0 && !eveningReminderSent) {
                showReminderMessage("Akşam oldu ama su içmeyi unuttuk sanki, vücudunu susuz bırakma prenses️");
                eveningReminderSent = true;
            }
        }
        // 3. DİLİM: 22:00 - 23:59 (Hedef %100 - Uyku öncesi)
        if (now.isAfter(LocalTime.of(22, 0)) && now.isBefore(LocalTime.of(23, 59))) {
            if (percentage < 100.0 && !nightReminderSent) {
                showReminderMessage("Uyumadan önce biraz su içip bugünkü hedefini tamamlamaya ne dersin aşkım?️");
                nightReminderSent = true;
            }
        }
    }

    private void showReminderMessage(String message) {
        if (reminderAction != null) {
            reminderAction.accept(message); // UIManager'daki kayan kutu animasyonunu tetikler
        }
    }
}