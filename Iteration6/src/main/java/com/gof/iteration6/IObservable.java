package com.gof.iteration6;

import java.util.Observer;

/**
 * Created by vitaliypopov on 26.11.14.
 */
public interface IObservable<T> {
    void addObserver(Observer o);

    void deleteObserver(Observer o);

    void notifyObservers();

    void notifyObservers(T arg);

    void deleteObservers();

    boolean hasChanged();

    int countObservers();
}
