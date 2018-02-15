package local.exercises.linkedList.src;

import local.algorithms.LinkedList;
import local.algorithms.Node;
import java.util.Stack;

// O(N) time, space

public class Palindrome {

    public static Stack<Node> fillStack(LinkedList<Character> list, int size) {
        Stack<Node> stack = new Stack<>();
        Node<Character> it = list.getFirstNode();

        for(int i = 0; i < size/2; i++) {
            stack.push(it);
            it = it.getNext();
        }

        return stack;
    }

    public static boolean parseStack(Stack<Node> stack, Node<Character> it) {
        Node<Character> aux;
        while(!stack.empty()) {
            aux = stack.pop();
            if(aux.getElement().charValue() != it.getElement().charValue())
                return false;
            it = it.getNext();
        }
        return true;
    }


    public static boolean isPalindrome(LinkedList<Character> list) {
        Node<Character> first = list.getFirstNode();
        int size = list.size();
        Stack<Node> stack = fillStack(list, size);

        if(size % 2 == 0)
            return parseStack(stack, first);
        else
            return parseStack(stack, first.getNext());

    }

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();

        list.add(Character.valueOf('a'));
        list.add(Character.valueOf('r'));
        list.add(Character.valueOf('a'));
        list.add(Character.valueOf('r'));
        list.add(Character.valueOf('a'));

        System.out.println(isPalindrome(list));
    }
}
