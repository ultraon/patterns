package com.gof.iteration4.algo.handlers;

/**
* Created by vitaliypopov on 25.11.14.
*/
public class PreparedAlgoHandler extends BaseAlgoHandler.SimpleReplacer  {
    private static final String REGEX = "0";
    private static final String REPLACEMENT = "358";
    public PreparedAlgoHandler() {
        super(REGEX, REPLACEMENT);
    }
}
