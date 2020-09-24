package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AlfaWindow;

public class Launcher extends Application{
	
	public static void main(String...strings) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AlfaWindow alfa = new AlfaWindow();
		alfa.show();
	}

}
