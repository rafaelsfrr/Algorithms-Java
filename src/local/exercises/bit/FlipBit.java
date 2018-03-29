package local.exercises.bit;

public class FlipBit {
    public static int flipBit(int a) {
        if(~a == 0) {
            return Integer.BYTES * Byte.SIZE;
        }

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;

        while(a != 0) {
            if((a & 1) == 1) {
                currentLength++;
            } else if((a & 1) == 0) {
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a  = a >>> 1;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(flipBit(0b0111110001110));
    }
}
