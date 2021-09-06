import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class add_sub_jframe extends JFrame implements ActionListener
{
	JPanel jp;
	JPanel jp1;
	
	JButton jb1;
	JButton jb2;
	JButton jb3;
	
	JTextField jtf1;
	JTextField jtf2;
	JTextField jtf3;
	
	JLabel jl1;
	JLabel jl2;
	JLabel jl3;
	
	String s = "";
	String s1 = "";
	String str = "";
	String answer = "";
	int ans;
	add_sub_jframe(String name)
	{
		super(name);
		
		jp = new JPanel();
		jp1 = new JPanel();
		setLayout(new GridLayout(2,1));
		add(jp);
		add(jp1);
		
		jl1 = new JLabel("First Number   : ");
		jtf1 = new JTextField(20);
		jl2 = new JLabel("Second Number   : ");
		jtf2 = new JTextField(20);
		jl3 = new JLabel("ANSWER    =");
		jtf3 = new JTextField(20);
		//jp.setLayout(new GridLayout(3,2));
		jp.setLayout(new FlowLayout());
		jp.add(jl1);
		jp.add(jtf1);
		jtf1.addActionListener(this);
		jp.add(jl2);
		jp.add(jtf2);
		jtf2.addActionListener(this);
		jp.add(jl3);
		jp.add(jtf3);
		jtf3.addActionListener(this);
		
		jb1 = new JButton("ADD");
		jb2 = new JButton("SUB");
		jb3 = new JButton("CLEAR");
		jp1.setLayout(new FlowLayout());
		jp1.add(jb1);
		jb1.addActionListener(this);
		jp1.add(jb2);
		jb2.addActionListener(this);
		jp1.add(jb3);
		jb3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object ref = ae.getSource();
		if( ref instanceof JButton)
		{
			str = ae.getActionCommand();
			if(str.equals("ADD"))
			{
				s = jtf1.getText();
				s1 = jtf2.getText();
				ans = Integer.parseInt(s) + Integer.parseInt(s1);
				answer = Integer.toString(ans);
				jtf3.setText(answer);
			}
			if(str.equals("SUB"))
			{
				s = jtf1.getText();
				s1 = jtf2.getText();
				ans = Integer.parseInt(s) - Integer.parseInt(s1);
				answer = Integer.toString(ans);
				jtf3.setText(answer);
			}
			if(str.equals("CLEAR"))
			{
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
			}
			repaint();
		}
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
	}
}

class add_sub_jframe_main
{
	public static void main(String[] args)
	{
		add_sub_jframe ref = new add_sub_jframe("ADD-SUBTRACT");
		ref.setSize(400,500);
		ref.setVisible(true);
		ref.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
