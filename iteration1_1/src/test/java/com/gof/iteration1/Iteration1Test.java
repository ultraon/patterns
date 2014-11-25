package com.gof.iteration1;

import com.gof.customer.RemoteInputAPI;
import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.DataAPI;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Iteration1Test {
    private RemoteOutputAPI remoteOutputAPI;
    private RemoteInputAPI remoteInputAPI;

    @Before
    public void init() {
        remoteOutputAPI = SingletonRemoteOutputAPI.getInstance();
        remoteInputAPI = new RemoteInputAPI();
    }

    @Test
    public void testRun() {
        final int size = 3;

        List<Iteration1> iterations = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            Iteration1 iteration1 = new Iteration1();
            iterations.add(iteration1);

            DataAPI inputData = remoteInputAPI.getInputData();
            assertNotNull("inputData must not be null", inputData);
            iteration1.getRemoteOutputAPI().setOutputData(inputData.getId(), inputData.getDataFX());
        }


        for (int i = 0; i < size; i++) {
            RemoteOutputAPI sameRemoteOutputAPI = iterations.get(i).getRemoteOutputAPI();
            assertSame("remoteOutputAPI != sameRemoteOutputAPI", remoteOutputAPI, sameRemoteOutputAPI);
        }
    }
}