package local.exercises.linkedList.tests;

import local.algorithms.LinkedList;
import local.algorithms.Node;
import local.exercises.linkedList.src.GetElement;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetElementTest {
    @Test
    public void getKthElementTest() {
        LinkedList<Integer> list = new LinkedList<>();
        GetElement<Integer> ge = new GetElement<>();

        list.add(Integer.valueOf(1));
        list.add(Integer.valueOf(4));
        list.add(Integer.valueOf(6));
        list.add(Integer.valueOf(10));
        list.add(Integer.valueOf(12));
        list.add(Integer.valueOf(16));

        Node<Integer> first = list.getFirstNode();

        assertEquals((Integer) 4, ge.getKthElement(first, 2));
        assertEquals((Integer) 10, ge.getKthElement(first, 4));
        assertEquals((Integer) 1, ge.getKthElement(first, 1));
    }
}