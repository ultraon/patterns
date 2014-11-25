package com.gof.iteration3;

import com.gof.customer.core.DataAPI;
import com.gof.customer.data.TypeOfData;

/**
 * Created by vitaliypopov on 14.11.14.
 */
public class ConcatDataAPIAdapter extends DataAPI {
    private DataAPI adaptee;

    public ConcatDataAPIAdapter(final DataAPI adaptee) {
        super(adaptee.getId(), adaptee.getDataFX(), adaptee.getTypeOfData());
        this.adaptee = adaptee;
    }

    @Override
    public void setResultX(final String resultX) {
        adaptee.setResultX(resultX);
    }

    @Override
    public String getDataMX() {
        return adaptee.getDataMX();
    }

    @Override
    public String getDataSX() {
        return adaptee.getDataSX();
    }

    @Override
    public String getDataBX() {
        return adaptee.getDataBX();
    }

    @Override
    public String getResultX() {
        return adaptee.getResultX();
    }

    @Override
    public Long getId() {
        return adaptee.getId();
    }

    @Override
    public String getDataFX() {
        String data = doConcatData();
        adaptee.setResultX(data);
        return data;
    }

    public String getRawDataFX() {
        return adaptee.getDataFX();
    }

    private String doConcatData() {
        return adaptee.getDataFX() + adaptee.getDataMX() + adaptee.getDataSX() + adaptee.getDataBX();
    }

    @Override
    public TypeOfData getTypeOfData() {
        return adaptee.getTypeOfData();
    }

    @Override
    public void setDataFX(final String dataFX) {
        adaptee.setDataFX(dataFX);
    }
}
