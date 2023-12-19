package pattern.strategy;

import pattern.Data;

// Définition de l'interface DataProcessingStrategy
public interface DataCompressionStrategy {
    String compressData(Data data);
}
