package local.exercises.linkedList.src;

import java.util.HashSet;

import local.algorithms.LinkedList;
import local.algorithms.Node;

// O(N) time, O(1) space
public class RemoveDuplicate<E> {

    public void deleteRepeated(Node<E> node) {
        HashSet<E> set = new HashSet<>();
        Node previous = null;

        while(node != null) {
            if(set.contains(node.getElement())) {
                previous.setNext(node.getNext());
            } else {
                set.add((E) node.getElement());
                previous = node;
            }
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        RemoveDuplicate<Integer> rd = new  RemoveDuplicate<>();

        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(12));
        list.add(Integer.valueOf(12));
        list.add(Integer.valueOf(16));

        Node<Integer> first = list.getFirstNode();
        rd.deleteRepeated(first);

        while(first != null) {
            System.out.println(first.getElement());
            first = first.getNext();
        }
    }
}
