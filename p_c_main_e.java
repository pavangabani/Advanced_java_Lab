class buffer 
{
    int no[]= new int[2];
    int id;
    volatile int flage=0;
    synchronized void put(int a,int i)
    {
        try
        {
            while(flage==2)
             wait();
             no[flage]=a;
             flage++;
             flage=1;
             notifyAll();
             System.out.print("produce : "+no[flage]);
        }
        catch(Exception e)
        {
            //
        }
        
    }
    synchronized void get(int i)
    {
        try{
            while(flage==0)
              wait();
			  flage--;
              notifyAll();	 
              System.out.print("consume : "+no[flage]);     
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

         b_ref.put(0,id);
         
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
            b_ref.get(id);
    }
}
class p_c_main_e{
    public static void main(String []s)
    {
        buffer b_ref=new buffer();
        produce pcom1 = new produce(b_ref,1);
		produce p2 = new produce(b_ref,2);
		produce p3 = new produce(b_ref,3);
        consume c1 = new consume(b_ref,1);
		consume c2 = new consume(b_ref,2);
		consume c3 = new consume(b_ref,3);
		
		
    }
}