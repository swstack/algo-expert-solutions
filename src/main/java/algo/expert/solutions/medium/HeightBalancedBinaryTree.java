package algo.expert.solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class HeightBalancedBinaryTree {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class NodeMeta {
        int value;
        int height;
        boolean balanced = true;

        public NodeMeta(int value, int height) {
            this.value = value;
            this.height = height;
        }

        public String toString() {
            return String.format("node: %s, h: %s, bal: %s", value, height, balanced);
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        return calcBalanced(tree, 0).balanced;
    }

    public NodeMeta calcBalanced(BinaryTree node, int depth) {
        // System.out.println(String.format("node: %s", node.value));
        if (node.left == null && node.right == null) {
            return new NodeMeta(node.value, depth);
        }

        NodeMeta leftMeta = new NodeMeta(node.value, depth);
        if (node.left != null) {
            leftMeta = calcBalanced(node.left, depth + 1);
        }

        NodeMeta rightMeta = new NodeMeta(node.value, depth);
        if (node.right != null) {
            rightMeta = calcBalanced(node.right, depth + 1);
        }

        System.out.println(String.format("L: %s", leftMeta));
        System.out.println(String.format("R: %s", rightMeta));
        NodeMeta meta = new NodeMeta(node.value, Math.max(leftMeta.height, rightMeta.height));
        meta.balanced = false;
        if (leftMeta.balanced && rightMeta.balanced && Math.abs(leftMeta.height - rightMeta.height) <= 1) {
            meta.balanced = true;
        }
        return meta;
    }

    public int maxHeight(BinaryTree node, int depth) {
        int leftHeight = depth;
        if (node.left != null) {
            leftHeight = maxHeight(node.left, depth + 1);
        }

        int rightHeight = depth;
        if (node.right != null) {
            rightHeight = maxHeight(node.right, depth + 1);
        }

        return Math.max(leftHeight, rightHeight);
    }

    public List<Integer> allHeights(BinaryTree node, int depth) {
        List<Integer> heights = new ArrayList<>();
        if (node.left == null && node.right == null) {
            heights.add(depth);
            return heights;
        }

        if (node.left != null) {
            heights.addAll(allHeights(node.left, depth + 1));
        }

        if (node.right != null) {
            heights.addAll(allHeights(node.right, depth + 1));
        }
        return heights;
    }
}
