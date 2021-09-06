import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;  
import java.io.*; 

class chatguic extends JFrame implements ActionListener
{
    JPanel p1=new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3= new JPanel();  
	
	JLabel jl[]=new JLabel[100];
	
	JButton jb;
	
	JTextField jtf;
	
	server_sidec s_s;
	
	String mess="  ";
	String cmess="  ";
	int i=0,j=20;
	

	chatguic(String name)
	{
		super(name);
        s_s=new server_sidec();
		jl[0]=new JLabel("write message :");
		p3.add(jl[0]);
		
		jb = new JButton("send");
		
		jtf = new JTextField(20);
		 setLayout(new GridLayout(3,1));  
			
		
		p3.add(jb);
		p3.add(jtf);
		add(p1);
		add(p2);
		add(p3);
		
		
		jb.addActionListener(this);


	}
	void chat(String m)
	{	   
	   jl[i]=new JLabel(m);
	   jl[i].setBounds(10,j,700,j+10); 
	   p2.add(jl[i]);
	   j=j+10;
       i=i+1;
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
				cmess=s_s.read_message();
				cmess="Server : "+cmess+"\n";
				chat(cmess);
				mess = jtf.getText();
				jtf.setText("");
				s_s.send_message(mess);
				mess="You : "+mess+"\n";
				chat(mess);
				
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
class server_sidec
{
	DataInputStream din;
	DataOutputStream dout;
    String cmess="";	
	int temp=0;
	server_sidec()
	{
		try
		{
		Socket s=new Socket("localhost",3333); 
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


class chat_tcp_client
{
	public static void main(String[] args)
	{
		chatguic ref = new chatguic("client");
		ref.setSize(400,500);
		ref.setVisible(true);
		ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

         
