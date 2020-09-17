package comm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Emisor {
	
	
	private OutputStream os;
	private BufferedWriter bwriter;
	
	private ArrayList<Thread> pool;
	
	public Emisor(OutputStream os) {
		this.os = os;
		bwriter = new BufferedWriter(new OutputStreamWriter(os));
		pool = new ArrayList<Thread>();
	}
	
	
	public void sendMessage(String msg) {
		Thread h = new Thread(
				()->{
					try {
						bwriter.write(msg+"\n");
						bwriter.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		);
		h.start();
		pool.add(h);
		
	}
	

}
