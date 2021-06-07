package simpleFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Voting extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new Scene(createRoot(), 260, 120);
		stage.setTitle("Voting Machine");
		stage.getIcons()
				.add(new Image("https://icons.iconarchive.com/icons/graphicloads/medical-health/16/hand-icon.png"));
		stage.setScene(scene);
		stage.show();

	}

	private int i;

	private VBox createRoot() {

		GridPane g = new GridPane();
		g.setPadding(new Insets(5));
		final Label label = new Label("0");
		label.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));

		Button b1 = new Button("Ofra Haza");
		Button b2 = new Button("Yardena Azari");
		g.add(b1, 0, 0);
		g.add(b2, 1, 0);
		g.add(label, 0, 1);
		label.setMaxWidth(Double.MAX_VALUE);
		label.setPrefHeight(500);
		label.setAlignment(Pos.CENTER);
		GridPane.setMargin(b1, new Insets(10, 5, 0, 30));
		GridPane.setMargin(b2, new Insets(10, 10, 0, 10));

		class Increaser implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent event) {
				i++;
				label.setText(i + "");

			}

		}

		class Decreaser implements EventHandler<ActionEvent> {

			@Override
			public void handle(ActionEvent event) {
				i--;
				label.setText(i + "");
			}

		}

		b1.setOnAction(new Increaser());
		b2.setOnAction(new Decreaser());

		VBox vbox = new VBox(5, g, label);

		vbox.setPrefWidth(200);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));

		return vbox;
	}

}
