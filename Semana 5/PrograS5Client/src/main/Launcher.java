package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ChatWindow;
import view.ConnectionWindow;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ConnectionWindow window = new ConnectionWindow();
		window.show();
	}

}
