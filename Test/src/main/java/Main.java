import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] a = {5, 2, 1, 4, 5, 2, 1, 2, 3};

        MergeSort.sort(a);
        QuickSort.sort(a);
        HeapSort.sort(a);
        HeapSort.cheatHeapSort(a);

        System.out.println(Arrays.toString(a));
    }
}

