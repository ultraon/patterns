package com.gof.iteration8.builder;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class DataBBuilder extends BaseDataAPIBuilder {

    public static DataBBuilder newInstance() {
        return new DataBBuilder();
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
        if (null == data) data = getCharsDataGenerator().generateData();
        dataAPI.setDataBX(data);
    }
}
