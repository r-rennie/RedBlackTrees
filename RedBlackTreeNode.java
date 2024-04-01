class RedBlackTreeNode {
    int data;
    RedBlackTreeNode parent;
    RedBlackTreeNode left;
    RedBlackTreeNode right;
    boolean isRed;

    public RedBlackTreeNode(int data) {
        this.data = data;
        isRed = true;
        parent = null;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}