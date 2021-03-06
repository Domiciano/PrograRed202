package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import app.Application;
import comm.Receptor.OnMessageListener;

public class TCPConnection extends Thread{

	
	
	private static TCPConnection instance = null;
	private TCPConnection() {}
	public static synchronized TCPConnection getInstance() {
		
		if(instance == null) {
			instance = new TCPConnection();
		}
		
		return instance;
		
	}
	
	private ServerSocket server;
	private Socket socket;
	private int puerto;
	private Receptor receptor;
	private Emisor emisor;
	private OnMessageListener listener;
	
	
	
	
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	@Override
	public void run() {
		try {
			server = new ServerSocket(puerto);
			
			System.out.println("Esperando un cliente");
			socket = server.accept();
			System.out.println("Cliente conectado");
			
			receptor = new Receptor(socket.getInputStream());
			receptor.setListener(listener);
			receptor.start();
			
			emisor = new Emisor(socket.getOutputStream());
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setListenerOfMessages(OnMessageListener listener) {
		this.listener = listener;
		
	}
	
	public Emisor getEmisor() {
		return this.emisor;
	}
	
	
	


}
