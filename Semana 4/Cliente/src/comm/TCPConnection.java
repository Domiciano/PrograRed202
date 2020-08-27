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
	
	private Socket socket;
	private String ip;
	private int puerto;
	private Receptor receptor;
	private Emisor emisor;
	private OnMessageListener listener;
	
	
	
	
	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Override
	public void run() {
		try {
			
			
			System.out.println("Esperando un cliente");
			socket = new Socket(ip, puerto);
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
