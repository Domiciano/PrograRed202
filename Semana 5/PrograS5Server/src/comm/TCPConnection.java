package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
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
	
	private Socket socket;
	private String ip;
	private int puerto;
	private Receptor receptor;
	private Emisor emisor;
	private OnMessageListener listener;
	private OnConnectionListener connectionListener;
	
	
	
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	@Override
	public void run() {
		try {
			
			ServerSocket server = new ServerSocket(puerto);
			System.out.println("Esperando en el puerto " + puerto);
			socket = server.accept();
			System.out.println("Conectado");
			connectionListener.onConnection();
			
			receptor = new Receptor(socket.getInputStream());
			receptor.start();
			
			emisor = new Emisor(socket.getOutputStream());
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setListenerOfMessages(OnMessageListener listener) {
		this.receptor.setListener(listener);
		
	}
	
	public void setConnectionListener(OnConnectionListener connectionListener) {
		this.connectionListener = connectionListener;
	}
	
	public Emisor getEmisor() {
		return this.emisor;
	}
	
	
	public interface OnConnectionListener{
		public void onConnection();
	}
	
	
	


}
