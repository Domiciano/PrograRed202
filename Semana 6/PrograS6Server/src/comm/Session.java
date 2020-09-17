package comm;

import java.io.IOException;
import java.net.Socket;

import comm.Receptor.OnMessageListener;

public class Session{
	
	
	private String id;
	private Socket socket;
	private Receptor receptor;
	private Emisor emisor;
	private OnMessageListener listener;
	
	
	public Session(String id, Socket socket) {
		try {
			this.id = id;
			this.socket = socket;
			receptor = new Receptor(socket.getInputStream());
			receptor.start();
			emisor = new Emisor(socket.getOutputStream());
		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public Emisor getEmisor() {
		return this.emisor;
	}
	
	public Receptor getReceptor() {
		return this.receptor;
	}
	
	public String getId() {
		return id;
	}

}
