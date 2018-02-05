package local.exercises.strings.tests;

import local.exercises.strings.src.Rotate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RotateTest {

    @Test
    public void rotateTest() {
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};

        int[][] rotateMatrix = {{13, 9, 5, 1},
                                {14, 10, 6, 2},
                                {15, 11, 7, 3},
                                {16, 12, 8, 4}};

        assertArrayEquals(rotateMatrix,
                Rotate.rotate(matrix));
    }

}