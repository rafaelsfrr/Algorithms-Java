package local.algorithms;

public class Stack<E> {

    private static class StackNode<E> {
        private E data;
        private StackNode<E> next;

        public StackNode(E item) {
            this.data = item;
        }
    }

    private StackNode<E> top;
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
    public void push(E item) {
        StackNode<E> node = new StackNode<>(item);
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
