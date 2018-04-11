package local.exercises.dynamic;

public class Multiply {

    public static int multiply(int a, int b) {
        int res = 0;
        int smaller = a < b ? a : b;
        int bigger = a > b ? a : b;

        return multiplyRec(smaller, bigger, res);
    }

    private static int multiplyRec(int i, int a, int res) {
        if(i <= 0) return res;

        res += a;
        return multiplyRec(i - 1, a, res);
    }

    public static void main(String[] args) {
        System.out.println(multiply(3,8));
    }
}
