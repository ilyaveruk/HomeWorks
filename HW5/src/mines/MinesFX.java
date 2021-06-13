package mines;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MinesFX extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		
		
		try {
			Controller controller = new Controller();
			
			Parent root = FXMLLoader.load(getClass().getResource("MinesFXML.fxml"));
			Scene scene = new Scene(root);
			
			stage.setTitle("The Amazing Mines Sweeper");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
	}

}
