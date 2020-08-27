package comm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Receptor extends Thread{
	
	
	private InputStream is; 
	public OnMessageListener listener;
	
	
	public Receptor(InputStream is) {
		this.is = is;
	}
	
	@Override
	public void run() {
		try {
		
			BufferedReader breader = new BufferedReader(new InputStreamReader(this.is));
			
			while(true) {	
				String msg = breader.readLine();
				if(listener != null) listener.OnMessage(msg);
				else System.out.println("No hay observer");
			}
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public void setListener(OnMessageListener listener) {
		this.listener = listener;
	}
	
	
	public interface OnMessageListener{
		public void OnMessage(String msg); 
	}
	

}
