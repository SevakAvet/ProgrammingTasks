public class QuickSort {
    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int low, int high) {
        int i = low;
        int j = high;
        int mid = (i + j) / 2;

        while (i <= j) {
            while (a[i] < a[mid]) ++i;
            while (a[j] > a[mid]) --j;

            if(i <= j) {
                swap(a, i, j);
                ++i;
                --j;
            }
        }

        if(low < j) {
            sort(a, low, j);
        }

        if(i < high) {
            sort(a, i, high);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
