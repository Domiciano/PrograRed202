package main;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		//Wifi, Ethernet
		try {
			Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
			
			while(interfaces.hasMoreElements()) {
				NetworkInterface netN = interfaces.nextElement();
				
				if(netN.isUp()) {
					System.out.println(netN.getName());
					if(netN.getHardwareAddress() != null) {
						
						String mac = new BigInteger(1, netN.getHardwareAddress()).toString(16);
						System.out.println("<<<"+mac);
						//4a:de:f5:d7:f1:0c
						
						List<InterfaceAddress> list = netN.getInterfaceAddresses(); 
						for(int i=0 ; i<list.size() ; i++) {
							System.out.println(">>>"+list.get(i));
						}
						
					}
				}
				
				
			}
			
			
			//Direccion MAC = DIreccion fisica
			//Direccion IP = Identificacion en la red
			
			
			InetAddress myAddress = InetAddress.getLocalHost();
			System.out.println(myAddress.getHostName());
			System.out.println(myAddress.getHostAddress());
			
			
			//Extraer prefijo, prefijo de subred
			NetworkInterface net = NetworkInterface.getByInetAddress(myAddress);
			System.out.println( "Network prefix: " + net.getInterfaceAddresses().get(1).getNetworkPrefixLength() );
			
			//ICMP
			InetAddress ubuntu = InetAddress.getByName("192.168.1.3");
			System.out.println( "Conectado: " + ubuntu.isReachable(500) );
			
			InetAddress motox4 = InetAddress.getByName("192.168.1.4");
			System.out.println( "Conectado: " + motox4.isReachable(500) );
			
			
			InetAddress facebook = InetAddress.getByName("www.facebook.com");
			System.out.println("Facebook IP: "+facebook.getHostAddress());
			
			
			
			int resultado = 192 & 128;
			System.out.println(resultado);
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
