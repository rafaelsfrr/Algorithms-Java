package local.exercises.stackQueue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks<E> {
    // set of stacks
    ArrayList<Stack<E>> set = new ArrayList<>();

    // global stack capacity
    private final int CAPACITY = 4;

    // control the stack being filled
    private int index;

    public SetOfStacks() {
        // Add the first stack to the set
        Stack<E> stack = new Stack<>();
        set.add(stack);
    }

    public void push(E data) {
        // the stack is full, we allocate another stack and increment the index control
        if(set.get(index).size() == CAPACITY) {
            index++;
            Stack<E> nStack = new Stack<>();
            nStack.add(data);
            set.add(index,nStack);
        } else {
            set.get(index).add(data);
        }
    }

    public E pop() {
        if(!set.get(index).isEmpty()) {
            E elem = set.get(index).pop();
            // if the stack is empty, we can decrease the index and remove the stack from the set
            if(set.get(index).isEmpty() && index > 0) {
                set.remove(index);
                index--;
            }
            return elem;
        }
        throw new EmptyStackException();
    }

    public E popAt(int label) {
        // check if exists a stack with the label passed as arg
        if(label <= index) {
            if(!set.get(label).isEmpty()) {
                E elem = set.get(label).pop();
                // if the stack is empty, we can decrease the index and remove the stack from the set
                if(set.get(label).isEmpty() && label > 0) {
                    set.remove(label);
                    index--;
                }
                return elem;
            }
        }
        throw new EmptyStackException();
    }
}
