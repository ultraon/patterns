package com.gof.iteration2;

import com.gof.customer.core.DataAPI;

/**
 * Created by vitaliypopov on 13.11.14.
 */
public class DefaultDataAPIHandler extends BaseDataAPIHandler {
    private boolean activate;

    public DefaultDataAPIHandler(final BaseDataAPIHandler wrappedHandler, final boolean activate) {
        super(wrappedHandler);
        this.activate = activate;
    }


    public DefaultDataAPIHandler(boolean activate) {
        this.activate = activate;
    }

    @Override
    public boolean canHandleData(final DataAPI data) {
        return activate;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(final boolean activate) {
        this.activate = activate;
    }

    @Override
    protected DataAPI doHandleData(final DataAPI data) {
        if (!activate) {
            throw new IllegalStateException("Handler doesn't active");
        }

        return data;
    }
}
