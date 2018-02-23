package local.exercises.stackQueue;

import java.util.EmptyStackException;
import java.util.Stack;

public class SortStack {
    private Stack<Integer> container = new Stack<>();
    private Stack<Integer> aux = new Stack<>();

    // O(N)
    private void auxToContainer() {
        while(!aux.isEmpty()) {
            container.push(aux.pop());
        }
    }

    // O(N)
    private void containerToAux() {
        while(!container.isEmpty()) {
            aux.push(container.pop());
        }
    }

    // O(1)
    public boolean isEmpty() {
        return container.isEmpty();
    }

    // O(1)
    public int peek() {
        if(!container.isEmpty())
            return container.peek().intValue();
        else throw new EmptyStackException();
    }

    // O(N)
    public void push(int data) {
        if(container.isEmpty()) {
            container.push(Integer.valueOf(data));
        } else {
            if(data <= container.peek().intValue()) {
                aux.push(Integer.valueOf(data));
                containerToAux();
                auxToContainer();
            } else {
                containerToAux();
                aux.push(Integer.valueOf(data));
                auxToContainer();
            }
        }
    }

    // O(1)
    public int pop() {
        if(!container.isEmpty())
            return container.pop().intValue();
        else throw new EmptyStackException();
    }

    public static void main(String[] args) {
        SortStack stack = new SortStack();

        stack.push(3);
        stack.push(11);
        stack.push(1);
        stack.push(0);
        stack.push(100);

        while(!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
