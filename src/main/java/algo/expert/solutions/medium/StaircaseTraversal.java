package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class StaircaseTraversal {
    public int staircaseTraversal(int height, int maxSteps) {
        List<List<Integer>> combos = rec(IntStream.range(1, maxSteps + 1).toArray(), List.of(), height);
        System.out.println(combos);
        return combos.size();
    }

    private List<List<Integer>> rec(int[] stepsAvailable, List<Integer> stepsUsed, int height) {
        List<List<Integer>> results = new java.util.ArrayList<>(List.of());

        int stepsSum = stepsUsed.stream().reduce(0, Integer::sum);

        if (stepsSum == height) {
            results.add(stepsUsed);
            return results;
        }

        if (stepsSum < height) {
            for (int s : stepsAvailable) {
                List<Integer> stepsUsedCopy = new ArrayList<>(stepsUsed);
                stepsUsedCopy.add(s);
                results.addAll(rec(stepsAvailable, stepsUsedCopy, height));
            }
        }

        return results;
    }
}
