package pattern.strategy;

import pattern.Data;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// Implémentation de l'interface pour le traitement d'images
public class ImageCompressionStrategy implements DataCompressionStrategy {
    private float quality = 0.5f;

    @Override
    public String compressData(Data data) {

        String result = "empty";
        try {
            // Lecture de l'image d'entrée
            BufferedImage inputImage = ImageIO.read(data.getFile());
            // Récupération de l'instance de l'encodeur JPEG
            ImageWriter writer = ImageIO.getImageWritersByFormatName("jpg").next();
            // Définition des paramètres d'encodage
            ImageWriteParam params = new JPEGImageWriteParam(null);
            params.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            params.setCompressionQuality(quality);
            // Définition du flux de sortie
            File output = new File("./data/compressed/jpg/c-" + data.getFile().getName());
            ImageOutputStream ios = new FileImageOutputStream(output);
            writer.setOutput(ios);
            // Encodage de l'image
            writer.write(null, new javax.imageio.IIOImage(inputImage, null, null), params);
            // Fermeture du flux de sortie
            ios.close();
            writer.dispose();

            result = output.getAbsolutePath();
        } catch (IOException e) {
            System.out.println("Error while compressing image file " + data.getFile().getName());
        }
        return result;
    }
}
