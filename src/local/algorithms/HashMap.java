package local.algorithms;

import java.lang.reflect.Array;

public class HashMap<K,V> {
    private NodeMap<K,V>[] map;

    public HashMap(Class<NodeMap> clazz, int size) {
        map = (NodeMap<K,V>[]) Array.newInstance(clazz, size);
    }

    public NodeMap[] getMap() {
        return map;
    }

    // O(1)
    public int getHash(K key) throws Exception {

        // This method accept a String or a Integer key
        if(key instanceof Integer) {
            return ((Integer) key).intValue() % map.length;
        } else if(key instanceof String) {
            return Integer.getInteger((String) key).intValue() % map.length;
        } else {
            throw new Exception("Key must be a String or a Integer");
        }
    }

    // O(1) because we always add on the first element
    public void add(K key, V value) throws Exception {
        int index = getHash(key);
        NodeMap<K,V> nn = new NodeMap<>();
        nn.setKey(key);
        nn.setValue(value);
        nn.setNext(map[index]);
        map[index] = nn;
    }

    // O(1) if no conflicts and O(N) if has conflicts
    public V get(K key) throws Exception{
        int index = getHash(key);

        NodeMap<K,V> it;
        it = map[index];

        // Search the list for the element. If there is no conflicts with the hash, this
        // method is O(1), otherwise is O(list.lenght), i.e, O(N)
        while(it.getNext() != null) {
            if(it.getKey() != key) {
                it = it.getNext();
            } else {
                return it.getValue();
            }
        }
        return null;
    }

    // O(1) if no conflicts and O(N) if has conflicts
    public void remove(K key) throws Exception {
        int index = getHash(key);

        NodeMap<K,V> it, aux;
        it = map[index];
        aux = it;

        // Search the list for the element. If there is no conflicts with the hash, this
        // method is O(1), otherwise is O(list.lenght), i.e, O(N)
        while(it.getNext() != null) {
            if(it.getKey() != key) {
                aux = it;
                it = it.getNext();
            } else {
                break;
            }
        }

        if(map[index] == it) {
            map[index] = it.getNext();
        } else {
            aux.setNext(it.getNext());
        }


    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>(
                NodeMap.class,10);

        try {
            hash.add(Integer.valueOf(1),Integer.valueOf(10));
            hash.add(Integer.valueOf(5),Integer.valueOf(20));
            hash.add(Integer.valueOf(2),Integer.valueOf(250));
            hash.add(Integer.valueOf(10),Integer.valueOf(11));
            hash.add(Integer.valueOf(30),Integer.valueOf(91));

            System.out.println("Items <K,V>: ");
            for(int i = 0; i < hash.getMap().length; i++) {
                if(hash.getMap()[i] != null) {
                    NodeMap<Integer,Integer> it = hash.getMap()[i];

                    System.out.println("<" + it.getKey() + "," +
                            it.getValue() + ">");
                    while(it.getNext() != null) {
                        it = it.getNext();
                        System.out.println("    <" + it.getKey() + "," +
                                it.getValue() + ">");
                    }

                } else {
                    System.out.println("null");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
