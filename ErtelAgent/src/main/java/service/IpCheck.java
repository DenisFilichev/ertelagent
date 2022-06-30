package service;

import controller.HostErtel;

public interface IpCheck {
    boolean isReachable(HostErtel host);
    boolean isReachable(String ip);

    static IpCheck newInstance(){
        return new IpCheckImpl();
    }
}
