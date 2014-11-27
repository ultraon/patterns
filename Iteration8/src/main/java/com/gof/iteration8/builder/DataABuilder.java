package com.gof.iteration8.builder;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class DataABuilder extends BaseDataAPIBuilder {

    public static DataABuilder newInstance() {
        return new DataABuilder();
    }

    @Override
    public void buildMXData(final String mxData) {
        String data = mxData;
        if (null == data) data = getCharsDataGenerator().generateData();
        dataAPI.setDataMX(data);
    }

    @Override
    public void buildSXData(final String sxData) {
        String data = sxData;
        if (null == data) data = getCharsDataGenerator().generateData();
        dataAPI.setDataSX(data);
    }
}
