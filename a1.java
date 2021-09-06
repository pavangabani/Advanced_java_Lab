import java.util.Scanner;
class buffer{
    int ar[];
    buffer(int n)
    {
        ar=new int[n];
        for(int i=0;i<n;i++) ar[i]=0;
    }
}
class my_exception extends Exception
{
    int code;
    my_exception(int n)
    {
        code=n;
    }
}
public class a1{

    public static void main(String []s)
    {
        int a=-1,b=-1,n;
        Scanner input =new Scanner(System.in);
        System.out.print("Enter array length :");
        n=input.nextInt(); 
        buffer object =new buffer(n);        
        while(a!=0 && b!=0)
        {
            try{
                a=input.nextInt();
                b=input.nextInt();
                if(a>n) throw new my_exception(1); 
                if(b<0) throw new my_exception(2); 
                if(object.ar[a]!=0) throw new my_exception(3); 
                object.ar[a]=b;
            }
            catch(my_exception e)
            {
                if(e.code==1) System.out.println("index is out of bound");
                if(e.code==2) System.out.println("value is nagative");
                if(e.code==3) System.out.println("already value added on this index");

            }
        }

    }
}