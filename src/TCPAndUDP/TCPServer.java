package TCPAndUDP;/*
TCPServer.java
*/


import java.net.*;
import java.io.*;


public class TCPServer{

	public static void main(String args[]) throws IOException
	{
		ServerSocket socServer = new ServerSocket(8080);
		Socket soc = socServer.accept();
		
		// Send data to the client
		DataOutputStream dataOutputStream = new DataOutputStream(soc.getOutputStream());
		dataOutputStream.writeUTF("Hello client!");
		
		
		// get data from the client
		DataInputStream dataInputStream = new DataInputStream(soc.getInputStream());
		String inputData = new String(dataInputStream.readUTF());
		
		System.out.println("MSG from the client" + inputData);
		
		dataOutputStream.close();		
		soc.close();

		return;
	
	}

}
