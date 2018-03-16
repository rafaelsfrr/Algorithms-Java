package local.exercises.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

public class NodesByLevel {
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

    public static ArrayList<LinkedList<Node>> getNodesByLevel(Node root) {

        ArrayList<LinkedList<Node>> result = new ArrayList<>();
        LinkedList<Node> currentLevel = new LinkedList<>();

        if(root != null) {
            currentLevel.add(root);
        }

        while(currentLevel.size() > 0) {
            result.add(currentLevel);
            LinkedList<Node> parents = currentLevel;
            currentLevel = new LinkedList<>();

            for(Node n : parents) {
                if(n.left != null)
                    currentLevel.add(n.left);
                if(n.right != null)
                    currentLevel.add(n.right);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        NodesByLevel tree = new NodesByLevel();

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

        ArrayList<LinkedList<Node>> res = getNodesByLevel(root);

        System.out.print("(");
        for(LinkedList<Node> list : res) {
            System.out.print("(");
            for(Node n : list) {
                if(n == list.getLast())
                    System.out.print(n);
                else
                    System.out.print(n + " ");
            }
            System.out.print(")");
        }
        System.out.print(")");
    }
}
