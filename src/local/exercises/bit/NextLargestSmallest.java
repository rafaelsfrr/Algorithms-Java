package local.exercises.bit;

public class NextLargestSmallest {

    public static int nextActivateBitOf(int number, int from) {
        if(number == 0) {
            return -1;
        }

        int mask = Integer.MAX_VALUE ^ 1;
        int i = from;
        while(i < Integer.BYTES * Byte.SIZE &&
                (number | mask) != Integer.MAX_VALUE) {
            i++;
            mask = (Integer.MAX_VALUE ^ 1 << i) | i;
        }
        return i;
    }

    public static int nextDeactivateBitOf(int number, int from) {
        if(number == Integer.MAX_VALUE) {
            return -1;
        }

        int mask = ~(Integer.MAX_VALUE ^ 1) << from;
        int i = from;
        while(i < Integer.BYTES * Byte.SIZE &&
                ((number & mask) != 0)) {
            i++;
            mask = ~(Integer.MAX_VALUE ^ 1) << i;
        }
        return i;
    }

    public static int activateBitAt(int number, int pos) {
        return number | (~(Integer.MAX_VALUE ^ 1) << pos);
    }

    public static int deactivateBitAt(int number, int pos) {
        return number & ((Integer.MAX_VALUE ^ 1) << pos);
    }

    public static int nextLargestNumberOf(int num) {
        int deactivatePos = nextActivateBitOf(num, 0);
        if(deactivatePos >= 0) {
            int activatePos = nextDeactivateBitOf(num, deactivatePos);
            if(activatePos >= 0) {
                int result = deactivateBitAt(num, deactivatePos);
                result = activateBitAt(result,activatePos);
                return result;
            }
        }
        return -1;
    }

    public static int nextSmallestNumberOf(int num) {
        int activatePos = nextDeactivateBitOf(num, 0);
        if(activatePos >= 0) {
            int deactivatePos = nextActivateBitOf(num, activatePos);
            if(deactivatePos >= 0) {
                int result = deactivateBitAt(num, deactivatePos);
                result = activateBitAt(result, activatePos);
                return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(nextLargestNumberOf(4)));
        System.out.println(Integer.toBinaryString(nextSmallestNumberOf(4)));

    }
}
