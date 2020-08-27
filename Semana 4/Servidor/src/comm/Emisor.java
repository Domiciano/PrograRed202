package comm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Emisor {
	
	
	private OutputStream os;
	private BufferedWriter bwriter;
	
	public Emisor(OutputStream os) {
		this.os = os;
		bwriter = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	
	public void sendMessage(String msg) {
		new Thread(
				()->{
					try {
						bwriter.write(msg+"\n");
						bwriter.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		).start();
	}
	

}
