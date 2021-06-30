package algo.expert.solutions.veryhard;

public class AllKindsOfNodeDepths {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int allKindsOfNodeDepths(BinaryTree root) {
        int rootSum = sumNodeDepths(root, 0);

        int leftSum = 0;
        if (root.left != null) {
            leftSum = allKindsOfNodeDepths(root.left);
        }

        int rightSum = 0;
        if (root.right != null) {
            rightSum = allKindsOfNodeDepths(root.right);
        }

        return rootSum + leftSum + rightSum;
    }

    static int sumNodeDepths(BinaryTree root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        int leftDepth = 0;
        if (root.left != null) {
            leftDepth = sumNodeDepths(root.left, depth + 1);
        }

        int rightDepth = 0;
        if (root.right != null) {
            rightDepth = sumNodeDepths(root.right, depth + 1);
        }

        return rightDepth + leftDepth + depth;
    }

}
