package TCPAndUDP;/*
TCPClient.java
*/


import java.net.*;
import java.io.*;

public class TCPClient{
	
	public static void main(String args[]) throws IOException {
	
	Socket socClient = new Socket("localhost",8080);

	
	// receiving MSG from the server
	DataInputStream dataInputStream = new DataInputStream(socClient.getInputStream());
	String inputStream = new String(dataInputStream.readUTF());
	System.out.println("Message Sent by server: " + inputStream);
	
	
	// MSG send to the server
	DataOutputStream dataOutputStream
	= new DataOutputStream(socClient.getOutputStream());
	dataOutputStream.writeUTF("Hello Server, this is client hitting at port 8080");
	
	dataInputStream.close();
	dataOutputStream.close();	
	socClient.close();
	
	return;
	}
}







