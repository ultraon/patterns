package com.gof.iteration7;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;
import com.gof.iteration7.factory.HeavyDataAPIFactory;
import com.gof.iteration7.factory.IDataAPIFactory;
import com.gof.iteration7.factory.LightDataAPIFactory;
import org.junit.Assert;
import org.junit.Test;

public class Iteration7Test {

    @Test
    public void testRun() {
        IDataAPIFactory factory = LightDataAPIFactory.newInstance();
        RemoteOutputAPITesting remoteOutputAPITesting = factory.newRemoteOutputAPI();

        final DataAPI lightDataAPI = factory.newDataAPI();
        factory = HeavyDataAPIFactory.newInstance();
        final DataAPI heavyDataAPI = factory.newDataAPI();

        Assert.assertNotNull(lightDataAPI.getDataFX());
        Assert.assertTrue(lightDataAPI.getDataFX().length() > 0);
        Assert.assertNull(lightDataAPI.getDataBX());
        Assert.assertNull(lightDataAPI.getDataMX());
        Assert.assertNull(lightDataAPI.getDataSX());

        Assert.assertNotNull(heavyDataAPI.getDataFX());
        Assert.assertTrue(heavyDataAPI.getDataFX().length() > 0);
        Assert.assertNotNull(heavyDataAPI.getDataBX());
        Assert.assertTrue(heavyDataAPI.getDataBX().length() > 0);
        Assert.assertNotNull(heavyDataAPI.getDataMX());
        Assert.assertTrue(heavyDataAPI.getDataMX().length() > 0);
        Assert.assertNotNull(heavyDataAPI.getDataSX());
        Assert.assertTrue(heavyDataAPI.getDataSX().length() > 0);

        remoteOutputAPITesting.setOutputData(lightDataAPI);
        remoteOutputAPITesting.setOutputData(heavyDataAPI);
    }
}