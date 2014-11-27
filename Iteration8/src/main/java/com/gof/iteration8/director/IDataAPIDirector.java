package com.gof.iteration8.director;

import com.gof.customer.core.DataAPI;
import com.gof.iteration8.builder.IDataAPIBuilder;

/**
* Created by vitaliypopov on 27.11.14.
*/
public interface IDataAPIDirector {
    void buildDataAPI(IDataAPIBuilder dataAPIBuilder);
    DataAPI getDataAPI();
}
