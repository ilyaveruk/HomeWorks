package mines;

import java.io.IOException;

import SimpleFx2.MyController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

public class MinesFX extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Mines sweeper");
		stage.getIcons()
				.add(new Image("https://icons.iconarchive.com/icons/graphicloads/medical-health/16/hand-icon.png"));
		VBox vbox;
		//MyController controller;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("MinesScreen.fxml"));
			vbox = loader.load();
			//controller = loader.getController();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		
		//controller.setTextArea("0");
		Scene scene = new Scene(vbox);
		stage.setScene(scene);
		stage.show();
	}
	
	
	private Mines mines;
	
	
}
