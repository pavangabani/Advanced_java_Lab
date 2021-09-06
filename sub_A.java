package p2;
import p1.A;
public class sub_A extends A
{
    public sub_A()
    {
        super();
        System.out.print("sub_A constructor");
    }
    public void m()
    {
        A obj=new A();
        System.out.print(obj.a);
    }
} 