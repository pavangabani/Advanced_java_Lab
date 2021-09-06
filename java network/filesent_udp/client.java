import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner; 

public class client
{ 
	public static void main(String args[]) throws IOException 
	{ 
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getLocalHost(); 
		Scanner keyboard = new Scanner(System.in);
		 
		String filename=keyboard.nextLine();
		byte[] receive =new byte[6000]; 
		DatagramPacket packet;
		receive=filename.getBytes();
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.send(packet);
		
		receive =new byte[6000];
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.receive(packet);
		System.out.print("Server : "+data(receive));
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
