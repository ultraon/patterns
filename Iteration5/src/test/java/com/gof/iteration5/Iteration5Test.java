package com.gof.iteration5;

import com.gof.customer.RemoteOutputAPIAcronis;
import com.gof.customer.core.DataAPI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@PrepareForTest(RemoteOutputAPIAcronis.class)
@RunWith(PowerMockRunner.class)
public class Iteration5Test {
    @Mock
    private DataAPI dataAPI;

    private IRemoteOutputAPI remoteOutputAPIAcronisFacade;

    @Before
    public void init() {
        remoteOutputAPIAcronisFacade = new RemoteOutputAPIAcronisFacade();
    }

    @Test
    public void testRun() {
        PowerMockito.mockStatic(RemoteOutputAPIAcronis.class);
        Mockito.when(dataAPI.getDataMX()).thenReturn("hello_MX");
        Mockito.when(dataAPI.getDataSX()).thenReturn("hello_SX");
        Mockito.when(dataAPI.getDataBX()).thenReturn("hello_BX");
        Mockito.when(dataAPI.getDataFX()).thenReturn("hello_FX");


        remoteOutputAPIAcronisFacade.setOutputData(dataAPI);

        InOrder order = Mockito.inOrder(dataAPI);
        order.verify(dataAPI, Mockito.times(1)).getDataMX();
        order.verify(dataAPI, Mockito.times(1)).getDataSX();
        order.verify(dataAPI, Mockito.times(1)).getDataBX();
        order.verify(dataAPI, Mockito.times(1)).getDataFX();

        //test static methods

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.initSystem();

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.preparingConnection();

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.connect();

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.sendMX(Matchers.eq("hello_MX"));

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.sendSX(Matchers.eq("hello_SX"));

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.sendBX(Matchers.eq("hello_BX"));

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.sendFX(Matchers.eq("hello_FX"));

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.stopSystem();

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.checkErrors();

        PowerMockito.verifyStatic(Mockito.times(1));
        RemoteOutputAPIAcronis.disconnect();
    }
}