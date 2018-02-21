package local.algorithms;

public class Queue<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> first;
    private Node<E> last;
    private int size;


    //O(1)
    public int size() {
        return size;
    }

    //O(1)
    public boolean isEmpty() {
        return first == null;
    }

    // O(1)
    public void add(E data) {
        Node<E> node = new Node<>(data);

        // Empty queue
        if(isEmpty())
            first = node;

        last.next = node;
        last = node;
        size++;
    }

    //O(1)
    public E remove() {
        if(!isEmpty()) {
            E elem = first.data;
            first = first.next;
            size--;
            return elem;
        }
        return null;
    }

    //O(1)
    public E peek() {

        if(!isEmpty())
            return first.data;

        return null;
    }
}
