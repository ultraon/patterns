package com.gof.iteration8;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;
import com.gof.iteration8.builder.DataABuilder;
import com.gof.iteration8.builder.DataBBuilder;
import com.gof.iteration8.builder.DataCBuilder;
import com.gof.iteration8.director.DefaultDataAPIDirector;
import com.gof.iteration8.director.IDataAPIDirector;
import org.junit.Assert;
import org.junit.Test;

public class Iteration8Test {

    @Test
    public void testRun() {
        final IDataAPIDirector dataAPIDirector = DefaultDataAPIDirector.newInstance();
        dataAPIDirector.buildDataAPI(DataABuilder.newInstance());
        final DataAPI dataA = dataAPIDirector.getDataAPI();
        Assert.assertNull(dataAPIDirector.getDataAPI());

        dataAPIDirector.buildDataAPI(DataBBuilder.newInstance());
        final DataAPI dataB = dataAPIDirector.getDataAPI();
        Assert.assertNull(dataAPIDirector.getDataAPI());

        dataAPIDirector.buildDataAPI(DataCBuilder.newInstance());
        final DataAPI dataC = dataAPIDirector.getDataAPI();
        Assert.assertNull(dataAPIDirector.getDataAPI());


        String dataMX = dataA.getDataMX();
        Assert.assertTrue(dataMX.length() == dataMX.replaceAll("\\d", "").length());
        String dataSX = dataA.getDataSX();
        Assert.assertTrue(dataSX.length() == dataSX.replaceAll("\\d", "").length());
        String dataFX = dataA.getDataFX();
        Assert.assertNull(dataFX);
        String dataBX = dataA.getDataBX();
        Assert.assertNull(dataBX);

        dataMX = dataB.getDataMX();
        Assert.assertNull(dataMX);
        dataSX = dataB.getDataSX();
        Assert.assertNull(dataSX);
        dataFX = dataB.getDataFX();
        Assert.assertTrue(dataFX.length() == dataFX.replaceAll("\\d", "").length());
        dataBX = dataB.getDataBX();
        Assert.assertTrue(dataBX.length() == dataBX.replaceAll("\\d", "").length());

        dataMX = dataC.getDataMX();
        Assert.assertTrue(dataMX.length() == dataMX.replaceAll("[a-zA-Z]", "").length());
        dataSX = dataC.getDataSX();
        Assert.assertTrue(dataSX.length() == dataSX.replaceAll("\\d", "").length());
        dataFX = dataC.getDataFX();
        Assert.assertTrue(dataFX.length() == dataFX.replaceAll("\\d", "").length());
        dataBX = dataC.getDataBX();
        Assert.assertTrue(dataBX.length() == dataBX.replaceAll("[a-zA-Z]", "").length());


        final RemoteOutputAPITesting remoteOutputAPITesting = new RemoteOutputAPITesting();
        remoteOutputAPITesting.setOutputData(dataA);
        remoteOutputAPITesting.setOutputData(dataB);
        remoteOutputAPITesting.setOutputData(dataC);
    }
}