package mines;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MinesFX extends Application {
	Mines game;
	Button b;
	String setHeight, setWidth, setMines;
	BackgroundFill fill = new BackgroundFill(Color.AQUA, new CornerRadii(10), null);
	Background bBack = new Background(fill);
	String t = ".";

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(createGrid());
		stage.setTitle("The Amazing Mines Sweeper");
		stage.setScene(scene);
		stage.show();

	}

	public GridPane createGrid() {
		GridPane grid = new GridPane();
		Button reset = new Button("Reset");
		reset.setMaxSize(70, 30);
		reset.setMinSize(70, 30);
		Text mines = new Text("Mines");
		Text width = new Text("width");
		Text height = new Text("height");
		TextField fMines = new TextField();
		fMines.setMaxSize(70, 10);
		TextField fHeight = new TextField();
		fHeight.setMaxSize(70, 10);
		TextField fWidth = new TextField();
		fWidth.setMaxSize(70, 10);
		grid.setMinSize(600, 400);
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setAlignment(Pos.BASELINE_LEFT);
		grid.add(reset, 1, 15);
		grid.add(mines, 0, 16);
		grid.add(fMines, 1, 16);
		grid.add(height, 0, 17);
		grid.add(fHeight, 1, 17);
		grid.add(width, 0, 18);
		grid.add(fWidth, 1, 18);
		grid.setStyle(
				"-fx-background-image: url(\"file:///C:/Users/Tal/eclipse-workspace/targil5/src/mines/image2.jpg\")");

		class BoardReset implements EventHandler<javafx.event.ActionEvent> {
			@Override
			public void handle(javafx.event.ActionEvent event) {

				int i;
				setHeight = fHeight.getText();
				setWidth = fWidth.getText();
				setMines = fMines.getText();
				setSize(grid, Integer.parseInt(setHeight), Integer.parseInt(setWidth), Integer.parseInt(setMines));
				for (i = 7; i < grid.getChildren().size(); i++)
					((ButtonBase) grid.getChildren().get(i)).setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							int x, y, j = 0, count = 0;
							event.getSource();
							x = (int) ((Button) event.getSource()).getProperties().get("gridpane-column");
							y = (int) ((Button) event.getSource()).getProperties().get("gridpane-row");
							game.open(y - 10, x - 22);
							String str = game.toString();
							for (int i = 7; i < grid.getChildren().size(); i++) {
								((Labeled) grid.getChildren().get(i)).setText(String.valueOf(str.charAt(j++)));
								if (str.charAt(j) == 'X')
									((Button) grid.getChildren().get(i + 1)).setStyle(
											"-fx-background-image: url(\"file:///C:/Users/Shahar/eclipse-workspace/targil5/src/mines/bomb.jpg\")");
								count++;
								if (count == Integer.parseInt(setWidth)) {
									j++;
									count = 0;
								}
							}
						}
					});
			}
		}
		reset.setOnAction(new BoardReset()); // When reset is pressed
		return grid;
	}

	public void setSize(GridPane grid, int height, int width, int numMines) {

		if (grid.getChildren().size() > 7)
			grid.getChildren().remove(7, grid.getChildren().size());
		game = new Mines(height, width, numMines);
		for (int i = 0; i < height; i++)
			for (int j = 2; j < width + 2; j++) {// start placing from 2nd column
				b = new MyButton(t, j + 20, i + 10);
				b.setBackground(bBack);
				b.setMinSize(30, 30);
				b.setMaxSize(30, 30);
				grid.add(b, j + 20, i + 10);
			}
		for (int i = 0; i < numMines; i++)
			game.addMine(randomWithRange(0, height - 1), randomWithRange(0, width - 1));
	}

	private class MyButton extends Button {
		MyButton(String t, int i, int j) {
			super(t);
		}
	}

	public int randomWithRange(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}
}
