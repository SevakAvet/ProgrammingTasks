package sort;

import java.io.IOException;
import java.util.Random;

public class Main {
    private static final int SIZE = 10_000_000;
    private static final int WARM_UP = 10;
    private static final int TEST_COUNT = 10;

    public static void main(String[] args) throws IOException {
        int[] a = new int[SIZE];

        double[] res = new double[4];
        Runnable[] runnables = new Runnable[4];
        runnables[0] = () -> MergeSort.sort(a);
        runnables[1] = () -> QuickSort.sort(a);
        runnables[2] = () -> HeapSort.sort(a);
        runnables[3] = () -> HeapSort.cheatHeapSort(a);


        String[] names = new String[]{"Merge sort", "Quick sort", "Heap sort", "Heap sort cheat"};
        for (int t = 0; t < 4; t++) {
            System.out.println(names[t] + " started... ");
            System.out.print("warm-up started: ");
            for (int i = 0; i < WARM_UP; i++) {
                System.out.print(". ");
                test(runnables[t], a);
            }
            System.out.println("warm-up finished");

            System.out.print("main tests: ");
            int sum = 0;
            for (int i = 0; i < TEST_COUNT; i++) {
                System.out.print(". ");
                sum += test(runnables[t], a);
            }
            res[t] = sum / TEST_COUNT;
            System.out.println(names[t] + " finished!");
        }

        System.out.println("ARRAY SIZE: " + SIZE);
        System.out.println("WARM-UP: " + WARM_UP);
        System.out.println("TEST COUNT: " + TEST_COUNT);
        System.out.println("---------------------------");
        System.out.println("MERGE SORT: " + res[0] + "ms");
        System.out.println("QUICK SORT: " + res[1] + "ms");
        System.out.println("HEAP SORT: " + res[2] + "ms");
        System.out.println("HEAP SORT CHEAT: " + res[3] + "ms");
    }

    public static void fill(int[] a) {
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(10_000);
        }
    }

    public static long test(Runnable r, int[] a) {
        fill(a);
        long start = System.currentTimeMillis();
        r.run();
        return System.currentTimeMillis() - start;
    }

}

