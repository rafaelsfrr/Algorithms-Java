package local.exercises.stackQueue;

import java.util.EmptyStackException;
import java.util.Stack;

// We use two stacks to implement a queue, one being the reverse of the other
public class QueueOfStacks<E> {
    // O(A+B) space
    private Stack<E> reverseStack;
    private Stack<E> normalStack;

    public QueueOfStacks() {
        reverseStack = new Stack<>();
        normalStack = new Stack<>();
    }

    // O(1)
    public int size() {
        return normalStack.size() + reverseStack.size();
    }

    // We use a lazy evaluation, sending data to the reverseStack just when this is empty
    // O(N) ~ O(1)
    public E peek() {
        if(reverseStack.isEmpty())
            sendToReverse();

        if(!reverseStack.isEmpty())
            return reverseStack.peek();
        else throw new EmptyStackException();
    }

    // O(N)
    public void sendToReverse() {
        while(!normalStack.isEmpty())
            reverseStack.push(normalStack.pop());
    }

    // O(1)
    public void add(E data) {
        normalStack.push(data);
    }

    // O(N) ~ O(1)
    public E remove() {
        if(reverseStack.isEmpty())
            sendToReverse();

        if(!reverseStack.isEmpty())
            return reverseStack.pop();
        else throw new EmptyStackException();
    }
}
