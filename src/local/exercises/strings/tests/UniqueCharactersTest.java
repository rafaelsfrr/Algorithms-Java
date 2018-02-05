package local.exercises.strings.tests;

import local.exercises.strings.src.UniqueCharacters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCharactersTest {

    @Test
    public void uniqueCharactersTest() {

        assertEquals(false,
                UniqueCharacters.uniqueCharacters("abacate"));

        assertEquals(true,
                UniqueCharacters.uniqueCharacters("qwertyuiakms;"));

        assertEquals(true,
                UniqueCharacters.uniqueCharacters("house"));
    }
}