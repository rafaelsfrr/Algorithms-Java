package local.exercises.graphs;

public class MinTree {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }
    }

    private static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static Node root = null;

    public static void createBST(int[] vet) {
        root = createBST(vet, 0, vet.length - 1);
    }

    public static Node createBST(int[] vet, int start, int end) {
        if(end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(vet[mid]);
        node.left = createBST(vet, start, mid - 1);
        node.right = createBST(vet, mid + 1, end );
        return node;
    }

    public static void visitInOrder(Node current) {
        if(current != null) {
            visitInOrder(current.left);
            System.out.print(current.value + " ");
            visitInOrder(current.right);
        }
    }

    public static void main(String[] args) {
        createBST(arr);
        visitInOrder(root);

    }
}
