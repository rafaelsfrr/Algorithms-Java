package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;


// O(A+B) time, O(1) space
public class Intersection {

    public static Node getTail(LinkedList list) {
        Node tail = list.getFirstNode();

        while(tail.getNext() != null)
            tail.getNext();

        return tail;
    }

    public static Node getIntersection(LinkedList a, LinkedList b) {
        int sizeA = a.size(), sizeB = b.size();
        Node tailA = getTail(a), tailB = getTail(b);

        if(tailA == tailB) {
            Node ptrA = a.getFirstNode(), ptrB = b.getFirstNode();

            if(sizeA > sizeB) {
                while(sizeA > sizeB) {
                    ptrA = ptrA.getNext();
                    sizeA--;
                }
            } else if(sizeB > sizeA) {
                while(sizeB > sizeA) {
                    ptrB = ptrB.getNext();
                    sizeB--;
                }
            }

            while(ptrA != ptrB) {
                ptrA = ptrA.getNext();
                ptrB = ptrB.getNext();
            }

            return ptrA;
        }

        return null;
    }
}
