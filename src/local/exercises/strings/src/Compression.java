package local.exercises.strings.src;

public class Compression {

    // O(N) time, O(1) space
    public static String compressRepresentation(String str) {
        int count = 1;
        int index = 0;
        StringBuilder strCompressed = new StringBuilder();

        while(index < str.length()) {
            if(index + count < str.length()) {
                while(str.charAt(index) == str.charAt(index + count)) {
                    count++;
                }
            }
            strCompressed.append(str.charAt(index));
            strCompressed.append(count);
            index = index + count;
            count = 1;
        }

        if(strCompressed.length() < str.length())
            return strCompressed.toString();

        return str;
    }
}
