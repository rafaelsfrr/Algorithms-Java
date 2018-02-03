package local.exercises;

public class ReplaceSpace {

    // O(N) time, O(1) space

    public static char[] getCharArray(String a) {
        return a.toCharArray();
    }

    public static String replaceSpace(String a, int size) {
        int spacesCount = 0;
        char[] str = getCharArray(a);

        for(int i = 0; i < size; i++) {
            if(str[i] == ' ') {
                spacesCount++;
            }
        }

        int newSize = size + spacesCount * 2;

        for(int i = size - 1; i >= 0; i--) {
            if(str[i] == ' ') {
                str[newSize - 1] = '0';
                str[newSize - 2] = '2';
                str[newSize - 3] = '%';
                newSize -= 3;
            } else {
                str[newSize - 1] = str[i];
                newSize--;
            }
        }

        return String.valueOf(str);

    }

    public static void main(String[] args) {
        System.out.println("Mr John Smith  " +
                replaceSpace("Mr John Smith      ", 13));
    }
}
