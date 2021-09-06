import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;  
import java.io.*; 

class chatgui extends JFrame implements ActionListener
{
    JPanel p1=new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3= new JPanel();  
	
	JLabel jl[]=new JLabel[100];
	
	JButton jb;
	JButton jb_c;
	
	JTextField jtf;
	
	server_side s_s;
	
	String mess="  ";
	String cmess="  ";
	int i=2,j=10;

	chatgui(String name)
	{
		super(name);
       
		jl[0]=new JLabel("write message :");
		p3.add(jl[0]);
		
		jb = new JButton("send");
		jb_c = new JButton("set_connection");
		
		jtf = new JTextField(20);
		 setLayout(new GridLayout(3,1));  
			
		
		p3.add(jb);
		p1.add(jb_c);
		p3.add(jtf);
		add(p1);
		add(p2);
		add(p3);
		
		
		jb.addActionListener(this);
		jb_c.addActionListener(this);


	}
	void chat(String m)
	{
	   
	   jl[i]=new JLabel(m);
	   jl[i].setBounds(10,j,700,j+10); 
	   p2.add(jl[i]);
       i=i+1; 
	   j=j+10;
       repaint();	   
       	   
	}
	public void actionPerformed(ActionEvent ae)
	{
		
		Object ref = ae.getSource();
		if( ref instanceof JButton)
		{
			String str = ae.getActionCommand();
			if(str.equals("send"))
			{
				mess = jtf.getText();
				jtf.setText("");
				s_s.send_message(mess);
				mess="You : "+mess+"\n";
				chat(mess);
				cmess=s_s.read_message();
				cmess="Client : "+cmess+"\n";
				chat(cmess);
			}
			if(str.equals("set_connection"))
			{
				s_s=new server_side();
				System.out.println("connected");
				jl[1]=new JLabel("connected");
				p1.add(jl[1]);
				
			}
		
		}
	    repaint();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		//g.drawString(mess,100,150+j);
		//g.drawString(cmess,100,170+j);
		//j=j+20;
	}
}
class server_side
{
	DataInputStream din;
	DataOutputStream dout;
    String cmess="";	
	int temp=0;
	server_side()
	{
		try
		{
		ServerSocket ss=new ServerSocket(3333);  
		Socket s=ss.accept();  
		din=new DataInputStream(s.getInputStream());  
		dout=new DataOutputStream(s.getOutputStream());  
		}
		catch( Exception e)
		{
			//
		}
	} 	 
	String read_message()
	{
		try
		{
        cmess=din.readUTF();		
		}
		catch(Exception e)
		{
			//
		}
		return cmess;
		
	}
	void send_message(String mess) 
	{
		try
		{
		dout.writeUTF(mess);  
		dout.flush(); 		
		}
		catch(Exception e)
		{
			//
		}
	}	

}


class chat_tcp_server
{
	public static void main(String[] args)
	{
		chatgui ref = new chatgui("server");
		ref.setSize(400,500);
		ref.setVisible(true);
		ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
