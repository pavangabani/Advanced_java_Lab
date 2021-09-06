import java.net.*;
public class inet
{
	public static void main(String s[])
	{
		String name="www.facebook.com";
		try
		{
			
			InetAddress ip=InetAddress.getByName(name);
			System.out.print("Host Name / Ip : " + ip);
			System.out.print("\nHost Ip : " + ip.getHostAddress());
			System.out.print("\nHost Name : " + ip.getHostName());
		}
		catch(UnknownHostException e)
		{
		    System.out.print("Not found IpAddress");	
		}
	}
}