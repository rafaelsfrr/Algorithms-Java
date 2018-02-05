package local.exercises.strings.src;

// O(N) time, O(1) space
public class CheckEdit {
    public static boolean checkOneEdit(String a, String b) {
        if(a.length() + 1 == b.length()) {
            return checkInsertion(a,b);
        } else if(a.length() == b.length()) {
            return checkReplacement(a,b);
        } else if(a.length() == b.length() + 1) {
            return checkInsertion(b,a);
        }

        return false;
    }

    private static boolean checkReplacement(String a, String b) {
        boolean flag = false;
        int indexA, indexB;

        indexA = 0;
        indexB = 0;

        while(indexA < a.length() && indexB < b.length()) {
            if(a.charAt(indexA) != b.charAt(indexB)) {
                if(flag) {
                    return false;
                }
                indexB++;
                indexA++;
                flag = true;
            } else {
                indexA++;
                indexB++;
            }
        }

        return true;

    }

    private static boolean checkInsertion(String a, String b) {
        boolean flag = false;
        int indexA, indexB;

        indexA = 0;
        indexB = 0;

        while(indexA < a.length() && indexB < b.length()) {
            if(a.charAt(indexA) != b.charAt(indexB)) {
                if(flag) {
                    return false;
                }
                indexB++;
                flag = true;
            } else {
                indexA++;
                indexB++;
            }
        }

        return true;
    }
}
