package com.gof.iteration1;

import com.gof.customer.RemoteOutputAPI;

/**
 * Created by vitaliypopov on 07.11.14.
 */
public class RemoteOutputAPIProvider implements IRemoteOutputAPIProvider {
    private static RemoteOutputAPI remoteOutputAPI;
    private static Object lock = new Object();

    @Override
    public RemoteOutputAPI provideRemoteOutputAPI() {
        if (null == remoteOutputAPI) {
            synchronized (lock) {
                if (null == remoteOutputAPI) {
                    remoteOutputAPI = new RemoteOutputAPI();
                }
            }
        }
        return remoteOutputAPI;
    }
}
