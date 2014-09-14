package hash;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        /*testChains();
        testOpenAddressing();*/

        chainsTest();
        System.out.println();
        openAddressingTest();
    }

    private static void openAddressingTest() {
        HashTableOpenAddressing table = new HashTableOpenAddressing();
        table.put(1, 1);
        table.put(1, 2);
        table.put(2, 3);
        table.put(2, 5);

        System.out.println(table.get(1));
        System.out.println(table.get(2));
    }

    private static void chainsTest() {
        HashTableChains table = new HashTableChains();
        table.put(1, 1);
        table.put(1, 2);
        table.put(2, 3);
        table.put(2, 5);

        System.out.println(table.get(1));
        System.out.println(table.get(2));
    }

    private static void testChains() {
        for (int i = 10; i < 1000; i += 10) {
            collisionNumberChains(i);
        }
    }

    private static void testOpenAddressing() {
        for (int i = 10; i < 1000; i += 10) {
            collisionNumberOpenAddressing();
        }
    }

    private static int collisionNumberOpenAddressing() {
        Set<Integer> collisions = new HashSet<>();

        int iterations = 0;
        for (int i = 10; i < 100; i += 10) {
            for (int j = 0; j < i; j++) {
                int hash = HashTableOpenAddressing.hash(i, j, j);
                collisions.add(hash);
                ++iterations;
            }
        }

        System.out.printf("Size: %d, collisions percent: %.1f%%\n", iterations, ((double) iterations / (iterations - collisions.size())));
        return iterations - collisions.size();
    }

    private static int collisionNumberChains(int m) {
        Set<Integer> collisions = new HashSet<>();

        for (int i = 0; i < m; i++) {
            int hash = HashTableChains.hash(m, i);
            collisions.add(hash);
        }

        System.out.printf("Size: %d, collisions percent: %.1f%%\n", m, ((double) m / (m - collisions.size())));
        return m - collisions.size();
    }
}
