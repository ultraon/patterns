package com.gof.iteration8;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;
import com.gof.iteration8.builder.DataABuilder;
import com.gof.iteration8.builder.DataBBuilder;
import com.gof.iteration8.builder.DataCBuilder;
import com.gof.iteration8.builder.IDataAPIBuilder;
import com.gof.iteration8.director.DefaultDataAPIDirector;
import com.gof.iteration8.director.IDataAPIDirector;

import java.util.Arrays;
import java.util.List;

/**
 * Builder pattern
 */
public class Iteration8 {

    public static void run() {
        final IDataAPIDirector dataAPIDirector = DefaultDataAPIDirector.newInstance();
        final List<IDataAPIBuilder> builders = Arrays.asList(DataABuilder.newInstance(), DataBBuilder.newInstance(), DataCBuilder.newInstance());
        final RemoteOutputAPITesting remoteOutputAPITesting = new RemoteOutputAPITesting();

        for (IDataAPIBuilder builder : builders) {
            dataAPIDirector.buildDataAPI(builder);
            final DataAPI dataAPI = dataAPIDirector.getDataAPI();
            remoteOutputAPITesting.setOutputData(dataAPI);
        }
    }

    public static void main(String[] args) {
        run();
    }

}