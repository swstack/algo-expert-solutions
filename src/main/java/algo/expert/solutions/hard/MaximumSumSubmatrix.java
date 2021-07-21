package algo.expert.solutions.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSumSubmatrix {

    public int maximumSumSubmatrix(int[][] matrix, int size) {
        List<int[][]> allSubmatrix = new ArrayList<>();
        for (int i = 0; i <= matrix.length - size; i++) {
            for (int j = 0; j <= matrix[0].length - size; j++) {
                int[][] sub = submatrix(matrix, i, j, size);
                allSubmatrix.add(sub);
            }
        }

        int greatestSum = Integer.MIN_VALUE;
        for (int[][] sub : allSubmatrix) {
            printSubmatrix(sub);
            int sum = sumSubmatrix(sub);
            if (sum > greatestSum) {
                greatestSum = sum;
            }
            System.out.println(String.format("sum: %s", sum));
        }

        return greatestSum;
    }

    private int[][] submatrix(int[][] matrix, int startI, int startJ, int size) {
        int[][] sub = new int[size][size];
        int subI = 0;
        for (int i = startI; i < startI + size; i++) {
            sub[subI] = Arrays.copyOfRange(matrix[i], startJ, startJ + size);
            subI++;
        }
        return sub;
    }

    private int sumSubmatrix(int[][] matrix) {
        int sum = 0;
        for (int[] x : matrix) {
            for (int y : x) {
                sum += y;
            }
        }
        return sum;
    }


    private void printSubmatrix(int[][] matrix) {
        System.out.println("Submatrix:");
        for (int[] x : matrix) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
