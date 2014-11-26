package com.gof.iteration6.data;

import com.gof.customer.core.DataAPI;

/**
* Created by vitaliypopov on 25.11.14.
*/
public class DefaultRawDataExtractor implements IRawDataExtractor {
    @Override
    public String extractRawData(final DataAPI dataAPI) {
        String dataMX = dataAPI.getDataMX();
        String dataSX = dataAPI.getDataSX();
        String dataBX = dataAPI.getDataBX();
        String dataFX = dataAPI.getDataFX();
        return (null == dataMX ? "" : dataMX) + (null == dataSX ? "" : dataSX) + (null == dataBX ? "" : dataBX) + (null == dataFX ? "" : dataFX);
    }
}
