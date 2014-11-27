package com.gof.iteration7.factory;

import com.gof.customer.core.DataAPI;
import com.gof.iteration7.generator.IDataGenerator;

import java.util.Random;

/**
 * Created by vitaliypopov on 27.11.14.
 */
public class HeavyDataAPIFactory extends BaseDataAPIFactory {

    public static LightDataAPIFactory newInstance(final Random random, final IDataGenerator charsGenerator, final IDataGenerator digitsGenerator) {
        final LightDataAPIFactory dataAPIFactory = new LightDataAPIFactory();
        if (null != random) dataAPIFactory.random = random;
        if (null != charsGenerator) dataAPIFactory.charsGenerator = charsGenerator;
        if (null != digitsGenerator) dataAPIFactory.digitsGenerator = digitsGenerator;
        return dataAPIFactory;
    }

    public static HeavyDataAPIFactory newInstance() {
        return new HeavyDataAPIFactory();
    }

    @Override
    public DataAPI newDataAPI() {
        return new DataAPI(++counter, generateTypeOfData(), digitsGenerator.generateData(), digitsGenerator.generateData(), digitsGenerator.generateData(), digitsGenerator.generateData());
    }
}
