package local.exercises.stackQueue;

import java.lang.reflect.Array;

public class ArrayStack<E> {

    // All stacks with the same fixed size
    private E[] container;
    private int[] count;
    private int size;
    private int numberOfStacks;

    public ArrayStack(int size, int numberOfStacks, Class<E> clazz) {
        this.numberOfStacks = numberOfStacks;
        this.size = size;
        this.container = (E[]) Array.newInstance(clazz,
                size * numberOfStacks);
        this.count = new int[numberOfStacks];
    }

    public boolean isFull(int stackLabel) {
        return count[stackLabel - 1] == size;
    }

    public boolean isEmpty(int stackLabel) {
        return count[stackLabel - 1] == 0;
    }

    public void add(E data, int stackLabel) {
        if(!isFull(stackLabel)) {
            int top = getTop(stackLabel);
            top--;
            container[top] = data;
            count[stackLabel - 1]++;
        }
    }

    public E remove(int stackLabel) {

        if(!isEmpty(stackLabel)) {
            int top = getTop(stackLabel);
            E elem = container[top];
            count[stackLabel - 1]--;
            return elem;
        }

        return null;
    }

    // stackLabel: 1 - stack1
    //             2 - stack2
    //               ...
    public int getTop(int stackLabel) {
        int top = size * stackLabel - count[stackLabel - 1];
        return top;
    }

    public static void main(String[] args) {
        ArrayStack<String> arr = new ArrayStack<>(3,
                3, String.class);

        arr.add("amarela", 1);
        arr.add("casa", 1);
        arr.add("casa", 1);
        arr.add("casa", 1);

        arr.add("azul", 2);
        arr.add("azul", 2);
        arr.add("azul", 2);
        arr.add("azul", 2);

        arr.add("verde", 3);
        arr.add("verde", 3);
        arr.add("floresta", 3);
        arr.add("floresta", 3);

        System.out.println(arr.remove(1));
        System.out.println(arr.remove(1));

        System.out.println(arr.remove(3));
        System.out.println(arr.remove(3));
        System.out.println(arr.remove(3));
    }


}
