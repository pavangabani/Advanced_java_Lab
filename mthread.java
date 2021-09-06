class prime extends Thread{
    int l;
    int u;
    prime(int a,int b)
    {
        l=a;
        u=b;
        //this.start();
    }
    public void run()
    {
        int f;
        for(int i=l;i<=u;i++)
        {
            f=0;
            for(int j=1;j<i;j++)
            {
                if(i%j==0)
                {
                    f++;
                }
            }
            if(f==1)
            {
                System.out.print(i+" ");
            }
        }
    }

}
public class mthread {

    public static void main(String []s) throws InterruptedException
    {
    prime t1=new prime(1,100);
    prime t2=new prime(101,200);
    prime t3=new prime(201,300);
     t1.start();
     t1.join();

     t2.start();
     t2.join();

     t3.start();
     t3.join();
    }
    
}
