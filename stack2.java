class stack1
{
    int []a;
    int t;
    stack1()
    {
        a = new int[2];
        t=-1;
    }
    int pop() 
    {
        int p=t;
        try
        {
            if (t<0) throw new Exception(); 
            t=t-1;
            
        }
        catch(Exception e)
        {
            System.out.print("stack underflow\n");
        }
        return a[p];
        
    }
    void push(int v)
    {
        try 
        {
            a[++t] = v;

        }
        catch(Exception e)
        {
            System.out.print("stack overflow  : " +e);
        }
    }

}

public class stack2 {

    public static void main(String[] s) {
        
        try{
            stack1 o = new stack1();
            o.push(5);
            o.push(10);
            System.out.print(o.pop()+"\n");
            System.out.print(o.pop()+"\n");
            System.out.print(o.pop()+"\n");
        }
        catch(Exception e)
        {
            System.out.println("Exception raise\n");
        }
       
        
    }

}