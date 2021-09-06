class A implements i
{
     void bubbleSort(int arr[]) {
        int n = arr.length;
        int temp = 0;
  
        for(int i = 0; i < n; i++) {
           for(int j=1; j < (n-i); j++) {
              if(arr[j-1] > arr[j]) {
                 temp = arr[j-1];
                 arr[j-1] = arr[j];
                 arr[j] = temp;
              }
           }
        }
    }
    public void sort_array(int arr[])
    {
        
        bubbleSort(arr);

    }

}
class B implements i
{
    void selectionSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
    public void sort_array(int arr[])
    {
    
        selectionSort(arr);

    }

}
class inter
{
    static void print_arr(int arr[])
    {
        int n = arr.length;
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
    public static void main(String []s)
    {
        int arr[] = {64,25,12,22,11};
        A a1=new A();
        B b1=new B();

        a1.sort_array(arr);
        b1.sort_array(arr);
        print_arr(arr);


    }
}