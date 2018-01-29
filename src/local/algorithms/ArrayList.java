package local.algorithms;

public class ArrayList<E> {
    private int size;
    private int nextElementIndex = 0;
    private E[] array = (E[]) new Object[size];

    public void setSize(int size) {
        this.size = size;
    }

    public int size() {
        return nextElementIndex;
    }

    public void add(E elem) {

        // Check if the array is full
        if(nextElementIndex == size) {
            // if it is full, we have to copy all the elements to a new array  - O(size)
            E[] narray = (E[]) new Object[2 * size];

            for(int i = 0; i < size; i++) {
                narray[i] = array[i];
            }

            narray[nextElementIndex] = elem;
            size = 2 * size;
            nextElementIndex++;
            array = narray;
        } else {
            // If it is not, we just add the new number - O(1)
            array[nextElementIndex] = elem;
            nextElementIndex++;
        }
    }

    // We have to allocate another array and copy all items less the item we want to remove
    public void remove(int index) {
        if(index <= nextElementIndex - 1) {
            E[] narray = (E[]) new Object[size];

            // aux is the offset that is valid when we find the element we want to remove
            int aux = 0;

            for(int i = 0; i < size; i++) {
                if(i != index) {
                    narray[i - aux] = array[i];
                } else {
                    aux++;
                }
            }
            nextElementIndex--;
            array = narray;
        }
    }

    public E getElement(int index) throws Exception {
        if(index <= nextElementIndex - 1) {
            return array[index];
        } else {
            throw new Exception("Index out of bounds");
        }
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> arr = new ArrayList<>();

        arr.setSize(4);

        arr.add(Integer.valueOf(1));
        arr.add(Integer.valueOf(10));
        arr.add(Integer.valueOf(19));
        arr.add(Integer.valueOf(15));
        // O(1) insertion

        arr.add(Integer.valueOf(13));
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
