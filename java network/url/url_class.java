import java.io.*;  
import java.net.*;  
public class url_class {  
public static void main(String[] args){  
try{  
URL url=new URL("https://www.bvmengineering.ac.in/syllabi/UG1920/CP/3CP42.pdf");  
URLConnection urlcon=url.openConnection();  
InputStream stream=urlcon.getInputStream();  
int i;  
while((i=stream.read())!=-1){  
System.out.print((char)i);  
}  
}catch(Exception e){System.out.println(e);}  
}  
}