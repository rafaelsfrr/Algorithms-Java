package local.exercises.strings.src;

// O(MN) time, O(1) space
public class NilMatrix {

    public static void setRowToZero(int[][] matrix, int row) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void setColToZero(int[][] matrix, int col) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static int[][] setToZero(int[][] matrix) {
        boolean rowHasZero = false, colHasZero = false;

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                colHasZero = true;
                break;
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) setRowToZero(matrix, i);
        }

        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) setColToZero(matrix, j);
        }

        if(rowHasZero) setRowToZero(matrix, 0);
        if(colHasZero) setColToZero(matrix, 0);

        return matrix;
    }
}
