package com.gof.iteration7;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;
import com.gof.iteration7.factory.HeavyDataAPIFactory;
import com.gof.iteration7.factory.IDataAPIFactory;
import com.gof.iteration7.factory.LightDataAPIFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract Factory pattern
 */
public class Iteration7 {
    private static final IDataAPIFactory LIGHT_DATA_API_FACTORY = LightDataAPIFactory.newInstance();
    private static final IDataAPIFactory HEAVY_DATA_API_FACTORY = HeavyDataAPIFactory.newInstance();
    private static final int OBJ_COUNT = 2;

    public static void run(){
        IDataAPIFactory factory = LIGHT_DATA_API_FACTORY;
        RemoteOutputAPITesting remoteOutputAPITesting = factory.newRemoteOutputAPI(); //in this example we can have only one remoteOutputAPITesting because it has only one implementation

        final List<DataAPI> dataAPIs = new ArrayList<>(OBJ_COUNT * 2);

        for (int i = 0; i < OBJ_COUNT; i++) {
            dataAPIs.add(factory.newDataAPI());
        }

        factory = HEAVY_DATA_API_FACTORY;
        for (int i = 0; i < OBJ_COUNT; i++) {
            dataAPIs.add(factory.newDataAPI());
        }

        for (final DataAPI dataAPI : dataAPIs) {
            remoteOutputAPITesting.setOutputData(dataAPI);
        }
    }

    public static void main(String[] args) {
        run();
    }

}