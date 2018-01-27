package local.algorithms;

public class NodeMap<K,V> {
    private V value;
    private K key;
    private NodeMap next;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public NodeMap getNext() {
        return next;
    }

    public void setNext(NodeMap next) {
        this.next = next;
    }
}
