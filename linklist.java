class ll
{
    int n;
    ll next;
    ll(int a)
    {
        n=a;
        next = null;
    }
    void append(ll new_node)
    {
        ll t=this;
        while(t.next!=null)
        {
            t=t.next;
        }
        t=new_node;
    }
    void t()
    {
        ll t=this;
        while(t!=null)
        {
            t=t.next;
            System.out.println(t.n);
        }
    }
    void search(int v)
    {
        ll t = this;
        while(t!=null)
        {
            if(t.n==v)
            {
              System.out.println("value is found");
              break;
            }
        }
        if(t==null)
         System.out.print("value is not found");
    }
}
class linklist
{
    public static void main(String []s)
    {
        ll f_node = new ll(5);
        ll n1 =new ll(10);
        f_node.append(n1);
        f_node.search(5);
    }
}