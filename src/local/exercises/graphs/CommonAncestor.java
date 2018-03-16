package local.exercises.graphs;

public class CommonAncestor {

    private static class Node {
        private int data;
        private Node left, right;

        public Node(int data) {
            this.data = data;
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
        if (root == null) {
            return new Node(data);
        } else {
            if (data <= root.data) {
                root.left = add(root.left, data);
            } else {
                root.right = add(root.right, data);
            }
        }

        return root;
    }

    public static Node getCommonAncestor(int a, int b) {
        Node res = getCommonAncestor(root, a, b);
        return res == null ? root : res;
    }

    private static Node getCommonAncestor(Node root, int a, int b) {
        if (root != null) {
            if (find(root.left, a) && find(root.left, b)) {
                return getCommonAncestor(root.left, a, b);
            } else if (find(root.right, a) && find(root.right, b)) {
                return getCommonAncestor(root.right, a, b);
            } else {
                return root;
            }
        }

        return null;
    }

    private static boolean find(Node root, int a) {
        if (root == null) {
            return false;
        } else if (root.data == a) {
            return true;
        } else {
            return find(root.left, a) || find(root.right, a);
        }
    }

    public static void main(String[] args) {
        CommonAncestor tree = new CommonAncestor();

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

        System.out.println(getCommonAncestor(4, 16));
    }
}
