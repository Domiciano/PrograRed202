package view;

import control.ChatController;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChatWindow extends Stage{
	
	
	//UI Elements
	private Scene scene;
	private TextField messageTF;
	private Button sendBtn;
	private TextField clientIDTF;
	private Button sendDirectBtn;
	private TextArea messagesArea;
	private ChatController contol;
	
	
	public ChatWindow() {
		
		messageTF = new TextField();
		sendBtn = new Button("Enviar");
		messagesArea = new TextArea();
		clientIDTF = new TextField();
		sendDirectBtn = new Button("Enviar directo");
		
		VBox vBox = new VBox();
		vBox.getChildren().add(messageTF);
		vBox.getChildren().add(sendBtn);
		vBox.getChildren().add(clientIDTF);
		vBox.getChildren().add(sendDirectBtn);
		vBox.getChildren().add(messagesArea);
		
		scene = new Scene(vBox, 400,400);
		this.setScene(scene);
		contol = new ChatController(this);
	}



	public TextField getMessageTF() {
		return messageTF;
	}



	public Button getSendBtn() {
		return sendBtn;
	}



	public TextArea getMessagesArea() {
		return messagesArea;
	}



	public TextField getClientIDTF() {
		return clientIDTF;
	}



	public Button getSendDirectBtn() {
		return sendDirectBtn;
	}
	
	
	
	
	
	
	

}
