package local.exercises.graphs;

public class ThereIsPath {
    // size of the matrix
    private static int SIZE = 5;
    // adjacency matrix representating the graph
    private static int[][] mat = {{0, 1, 1, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0}};
    // array that mark visited nodes
    private static boolean[] visited = new boolean[SIZE];

    public static boolean isPath(int from, int to) {

        // printNode(from, to);

        if(!visited[from]) {
            visited[from] = true;
            if(from == to) {
                return true;
            } else {
                for(int i = 0; i < mat[from].length; i++) {
                    if(!visited[i] && mat[from][i] == 1) {
                        return isPath(i, to);
                    }
                }
            }
        }

        return false;
    }

    public static void printNode(int from, int to) {
        System.out.println("(" + from + "," + to + ")");
    }


    public static void main(String[] args) {

        System.out.println(isPath(0,3));

    }
}
