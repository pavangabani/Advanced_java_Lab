import java.io.*;    
import java.net.*;    
public class url_http{    
public static void main(String[] args){    
try{    
URL url=new URL("https://www.bvmengineering.ac.in/syllabi/UG1920/CP/3CP42.pdf");    
HttpURLConnection huc=(HttpURLConnection)url.openConnection();  
for(int i=1;i<=8;i++){  
System.out.println(huc.getHeaderFieldKey(i)+" = "+huc.getHeaderField(i));  
}  
huc.disconnect();   
}catch(Exception e){System.out.println(e);}    
}    
}  