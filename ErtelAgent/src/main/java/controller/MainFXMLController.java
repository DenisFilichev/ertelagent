package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import service.IpCheck;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

        DateFormat dateFormat = new SimpleDateFormat("HH mm ss");
        textArea.appendText(dateFormat.format(System.currentTimeMillis()) + " >>> Получение объектов JSON\n");
        new ParserService().pars();
        textArea.appendText(dateFormat.format(System.currentTimeMillis()) + " >>> Получено " + HostErtel.hosts.size() + " объектов\n");
        long start = System.currentTimeMillis();
        textArea.appendText(dateFormat.format(System.currentTimeMillis()) + " >>> Начинаем опрос IP-адресов\n");
        IpCheck ipCheck = IpCheck.newInstance();
        HostErtel.hosts.forEach(e -> {
                if(!ipCheck.isReachable(e)){
                    textArea.appendText(e.toString() + "\n");
                }
            });
        long finish = System.currentTimeMillis();
        textArea.appendText(dateFormat.format(System.currentTimeMillis()) + " >>> Опрос IP-адресов окончен\n");
        textArea.appendText("Затрачено времени " + dateFormat.format(finish - start + (21*60*60*1000)) + "\n");

    }

    public void initialize(URL location, ResourceBundle resources) {

    }
}
