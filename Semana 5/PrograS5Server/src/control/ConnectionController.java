package control;

import comm.TCPConnection;
import javafx.application.Platform;
import view.ChatWindow;
import view.ConnectionWindow;

public class ConnectionController implements TCPConnection.OnConnectionListener{
	
	private ConnectionWindow view;
	private TCPConnection connection;
	
	public ConnectionController(ConnectionWindow view) {
		this.view = view;
		init();
	}
	
	public void init() {
		connection = TCPConnection.getInstance();
		connection.setPuerto(5000);
		connection.setConnectionListener(this);
		connection.start();
	}

	@Override
	public void onConnection() {
		//Estamos conectados
		//No se puede usar metodos con resultado grafico en un hilo que no sea el principal
		Platform.runLater(
				
				()->{
					ChatWindow window = new ChatWindow();
					window.show();
					view.close();
				}
				
				);
	}
	

}
