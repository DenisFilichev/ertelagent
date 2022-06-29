import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFXMLController implements Initializable {
    @FXML
    public Button button;
    @FXML
    private Label label;
    @FXML
    private TextArea textArea;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        new ParserService().pars();
        URI uri = URI.create("192.168.1.147");
        HostErtel.hosts.forEach(e -> {
            textArea.appendText("\n");
            try {
                if(!InetAddress.getByName(e.getIp()).isReachable(1000)){
                    textArea.appendText(e.getIp() + " >>> not connect");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            });
    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
