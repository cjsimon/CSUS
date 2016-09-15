package Main;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox {
	// Button Pressed
	static int status;
	
	public static int display(String title, String message, double width, double height) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(width);
		window.setMinHeight(height);
		window.setResizable(false);
		
		Label label = new Label();
		label.setText(message);
		
		Button buttonOk = new Button("Ok");
		buttonOk.setPrefWidth(150);
		buttonOk.setOnAction(e -> {
			status = 0;
			window.close();
		});
		
		Button buttonCancel = new Button("Cancel");
		buttonCancel.setPrefWidth(150);
		buttonCancel.setOnAction(e -> {
			status = 1;
			window.close();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, buttonOk, buttonCancel);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
		return status;
	}
}