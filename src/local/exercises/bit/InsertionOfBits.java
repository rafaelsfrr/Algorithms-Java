package local.exercises.bit;

public class InsertionOfBits {

    public static int insetIn(int n, int m, int i, int j) {
        int allOnes = Integer.MAX_VALUE;
        int left = allOnes << (j + 1);
        int right = ((i << i) - 1);
        int mask = left | right; //0b111 M 111...
        int nCleared = n & mask;
        int mShifted = m << i;
        return nCleared | mShifted;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(insetIn(0b00001111, 0b1111, 8, 5)));
    }
}
