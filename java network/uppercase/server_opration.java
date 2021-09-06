import java.io.*;
import java.net.*;
public class server_opration
{
   public static void main(String S[])
   {
	   try
	   {
		   ServerSocket ss=new ServerSocket(129);
		   Socket s=ss.accept();
		   DataInputStream din=new DataInputStream(s.getInputStream());  
		   DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		   
           int n1,n2;
		   n1=din.readInt();
		   n2=din.readInt();
		   
		   System.out.println("Client numbers : n1 = "+n1+" n2 = "+n2);
		   dout.writeUTF("which opration ? ");
		   
		   String s1=din.readUTF();
		   System.out.println("opration send by client : "+s1);
		   if(s1.equals("+")) {dout.writeUTF(Integer.toString(n1+n2));dout.flush();}
		   else if(s1.equals("-")) {dout.writeUTF(Integer.toString(n1-n2));dout.flush();}
		   else if(s1.equals("*")) {dout.writeUTF(Integer.toString(n1*n2));dout.flush();}
		   else if(s1.equals("/")) {dout.writeUTF(Integer.toString(n1/n2));dout.flush();}
		   else {dout.writeUTF("not valid opration");dout.flush();}

	   }
	   catch(Exception e)
	   {
		   //
	   }
   }
}


