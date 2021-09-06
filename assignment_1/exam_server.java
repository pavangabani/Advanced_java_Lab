import java.io.*;  
import java.net.*;  
public class exam_server 
{  
	public static void main(String[] args)
	{  
		try
		{  
			ServerSocket ss=new ServerSocket(6666);  
			Socket s=ss.accept();
			
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream din=new DataInputStream(s.getInputStream());
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			 
			System.out.println("Ip = "+din.readUTF());
			System.out.println("Port = "+din.readInt());
			System.out.println("Client Message = "+din.readUTF()); 			
			
			String data=br.readLine();
			dout.writeUTF(data);

			System.out.println("Client Message = "+din.readUTF()); 
			
			ss.close();  
			
			
			
		}
		catch(Exception e){System.out.println(e);}  
	}  
} 