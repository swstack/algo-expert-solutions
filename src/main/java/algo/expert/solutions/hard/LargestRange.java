package algo.expert.solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LargestRange {
    public static int[] largestRange(int[] array) {
        Arrays.sort(array);

        if (array.length == 1) {
            return new int[]{array[0], array[0]};
        }

        if (array.length == 2) {
            return new int[]{array[0], array[1]};
        }

        int longestStart = -1;
        int longestEnd = -1;
        int longest = -1;
        List<Integer> currentRange = new ArrayList<>();
        for (int i : array) {
            if (currentRange.size() == 0) {
                currentRange.add(i);
                continue;
            }

            int last = currentRange.get(currentRange.size() - 1);
            if (i == last + 1) {
                currentRange.add(i);
                continue;
            } else if (i == last) {
                // duplicate, doesn't break the range but doesn't add to the count
                continue;
            } else {
                if (currentRange.size() > longest) {
                    longestStart = currentRange.get(0);
                    longestEnd = last;
                    longest = currentRange.size();
                }
                currentRange.clear();
                currentRange.add(i);
            }
            System.out.println("--");
        }

        // Handle the case where the range never reset
        if (currentRange.size() > longest) {
            longestStart = currentRange.get(0);
            longestEnd = currentRange.get(currentRange.size() - 1);
            currentRange.clear();
        }

        return new int[]{longestStart, longestEnd};
    }
}
