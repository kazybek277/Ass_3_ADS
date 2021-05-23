import java.util.Scanner;

public class quickSort<T extends Comparable<? super T>> {
    public static void main(String[] args)
    {
        quickSort<Integer> quick = new quickSort<>(){};
        Scanner cin = new Scanner(System.in);
        Integer[] Array = new Integer[10];
        for (int i = 0; i < Array.length; i++) {
            int a = cin.nextInt();
            Array[i] = a;
        }
        System.out.println("\nAfter sorting");
        quick.sort(Array);
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
    }
    public void sort(T[] Array){
        sort(Array, 0, Array.length - 1);
    }
    private void sort(T[] Array, int init, int last)
    {
        if (init < last)
        {
            int middle = partition(Array, init, last);
            sort(Array, init, middle - 1);
            sort(Array, middle, last);
        }
    }
    private int partition(T[] Array, int init, int last) {
        int mid = (init + last) / 2;
        T pivot = Array[mid];
        while (last >= init) {
            while (Array[init].compareTo(pivot) < 0) {
                init++;
            }
            while (pivot.compareTo(Array[last]) < 0) {
                last--;
            }
            if (last >= init) {
                T swap = Array[init];
                Array[init] = Array[last];
                Array[last] = swap;
                ++init;
                --last;
            }
        }
        return init;
    }
}