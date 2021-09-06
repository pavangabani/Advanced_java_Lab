class buffer 
{
    int no;
    volatile int flage=0;
    synchronized void put(int a)
    {
        try
        {
            if(flage==1)
             wait();
        no=a;
        flage=1;
        notify();
        System.out.println("produced : "+no);
        }
        catch(Exception e)
        {
            //
        }
        
    }
    synchronized void get()
    {
        try{
            if(flage==0)
              wait();
        flage=0;
        notify();
        System.out.println("connsume : "+no);
        }
        catch(Exception e)
        {

        }
        
    }
}
class produce extends Thread{
    buffer b_ref;
    produce(buffer d_b_ref)
    {
        b_ref=d_b_ref;
        start();
    }
    public void run()
    {
         for(int i=0;i<5;i++)
         {
             b_ref.put(i);
         }
    }
}
class consume extends Thread{
    buffer b_ref;
    consume(buffer d_b_ref)
    {
        b_ref=d_b_ref;
        start();
    }
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            b_ref.get();
        }
    }
}
class p_c_main{
    public static void main(String []s)
    {
        buffer b_ref=new buffer();
        produce p = new produce(b_ref);
        consume c = new consume(b_ref);
    }
}