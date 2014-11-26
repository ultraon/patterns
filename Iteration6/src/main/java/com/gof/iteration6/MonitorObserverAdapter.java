package com.gof.iteration6;

import com.gof.customer.monitors.Monitor;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by vitaliypopov on 26.11.14.
 */
public class MonitorObserverAdapter implements Observer {
    private Monitor monitor;

    public MonitorObserverAdapter(final Monitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void update(final Observable o, final Object arg) {
        monitor.showMessage(null == arg ? "" : arg.toString());
    }
}
