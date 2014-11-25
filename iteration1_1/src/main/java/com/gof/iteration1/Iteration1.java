package com.gof.iteration1;

import com.gof.customer.RemoteInputAPI;
import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.DataAPI;

/**
 * Singleton pattern variant
 */
public class Iteration1 {
    private static final RemoteInputAPI RM_IN = new RemoteInputAPI();
    private static final RemoteOutputAPI RM_OUT = SingletonRemoteOutputAPI.getInstance();

    public static void run() {
        DataAPI inputData = RM_IN.getInputData();
        RM_OUT.setOutputData(inputData.getId(), inputData.getDataFX());
    }

    public RemoteOutputAPI getRemoteOutputAPI() {
        return RM_OUT;
    }

    public static void main(String[] args) {
        run();
    }

}
