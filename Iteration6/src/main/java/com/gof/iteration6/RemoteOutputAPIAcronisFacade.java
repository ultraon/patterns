package com.gof.iteration6;

import com.gof.customer.RemoteOutputAPIAcronis;
import com.gof.customer.core.DataAPI;

/**
* Created by vitaliypopov on 26.11.14.
*/
public class RemoteOutputAPIAcronisFacade implements IRemoteOutputAPI {

    @Override
    public void setOutputData(final DataAPI dataAPI) {
        RemoteOutputAPIAcronis.initSystem();
        RemoteOutputAPIAcronis.preparingConnection();
        RemoteOutputAPIAcronis.connect();
        RemoteOutputAPIAcronis.sendMX(dataAPI.getDataMX());
        RemoteOutputAPIAcronis.sendSX(dataAPI.getDataSX());
        RemoteOutputAPIAcronis.sendBX(dataAPI.getDataBX());
        RemoteOutputAPIAcronis.sendFX(dataAPI.getDataFX());
        RemoteOutputAPIAcronis.stopSystem();
        RemoteOutputAPIAcronis.checkErrors();
        RemoteOutputAPIAcronis.disconnect();
    }
}
