package local.algorithms;

public class LinkedList<E> {
    private Node first;
    private int length;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return length;
    }

    // In this implementation we add on the first - FILO scheme O(1)
    public void add(E element) {
        Node<E> nn = new Node<>();
        nn.setElement(element);
        nn.setNext(first);
        first = nn;
        length++;
    }

    public Node<E> getFirstNode() {
        return first;
    }

    public E getFirstElement() {
        return (E) first.getElement();
    }

    // O(N)
    public int getIndex(E element) {
        Node it = first;
        int index = 0;

        while(it != null) {
            if(it.getElement() == element) {
                return index;
            } else {
                it = it.getNext();
                index++;
            }
        }

        return -1;
    }

    // O(N)
    public E getByIndex(int index) {
        Node it = first;

        for(int i = 0; i < index; i++) {
            it = it.getNext();
        }

        return (E) it.getElement();
    }

    // remove first element - O(1)
    public E remove() {
        if(first != null) {
            Node rn = first;
            first = first.getNext();
            return (E) rn.getElement();
        }
        return null;
    }

    // O(N)
    public E removeByIndex(int index) {
        Node it = first;
        Node nodeBefore = null;

        for(int i = 0; i < index; i++) {
            nodeBefore = it;
            it = it.getNext();
        }

        // first element
        if(nodeBefore == null) {
            first = it.getNext();
            length--;
            return (E) it.getElement();
        } else {
            nodeBefore.setNext(it.getNext());
            length--;
            return (E) it.getElement();
        }
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();

        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(10));
        list.add(Integer.valueOf(81));
        list.add(Integer.valueOf(9));

        // Print all values
        System.out.println("Items:");
        Node it = list.first;
        for(int i = 0; i < list.size(); i++) {
            System.out.println(it.getElement());
            it = it.getNext();
        }

        // Print index of 10
        System.out.println("Index of 10: " + list.getIndex(Integer.valueOf(10)));

        // get 10 by index
        System.out.println("Element: " + list.getByIndex(2));

        // Print list without 10
        list.removeByIndex(0);
        System.out.println("Items:");
        it = list.first;
        for(int i = 0; i < list.size(); i++) {
            System.out.println(it.getElement());
            it = it.getNext();
        }
    }
}