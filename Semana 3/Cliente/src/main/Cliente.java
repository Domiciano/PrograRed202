package main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		
		try {
			Socket socket = new Socket("127.0.0.1",5000);
			
			
			OutputStream out = socket.getOutputStream();			
			BufferedWriter bwriter = new BufferedWriter(new OutputStreamWriter(out));
			
			
			Scanner scan = new Scanner(System.in);
			
			while(true) {
				
				
				String line = scan.nextLine() + "\n";
				bwriter.write(line);
				bwriter.flush();
				
				
				
			}
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
