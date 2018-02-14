package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;

public class SumLists {

    public static LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> total = new LinkedList<>();
        Node<Integer> ptrA = a.getFirstNode();
        Node<Integer> ptrB = b.getFirstNode();
        int sum = 0, carry = 0;

        while(ptrA != null || ptrB != null) {

            if(ptrA != null && ptrB != null) {
                sum = ptrA.getElement().intValue() +
                        ptrB.getElement().intValue() + carry;
                ptrA = ptrA.getNext();
                ptrB = ptrB.getNext();
            } else if(ptrA == null) {
                sum = ptrB.getElement().intValue() + carry;
                ptrB = ptrB.getNext();
            } else if(ptrB == null) {
                sum = ptrA.getElement().intValue() + carry;
                ptrA = ptrA.getNext();
            }
            carry = sum / 10;
            sum = sum % 10;
            total.add(Integer.valueOf(sum));
        }
        sum = carry % 10;
        if(sum > 0) total.add(Integer.valueOf(sum));
        return total;
    }

    public static void main(String[] args) {
        LinkedList<Integer> la = new LinkedList<>();
        LinkedList<Integer> lb = new LinkedList<>();
        LinkedList<Integer> sum;

        la.add(Integer.valueOf(6));
        la.add(Integer.valueOf(1));
        la.add(Integer.valueOf(7));

        lb.add(Integer.valueOf(2));
        lb.add(Integer.valueOf(9));
        lb.add(Integer.valueOf(5));

        sum = sum(la, lb);
        Node<Integer> node = sum.getFirstNode();

        while(node != null) {
            System.out.println(node.getElement());
            node = node.getNext();
        }

    }
}
