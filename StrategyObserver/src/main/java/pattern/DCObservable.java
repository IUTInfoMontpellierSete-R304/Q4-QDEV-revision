package pattern;

import pattern.observer.DataCompressionObserver;

public abstract class DCObservable {

    abstract void register(DataCompressionObserver dco);
    abstract void unregister(DataCompressionObserver dco);
    abstract void notifyChanges(String message);
}
