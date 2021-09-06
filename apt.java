/*<html>
   <title>The Hello, World Applet</title>
   <hr>
   <applet code = "apt.class" width = "320" height = "120">
   </applet>
   <hr>
</html>*/

import java.applet.*;
import java.awt.*;
public class apt extends Applet {
   public void paint (Graphics g) {
	   for(int i=0;i<10;i++){
      g.drawOval(20,20,200,120);
      g.setColor(Color.green);
      g.fillOval(70,30,100,100);
	  g.setColor(Color.white);
	  
	   }
   }
}