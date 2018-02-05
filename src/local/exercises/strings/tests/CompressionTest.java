package local.exercises.strings.tests;

import local.exercises.strings.src.Compression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressionTest {

    @Test
    public void compressRepresentationTest() {
        assertEquals("a2c7a1",
                Compression.compressRepresentation("aaccccccca"));

        assertEquals("abcdefg",
                Compression.compressRepresentation("abcdefg"));
    }

}