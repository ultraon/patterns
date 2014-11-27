package com.gof.iteration8.generator;

import java.math.BigInteger;
import java.util.Random;

/**
* Created by vitaliypopov on 27.11.14.
*/
public class CharsGenerator extends BaseLengthGenerator {

    public CharsGenerator(final int length) {
        super(length);
    }

    @Override
    protected String nextGeneration(final Random random) {
        return new String(new BigInteger(132, random).toString(36).getBytes()).replaceAll("\\d", "");
    }
}
