package local.algorithms;

public class KMP {

    public static int[] computeTemporaryArray(char[] pattern){
        int[] lps = new int[pattern.length];
        int i = 0, j = 1;
        while(j < pattern.length) {
          if(pattern[j] == pattern[i]) {
            lps[j] = i + 1;
            i++;
            j++;
          } else {
            if(i != 0) {
              i = lps[i - 1];
            } else {
              lps[j] = 0;
              j++;
            }
          }
        }
        return lps;
    }

    public static int search(char[] text, char[] pattern){
        int[] lps = computeTemporaryArray(pattern);
        int i = 0, j = 0, index = 0;

        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            } else {
                if(j != 0){
                    j = lps[j-1];
                } else {
                    i++;
                    index = i;
                }
            }
        }
        if(j == pattern.length){
            return index;
        }
        return -1;
    }

    public static void main(String args[]){

        String str = "aabraacadbraacaadaadabra";
        String subString = "aacaa";
        System.out.print(KMP.search(str.toCharArray(),
                                            subString.toCharArray()));

    }
}
