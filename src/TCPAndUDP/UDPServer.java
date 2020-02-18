package TCPAndUDP;/*
Server code using UDP protocol
*/


import java.io.*;
import java.io.IOException;
import java.net.*;
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 

public class UDPServer{
	public static void main(String args[]) throws Exception{
	
	// Create the socket object for 
    DatagramSocket dsServer = new DatagramSocket(4567);
	
	byte[] incomingData= new byte[1024];
	byte[] outgoingData= new byte[1024];
	
	DatagramPacket incomingPacket = new DatagramPacket(incomingData, incomingData.length);
	dsServer.receive(incomingPacket);	
	
	String message = new String(incomingPacket.getData());
	
	System.out.println("MSG Received from the client: " + message);
	
	InetAddress clientIP = incomingPacket.getAddress();
	int clientPort = incomingPacket.getPort();
	
	String messageInUpperCase = message.toUpperCase();
	outgoingData = messageInUpperCase.getBytes();
	
	DatagramPacket outgoingPacket = new DatagramPacket(outgoingData, outgoingData.length, clientIP, clientPort);
	dsServer.send(outgoingPacket);
	
	dsServer.close();
	
	}
}