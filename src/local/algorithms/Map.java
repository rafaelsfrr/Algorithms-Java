package local.algorithms;

public class Map<K,V> {
    private NodeMap first;
    private int length;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return length;
    }

    // In this implementation we add on the first - FILO scheme O(1)
    public void add(K key, V value) {
        NodeMap<K,V> nm = new NodeMap<>();
        nm.setKey(key);
        nm.setValue(value);
        nm.setNext(first);
        first = nm;
        length++;
    }

    //O(1)
    public NodeMap getFirst() {
        return first;
    }

    //O(1)
    public NodeMap removeFirst() {
        NodeMap nm = first;
        first = first.getNext();
        length--;
        return nm;
    }

    // O(N)
    public NodeMap getNodeByKey(K key) {
        NodeMap nm = first;

        for(int i = 0; i < length; i++) {
            if(nm.getKey() == key) {
                return nm;
            } else {
                nm = nm.getNext();
            }
        }

        return null;
    }

    // O(N)
    public int getNodeIndex(K key) {
        NodeMap nm = first;

        for(int i = 0; i < length; i++) {
            if(nm.getKey() == key) {
                return i;
            } else {
                nm = nm.getNext();
            }
        }

        return -1;
    }

    // O(N)
    public NodeMap removeByKey(K key) {
        NodeMap nm = first;
        NodeMap nodeBefore = null;

        for(int i = 0; i < length; i++) {
            if(nm.getKey() == key) {
                nodeBefore.setNext(nm.getNext());
                length--;
                return nm;
            } else {
                nodeBefore = nm;
                nm = nm.getNext();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new Map<>();

        map.add(Integer.valueOf(1), "house");
        map.add(Integer.valueOf(10), "yellow");
        map.add(Integer.valueOf(81), "blue");
        map.add(Integer.valueOf(9), "dog");

        // Print all values
        System.out.println("Items <K,V>:");
        NodeMap it = map.first;
        for(int i = 0; i < map.size(); i++) {
            System.out.println("<" + it.getKey() + "," +
                               it.getValue() + ">");
            it = it.getNext();
        }

        // Print index of value by key 10
        System.out.println("Index of key 10: " + map.getNodeIndex(Integer.valueOf(10)));

        // get value by key 10
        NodeMap nm = map.getNodeByKey(Integer.valueOf(10));
        System.out.println("Element<K,V>: " + "<" +
                nm.getKey() + "," + nm.getValue() + ">" );

        // Print list without 10
        map.removeByKey(Integer.valueOf(10));
        System.out.println("Items<K,V>:");
        it = map.first;
        for(int i = 0; i < map.size(); i++) {
            System.out.println("<" + it.getKey() + "," +
                    it.getValue() + ">");
            it = it.getNext();
        }
    }


}
