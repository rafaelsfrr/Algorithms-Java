package local.algorithms;

public class Stack<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    private Node<E> top;
    private int size;

    // O(1)
    public int size() {
        return size;
    }

    // O(1)
    public boolean isEmpty() {
        return top == null;
    }

    // O(1)
    public E pop() {
        if(!isEmpty()) {
            E elem = top.data;
            top = top.next;
            size--;
            return elem;
        }
        return null;
    }

    // O(1)
    public void push(E data) {
        Node<E> node = new Node<>(data);
        node.next = top;
        top = node;
        size++;
    }

    // O(1)
    public E peek() {
        if(!isEmpty()) {
            return top.data;
        }
        return null;
    }
}
