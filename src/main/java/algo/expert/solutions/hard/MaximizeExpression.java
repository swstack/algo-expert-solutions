package algo.expert.solutions.hard;

public class MaximizeExpression {
    public int maximizeExpression(int[] array) {
        if (array.length < 4) {
            return 0;
        }

        return bruteForce(array);
    }

    private int bruteForce(int[] array) {
        // Every combination of 4 indexes in the array
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array.length; l++) {
                        if (i != j && j != k && k != l) {
                            int val = expression(array, i, j, k, l);
                            if (val > maxVal) {
                                maxVal = val;
                            }
                        }
                    }
                }
            }
        }
        return maxVal;
    }

    private int expression(int[] array, int a, int b, int c, int d) {
        if (a < b && b < c && c < d) {
            return array[a] - array[b] + array[c] - array[d];
        } else {
            return Integer.MIN_VALUE;
        }
    }
}
