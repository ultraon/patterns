package com.gof.iteration8.generator;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Created by vitaliypopov on 27.11.14.
 */
public abstract class BaseLengthGenerator implements IDataGenerator {
    protected int length;
    private Random random = new SecureRandom();

    public BaseLengthGenerator(final int length) {
        this.length = length;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(final Random random) {
        this.random = random;
    }

    public int getLength() {
        return length;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    @Override
    public String generateData() {
        String generated = nextGeneration(random);
        if (generated.length() >= length) {
            return generated.substring(0, length);
        }
        StringBuilder sb = new StringBuilder(generated);
        while(sb.length() < length) sb.append(nextGeneration(random));

        return sb.substring(0, length);
    }

    protected abstract String nextGeneration(final Random random);
}
