package local.exercises.strings.src;

public class StringRotation {

    public static boolean isRotation(String a, String b) {
        if(a.length() == b.length() && a.length() > 0) {
            String c = a + a;
            return c.contains(b);
        }

        return false;
    }
 }
