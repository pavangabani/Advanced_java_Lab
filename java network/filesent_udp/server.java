// Java program to illustrate Server side 
// Implementation using DatagramSocket 
import java.io.*; 
import java.net.*;
import java.util.Scanner;


public class server 
{ 
	public static void main(String[] args) throws IOException 
	{ 
		DatagramSocket ds = new DatagramSocket(5555);// for socket
		byte[] receive = new byte[100000];
		DatagramPacket packet ; 

		packet = new DatagramPacket(receive,receive.length);
		ds.receive(packet);//receive message
		String one = data(receive).toString();
		System.out.println("Client : "+one);
		InetAddress clientAddress = packet.getAddress();
		int clientPort = packet.getPort();
		
	String file_content=" ";
      try 
	  {

		File myObj = new File(one);
		Scanner myReader = new Scanner(myObj);
		while (myReader.hasNextLine()) 
		{
			file_content = file_content+ myReader.nextLine()+"\n";
		}
		myReader.close();
      } 
	  catch (FileNotFoundException e) 
	  {
		System.out.println("An error occurred.");
        e.printStackTrace();
      }

	  receive = new byte[100000];
		receive = file_content.getBytes();
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.send(packet);
	  
	} 
	public static StringBuilder data(byte[] a) 
	{ 
		if (a == null) 
			return null; 
		StringBuilder ret = new StringBuilder(); 
		int i = 0; 
		while (a[i] != 0) 
		{ 
			ret.append((char) a[i]); 
			i++; 
		} 
		return ret; 
	} 
} 
