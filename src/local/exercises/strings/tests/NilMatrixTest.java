package local.exercises.strings.tests;

import local.exercises.strings.src.NilMatrix;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NilMatrixTest {

    @Test
    public void setToZeroTest() {
        int[][] matrix = {{1, 1, 0, 1},
                          {0, 1, 1, 1},
                          {1, 1, 1, 1},
                          {1, 1, 1, 1}};

        int[][] matrixExpected = {{0, 0, 0, 0},
                                  {0, 0, 0, 0},
                                  {0, 1, 0, 1},
                                  {0, 1, 0, 1}};

        assertArrayEquals(matrixExpected,
                NilMatrix.setToZero(matrix));
    }

}