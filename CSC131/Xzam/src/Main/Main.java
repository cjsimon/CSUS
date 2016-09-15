package Main;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage window) {
		window.setTitle("Main");
		
		Button button = new Button();
		button.setText("Click Me!");
		button.setOnAction(e -> AlertBox.display("Title", "WOW!", 250, 150));
		
		window.setOnCloseRequest(e -> {
			e.consume(); // Swallow the action event
			closeProgram(window);
		});
		
		StackPane layout = new StackPane();
		layout.getChildren().addAll(button);
		
		Scene scene = new Scene(layout, 300, 300);
		window.setScene(scene);
		window.show();
	}
	
	public void closeProgram(Stage window) {
		int status = AlertBox.display("Quit", "Are you sure you want to quit?", 250, 150);
		if(status == 1) window.close();
	}
}
