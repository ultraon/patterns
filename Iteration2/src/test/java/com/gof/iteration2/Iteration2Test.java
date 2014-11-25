package com.gof.iteration2;

import com.gof.customer.RemoteOutputAPI;
import com.gof.customer.core.Channel1;
import com.gof.customer.core.DataAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class Iteration2Test {

    private Channel1 ch1;
    private RemoteOutputAPI remoteOutputAPI;

    @Before
    public void setUp() {
        ch1 = new Channel1();
        remoteOutputAPI = new RemoteOutputAPI();
    }

    @Test
    public void testRunChainTrue() {
        final IDataAPIHandler dataAPIHandler = new DefaultDataAPIHandler(new AppendDataApiHandler(), false);

        List<DataAPI> dataAPI = ch1.getDataAPI();
        for (DataAPI data : dataAPI) {
            data.setDataFX(data.getDataFX() + "_");
            dataAPIHandler.handleData(data);
            final String changedDataFX = data.getDataFX();
            final char chChanged = changedDataFX.charAt(changedDataFX.length() - 1);
            Assert.assertTrue(AppendDataApiHandler.DEFAULT_DATA_TYPE_MAPPING.get(data.getTypeOfData()).equals(String.valueOf(chChanged)));

            remoteOutputAPI.setOutputData(data);
        }
    }

    @Test
    public void testRunChainFalse() {
        final IDataAPIHandler dataAPIHandler = new DefaultDataAPIHandler(new AppendDataApiHandler(), true);

        List<DataAPI> dataAPI = ch1.getDataAPI();
        for (DataAPI data : dataAPI) {
            data.setDataFX(data.getDataFX() + "_");
            dataAPIHandler.handleData(data);
            final String changedDataFX = data.getDataFX();
            final char chChanged = changedDataFX.charAt(changedDataFX.length() - 1);
            Assert.assertFalse(AppendDataApiHandler.DEFAULT_DATA_TYPE_MAPPING.get(data.getTypeOfData()).equals(String.valueOf(chChanged)));

            remoteOutputAPI.setOutputData(data);
        }
    }

    @Test
    public void testRunChainFalseNull() {
        final IDataAPIHandler dataAPIHandler = new DefaultDataAPIHandler(null, true);

        List<DataAPI> dataAPI = ch1.getDataAPI();
        for (DataAPI data : dataAPI) {
            data.setDataFX(data.getDataFX() + "_");
            dataAPIHandler.handleData(data);
            final String changedDataFX = data.getDataFX();
            final char chChanged = changedDataFX.charAt(changedDataFX.length() - 1);
            Assert.assertFalse(AppendDataApiHandler.DEFAULT_DATA_TYPE_MAPPING.get(data.getTypeOfData()).equals(String.valueOf(chChanged)));

            remoteOutputAPI.setOutputData(data);
        }
    }

    @Test
    public void testRunChainTrueNull() {
        final IDataAPIHandler dataAPIHandler = new DefaultDataAPIHandler(null, false);

        List<DataAPI> dataAPI = ch1.getDataAPI();
        for (DataAPI data : dataAPI) {
            data.setDataFX(data.getDataFX() + "_");
            dataAPIHandler.handleData(data);
            final String changedDataFX = data.getDataFX();
            final char chChanged = changedDataFX.charAt(changedDataFX.length() - 1);
            Assert.assertFalse(AppendDataApiHandler.DEFAULT_DATA_TYPE_MAPPING.get(data.getTypeOfData()).equals(String.valueOf(chChanged)));

            remoteOutputAPI.setOutputData(data);
        }
    }

}