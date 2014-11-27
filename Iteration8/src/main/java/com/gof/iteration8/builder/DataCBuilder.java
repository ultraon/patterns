package com.gof.iteration8.builder;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class DataCBuilder extends BaseDataAPIBuilder {

    public static DataCBuilder newInstance() {
        return new DataCBuilder();
    }

    @Override
    public void buildMXData(final String mxData) {
        String data = mxData;
        if (null == data) data = getDigitsDataGenerator().generateData();
        dataAPI.setDataMX(data);
    }

    @Override
    public void buildSXData(final String sxData) {
        String data = sxData;
        if (null == data) data = getCharsDataGenerator().generateData();
        dataAPI.setDataSX(data);
    }

    @Override
    public void buildFXData(final String fxData) {
        String data = fxData;
        if (null == data) data = getCharsDataGenerator().generateData();
        dataAPI.setDataFX(data);
    }

    @Override
    public void buildBXData(final String bxData) {
        String data = bxData;
        if (null == data) data = getDigitsDataGenerator().generateData();
        dataAPI.setDataBX(data);
    }
}
