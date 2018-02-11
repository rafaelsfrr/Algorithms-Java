package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;

// O(1) time and space
public class DeleteNode {

    public static void delete(Node node) {
        if(node != null && node.getNext() != null) {
            node.setElement(node.getNext().getElement());
            node.setNext(node.getNext().getNext());
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(12));
        list.add(Integer.valueOf(12));
        list.add(Integer.valueOf(16));

        DeleteNode.delete(list.getNodeByIndex(3));
        Node<Integer> node = list.getFirstNode();

        while(node != null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }

    }
}
