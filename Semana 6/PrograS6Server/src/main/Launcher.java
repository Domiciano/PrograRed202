package main;

import javafx.application.Application;
import javafx.stage.Stage;
import view.ChatWindow;

public class Launcher extends Application{

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ChatWindow window = new ChatWindow();
		window.show();
		
	}

}
