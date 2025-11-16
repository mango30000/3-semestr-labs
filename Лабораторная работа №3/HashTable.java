import java.util.*;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int Capacity = 16;

    public static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        K getKey() {
            return key;
        }
        V getValue() {
            return value;
        }
        void setValue(V value) {
            this.value = value;
        }
    }

    public HashTable() {
        this.table = new LinkedList[Capacity];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (table.length - 1);
    }
    
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<Entry<K, V>>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        int index = hash(key);
        if (table[index] == null) return null;
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }  
    public V remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Ключ не может быть null");
        }
        int index = hash(key);
        if (table[index] == null) return null;
        Iterator<Entry<K, V>> iterator = table[index].iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                V removedValue = entry.getValue();
                iterator.remove();
                size--;
                return removedValue;
            }
        }
        return null;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public static void printHashTable(HashTable<String, Integer> ht) {
        for (int i = 0; i < ht.table.length; i++) {
            System.out.print("Index " + i + ": ");
            if (ht.table[i] != null && !ht.table[i].isEmpty()) {
                boolean first = true;
                for (HashTable.Entry<String, Integer> entry : ht.table[i]) {
                    if (!first) System.out.print(", ");
                    System.out.print("'" + entry.key + "', " + entry.value);
                    first = false;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>();

        ht.put("apple", 5);
        ht.put("banana", 3);
        ht.put("apple", 7);

        System.out.println(ht.get("apple"));
        System.out.println(ht.get("banana"));
        System.out.println(ht.get("grape"));

        ht.remove("banana");
        System.out.println(ht.get("banana"));

        System.out.println(ht.size);
        ht.put("orange", 4);
        System.out.println(ht.size);

        System.out.println(ht.isEmpty());
        System.out.println(ht.remove("apple"));
        System.out.println(ht.remove("orange"));
        System.out.println(ht.isEmpty());

        ht.put("strawberry", 1);
        ht.put("raspberry", 5);
        ht.put("apple", 3);
        ht.put("banana", 5);
        printHashTable(ht);
    }
}
    




    // @Override
    // public String toString() {
    //     StringBuilder sb = new StringBuilder();
    //     sb.append("{[");
    //     for (int i = 0; i < table.length; i++) {
    //         if (table[i] != null) { 
    //         sb.append(i).append(":").append(table[i]).append("; ");
    //         }
    //     }
    //     sb.append("]}");
    //     return sb.toString();
    // }




    // @Override
    // public String toString() {
    //     if (size == 0) {
    //         return "{}";
    //     }
    //     StringBuilder sb = new StringBuilder("{");
    //     boolean first = true;
    //     for (LinkedList<Entry<K, V>> bucket : table) {
    //         if (bucket != null) {
    //             for (Entry<K, V> entry : bucket) {
    //                 if (!first) {
    //                     sb.append(", ");
    //                 }
    //                 sb.append(entry.getKey()).append("=").append(entry.getValue());
    //                 first = false;
    //             }
    //         }
    //     }
    //     return sb.append("}").toString();
    // }


