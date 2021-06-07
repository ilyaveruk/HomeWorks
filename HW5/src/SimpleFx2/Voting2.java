package SimpleFx2;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Voting2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Voting Machine");
		stage.getIcons()
				.add(new Image("https://icons.iconarchive.com/icons/graphicloads/medical-health/16/hand-icon.png"));
		VBox vbox;
		MyController controller;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("VotingScreen.fxml"));
			vbox = loader.load();
			controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		
		controller.setTextArea("0");
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}

}
