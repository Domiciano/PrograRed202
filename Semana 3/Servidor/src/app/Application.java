package app;

import java.util.Calendar;

import comm.TCPConnection;

public class Application implements TCPConnection.OnMessageListener{
	
	private TCPConnection connection;
	
	public Application() {
			
		connection = TCPConnection.getInstance();
		connection.setPuerto(5000);
		connection.setListener(this);
		
	}
	
	public void init() {
		connection.start();
	}

	
	
	
	@Override
	public void OnMessage(String msg) {
		System.out.println("Recibido: "+msg);
	}

	
	

	
	

}
