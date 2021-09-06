import java.io.*;
import java.net.*;
public class server_uppercase
{
   public static void main(String S[])
   {
	   try
	   {
		   ServerSocket ss=new ServerSocket(129);
		   Socket s=ss.accept();
		   DataInputStream din=new DataInputStream(s.getInputStream());  
		   DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		   
        
		   String string=din.readUTF();	   
		   System.out.println("Client String : "+ string);
		   dout.writeUTF(string.toUpperCase());
		   dout.flush();

	   }
	   catch(Exception e)
	   {
		   //
	   }
   }
}


