import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;

public class ParserService {

    public void pars(){
        try {
            URL url = new URL("http://188.134.70.58:8090/api/hosts");
            try(InputStream is = url.openStream()){
                JSONParser parser = new JSONParser();
                JSONArray array = (JSONArray)parser.parse(new InputStreamReader(is));
                for (Object o : array) {
                    JSONObject object = (JSONObject) o;
                    String id = Objects.toString(object.get("id"), "");
                    String type = Objects.toString(object.get("type"), "");
                    String model = Objects.toString(object.get("model"), "");
                    String ip = Objects.toString(object.get("ip"), "");
                    String mac = Objects.toString(object.get("mac"), "");
                    String ping = Objects.toString(object.get("ping"), "");
                    HostErtel.hosts.add(new HostErtel(id, type, model, ip, mac, ping));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
