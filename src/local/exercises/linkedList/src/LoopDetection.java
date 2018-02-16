package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;

// O(N) time, O(1) space
public class LoopDetection {

    public Node getLoopHead(LinkedList a) {
        Node ptrFast = a.getFirstNode(), ptrSlow = a.getFirstNode();

        while(ptrFast != null && ptrFast.getNext() != null) {
            // Loop detection
            if(ptrFast == ptrSlow)
                break;

            ptrFast = ptrFast.getNext().getNext(); // Move 2x faster than ptrSlow
            ptrSlow = ptrSlow.getNext();
        }

        // Has loop. To find the head of the loop, we move one ptr to the head of
        // the list and move the two pointers on the same speed. They will collide
        // on the head of the loop.
        if(ptrFast != null) {
            ptrSlow = a.getFirstNode();

            while(ptrSlow != ptrFast) {
                ptrSlow = ptrSlow.getNext();
                ptrFast = ptrFast.getNext();
            }

            return ptrSlow;
        }

        // No loop
        return null;
    }
}
