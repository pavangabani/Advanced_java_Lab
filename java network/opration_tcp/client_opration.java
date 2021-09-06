import java.io.*;
import java.net.*;

public class client_opration
{
   public static void main(String S[])
   {
	   
	try
	{
		Socket s=new Socket("localhost",129);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		
		int n1=10,n2=11;
		dout.writeInt(n1);
        dout.flush();		
		dout.writeInt(n2);
		dout.flush();	
		
        System.out.println("Server say :"+din.readUTF());
		
		dout.writeUTF("*");
		dout.flush();	
		
        System.out.println(din.readUTF());
         		
	}
	catch(Exception e)
	{
		//
	}
	   
   }
}