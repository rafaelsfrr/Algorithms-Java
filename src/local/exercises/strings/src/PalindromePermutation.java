package local.exercises.strings.src;

public class PalindromePermutation {

    // O(N) time, O(1) space

    public static boolean isPalindrome(String str) {
        int[] map = getCharFrequencyMap(str);
        return checkOdd(map);
    }

    private static int[] getCharFrequencyMap(String str) {
        int[] mapFrequency = new int[Character.getNumericValue('z') -
                                    Character.getNumericValue('a') + 1];
        for(char c : str.toCharArray()) {
            int index = getIndex(c);

            // Check if the index is not of a non-numeric value
            if(index != -1) {
                mapFrequency[index]++;
            }
        }

        return mapFrequency;
    }

    private static int getIndex(char c) {
        int max = Character.getNumericValue('z');
        int min = Character.getNumericValue('a');
        int val = Character.getNumericValue(c);

        if(val >= min && val <= max) {
            return val - min;
        }

        // Non-numeric values get a -1 index and are ignored on the frequency map
        return -1;
    }

    public static boolean checkOdd(int[] map) {
        boolean flag = false;

        // Check if the frequency map has only one character with a odd frequency
        for(int frequency : map) {
            if(frequency % 2 == 1) {
                if(flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }

        return true;
    }
}
