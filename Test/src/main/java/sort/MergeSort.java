package sort;

public class MergeSort {
    private static int[] numbers;
    private static  int[] temp;

    public static void sort(int[] a) {
        numbers = a;
        temp = new int[numbers.length];
        sort(0, numbers.length - 1);
    }

    private static void sort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            sort(low, middle);
            sort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (temp[i] <= temp[j]) {
                numbers[k] = temp[i];
                i++;
            } else {
                numbers[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = temp[i];
            k++;
            i++;
        }
    }
} 