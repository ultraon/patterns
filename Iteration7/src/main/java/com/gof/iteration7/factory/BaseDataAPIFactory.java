package com.gof.iteration7.factory;

import com.gof.customer.RemoteOutputAPITesting;
import com.gof.customer.core.DataAPI;
import com.gof.customer.data.TypeOfData;
import com.gof.iteration7.generator.CharsGenerator;
import com.gof.iteration7.generator.DigitsGenerator;
import com.gof.iteration7.generator.IDataGenerator;

import java.util.Random;

/**
 * Created by vitaliypopov on 27.11.14.
 */
public abstract class BaseDataAPIFactory implements IDataAPIFactory {
    public static final IDataGenerator CHARS_GENERATOR = new CharsGenerator(128);
    public static final IDataGenerator DIGITS_GENERATOR = new DigitsGenerator(128);

    private static class RemoteOutputAPITestingHolder {
        public static RemoteOutputAPITesting REMOTE_OUTPUT_API_TESTING_INSTANCE = new RemoteOutputAPITesting();
    }

    protected IDataGenerator charsGenerator = CHARS_GENERATOR;
    protected IDataGenerator digitsGenerator = DIGITS_GENERATOR;
    protected Random random = new Random();
    protected long counter;

    @Override
    public abstract DataAPI newDataAPI();

    @Override
    public RemoteOutputAPITesting newRemoteOutputAPI() {
        return RemoteOutputAPITestingHolder.REMOTE_OUTPUT_API_TESTING_INSTANCE;
    }

    protected TypeOfData generateTypeOfData() {
        return TypeOfData.values()[random.nextInt(TypeOfData.values().length)];
    }
}
