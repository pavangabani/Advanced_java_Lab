class Commandline_a
{
    public static void main( String[] s)
    {
        int p=0;
        int n=0;
        for(int i=0;i<s.length;i++)
          try
          {
                int k=Integer.parseInt(s[i]);
                if(k<0) n++;
                if(k>0) p++;  
          } 
          catch(NumberFormatException nfe)
          {
              System.out.print("Exception " + nfe  + "\n");
          }

          System.out.print("potive number " + p + " negative number " +n);
    }
}