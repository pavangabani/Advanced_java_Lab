import java.util.Scanner;
class matrix
{
    int [][]a;
    int m,n;
    matrix()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter n & m : ");
        m=input.nextInt();
        n=input.nextInt();
        a= new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("Enter element "+i+" "+ j + " value : ");
                a[i][j]=input.nextInt();
            }
        }
    }
    matrix(int dm,int dn)
    {
        m=dm;
        n=dn;
        a= new int[m][n];
    }
    matrix add(matrix m1)
    {
        matrix result = new matrix(this.m,this.n);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                result.a[i][j] = m1.a[i][j]+this.a[i][j];
            }
            
        }
        return result;

    }
    void display()
    {
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(this.a[i][j]+" ");
            }
            System.out.print("\n");   
        } 

    }

}
class m
{
    public static void main(String []s)
    {
        matrix m1= new matrix();
        matrix m2= new matrix();
        matrix r = new matrix(m1.m,m1.n);
        r = m2.add(m1);
        r.display();
        
    }
}