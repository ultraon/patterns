package com.gof.iteration6;

import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import com.gof.customer.monitors.MonitorFR;
import com.gof.customer.monitors.MonitorSE;
import com.gof.customer.monitors.MonitorUK;
import com.gof.customer.monitors.MonitorUS;

import java.util.List;

/**
 * Observer pattern
 */
public class Iteration6 {

    public static void run() {
        final RemoteOutputAPIAcronisFacadeObservable remoteOutputAPIFacadeObservable = new RemoteOutputAPIAcronisFacadeObservable();
        final IRemoteOutputAPI remoteOutputAPI = remoteOutputAPIFacadeObservable;

        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(new MonitorFR()));
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(new MonitorSE()));
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(new MonitorUK()));
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(new MonitorUS()));

        final Channel2 ch2 = new Channel2();
        final List<DataAPI> dataAPIs = ch2.getDataAPI();
        for (final DataAPI dataAPI : dataAPIs) {
            remoteOutputAPI.setOutputData(dataAPI);
        }
    }

    public static void main(String[] args) {
        run();
    }
}
