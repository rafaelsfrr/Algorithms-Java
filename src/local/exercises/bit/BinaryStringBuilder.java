package local.exercises.bit;

public class BinaryStringBuilder {
    public static String getBinary(double num) {
        if(num >= 1 || num <= 0) {
            return "ERROR 1";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while(num > 0) {
            if(binary.length() >= 32) {
                break;
            }

            double r = num * 2;
            if(r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        System.out.println(getBinary(0.72));
    }
}
