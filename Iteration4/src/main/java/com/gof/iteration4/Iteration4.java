package com.gof.iteration4;

import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import com.gof.iteration4.algo.DefaultAlgoResolver;
import com.gof.iteration4.algo.handlers.IAlgoHandler;
import com.gof.iteration4.algo.IAlgoResolver;

import java.util.List;

/**
 * Strategy pattern
 */
public class Iteration4 {

    public static void run() {
        final IAlgoResolver algoResolver = new DefaultAlgoResolver();

        final Channel2 ch2 = new Channel2();
        final List<DataAPI> dataAPIs = ch2.getDataAPI();

        for (DataAPI dataAPI : dataAPIs) {
            IAlgoHandler algoHandler = algoResolver.resolveAlgo(dataAPI.getTypeOfData());
            String handledData = algoHandler.handleData(dataAPI);
            System.out.println("dataAPI: " + dataAPI.getDataFX() + ", dataType " + dataAPI.getTypeOfData());
            System.out.println("handledData: " + handledData);
            dataAPI.setDataFX(handledData);
        }
    }

    public static void main(String[] args) {
        run();
    }

}