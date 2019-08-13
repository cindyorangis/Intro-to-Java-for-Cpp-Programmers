package checkerBoard;

import javafx.application.Application;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class CheckerBoard extends Application {
	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		
		int count = 0;
		int side = 80;
		for (int i = 0; i < 8; i++) {
			count++;
			for (int j = 0; j < 8; j++) {
				Rectangle rect = new Rectangle(side, side, side, side);
				if (count % 2 == 0) {
					rect.setFill(Color.WHITE);
				}
				grid.add(rect,  j,  i);
				count++;
			}
		}
		Scene scene = new Scene(grid);
		primaryStage.setTitle("Chess Board");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
}
