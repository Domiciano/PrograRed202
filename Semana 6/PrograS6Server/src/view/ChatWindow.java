package view;

import control.ChatController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Stage{
	
	
	//UI Elements
	private Scene scene;
	private TextArea messagesArea;
	
	private ChatController control;
	

	public ChatWindow() {
		messagesArea = new TextArea();
		
		VBox vBox = new VBox();
		vBox.getChildren().add(messagesArea);
		
		scene = new Scene(vBox, 400,400);
		this.setScene(scene);
		control = new ChatController(this);
	}

	public TextArea getMessagesArea() {
		return messagesArea;
	}
	
	
	

	
	
	

}
