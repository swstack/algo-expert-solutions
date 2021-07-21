package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        if (array.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<Integer>> permutations = new ArrayList<>();
        rec(permutations, new ArrayList<>(), array);
        System.out.println(permutations);
        return permutations;
    }

    private static void rec(List<List<Integer>> permutations, List<Integer> perm, List<Integer> remaining) {
        System.out.println(String.format("remaining: %s", remaining));
        System.out.println(String.format("perm: %s", perm));
        if (remaining.size() == 0) {
            permutations.add(perm);
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            List<Integer> remainingCopy = new ArrayList<>(remaining);
            List<Integer> permCopy = new ArrayList<>(perm);
            remainingCopy.remove(i);
            System.out.println(remainingCopy);
            permCopy.add(remaining.get(i));
            rec(permutations, permCopy, remainingCopy);
        }
    }
}
