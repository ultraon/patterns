package com.gof.iteration4.algo.handlers;

import com.gof.customer.core.DataAPI;
import com.gof.iteration4.data.DefaultRawDataExtractor;
import com.gof.iteration4.data.IRawDataExtractor;

/**
* Created by vitaliypopov on 25.11.14.
*/
public abstract class BaseAlgoHandler implements IAlgoHandler {
    public static final IRawDataExtractor DEFAULT_RAW_DATA_EXTRACTOR = new DefaultRawDataExtractor();
    private IRawDataExtractor dataExtractor = DEFAULT_RAW_DATA_EXTRACTOR;

    @Override
    public final String handleData(final DataAPI dataAPI) {
        return changeData(extractRawData(dataAPI));
    }

    protected abstract String changeData(String rawData);


    private String extractRawData(final DataAPI dataAPI) {
        if (null == dataExtractor) dataExtractor = DEFAULT_RAW_DATA_EXTRACTOR;
        return dataExtractor.extractRawData(dataAPI);
    }

    public IRawDataExtractor getDataExtractor() {
        return dataExtractor;
    }

    public void setDataExtractor(final IRawDataExtractor dataExtractor) {
        this.dataExtractor = dataExtractor;
    }

    public static class SimpleReplacer extends BaseAlgoHandler {
        private String regex;
        private String replacement;

        public SimpleReplacer(final String regex, final String replacement) {
            this.regex = regex;
            this.replacement = replacement;
        }

        @Override
        protected String changeData(final String rawData) {
            return rawData.replaceAll(regex, replacement);
        }
    }
}
