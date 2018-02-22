package local.exercises.stackQueue;
import java.util.Stack;

// Worst case, O(1) time, O(N) space when we have to add every element on the stack
public class MinStack extends Stack<Integer> {
    private Stack<Integer> stack = new Stack<>();

    public void push(int data) {
        if(stack.isEmpty()) {
            stack.push(Integer.valueOf(data));
        } else if(stack.peek() >= data) {
            stack.push(Integer.valueOf(data));
        }
        super.push(data);
    }

    public Integer pop() {
        int value = super.pop();
        if(value == min()) {
            stack.pop();
        }
        return value;
    }

    // O(1) time
    public int min() {
        if(stack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return stack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();

        stack.push(10);
        stack.push(10);
        stack.push(15);
        stack.push(3);
        stack.push(1);
        stack.push(20);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();

        System.out.println(stack.min());

        stack.pop();
        stack.pop();

        System.out.println(stack.min());

    }

}
