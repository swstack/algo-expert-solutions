package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Powerset {
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> sets = new ArrayList<>();
        rec(sets, array);
        return sets;
    }

    private static void rec(List<List<Integer>> sets, List<Integer> set) {
        // O(
        if (!sets.contains(set)) {
            sets.add(set);
        }

        for (int i = 0; i < set.size(); i++) {
            List<Integer> setCopy = new ArrayList<>(set);
            setCopy.remove(i);
            rec(sets, setCopy);
        }
    }
}
