package com.gof.iteration2;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel1;
import com.gof.customer.core.DataAPI;

import java.util.List;

/**
 * Chain of responsibility pattern
 */
public class Iteration2 {

    public static void run() {
        final IDataAPIHandler dataAPIHandler = new DefaultDataAPIHandler(new AppendDataApiHandler(), false);
        final Channel1 ch1 = new Channel1();
        final RemoteOutputAPI remoteOutputAPI = new RemoteOutputAPI();

        List<DataAPI> dataAPI = ch1.getDataAPI();
        for (DataAPI data : dataAPI) {
            dataAPIHandler.handleData(data);
            remoteOutputAPI.setOutputData(data);
        }
    }

    public static void main(String[] args) {
        run();
    }

}