package local.exercises.linkedList.src;


import local.algorithms.LinkedList;
import local.algorithms.Node;

// O(N) time, O(1) space
public class GetElement<E> {

    public E getKthElement(Node<E> first, int k) {
        Node<E> ptr = first;
        Node<E> runner = first;
        int count = 0;

        while(runner != null && count != k) {
            runner = runner.getNext();
            count++;
        }

        while(runner != null) {
            runner = runner.getNext();
            ptr = ptr.getNext();
        }
        return ptr.getElement();
    }
}
