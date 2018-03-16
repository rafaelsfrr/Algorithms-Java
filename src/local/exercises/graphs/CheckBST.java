package local.exercises.graphs;

public class CheckBST {
    private static class Node {
        int data;
        Node left, right;

        public Node(int value) {
            this.data = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    private static Node root;

    public static void add(int data) {
        root = add(root, data);
    }

    private static Node add(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            if(data <= root.data) {
                root.left = add(root.left, data);
            } else {
                root.right = add(root.right, data);
            }
        }

        return root;
    }

    public static boolean isBST(Node current) {
        return isBST(current, null, null);
    }

    private static boolean isBST(Node current, Integer min, Integer max) {
        if(current == null) {
            return true;
        }

        if((min != null && current.data <= min) ||
                (max != null && current.data > max)) {
            return false;
        }

        if(!isBST(current.left, min, current.data) ||
                !isBST(current.right, current.data, max)) {
            return false;
        }

        return true;
    }
}
