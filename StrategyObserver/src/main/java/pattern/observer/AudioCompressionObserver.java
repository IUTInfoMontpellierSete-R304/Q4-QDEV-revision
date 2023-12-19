package pattern.observer;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// Implémentation de l'interface pour l'observation des fichiers audio
public class AudioCompressionObserver implements DataCompressionObserver {
    @Override
    public void update(String fileName) {         // Créer un objet AudioInputStream à partir du fichier audio WAV
        // Code d'observation pour les audios
        if (fileName.contains("/wav/")) {
            LocalTime now = LocalTime.now();

            // Formater l'heure dans le format souhaité (hh:mm:ss)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String formattedTime = now.format(formatter);
            String content = formattedTime;


            System.out.println("-----------------------------------------------------------------------");
            System.out.println("Observation des audios...");

            content += " ::Fichier compressé : " + fileName;
            FileWriter.writeToFile("./data/compressed/wav/AudioCompressionObserver.txt", content);
            System.out.println("-----------------------------------------------------------------------");

        }
    }
}



