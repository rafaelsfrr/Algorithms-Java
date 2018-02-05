package local.exercises.strings.tests;

import local.exercises.strings.src.PalindromePermutation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePermutationTest {

    @Test
    public void isPalindromeTest() {
        assertEquals(false,
                PalindromePermutation.isPalindrome("house"));

        assertEquals(true,
                PalindromePermutation.isPalindrome("arara"));

        assertEquals(true,
                PalindromePermutation.isPalindrome("aaarr"));
    }


}