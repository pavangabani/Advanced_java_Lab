
import java.util.Scanner;
class Student{
    String name;
    String branch;
    Student(String s,String b)
    {
        name=s;
        branch=b;
    }

}
class performance extends Student
{
    float cpi;
    performance(float c,String s,String b)
    {
       super(s, b);
       cpi=c;
    }

}
public class a2 {
    public static void main(String []s)
    {
        Scanner input = new Scanner (System.in);
        Scanner input2 = new Scanner (System.in);
        performance st[]=new performance[5]; 
        float a,max=0;
        String c,b;
        for(int i=0;i<5;i++)
        {
            a=input2.nextFloat();
            b=input.nextLine();
            c=input.nextLine();
            st[i]=new performance(a,b,c);
        }

        for(int i=0;i<5;i++)
        {
            if(max<st[i].cpi) max=st[i].cpi;
        }
        for(int i=0;i<5;i++)
        {
            if(st[i].cpi==max)
            {
                System.out.println("name : " + st[i].name);
                System.out.println("branch : "+ st[i].branch);
                System.out.println("cpi :" + st[i].cpi);
            }
        }
    }
}
