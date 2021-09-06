import java.net.*;

public class Server
{
	public static void main(String[] args) throws Exception{
		
		DatagramSocket ds = new DatagramSocket(5555);// for socket
		byte[] receive = new byte[100000];
		DatagramPacket packet ; 

		//--Client Name--//
		packet = new DatagramPacket(receive,receive.length);
		ds.receive(packet);//receive message
		String one = data(receive).toString();
		System.out.println("Client : "+one);
		InetAddress clientAddress = packet.getAddress();
		int clientPort = packet.getPort();
 

		//--Request for no 1--//
		receive = new byte[100000];
		receive = "This program is for Addition Of two Nos.\n-->Enter No. One : ".getBytes();
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.send(packet);//sending request of first no
		

	
		//--Reply for no 1--//
		receive = new byte[100000];
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.receive(packet);//receive no 1
		one = data(receive).toString();
		System.out.println("Client : "+one);


		//--Request for no 2--//
		receive = new byte[100000];
		receive = "-->Enter No. Two : ".getBytes();
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.send(packet);//sending request of second no


		//--Reply for no 2--//
		receive = new byte[100000];
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.receive(packet);//receive no 2
		String two = data(receive).toString();
		System.out.println("Client : "+two);



		int c=-1;
		try{
			int a = Integer.parseInt(one);
			int b = Integer.parseInt(two);
			c = a+b;
		}
		catch(Exception e)
		{
			System.out.println("number is int");
		}


		//-----SENDING ANSWER------//
		receive = new byte[100000];
		receive = String.valueOf(c).getBytes();
		packet = new DatagramPacket(receive,receive.length,clientAddress,clientPort);
		ds.send(packet);//sending ANS

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