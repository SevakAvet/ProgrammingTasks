package sort;

import java.util.PriorityQueue;

public class HeapSort {
    private static int heapSize;

    public static void sort(int[] a) {
        buildHeap(a);
        while (heapSize > 1) {
            swap(a, 0, heapSize - 1);
            heapSize--;
            heapify(a, 0);
        }
    }

    private static void buildHeap(int[] a) {
        heapSize = a.length;
        for (int i = a.length / 2; i >= 0; i--) {
            heapify(a, i);
        }
    }

    private static void heapify(int[] a, int i) {
        int l = 2 * i + 2;
        int r = 2 * i + 1;
        int largest = i;
        if (l < heapSize && a[i] < a[l]) {
            largest = l;
        }
        if (r < heapSize && a[largest] < a[r]) {
            largest = r;
        }
        if (i != largest) {
            swap(a, i, largest);
            heapify(a, largest);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void cheatHeapSort(int[] a) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(a.length);
        for (int x : a) {
            heap.add(x);
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = heap.remove();
        }
    }
}