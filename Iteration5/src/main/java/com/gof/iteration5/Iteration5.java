package com.gof.iteration5;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;

import java.util.List;

/**
 * Facade pattern
 */
public class Iteration5 {

    public static void run() {
        final Channel2 ch2 = new Channel2();
        final IRemoteOutputAPI remoteOutputAPIAcronisFacade = new RemoteOutputAPIAcronisFacade();
        final RemoteOutputAPI remoteOutputAPI = new RemoteOutputAPI();

        final List<DataAPI> dataAPIs = ch2.getDataAPI();

        for (DataAPI dataAPI : dataAPIs) {
            remoteOutputAPIAcronisFacade.setOutputData(dataAPI);
            remoteOutputAPI.setOutputData(dataAPI);
        }
    }

    public static void main(String[] args) {
        run();
    }
}