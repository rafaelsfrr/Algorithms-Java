package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;

// O(N) time, O(1) space
public class PartitionList {

    public static void partitionList(Node first, int value) {
        Node<Integer> lt = first, geq = first;

        while(lt != null && geq != null) {
            if(lt.getElement() < Integer.valueOf(value) &&
                    geq.getElement() >= Integer.valueOf(value)) {
                // exchange
                Integer aux = lt.getElement();
                lt.setElement(geq.getElement());
                geq.setElement(aux);

            } else if(lt.getElement() < Integer.valueOf(value)) {
                // fix lt and move geq
                geq = geq.getNext();

            } else if(geq.getElement() >= Integer.valueOf(value)) {
                // fix geq and move lt
                lt = lt.getNext();

            } else {
                lt = lt.getNext();
                geq = geq.getNext();
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(Integer.valueOf(3));
        list.add(Integer.valueOf(5));
        list.add(Integer.valueOf(8));
        list.add(Integer.valueOf(5));
        list.add(Integer.valueOf(10));
        list.add(Integer.valueOf(2));
        list.add(Integer.valueOf(1));

        Node<Integer> first = list.getFirstNode();
        partitionList(first, 5);

        while(first != null) {
            System.out.println(first.getElement());
            first = first.getNext();
        }
    }
}
