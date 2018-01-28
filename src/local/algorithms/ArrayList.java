package local.algorithms;

public class ArrayList<E> {
    private int capacity = 4;
    private int length = 0;
    private E[] array = (E[]) new Object[capacity];


    public int size() {
        return capacity;
    }

    public void add(E elem, int index) {

        // Check if the array is full
        if(length == capacity) {
            // if it is full, we have to copy all the elements to a new array  - O(size)
            E[] narray = (E[]) new Object[2 * capacity];

            for(int i = 0; i < length; i++) {
                narray[i] = array[i];
            }

            narray[index] = elem;
            capacity = 2 * capacity;
            length++;
            array = narray;
        } else {
            // If it is not, we just add the new number - O(1)
            array[index] = elem;
            length++;
        }
    }

    // We have to allocate another array and copy all items less the item we want to remove
    public void remove(int index) {
        E[] narray = (E[]) new Object[capacity];

        // aux is the offset that is valid when we find the element we want to remove
        int aux = 0;

        for(int i = 0; i < capacity; i++) {
            if(i != index) {
                narray[i - aux] = array[i];
            } else {
                aux++;
            }
        }
        length--;
        array = narray;
    }

    public E getElement(int index) {
        return array[index];
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(Integer.valueOf(1), Integer.valueOf(0));
        arr.add(Integer.valueOf(10), Integer.valueOf(1));
        arr.add(Integer.valueOf(19), Integer.valueOf(2));
        arr.add(Integer.valueOf(15), Integer.valueOf(3));
        // O(1) insertion

        arr.add(Integer.valueOf(13), Integer.valueOf(4));
        // O(N) insertion

        // Printing 1 10 19 15 13
        System.out.println("After add:");
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.getElement(i));
        }

        // Printing 1 10 15 13
        arr.remove(2);
        System.out.println("After remove:");
        for(int i = 0; i < arr.size(); i++) {
            System.out.println(arr.getElement(i));
        }
    }
}
