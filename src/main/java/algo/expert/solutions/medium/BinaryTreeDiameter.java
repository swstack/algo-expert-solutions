package algo.expert.solutions.medium;

public class BinaryTreeDiameter {
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class NodeMeta {
        public int height;
        public int maxDiameter;

        public NodeMeta(int height, int maxDiameter) {
            this.height = height;
            this.maxDiameter = maxDiameter;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {
        return traverse(tree).maxDiameter - 1;
    }

    public NodeMeta traverse(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            // Root node, height is 1, max diameter is 1 (the current node)
            return new NodeMeta(1, 1);
        }

        NodeMeta leftMeta = new NodeMeta(0, 0);
        if (tree.left != null) {
            leftMeta = traverse(tree.left);
        }

        NodeMeta rightMeta = new NodeMeta(0, 0);
        if (tree.right != null) {
            rightMeta = traverse(tree.right);
        }

        int currentDiameter = leftMeta.height + rightMeta.height + 1;
        NodeMeta meta = new NodeMeta(
                Math.max(leftMeta.height, rightMeta.height) + 1,
                Math.max(currentDiameter, Math.max(leftMeta.maxDiameter, rightMeta.maxDiameter))
        );

        System.out.println(String.format("node: %s, h: %s,  maxD: %s", tree.value, meta.height, currentDiameter));
        return meta;
    }
}
