import java.io.*;
import java.net.*;

public class client_uppercase
{
   public static void main(String S[])
   {
	   
	try
	{
		Socket s=new Socket("localhost",129);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		
		String string="pavan";
		System.out.println("String : "+string);
		dout.writeUTF(string);
        dout.flush();			
		
        System.out.println("Server Reply :"+din.readUTF());
         		
	}
	catch(Exception e)
	{
		//
	}
	   
   }
}