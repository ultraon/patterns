package com.gof.iteration4.algo;

import com.gof.customer.data.TypeOfData;
import com.gof.iteration4.algo.handlers.IAlgoHandler;

/**
* Created by vitaliypopov on 25.11.14.
*/
public interface IAlgoResolver {
    IAlgoHandler resolveAlgo(TypeOfData dataType);
}
