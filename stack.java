class stack1
{
    int []a;
    int t;
    stack1()
    {
        a = new int[10];
        t=-1;
    }
    int pop()
    {
        return(a[t--]);
    }
    void push(int v) {

        a[++t] = v;
    }

    void display() {
        for (int i = 0; i < 10; i++)
            System.out.print(a[i] + " ");
    }

}

public class stack {

    public static void main(String[] s) {
        stack1 o = new stack1();

        for (int i = 0; i < s.length; i++) {
            String s1 = "pop";
            String s2 = "push";
            if(s1.equals(s[i])) o.pop();
            if(s2.equals(s[i]))  { i++; o.push(Integer.parseInt(s[i])); }
              
        }
        o.display();
    }

}