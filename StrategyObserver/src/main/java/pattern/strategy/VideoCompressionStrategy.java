package pattern.strategy;

import pattern.Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Implémentation de l'interface pour le traitement de vidéos
public class VideoCompressionStrategy implements DataCompressionStrategy {
    @Override
    public String compressData(Data data) {


        String result = "./data/compressed/mp4/c-" + data.getFile().getName();
        try {
            FileInputStream inputStream = new FileInputStream(data.getFile().getAbsolutePath());

            FileOutputStream outputStream = new FileOutputStream(result);


        byte[] buffer = new byte[4096];
        int length;

        while (true) {

                if (!((length = inputStream.read(buffer)) > 0)) break;
                outputStream.write(buffer, 0, length);


        }


            inputStream.close();

        outputStream.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
