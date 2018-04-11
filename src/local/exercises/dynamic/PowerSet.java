package local.exercises.dynamic;

import java.util.ArrayList;

/*
* Suppose a set {1}. The powerset of this set is {{}, {1}}. Now, suppose
* a set {1,2}. The power set is {{}, {1}, {2}, {1,2}}. This is,
* we take every set of the powerset of 1 and add the element 2 to it,
* generating the new sets {2} and {1,2} of the powerset.
* We use the same approach to implement this algorithm.
 */

public class PowerSet {

    public static ArrayList<ArrayList<Integer>> powerSetOf(ArrayList<Integer> conj) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        //add the empty set to the power set
        result.add(new ArrayList<Integer>());

        return buildPowerSet(conj, result);
    }

    private static ArrayList<ArrayList<Integer>> buildPowerSet(ArrayList<Integer> conj,
                                                  ArrayList<ArrayList<Integer>> result) {
        if(conj.size() == 0) return result;

        Integer elem = conj.remove(0);
        ArrayList<ArrayList<Integer>> auxSubSet = new ArrayList<>();

        // for each subset of the result powerset that is been computing
        for(ArrayList<Integer> resultSubSet : result) {
            ArrayList<Integer> nSubSet = new ArrayList<>();

            // add every element of the subset
            nSubSet.addAll(resultSubSet);

            // add the element that has been removed from the original set computing a
            // new subset
            nSubSet.add(elem);

            // add this new subset to the aux powerset
            auxSubSet.add(nSubSet);
        }
        // add every subset to the result powerset
        result.addAll(auxSubSet);
        return buildPowerSet(conj, result);
    }

    public static void main(String[] args) {
        ArrayList<Integer> conj = new ArrayList<>();
        conj.add(Integer.valueOf(1));
        conj.add(Integer.valueOf(2));
        conj.add(Integer.valueOf(3));
        conj.add(Integer.valueOf(4));

        ArrayList<ArrayList<Integer>> powerSet = powerSetOf(conj);

        for (ArrayList<Integer> subSet : powerSet) {
            System.out.print("(");
            for (Integer elem : subSet) {
                System.out.print(elem + ",");
            }
            System.out.print(") ");
        }

    }


}
