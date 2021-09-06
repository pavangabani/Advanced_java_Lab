class Shape
{
    int a;
    int d1;
    int d2;
    Shape(int d_d1,int d_d2)
    {
        d1=d_d1;
        d2=d_d2;
        a=0;
    }
    void area(){}

}
class Tri extends Shape
{
    Tri(int d1,int d2)
    {
        super(d1,d2);
    }
    void area()
    {
        a=d1*d2/2;
        System.out.println("Tringle Area :"+ a);
    }

}
class Rectangle extends Shape
{ 
    Rectangle(int d1,int d2)
    {
        super(d1,d2);
    }
    void area()
    {
        a=d1*d2;
        System.out.println("Rectangle Area :"+a);
    }
}
public class poly {
    public static void main(String []s)
    {
        Shape s1;
        Tri t =new Tri(10,20);
        Rectangle r=new Rectangle(10,20);

        System.out.println("run time polymorphism");
        s1=t;
        s1.area();
        s1=r;
        s1.area();
        


        System.out.println("without run time polymorphism");
        t.area();
        r.area();
        System.out.print("\n pavan :"+r.a);

    }
}
