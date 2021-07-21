package algo.expert.solutions.hard;

import java.util.ArrayList;

public class GenerateDivTags {
    public ArrayList<String> generateDivTags(int numberOfTags) {
//        return bruteForceAllCombinations("", numberOfTags, 0, 0, new ArrayList<>());
        return validCombinations("", numberOfTags, 0, 0, new ArrayList<>());

    }

    public ArrayList<String> validCombinations(String s, int total, int numLeft, int numRight, ArrayList<String> results) {
        if (numLeft < total) {
            String tmp = s + "<div>";
            validCombinations(tmp, total, numLeft + 1, numRight, results);
        }

        if (numLeft > numRight) {
            String tmp = s + "</div>";
            validCombinations(tmp, total, numLeft, numRight + 1, results);
        }

        if (numRight == total && numLeft == total) {
            results.add(s);
        }

        return results;
    }

    public ArrayList<String> bruteForceAllCombinations(String s, int total, int numLeft, int numRight, ArrayList<String> results) {
        if (numLeft < total) {
            String tmp = s + "<div>";
            bruteForceAllCombinations(tmp, total, numLeft + 1, numRight, results);
        }

        if (numRight < total) {
            String tmp = s + "</div>";
            bruteForceAllCombinations(tmp, total, numLeft, numRight + 1, results);
        }

        if (numRight == total && numLeft == total) {
            results.add(s);
        }

        return results;
    }
}
