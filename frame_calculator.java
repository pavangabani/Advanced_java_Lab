import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

class frame_with_t_f extends JFrame implements ActionListner, ItemListner {

    JPanel p1;
    JPanel p2;

    JButton ad;
    JButton sub;
    JButton clear;

    JTextField n1;
    JTextField n2;
    JTextField ans;
     
    int a=0,b=0,answer=0;
    String s="";


    frame_with_t_f(String title)
    {
        super(titile);

        ad=new JButton(" + ");
        sub=new JButton(" - ");
        clear=new JButton(" clear ");

        n1=new JTextField();
        n2=new JTextField();
        ans=new JTextField();

        p1.add(n1);
        p1.add(n2);
        p1.add(ans);
        p1.setLayout(new FlowLayout());
    
        p2.add(ad);
        p2.add(sub);
        p2.add(clear);
        p2.setLayout(new FlowLayout());

        ad.addActionListener(this);
        sub.addActionListener(this);
        clear.addActionListener(this);    

    }
    	
    public void itemStateChanged(ItemEvent e){ }
    public void actionPerfomed(ActionEvent e)
    {
        Object ref = ae.getSource();     
        if( ref instanceof ad) 
        {
            s=n1.getText();
            a=Integer.parseInt(s);
            s=n2.getText();
            b=Integer.parseInt(s);
            answer=a+b;
            ans.setText(answer);
        }
        if( ref instanceof sub)
        { 
            s=n1.getText();
            a=Integer.parseInt(s);
            s=n2.getText();
            b=Integer.parseInt(s);
            answer=a-b;
            ans.setText(answer);

        }
        if( ref instanceof clear) 
        { 
            n1.setText(" ");
            n2.setText(" ");
            a=0; b=0; 
        }

    }
   
    
}

public class frame_calculator 
{
    public static void main(String []s)
    {
        frame_with_t_f f_r = new frame_with_t_f("pavan");
        f_r.setSize(200,300);
        f_r.setVisible(true);

    }
}

