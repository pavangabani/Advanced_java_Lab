import java.util.Scanner;
public class scan {
    public static void main(String []s)
    {
        Scanner input = new Scanner(System.in);
        int  a = input.nextInt();
        int  b = input.nextInt();
        System.out.print(a+b);

        Scanner input2 = new Scanner(System.in);
        String c = input2.nextLine();
        System.out.print(c);

    }
}