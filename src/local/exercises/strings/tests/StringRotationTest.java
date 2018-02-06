package local.exercises.strings.tests;

import local.exercises.strings.src.StringRotation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringRotationTest {

    @Test
    public void isRotationTest() {
        String a = "waterbottle", b = "erbottlewat",
                c = "house", d = "uhose",
                e = "cat", f = "cats";

        assertEquals(true, StringRotation.isRotation(a,b));
        assertEquals(false, StringRotation.isRotation(c,d));
        assertEquals(false, StringRotation.isRotation(e,f));
    }

}