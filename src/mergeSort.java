import java.util.Scanner;

public class mergeSort<T extends Comparable<? super T>> {
    public static void main(String[] args) {
        mergeSort<Integer> merge = new mergeSort<>(){};
        Scanner cin = new Scanner(System.in);
        Integer[] Array = new Integer[10];
        for (int i = 0; i < Array.length; i++) {
            int a = cin.nextInt();
            Array[i] = a;
        }
        System.out.println("\nAfter sorting");
        merge.sort(Array);
        for (int i = 0; i < Array.length; i++) {
            System.out.print(Array[i] + " ");
        }
    }
    public void sort(T[] Array){
        sort(Array, 0, Array.length - 1);
    }
    public void sort(T[] Array, int init, int last){
        if (init < last)
        {
            int middle = (init + last) / 2;
            sort(Array, init, middle);
            sort(Array, middle + 1, last);
            sort(Array, init, middle, last);
        }
    }
    public void sort(T[] Array, int init, int middle, int last){
        T[] left = (T[]) new Comparable[middle - init + 1];
        T[] right = (T[]) new Comparable[last - middle];
        for (int i = 0; i < left.length; i++) {
            left[i] = Array[init + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = Array[middle + 1 + i];
        }
        int idx1 = 0, idx2 = 0;
        int ind = init;
        while(idx2 < right.length || idx1 < left.length){
            if(idx1 < left.length && idx2 < right.length){
                if(left[idx1].compareTo(right[idx2]) <= 0){
                    Array[ind++] = left[idx1++];
                }
                else{
                    Array[ind++] = right[idx2++];
                }
            }
            else if(idx1 < left.length){
                Array[ind++] = left[idx1++];
            }
            else if(idx2 < right.length){
                Array[ind++] = right[idx2++];
            }
        }
    }
}