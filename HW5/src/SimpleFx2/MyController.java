package SimpleFx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class MyController {

    @FXML
    private Button button1;

    @FXML
    private Button button2;
    
    @FXML
    private Text textArea;

    @FXML
    void press1(ActionEvent event) {

    }

    @FXML
    void press2(ActionEvent event) {

    }
    
    public void setTextArea(String msg) {
    	textArea.setText(msg);
    }

}
