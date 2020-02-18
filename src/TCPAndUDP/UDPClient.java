package TCPAndUDP;/*
Client code using UDP protocol
*/


import java.io.*;
import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 

public class UDPClient{
	public static void main(String args[]) throws Exception{
		
		BufferedReader incoming = new BufferedReader(new InputStreamReader(System.in));
		
		// Create the socket object for UDP based connection, that binds to a arbitary port
        DatagramSocket ds = new DatagramSocket();
		
		InetAddress Ip = InetAddress.getLocalHost();
		/*
		InetAddress clientIp = InetAddress.getByName("localhost");
		*/
		
        byte[] incomingData= new byte[1024];
		byte[] outgoingData= new byte[1024];
	
	
		String message = incoming.readLine();
		outgoingData = message.getBytes();
		
		DatagramPacket outgoingPacket = new DatagramPacket(outgoingData, outgoingData.length, Ip, 4567);	
		ds.send(outgoingPacket);
		
		DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
		ds.receive(incomingPacket);		
		String messageInCap = new String(incomingPacket.getData());
		
		System.out.println("MSG Received from the Server: "+ messageInCap);
		
		ds.close();
		
	}
}