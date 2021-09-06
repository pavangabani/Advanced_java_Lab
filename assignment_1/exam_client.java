import java.io.*;  
import java.net.*;  
public class exam_client 
{  
	public static void main(String[] args)
	{  
		try
		{      
			Socket s=new Socket("localhost",6666);  
			
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream din=new DataInputStream(s.getInputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			
			InetAddress ip=s.getInetAddress(); 
			int port=s.getPort();
			
			dout.writeUTF(ip.toString());  
			dout.flush();  
			dout.writeInt(port);  
			dout.flush(); 
			
			String data=br.readLine();
			dout.writeUTF(data);  
			dout.flush();
			
			System.out.println("Server Message = "+din.readUTF()); 
			
			dout.writeUTF("Exit");  
			dout.flush();
			
			din.close();
			dout.close();  
			s.close();  
		}
		catch(Exception e){System.out.println(e);}  
	}  
}  