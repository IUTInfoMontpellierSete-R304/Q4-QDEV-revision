package pattern;

import pattern.observer.DataCompressionObserver;
import pattern.strategy.DataCompressionStrategy;

import java.util.ArrayList;
import java.util.List;

public class DataCompression extends DCObservable {


    private DataCompressionStrategy dataCompressionStrategy;
    private List<DataCompressionObserver> dataObservers = new ArrayList<>();

    public void setDataCompressionStrategy(DataCompressionStrategy strategy) {
        this.dataCompressionStrategy = strategy;
    }


    public String compressData(Data data) {
        // Appel de la méthode processData() de la stratégie appropriée
        String result = this.dataCompressionStrategy.compressData(data);

        // Notification de tous les observateurs enregistrés
        this.notifyChanges(result);
        return result;
    }

    @Override
    void register(DataCompressionObserver dco) {
        this.dataObservers.add(dco);
    }

    @Override
    void unregister(DataCompressionObserver dco) {
        this.dataObservers.remove(dco);
    }

    @Override
    void notifyChanges(String message) {
        for (DataCompressionObserver observer : dataObservers) {
            observer.update(message);
        }
    }
}