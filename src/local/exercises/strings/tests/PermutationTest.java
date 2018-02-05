package local.exercises.strings.tests;

import local.exercises.strings.src.Permutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationTest {

    @Test
    public void isPermutationTest() {
        assertEquals(true,
                Permutation.isPermutation("house", "ouhse"));

        assertEquals(false,
                Permutation.isPermutation("dog", "cat"));

        assertEquals(true,
                Permutation.isPermutation("dog%", "og%d"));
    }

}