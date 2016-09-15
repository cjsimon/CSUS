package Examples;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Scenes extends Application {
	Scene scene1, scene2;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Starts the JavaFX Application with a stage
	 * @param  window
	 * @throws Exception
	 */
	@Override
	public void start(Stage window) throws Exception {
		// Label1
		Label label1 = new Label("This is the first scene");
		
		// Label2
		Label label2 = new Label("This is the second scene");
		
		// Button 1
		Button button1 = new Button();
		button1.setText("Button 1");
		button1.setOnAction(e -> window.setScene(scene2));
		
		// Button 2
		Button button2 = new Button();
		button2.setText("Button2");
		button2.setOnAction(e -> window.setScene(scene1));
		
		// Layout 1 - VBox
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		scene1 = new Scene(layout1, 200, 200);
		
		// Layout 2 - StackPane
		StackPane layout2 = new StackPane();
		layout2.getChildren().addAll(label2, button2);
		scene2 = new Scene(layout2, 300, 300);
		
		window.setTitle("Hello World!");
		window.setScene(scene1);
		window.show();
	}
}









