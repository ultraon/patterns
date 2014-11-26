package com.gof.iteration6;

import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import com.gof.customer.monitors.MonitorFR;
import com.gof.customer.monitors.MonitorSE;
import com.gof.customer.monitors.MonitorUK;
import com.gof.customer.monitors.MonitorUS;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.List;

public class Iteration6Test {

    @Test
    public void testRun() {
        final RemoteOutputAPIAcronisFacadeObservable remoteOutputAPIFacadeObservable = new RemoteOutputAPIAcronisFacadeObservable();
        final IRemoteOutputAPI remoteOutputAPI = remoteOutputAPIFacadeObservable;

        final MonitorFR monitorFRMock = Mockito.spy(new MonitorFR());
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(monitorFRMock));
        final MonitorSE monitorSEMock = Mockito.spy(new MonitorSE());
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(monitorSEMock));
        final MonitorUK monitorUKMock = Mockito.spy(new MonitorUK());
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(monitorUKMock));
        final MonitorUS monitorUSMock = Mockito.spy(new MonitorUS());
        remoteOutputAPIFacadeObservable.addObserver(new MonitorObserverAdapter(monitorUSMock));

        final Channel2 ch2 = new Channel2();
        final List<DataAPI> dataAPIs = ch2.getDataAPI();
        for (final DataAPI dataAPI : dataAPIs) {
            remoteOutputAPI.setOutputData(dataAPI);
        }

        final int callsCount = dataAPIs.size();
        Mockito.verify(monitorFRMock, Mockito.times(callsCount)).showMessage(Matchers.anyString());
        Mockito.verify(monitorSEMock, Mockito.times(callsCount)).showMessage(Matchers.anyString());
        Mockito.verify(monitorUKMock, Mockito.times(callsCount)).showMessage(Matchers.anyString());
        Mockito.verify(monitorUSMock, Mockito.times(callsCount)).showMessage(Matchers.anyString());
    }
}