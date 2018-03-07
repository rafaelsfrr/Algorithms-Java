package local.algorithms;

public class Trie {
    // In this implementation we use an array with the size of the alphabet to storage
    // all the nodes that have a relation. With this, we can check if a word with
    // lenght K is on the Trie on O(K) time
    private final static int ALPHABET_SIZE = 26;

    private static class Node {
        private Node[] next = new Node[ALPHABET_SIZE];
    }

    private Node root = new Node();

    public void put(String word) {
        root = put(root, word, 0);
    }

    private Node put(Node x, String word, int i) {
        if(x == null)
            x = new Node();

        if(i == word.length())
            return x;

        char c = word.toLowerCase().charAt(i);
        x.next[c - 'a'] = put(x.next[c - 'a'], word, i + 1);
        return x;
    }

    public boolean exists(String word) {
        Node node = get(root, word, 0);

        if(node == null)
            return false;
        else
            return true;
    }

    private Node get(Node current, String word, int i) {

        if(current == null)
            return null;

        if(i == word.length())
            return current;

        char c = word.toLowerCase().charAt(i);
        return get(current.next[c - 'a'], word, i + 1);
    }
}
