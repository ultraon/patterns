package com.gof.iteration1;

import com.gof.customer.RemoteOutputAPI;

/**
 * Created by vitaliypopov on 25.11.14.
 */
public class SingletonRemoteOutputAPI extends RemoteOutputAPI {

    private static class InstanceHolder {
        public static final SingletonRemoteOutputAPI INSTANCE = new SingletonRemoteOutputAPI();
    }

    public static SingletonRemoteOutputAPI getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private SingletonRemoteOutputAPI() {
        super();
    }
}
