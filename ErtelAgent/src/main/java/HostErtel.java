
import java.util.ArrayList;
import java.util.List;
public class HostErtel {
    private String id;
    private String type;
    private String model;
    private String ip;
    private String mac;
    private String ping;
    public static List<HostErtel> hosts = new ArrayList<>();

    public HostErtel(String id, String type, String model, String ip, String mac, String ping) {
        this.id = id;
        this.type = type;
        this.model = model;
        this.ip = ip;
        this.mac = mac;
        this.ping = ping;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getPing() {
        return ping;
    }

    public void setPing(String ping) {
        this.ping = ping;
    }

    public static List<HostErtel> getHosts() {
        return hosts;
    }

    public static void setHosts(List<HostErtel> hosts) {
        HostErtel.hosts = hosts;
    }

    @Override
    public String toString() {
        return "HostErtel{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", ping='" + ping + '\'' +
                '}';
    }
}
