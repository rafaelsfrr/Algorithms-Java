public class UniqueCharacters {


    // O(N) time, O(1) space
    public static boolean uniqueCharacters(String str) {

        // Assuming a ASCII string
        if(str.length() > 128) {
            return false;
        }

        boolean[] str_map = new boolean[128];

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);

            if(str_map[index]) {
                return false;
            }

            str_map[index] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueCharacters("abacate"));
        System.out.println(uniqueCharacters("qwertyuiakms;"));
        System.out.println(uniqueCharacters("house"));
    }
}
