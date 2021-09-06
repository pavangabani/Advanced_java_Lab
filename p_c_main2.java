class buffer 
{
    int no;
    volatile int flage=0;
    synchronized void put(int a,int id)
    {
        try
        {
            while(flage==1)
             wait();
			 no=a;
             flage=1;
             notifyAll();
             System.out.println("id : "+id +" produced : "+no);    
        }
        catch(Exception e)
        {
            //
        }
        
    }
    synchronized void get(int id)
    {
        try{
            while(flage==0)
              wait();
			  flage=0;
              notifyAll();
              System.out.println("id : "+id +" connsume : "+no);	      
        }
        catch(Exception e)
        {

        }
        
    }
}
class produce extends Thread{
    buffer b_ref;
	int id;
    produce(buffer d_b_ref,int i)
    {
        b_ref=d_b_ref;
		id=i;
        start();
    }
    public void run()
    {

         for(int i=0;i<2;i++)
         {
             b_ref.put(i,id);
         }
    }
}
class consume extends Thread{
    buffer b_ref;
	int id;
    consume(buffer d_b_ref,int i)
    {
        b_ref=d_b_ref;
		id=i;
        start();
    }
    public void run()
    {
        for(int i=0;i<2;i++)
        {
            b_ref.get(id);
        }
    }
}
class p_c_main2{
    public static void main(String []s)
    {
        buffer b_ref=new buffer();
        produce p1 = new produce(b_ref,1);
		produce p2 = new produce(b_ref,2);
		produce p3 = new produce(b_ref,3);
        consume c1 = new consume(b_ref,1);
		consume c2 = new consume(b_ref,2);
		consume c3 = new consume(b_ref,3);
		
		
    }
}