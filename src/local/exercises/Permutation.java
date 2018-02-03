package local.exercises;

public class Permutation {

    // We need to count the number of characters, resulting in a O(A + B) in time
    // and O(1) in space (ASCII)
    public static boolean isPermutation(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }

        int[] vetChars = new int[256];

        for(int i = 0; i < a.length(); i++) {
            vetChars[a.charAt(i)]++;
        }

        for(int i = 0; i < b.length(); i++) {
            vetChars[b.charAt(i)]--;
        }

        for(int i = 0; i < vetChars.length; i++) {
            if(vetChars[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("house " +
                "ouhse " + isPermutation("house", "ouhse"));

        System.out.println("dog " +
                "cat " + isPermutation("dog", "cat"));

        System.out.println("dog% " +
                "og%d " + isPermutation("dog%", "og%d"));
    }
}
