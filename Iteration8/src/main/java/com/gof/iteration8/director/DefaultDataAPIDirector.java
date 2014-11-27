package com.gof.iteration8.director;

import com.gof.customer.core.DataAPI;
import com.gof.iteration8.builder.IDataAPIBuilder;

import java.util.concurrent.atomic.AtomicLong;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class DefaultDataAPIDirector implements IDataAPIDirector {
    protected static final AtomicLong counter = new AtomicLong(0L);
    private DataAPI dataAPI;

    public static DefaultDataAPIDirector newInstance() {
        return new DefaultDataAPIDirector();
    }

    @Override
    public void buildDataAPI(final IDataAPIBuilder dataAPIBuilder) {
        dataAPIBuilder.buildDataAPI(counter.incrementAndGet());

        dataAPIBuilder.buildMXData(getMXData());
        dataAPIBuilder.buildSXData(getSXData());
        dataAPIBuilder.buildFXData(getFXData());
        dataAPIBuilder.buildBXData(getBXData());

        dataAPI = dataAPIBuilder.getDataAPI();
    }

    protected String getMXData() {
        return null;
    }

    protected String getSXData() {
        return null;
    }

    protected String getFXData() {
        return null;
    }

    protected String getBXData() {
        return null;
    }

    @Override
    public DataAPI getDataAPI() {
        final DataAPI result = dataAPI;
        dataAPI = null;
        return result;
    }
}
