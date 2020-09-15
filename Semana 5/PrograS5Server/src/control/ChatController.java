package control;

import comm.Receptor.OnMessageListener;

import java.util.Calendar;
import java.util.UUID;

import com.google.gson.Gson;

import comm.TCPConnection;
import javafx.application.Platform;
import model.Message;
import view.ChatWindow;

public class ChatController implements OnMessageListener{
	
	private ChatWindow view;
	private TCPConnection connection;
	
	public ChatController(ChatWindow view) {
		this.view = view;
		init();
	}
	
	public void init() {
		connection = TCPConnection.getInstance();
		connection.setListenerOfMessages(this);
		
		
		view.getSendBtn().setOnAction(
					(e)->{
						String id = UUID.randomUUID().toString();
						String date = Calendar.getInstance().getTime().toString();
						String msg = view.getMessageTF().getText();
						Message msgObj = new Message(id, msg, date);
						Gson gson = new Gson();
						String json = gson.toJson(msgObj);
						
						
						connection.getEmisor().sendMessage(json);
						view.getMessageTF().setText("");
						view.getMessagesArea().appendText(">>> " + date + ": " + msg + "\n");
					}
		);
		
		
	}

	@Override
	public void OnMessage(String msg) {
		Platform.runLater(
				
				()->{
					Gson gson = new Gson();
					Message msjObj = gson.fromJson(msg, Message.class);
					view.getMessagesArea().appendText("<<< "+ msjObj.getDate() +": " +msjObj.getBody()+"\n");
				}
				
				);
		
		
	}

}
