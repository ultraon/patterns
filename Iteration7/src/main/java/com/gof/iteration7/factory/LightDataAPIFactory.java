package com.gof.iteration7.factory;

import com.gof.customer.core.DataAPI;
import com.gof.iteration7.generator.IDataGenerator;

import java.util.Random;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class LightDataAPIFactory extends BaseDataAPIFactory {

    public static LightDataAPIFactory newInstance(final Random random, final IDataGenerator charsGenerator, final IDataGenerator digitsGenerator) {
        final LightDataAPIFactory lightDataAPIFactory = new LightDataAPIFactory();
        if (null != random) lightDataAPIFactory.random = random;
        if (null != charsGenerator) lightDataAPIFactory.charsGenerator = charsGenerator;
        if (null != digitsGenerator) lightDataAPIFactory.digitsGenerator = digitsGenerator;
        return lightDataAPIFactory;
    }

    public static LightDataAPIFactory newInstance() {
        return new LightDataAPIFactory();
    }

    @Override
    public synchronized DataAPI newDataAPI() {
        return new DataAPI(++counter, charsGenerator.generateData(), generateTypeOfData());
    }
}
