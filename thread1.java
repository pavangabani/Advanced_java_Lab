public class thread1 {
    public static void main(String []s)
    {
        Thread t_ref;
        t_ref=Thread.currentThread();
        t_ref.setPriority(3);
        t_ref.setName("Pavan");

        System.out.println(t_ref);

        String s1=t_ref.getName();
        int p=t_ref.getPriority();

        System.out.println("Name :" + s1 + " Priority :"+ p );

    }
}
