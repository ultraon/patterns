package com.gof.iteration2;

import com.gof.customer.core.DataAPI;

/**
 * Created by vitaliypopov on 13.11.14.
 */
public abstract class BaseDataAPIHandler implements IDataAPIHandler {

    private BaseDataAPIHandler wrappedHandler;

    public BaseDataAPIHandler() {
    }


    @Override
    public final DataAPI handleData(final DataAPI data) {
        if (canHandleData(data)) return doHandleData(data);

        try {
            if (null != wrappedHandler) return wrappedHandler.handleData(data);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    protected abstract boolean canHandleData(DataAPI data);

    protected abstract DataAPI doHandleData(final DataAPI data);

    public BaseDataAPIHandler(final BaseDataAPIHandler wrappedHandler) {
        this.wrappedHandler = wrappedHandler;
    }

    public BaseDataAPIHandler getWrappedHandler() {
        return wrappedHandler;
    }

    public void setWrappedHandler(final BaseDataAPIHandler wrappedHandler) {
        this.wrappedHandler = wrappedHandler;
    }
}
