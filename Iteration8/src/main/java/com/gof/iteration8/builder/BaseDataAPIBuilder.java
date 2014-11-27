package com.gof.iteration8.builder;

import com.gof.customer.core.DataAPI;
import com.gof.iteration8.generator.CharsGenerator;
import com.gof.iteration8.generator.DigitsGenerator;
import com.gof.iteration8.generator.IDataGenerator;

/**
* Created by vitaliypopov on 27.11.14.
*/
public abstract class BaseDataAPIBuilder implements IDataAPIBuilder {
    public static final IDataGenerator CHARS_DATA_GENERATOR = new CharsGenerator(128);
    public static final IDataGenerator DIGITS_DATA_GENERATOR = new DigitsGenerator(128);

    protected DataAPI dataAPI;
    private IDataGenerator charsDataGenerator = CHARS_DATA_GENERATOR;
    private IDataGenerator digitsDataGenerator = DIGITS_DATA_GENERATOR;

    @Override
    public void buildDataAPI(final long id) {
        dataAPI = new DataAPI(id);
    }

    @Override
    public void buildMXData(final String mxData) {

    }

    @Override
    public void buildSXData(final String sxData) {

    }

    @Override
    public void buildFXData(final String fxData) {

    }

    @Override
    public void buildBXData(final String bxData) {

    }

    @Override
    public DataAPI getDataAPI() {
        final DataAPI result = dataAPI;
        dataAPI = null;
        return result;
    }

    public IDataGenerator getCharsDataGenerator() {
        return charsDataGenerator;
    }

    public void setCharsDataGenerator(final IDataGenerator charsDataGenerator) {
        this.charsDataGenerator = charsDataGenerator;
    }

    public IDataGenerator getDigitsDataGenerator() {
        return digitsDataGenerator;
    }

    public void setDigitsDataGenerator(final IDataGenerator digitsDataGenerator) {
        this.digitsDataGenerator = digitsDataGenerator;
    }
}
