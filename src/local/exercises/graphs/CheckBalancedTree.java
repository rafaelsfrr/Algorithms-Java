package local.exercises.graphs;

public class CheckBalancedTree {
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

    public static int checkHeight(Node root) {
        if(root == null) {
            return -1;
        }

        int leftHeight = checkHeight(root.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(root.right);
        if(rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int diff = leftHeight - rightHeight;
        if(Math.abs(diff) > 1) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public static boolean isBalanced(Node root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        CheckBalancedTree tree = new CheckBalancedTree();

        tree.add(10);
        tree.add(7);
        tree.add(14);
        tree.add(5);
        tree.add(9);
        tree.add(6);
        tree.add(4);
        tree.add(13);
        tree.add(15);
        tree.add(12);
        tree.add(16);

        System.out.println(isBalanced(root));
    }
}
