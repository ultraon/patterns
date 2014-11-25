package com.gof.iteration3;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;

/**
 * Adapter pattern
 */
public class Iteration3 {

    public static void run() {
        final RemoteOutputAPI remoteOutputAPI = new RemoteOutputAPI();
        final Channel2 ch2 = new Channel2();

        for (DataAPI dataAPI : ch2.getDataAPI()) {
            final ConcatDataAPIAdapter dataAPIAdapter = new ConcatDataAPIAdapter(dataAPI);
            System.out.println("dataAPI: " + dataAPIAdapter.getRawDataFX());
            System.out.println("dataAPIAdapter: " + dataAPIAdapter.getDataFX());
            remoteOutputAPI.setOutputData(dataAPIAdapter);
        }
    }

    public static void main(String[] args) {
        run();
    }
}