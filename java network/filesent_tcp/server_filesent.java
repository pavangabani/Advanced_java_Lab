import java.io.*;
import java.net.*;
public class server_filesent
{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(47);
        Socket s = ss.accept();
 
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        dout.writeUTF("Enter File Name : ");
        String fname = din.readUTF();
        System.out.println("Client : " + fname);
 
        File f = new File(fname);
 
        String content = "";
 
        try {
            BufferedReader nbr = new BufferedReader(new FileReader(f));
            String tmp = nbr.readLine();
            while (tmp=!null)
			{
				content+=tmp+"\n";
				tmp=readLine();
			}
            System.out.println(content);
            dout.writeUTF(content);
        } catch (Exception e) {
            dout.writeUTF("File Does not Exists");
        }
        s.close();
        ss.close();
        din.close();
        dout.close();
    }
}


