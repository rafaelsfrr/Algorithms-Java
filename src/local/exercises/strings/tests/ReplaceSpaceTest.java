package local.exercises.strings.tests;

import local.exercises.strings.src.ReplaceSpace;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReplaceSpaceTest {

    @Test
    public void replaceSpaceTest() {
        assertEquals("Mr%20John%20Smith  ",
                ReplaceSpace.replaceSpace("Mr John Smith      ", 13));
    }
}