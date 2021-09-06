import java.io.*;
import  java.net.*;

class client_filesent
{
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost",47);
 
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
         
        System.out.print("Server : "+din.readUTF());
        String fname = br.readLine();
 
        dout.writeUTF(fname);
        System.out.println("Server : "+din.readUTF());
 
        din.close();
        dout.close();
        s.close();
    }
}