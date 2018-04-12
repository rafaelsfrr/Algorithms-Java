package local.exercises.dynamic;

import java.util.Stack;

public class Hanoi {

    public static class Tower {
        private Stack<Integer> disks;
        private int label;

        public Tower(int label) {
            this.disks = new Stack<>();
            this.label = label;
        }

        public Stack<Integer> getDisks() {
            return disks;
        }

        public void setDisks(Stack<Integer> disks) {
            this.disks = disks;
        }

        public int getLabel() {
            return label;
        }

        public void setLabel(int label) {
            this.label = label;
        }

        public void add(int disk) {
            if(!this.disks.isEmpty() && this.disks.peek() < disk) {
                System.out.println("Error. Placing a bigger disk on top of the tower");
            } else {
                this.disks.push(disk);
            }
        }

        public void moveDiskTo(Tower b) {
            if(!this.disks.isEmpty()) {
                b.add(this.disks.pop());
            } else {
                System.out.println("Empty Tower");
            }
        }

        public void moveDisks(int n, Tower dest, Tower buf) {
            if(n > 0) {
                moveDisks(n - 1, buf, dest);
                moveDiskTo(dest);
                buf.moveDisks(n - 1, dest, this);
            }
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int numberOfDisks = 5;

        Tower[] towers = new Tower[n];

        for(int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }

        for(int i = numberOfDisks - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(numberOfDisks, towers[2], towers[1]);

        for (Integer i : towers[2].getDisks()) {
            System.out.print(i);
        }
    }
}
