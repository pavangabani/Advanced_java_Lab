package p2;
import p1.A;
public class sub_A extends A
{
    public sub_A()
    {
        super();
        System.out.print("class sub_A constructor \n");
    }
    public void m()
    {
        A obj=new A();
        System.out.print("in class sub_A made class A object \n");
    }
} 