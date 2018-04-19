package local.exercises.dynamic;

import java.util.ArrayList;

public class Permutation {
    public static ArrayList<String> getPermutations(String word) {

        if(word == null) {
            return null;
        }

        ArrayList<String> permutations = new ArrayList<>();

        // empty string
        if(word.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = word.charAt(0);
        String remainder = word.substring(1);
        ArrayList<String> aux = getPermutations(remainder);

        for(String w : aux) {
            for(int i = 0; i < word.length(); i++) {
                permutations.add(addCharToWordAt(first, w, i));
            }
        }

        return permutations;

    }

    public static String addCharToWordAt(char a, String word, int i) {
        String beg = word.substring(0, i);
        String end = word.substring(i);
        return beg + a + end;
    }

    public static void main(String[] args) {
        ArrayList<String> res = getPermutations("abc");

        for(String w : res) {
            System.out.println(w);
        }
    }
}
