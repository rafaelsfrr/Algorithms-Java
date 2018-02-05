package local.exercises.strings.src;

public class Rotate {

    // O(N^2) time
    public static int[][] rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length/2; i++) {
            int first = i;
            int last = matrix.length - 1 - i;

            for(int j = first; j < last; j++) {
                int offset = j - first;

                int top = matrix[first][j];
                matrix[first][j] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }

        return matrix;
    }
}
