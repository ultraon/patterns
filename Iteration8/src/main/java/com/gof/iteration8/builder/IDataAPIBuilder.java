package com.gof.iteration8.builder;

import com.gof.customer.core.DataAPI;

/**
* Created by vitaliypopov on 27.11.14.
*/
public interface IDataAPIBuilder {
    void buildDataAPI(long id);
    void buildMXData(String mxData);
    void buildSXData(String sxData);
    void buildFXData(String fxData);
    void buildBXData(String bxData);
    DataAPI getDataAPI();
}
