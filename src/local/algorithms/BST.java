package local.algorithms;

// integer binary search tree implementation
public class BST {
    private static class Node {
        private int data;
        private Node right, left;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public void add(int data) {
        root = add(root, data);
    }

    // O(N)
    private Node add(Node current, int data) {
        if(current == null)
            return new Node(data);

        if(data > current.data)
            current.right = add(current.right, data);
        else if(data < current.data)
            current.left = add(current.left, data);
        return current;
    }

    public Node search(int data) {
        try {
            return search(root, data);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // O(N)
    private Node search(Node current, int data) throws Exception {
        // element not found
        if(current == null)
            throw new Exception();

        if(data > current.data)
            return search(current.right, data);
        else if(data < current.data)
            return search(current.left, data);
        else
            return current;
    }

    public void remove(int data) {
        try {
            remove(root, data);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // O(N)
    private Node remove(Node current, int data) throws Exception {
        // element not found
        if(current == null)
            throw new Exception();

        if(data > current.data)
            current.right = remove(current.right, data);
        else if(data < current.data)
            current.left = remove(current.left, data);
        else {
            // element found. Now we have 4 cases:
            // the element has two childs
            if(current.left != null && current.right != null) {
                // in this case, we can promote the rightest leaf of the left child of the element
                // or we can promote the leftest leaf of the right child of the element
                // here, we will promote the rightest leaf of the left child of the element, so
                // we save the right subtree and parse the tree to find the rightest leaf
                Node rightSubTree = current.right;
                current = current.left;

                while(current.right != null)
                    current = current.right;

                // the righest leaf has been found. Now we add the right subtree and return the node
                current.right = rightSubTree;
                return current;
            }
            // the element does not have child
            else if(current.left == null && current.right == null)
                return null;
            // the element has just the left child
            else if(current.left != null)
                return current.left;
            // the element has just the right child
            else
                return current.right;
        }
        return current;
    }

    public static void visitPreOrder(Node current) {
        if(current != null) {
            System.out.print(current.data + " ");
            visitPreOrder(current.left);
            visitPreOrder(current.right);
        }
    }

    public static void visitInOrder(Node current) {
        if(current != null) {
            visitInOrder(current.left);
            System.out.print(current.data + " ");
            visitInOrder(current.right);
        }
    }
    public static void visitPostOrder(Node current) {
        if(current != null) {
            visitPostOrder(current.left);
            visitPostOrder(current.right);
            System.out.print(current.data + " ");
        }
    }
}
