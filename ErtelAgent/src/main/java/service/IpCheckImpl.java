package service;

import controller.HostErtel;

import java.io.IOException;
import java.net.InetAddress;

public class IpCheckImpl implements IpCheck {
    @Override
    public boolean isReachable(HostErtel host){
        boolean isReachable = isReachable(host.getIp());
        host.setPing(isReachable ? "true" : "false");
        return isReachable;
    }
    @Override
    public boolean isReachable(String ip){
        try {
            return InetAddress.getByName(ip).isReachable(100);
        } catch (IOException e) {e.printStackTrace();}
        return false;
    }
}
