package com.gof.iteration7.factory;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;

/**
* Created by vitaliypopov on 27.11.14.
*/
public interface IDataAPIFactory {
    DataAPI newDataAPI();
    RemoteOutputAPITesting newRemoteOutputAPI();
}
