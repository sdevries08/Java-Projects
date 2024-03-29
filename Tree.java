public class Tree {
    private TreeNode root;

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        else {
            root.insert(value);
        }
    }

    public int min() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return root.min();
        }
    }

    public int max() {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        else {
            return root.max();
        }
    }

    public TreeNode get(int value) {
        if (root != null) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value){
        root = delete(root, value);
    }
    // Return replacemenet node
    private TreeNode delete(TreeNode subtreeRoot, int value) {
        if (subtreeRoot == null) {
            return subtreeRoot;
        }
        if (value < subtreeRoot.getData()) {
            subtreeRoot.setLeftChild(delete(subtreeRoot, value));
        }
        else if (value > subtreeRoot.getData()) {
            subtreeRoot.setRightChild(delete(subtreeRoot, value));
        }
        else {
            if (subtreeRoot.getLeftChild() == null) {
                return subtreeRoot.getRightChild();
            } 
            else if (subtreeRoot.getRightChild() == null) {
                return subtreeRoot.getLeftChild();
            }
        }
        return subtreeRoot;
    }
    
    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

}
