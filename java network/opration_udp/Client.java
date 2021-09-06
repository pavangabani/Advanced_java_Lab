import java.net.*;
import java.util.Scanner;
public class Client
{
	public static void main(String[] args) throws Exception{
		DatagramSocket ds = new DatagramSocket();// for socket
		InetAddress ip = InetAddress.getLocalHost(); 
		Scanner keyboard = new Scanner(System.in);
		
		byte[] receive =new byte[6000]; 
		DatagramPacket packet;
		
		//---Sending name---//
		receive="This is Pavan".getBytes();
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.send(packet);//sending number 1

		//--receive request--1//
		receive =new byte[6000];
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.receive(packet);
		System.out.print("Server : "+data(receive));

		//---reply no 1---//
		receive=keyboard.next().getBytes();
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.send(packet);//sending number 1

		//--receive request--2//
		receive =new byte[6000]; 
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.receive(packet);
		System.out.print("Server : "+data(receive));

		//-----reply number 2 ----//
		receive=keyboard.next().getBytes();
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.send(packet);//sending number 2

		//--receive request--2//
		receive =new byte[6000]; 
		packet= new DatagramPacket(receive,receive.length,ip,5555);
		ds.receive(packet);
		System.out.println("Server : "+data(receive));

		ds.close();		
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