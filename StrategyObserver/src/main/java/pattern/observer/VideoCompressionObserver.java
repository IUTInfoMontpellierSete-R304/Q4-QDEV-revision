package pattern.observer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Implémentation de l'interface pour l'observation des vidéos
public class VideoCompressionObserver implements DataCompressionObserver {
    @Override
    public void update(String fileName) {
        // Code d'observation pour les videos
        if (fileName.contains("/mp4/")) {
            LocalTime now = LocalTime.now();


            // Formater l'heure dans le format souhaité (hh:mm:ss)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = now.format(formatter);
            String content = formattedTime;


            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Observation des audios...");

            content += " ::Fichier compressé : " + fileName;
            FileWriter.writeToFile("./data/compressed/mp4/VideoCompressionObserver.txt", content);
            System.out.println("-----------------------------------------------------------------------");
        }
    }
}
