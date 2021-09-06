import java.io.*;
import java.net.*;
public class server
{
   public static void main(String S[])
   {
	   try
	   {
		   ServerSocket ss=new ServerSocket(129);
		   System.out.println("waiting for request");
		   Socket s=ss.accept();
		   System.out.println("request accepted");
		   
		   PrintStream ps=new PrintStream(s.getOutputStream());
		   BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		   System.out.println("input data at server");
		   ps.print(br.readLine());
		   s.close();
		   ss.close();
	   }
	   catch(Exception e)
	   {
		   //
	   }
   }
}


