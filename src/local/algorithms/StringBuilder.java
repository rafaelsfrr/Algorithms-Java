package local.algorithms;

public class StringBuilder {
    private ArrayList<Character> str;

    public StringBuilder() {
        str = new ArrayList<>(Character.class, 16);
    }

    public StringBuilder(int size) {
        str = new ArrayList<>(Character.class, size);
    }

    public int size() {
        return str.size();
    }

    public void append(Character c) {
        str.add(c);
    }

    public Character charAt(int index) {
        try {
            return str.getElement(index);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder();

        str.append(Character.valueOf('t'));
        str.append(Character.valueOf('e'));
        str.append(Character.valueOf('s'));
        str.append(Character.valueOf('t'));

        for(int i = 0; i < str.size(); i++) {
            System.out.print(str.charAt(i));
        }
    }
}
