package app;

import java.util.Calendar;
import java.util.Scanner;

import comm.Emisor;
import comm.Receptor.OnMessageListener;
import comm.TCPConnection;

public class Application implements OnMessageListener{
	
	private TCPConnection connection;
	
	public Application() {
			
		connection = TCPConnection.getInstance();
		connection.setIp("127.0.0.1");
		connection.setPuerto(5000);
		connection.setListenerOfMessages(this);
		
	}
	
	public void init() {
		connection.start();
		
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String line = scanner.nextLine();
			
			Emisor m = connection.getEmisor();
			if(m!=null) m.sendMessage(line);
			else System.out.println("Ningun cliente se ha conectado aun");
		}
		
	}

	
	
	
	@Override
	public void OnMessage(String msg) {
		System.out.println("Recibido: "+msg);
	}

	
	

	
	

}
