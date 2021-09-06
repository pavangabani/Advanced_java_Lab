class Commandline_b
{
    public static void main( String[] s)
    {
        int p=0;
        int n=0;
        
          
            for(int i=0;i<s.length;i++)
            {
                int k=Integer.parseInt(s[i]);
                if(k<0) n++;
                if(k>0) p++;  
            }
         

          System.out.print("potive number " + p + " negative number " +n);
    }
}