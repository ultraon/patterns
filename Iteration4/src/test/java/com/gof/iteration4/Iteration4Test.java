package com.gof.iteration4;

import com.gof.customer.core.DataAPI;
import com.gof.customer.data.TypeOfData;
import com.gof.iteration4.algo.DefaultAlgoResolver;
import com.gof.iteration4.algo.IAlgoResolver;
import org.junit.Assert;
import org.junit.Test;

public class Iteration4Test {

    @Test
    public void testRun() {
        final IAlgoResolver algoResolver = new DefaultAlgoResolver();

        final DataAPI dataAPIErr = new DataAPI(0L, "0", TypeOfData.ERR); //0 -> ER
        final DataAPI dataAPIFake = new DataAPI(1L, "0", TypeOfData.FAKE); //0 -> #
        final DataAPI dataAPILive = new DataAPI(2L, "0", TypeOfData.LIVE); //0 -> 1
        final DataAPI dataAPIPre = new DataAPI(3L, "0", TypeOfData.PREPARED); //0 -> 358

        DataAPI currentDataAPI = dataAPIErr;
        Assert.assertEquals(algoResolver.resolveAlgo(currentDataAPI.getTypeOfData()).handleData(currentDataAPI), "ER");
        currentDataAPI = dataAPIFake;
        Assert.assertEquals(algoResolver.resolveAlgo(currentDataAPI.getTypeOfData()).handleData(currentDataAPI), "#");
        currentDataAPI = dataAPILive;
        Assert.assertEquals(algoResolver.resolveAlgo(currentDataAPI.getTypeOfData()).handleData(currentDataAPI), "1");
        currentDataAPI = dataAPIPre;
        Assert.assertEquals(algoResolver.resolveAlgo(currentDataAPI.getTypeOfData()).handleData(currentDataAPI), "358");
    }
}