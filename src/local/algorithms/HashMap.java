package local.algorithms;

public class HashMap<K,V> {
    private ArrayList<NodeMap<K,V>> map = new ArrayList<>();

    // O(1)
    public int getHash(K key) {

        // This method accept a String or a Integer key
        if(key instanceof Integer) {
            return ((Integer) key).intValue() % map.size();
        } else if(key instanceof String) {
            return Integer.getInteger((String) key).intValue() % map.size();
        } else {
            return -1;
        }
    }

    // O(1) because we always add on the first element
    public void add(K key, V value) {
        int index = getHash(key);
        // Check if the hash works, i.e., String or Integer key
        if(index > -1) {
            NodeMap<K,V> nn = new NodeMap<>();
            nn.setKey(key);
            nn.setValue(value);
            nn.setNext(map.getElement(index));
            map.add(nn, index);
        }
    }

    // O(1) if no conflicts and O(N) if has conflicts
    public V getValue(K key) {
        int index = getHash(key);

        // Check if the hash works, i.e., String or Integer key
        if(index > -1) {
            NodeMap<K,V> it;
            it = map.getElement(index);
            System.out.println(it.getValue());

            // Search the list for the element. If there is no conflicts with the hash, this
            // method is O(1), otherwise is O(list.lenght), i.e, O(N)
            while(it.getKey() != key) {
                if(it.getNext() != null) {
                    it = it.getNext();
                } else {
                    return null;
                }
            }
            return it.getValue();
        } else {
            return null;
        }
    }

    public ArrayList<NodeMap<K, V>> getMap() {
        return map;
    }

    public void setMap(ArrayList<NodeMap<K, V>> map) {
        this.map = map;
    }

    // O(1) if no conflicts and O(N) if has conflicts
    public void removeValue(K key) {
        int index = getHash(key);

        // Check if the hash works, i.e., String or Integer key
        if(index > -1) {
            NodeMap<K,V> it, aux;
            it = map.getElement(index);
            aux = it;

            // Search the list for the element. If there is no conflicts with the hash, this
            // method is O(1), otherwise is O(list.lenght), i.e, O(N)
            while(it.getKey() != key) {
                if(it.getNext() != null) {
                    aux = it;
                    it = it.getNext();
                } else {
                    aux = null;
                    it = null;
                    break;
                }
            }

            if(map.getElement(index) == it) {
                map.add(it.getNext(), index);
            } else {
                aux.setNext(it.getNext());
            }
        }


    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> hash = new HashMap<>();

        hash.add(Integer.valueOf(1),Integer.valueOf(10));
        hash.add(Integer.valueOf(5),Integer.valueOf(20));
        hash.add(Integer.valueOf(2),Integer.valueOf(250));
        hash.add(Integer.valueOf(10),Integer.valueOf(11));
        hash.add(Integer.valueOf(30),Integer.valueOf(91));

        // <1,10>
        System.out.println("Items<K,V>: ");
        System.out.println("<" +
                "1" +
                "," +
                hash.getValue(1) + ">");

        // <5,20>
        System.out.println("<" +
                "5" +
                "," +
                hash.getValue(5) + ">");

        // <2,250>
        System.out.println("<" +
                "2" +
                "," +
                hash.getValue(2) + ">");

        // <10,11>
        System.out.println("<" +
                "10" +
                "," +
                hash.getValue(10) + ">");

        // <30,91>
        System.out.println("<" +
                "30" +
                "," +
                hash.getValue(30) + ">");

    }

}
