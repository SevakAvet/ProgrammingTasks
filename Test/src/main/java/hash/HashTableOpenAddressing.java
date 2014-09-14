package hash;

import java.util.NoSuchElementException;

public class HashTableOpenAddressing {
    private static int TABLE_SIZE = 1 << 6;
    private Entry[] table;

    public HashTableOpenAddressing() {
        table = new Entry[TABLE_SIZE];
    }

    public void put(int key, int value) {
        int x = hash1(TABLE_SIZE, key);
        int y = hash2(TABLE_SIZE, key);

        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[x] == null || (table[x] != null && table[x].getKey() == key)) {
                table[x] = new Entry(key, value);
                return;
            }
            x = (x + y) % TABLE_SIZE;
        }

        resize();
    }

    public int get(int key) {
        int x = hash1(TABLE_SIZE, key);
        int y = hash2(TABLE_SIZE, key);

        for (int i = 0; i < TABLE_SIZE; i++) {
            if (table[x] != null) {
                if (table[x].getKey() == key) {
                    return table[x].getValue();
                }
            } else {
                break;
            }

            x = (x + y) % TABLE_SIZE;
        }

        throw new NoSuchElementException("Element by key = " + key + " not found!");
    }

    private void resize() {
        TABLE_SIZE <<= 1;
        Entry[] newTable = new Entry[TABLE_SIZE];
        System.arraycopy(table, 0, newTable, 0, table.length);
        table = newTable;
    }

    public static int hash(int tableSize, int key, int i) {
        return hash1(tableSize, key) + i * hash2(tableSize, key);
    }


    private static int hash1(int tableSize, int key) {
        return key % tableSize;
    }

    private static int hash2(int tableSize, int key) {
        return 1 + key % (tableSize - 1);
    }
}
