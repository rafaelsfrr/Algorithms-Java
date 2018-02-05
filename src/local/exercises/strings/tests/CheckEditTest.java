package local.exercises.strings.tests;

import local.exercises.strings.src.CheckEdit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckEditTest {

    @Test
    public void checkOneEditTest() {

        assertEquals(true,
                CheckEdit.checkOneEdit("apple", "appple"));

        assertEquals(true,
                CheckEdit.checkOneEdit("pple", "apple"));

        assertEquals(true,
                CheckEdit.checkOneEdit("aapple", "apple"));

        assertEquals(false,
                CheckEdit.checkOneEdit("aapple", "aple"));
    }
}