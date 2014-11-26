package com.gof.iteration6;

import com.gof.customer.core.DataAPI;
import com.gof.iteration6.data.DefaultRawDataExtractor;
import com.gof.iteration6.data.IRawDataExtractor;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vitaliypopov on 26.11.14.
 */
public class RemoteOutputAPIAcronisFacadeObservable extends RemoteOutputAPIAcronisFacade implements IObservable<String> {
    private final Observable observable = new Observable() {
        @Override
        public void notifyObservers() {
            setChanged();
            super.notifyObservers();
        }

        @Override
        public void notifyObservers(final Object arg) {
            setChanged();
            super.notifyObservers(arg);
        }
    };
    private IRawDataExtractor dataExtractor = new DefaultRawDataExtractor();

    @Override
    public void setOutputData(final DataAPI dataAPI) {
        super.setOutputData(dataAPI);
        observable.notifyObservers(extractRawData(dataAPI));
    }

    private String extractRawData(final DataAPI dataAPI) {
        return dataExtractor.extractRawData(dataAPI);
    }

    @Override
    public void addObserver(final Observer o) {
        observable.addObserver(o);
    }

    @Override
    public void deleteObserver(final Observer o) {
        observable.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        observable.notifyObservers();
    }

    @Override
    public void notifyObservers(final String arg) {
        observable.notifyObservers(arg);
    }

    @Override
    public void deleteObservers() {
        observable.deleteObservers();
    }

    @Override
    public boolean hasChanged() {
        return observable.hasChanged();
    }

    @Override
    public int countObservers() {
        return observable.countObservers();
    }

    public IRawDataExtractor getDataExtractor() {
        return dataExtractor;
    }

    public void setDataExtractor(final IRawDataExtractor dataExtractor) {
        this.dataExtractor = dataExtractor;
    }
}
