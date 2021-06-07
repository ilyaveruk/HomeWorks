package SimpleFx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController {
	
	private int i; 
	
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Label labelText;

    @FXML
    void press1(ActionEvent event) {
    	i++;
    	labelText.setText(i + "");
    }

    @FXML
    void press2(ActionEvent event) {
    	i--;
    	labelText.setText(i + "");
    }
    
    public void setTextArea(String msg) {
    	labelText.setText(msg);
    }



    
   

}
