package hash;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HashTableChains {
    private static final int TABLE_SIZE = 1 << 10;
    private ArrayList<Entry>[] table;

    public HashTableChains() {
        table = new ArrayList[TABLE_SIZE];
    }

    public void put(int key, int value) {
        Entry entry = new Entry(key, value);
        int hash = hash(TABLE_SIZE, key);

        if(table[hash] == null) {
            table[hash] = new ArrayList<>();
        }

        boolean hasPutted = false;
        for (Entry tableEntry : table[hash]) {
            if(tableEntry.getKey() == key) {
                tableEntry.setValue(value);
                hasPutted = true;
                break;
            }
        }

        if(!hasPutted) {
            table[hash].add(entry);
        }
    }

    public int get(int key) {
        int hash = hash(TABLE_SIZE, key);

        if(table[hash] == null) {
            throw new NoSuchElementException("Element by key = " + key + " not found!");
        }

        ArrayList<Entry> chain = table[hash];
        System.out.println("Key: " + key + " chain: " + chain);
        int result = -1;
        for (Entry entry : chain) {
            if(entry.getKey() == key) {
                result = entry.getValue();
            }
        }

        return result;
    }

    public static int hash(int m, int key) {
        return (int) (m * ((key * 0.61) % 1.0));
    }
}
