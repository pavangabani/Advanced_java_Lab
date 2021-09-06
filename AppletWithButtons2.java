import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AppletWithButtons2 extends Applet implements ActionListener {
	
    Button button1, button2,button3;
    int c1=0,c2=-0,c3=0;

	String s,s1="button1 :",s2="button2",s3="button3";
	public void init(){
		
	
		button1 = new Button("Button 1");
		add(button1);
		button1.addActionListener(this);

		button2 = new Button("Button 2");
		add(button2);
        button2.addActionListener(this);
        
        button3 = new Button("Button 3");
		add(button3);
        button3.addActionListener(this);
        
        setLayout(new FlowLayout());
	}

	public void actionPerformed(ActionEvent e) {
        s=e.getActionCommand();
        if(s.equals("Button 1"))
        {
              c1++;
        }
        if(s.equals("Button 2"))
        {
              c2++;
        }
        if(s.equals("Button 3"))
        {
              c3++;
        }

		repaint();
	}
	public void paint (Graphics g)
	{
        super.paint(g);
        
        g.drawString(s1,100,100);
        g.drawString(" "+c1,150,100);
        g.drawString(s2,100,200);
        g.drawString(" "+c2,150,200);
        g.drawString(s3,100,300);
        g.drawString(" "+c3,150,300);
		System.out.println(s);
	}
}

