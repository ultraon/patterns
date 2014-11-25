package com.gof.iteration3;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel2;
import com.gof.customer.core.DataAPI;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public class Iteration3Test {
    private RemoteOutputAPI remoteOutputAPI;
    private Channel2 ch2;

    @Before
    public void init() {
        remoteOutputAPI = new RemoteOutputAPI();
        ch2 = new Channel2();
    }

    @Test
    public void testRun() {
        for (DataAPI dataAPI : ch2.getDataAPI()) {
            final ConcatDataAPIAdapter dataAPIAdapter = new ConcatDataAPIAdapter(dataAPI);
            final String targetResult = dataAPI.getDataFX() + dataAPI.getDataMX() + dataAPI.getDataSX() + dataAPI.getDataBX();
            Assert.assertEquals("targetResult doesn't equal dataAPIAdapter.getDataFX()", targetResult, dataAPIAdapter.getDataFX());
            remoteOutputAPI.setOutputData(dataAPIAdapter);
        }
    }
}