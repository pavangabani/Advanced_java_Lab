import java.io.*;
import java.net.*;

public class client
{
   public static void main(String S[])
   {
	   
	   try
	   {
		    System.out.println("request send....");
		    Socket s = new Socket("localhost",129);
			System.out.println("Connected successfully");
			
			//PrintStream ps = new PrintStream(s.getOutputStream());
			
			BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.print("client side :"+br.readLine());		
            s.close();			
	   }
	   catch(Exception e)
	   {
		   
		   //
	   }
	   
   }
}