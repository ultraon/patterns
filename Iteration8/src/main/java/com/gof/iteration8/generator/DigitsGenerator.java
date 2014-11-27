package com.gof.iteration8.generator;

import java.math.BigInteger;
import java.util.Random;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class DigitsGenerator extends BaseLengthGenerator {
    public DigitsGenerator(final int length) {
        super(length);
    }

    @Override
    protected String nextGeneration(final Random random) {
        return new BigInteger(132, random).toString(10);
    }
}
