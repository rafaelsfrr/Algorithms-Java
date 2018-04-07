package local.exercises.dynamic;

public class MagicIndex {
    public static int findMagicIndex(int[] array) {
        return findMagicIndex(array, 0, array.length - 1);
    }

    private static int findMagicIndex(int[] array, int start, int end) {
        if(end < start) {
            return -1;
        }

        int mid = (start + end) / 2;
        int value = array[mid];
        if(value == mid) {
            return mid;
        }

        int leftIndex = Math.min(mid - 1, value);
        int left = findMagicIndex(array, start, leftIndex);
        if(left >= 0) {
            return left;
        }

        int rightIndex = Math.max(mid + 1, value);
        int right = findMagicIndex(array, rightIndex, end);

        return right;
    }

    public static void main(String[] args) {
        int[] array = new int[10];

        array[0] = -1;
        array[1] = 0;
        array[2] = 1;
        array[3] = 2;
        array[4] = 4;
        array[5] = 6;
        array[6] = 7;
        array[7] = 8;
        array[8] = 9;
        array[9] = 10;

        System.out.println(findMagicIndex(array));
    }
}
