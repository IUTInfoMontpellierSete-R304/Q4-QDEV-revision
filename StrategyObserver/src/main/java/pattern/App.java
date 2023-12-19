package pattern;

import pattern.observer.*;
import pattern.strategy.AudioCompressionStrategy;
import pattern.strategy.DataCompressionStrategy;
import pattern.strategy.ImageCompressionStrategy;
import pattern.strategy.VideoCompressionStrategy;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class App {


    public static void main(String[] args) throws IOException {
        // Vider les dossiers avec les contenus compressés
        File compressionImageFolder = new File("./data/compressed/jpg");
        File compressionAudioFolder = new File("./data/compressed/wav");
        File compressionVideoFolder = new File("./data/compressed/mp4");
        FileWriter.clearFolder(compressionImageFolder);
        FileWriter.clearFolder(compressionAudioFolder);
        FileWriter.clearFolder(compressionVideoFolder);


        // Création des données à traiter
        ArrayList<ImageData> imageList = new ArrayList<>();
        ArrayList<AudioData> audioList = new ArrayList<>();
        ArrayList<VideoData> videoList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            imageList.add(new ImageData(new File("./data/jpg/image" + i + ".jpg")));
            audioList.add(new AudioData(new File("./data/wav/audio" + i + ".wav")));
            videoList.add(new VideoData(new File("./data/mp4/video" + i + ".mp4")));
        }
        // Création des stratégies de traitement
        DataCompressionStrategy imageStrategy = new ImageCompressionStrategy();
        DataCompressionStrategy soundStrategy = new AudioCompressionStrategy();
        DataCompressionStrategy videoStrategy = new VideoCompressionStrategy();

        // Configuration du DataCompression avec les stratégies de traitement
        DataCompression dataCompression = new DataCompression();

        // Création des observateurs
        DataCompressionObserver imageObserver = new ImageCompressionObserver();
        DataCompressionObserver soundObserver = new AudioCompressionObserver();
        DataCompressionObserver videoObserver = new VideoCompressionObserver();

        // Ajout des observateurs à la liste des observateurs du DataCompression
        dataCompression.register(imageObserver);
        dataCompression.register(soundObserver);
        dataCompression.register(videoObserver);

        // Traitement des données avec la stratégie de traitement appropriée
        String imageResult, soundResult, videoResult;

        for (int i = 0; i < 10; i++) {
            dataCompression.setDataCompressionStrategy(imageStrategy);
            imageResult = dataCompression.compressData(imageList.get(i));
            dataCompression.setDataCompressionStrategy(soundStrategy);
            soundResult = dataCompression.compressData(audioList.get(i));
            dataCompression.setDataCompressionStrategy(videoStrategy);
            videoResult = dataCompression.compressData(videoList.get(i));

            // Vérification du résultat du traitement
            System.out.println("Résultat du traitement de l'image : " + imageResult);
            System.out.println("Résultat du traitement du son : " + soundResult);
            System.out.println("Résultat du traitement de la vidéo : " + videoResult);


            // Supprimer l'observateur Video après le traitement de 5 fichiers vidéo
            if (i == 5) dataCompression.unregister(videoObserver);


        }

    }
}

// Définition de la classe DataCompression

