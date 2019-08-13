package welcomeCircle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.geometry.Point2D;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Welcome extends Application {
	@Override
	public void start(Stage primaryStage) {
		double radius = 100;
		double angle = 0;
		double rotate = 90;
		
		Pane pane = new Pane();
		String[] welcome = "Welcome to Java".split("");
		Point2D centre = new Point2D(150, 150);
		Font font = Font.font("Times New Roman", FontWeight.BOLD, 30);
		
		for (int i = 0; i < welcome.length; i++) {
			angle += 22;
			rotate += 22;
			double x = centre.getX() + radius * Math.cos(Math.toRadians(angle));
			double y = centre.getY() + radius * Math.sin(Math.toRadians(angle));
			Text msg = new Text(x, y, welcome[i]);
			msg.setFont(font);
			msg.setRotate(rotate);
			pane.getChildren().add(msg);
		}
		
		Scene scene = new Scene(pane, 300, 300);
		primaryStage.setTitle("Welcome to Java");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}

}
