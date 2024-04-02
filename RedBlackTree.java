import java.util.ArrayList;
import java.util.List;

public class RedBlackTree {
    private RedBlackTreeNode root;

    public RedBlackTree() {
        root = null;
    }

    public RedBlackTreeNode getRoot() {
        return root;
    }

    // Left Rotation
    private void leftRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.right;
        x.right = y.left;
        if (y.left != null)
            y.left.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.left)
            x.parent.left = y;
        else
            x.parent.right = y;
        y.left = x;
        x.parent = y;
    }

    // Right Rotation
    private void rightRotate(RedBlackTreeNode x) {
        RedBlackTreeNode y = x.left;
        x.left = y.right;
        if (y.right != null)
            y.right.parent = x;
        y.parent = x.parent;
        if (x.parent == null)
            root = y;
        else if (x == x.parent.right)
            x.parent.right = y;
        else
            x.parent.left = y;
        y.right = x;
        x.parent = y;
    }

    // Fix violation of Red-Black Tree properties after insertion
    private void insertFixup(RedBlackTreeNode z) {
        while (z != root && z.parent.isRed) {
            if (z.parent == z.parent.parent.left) {
                RedBlackTreeNode y = z.parent.parent.right;
                if (y != null && y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.right) {
                        z = z.parent;
                        leftRotate(z);
                    }
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    rightRotate(z.parent.parent);
                }
            } else {
                RedBlackTreeNode y = z.parent.parent.left;
                if (y != null && y.isRed) {
                    z.parent.isRed = false;
                    y.isRed = false;
                    z.parent.parent.isRed = true;
                    z = z.parent.parent;
                } else {
                    if (z == z.parent.left) {
                        z = z.parent;
                        rightRotate(z);
                    }
                    z.parent.isRed = false;
                    z.parent.parent.isRed = true;
                    leftRotate(z.parent.parent);
                }
            }
        }
        root.isRed = false;
    }

    // Insertion
    public void insert(int data) {
        RedBlackTreeNode newNode = new RedBlackTreeNode(data);
        RedBlackTreeNode y = null;
        RedBlackTreeNode x = root;
        while (x != null) {
            y = x;
            if (newNode.data < x.data)
                x = x.left;
            else
                x = x.right;
        }
        newNode.parent = y;
        if (y == null)
            root = newNode;
        else if (newNode.data < y.data)
            y.left = newNode;
        else
            y.right = newNode;
        newNode.isRed = true;
        insertFixup(newNode);
    }

    // Inorder traversal for printing
    private void inorderTraversal(RedBlackTreeNode node, List<Integer> result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.add(node.data);
            inorderTraversal(node.right, result);
        }
    }

    // Print the Red-Black Tree
    public void printTree() {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        System.out.println("Red-Black Tree:");
        for (int data : result) {
            System.out.print(data + " ");
        }
        System.out.println();
    }


    /*
    Rules for coloring node:
    1. Every node is colored either red or black
    2. The root is black & every leaf (NULL) is black
    3. If a node is red, the children must be black
    4. Every path from a node to a
    NULL pointer must contain the
    same number of black nodes
    Does the diagram fit
    all 4 properties?

    Cases:
    1. Deleting Leaf node (no children)
    2. Node has one child (replace node with child)
    3. Node has two children (Replace node with its in-order successor or the leftmost node in right subtree)
    Delete successor like number 2
    4. Restore properities and color changes with rotations

    TODO How does one delete memory in java?
    
    */


    /* DeleteNode: Deletes a node from the Red Black Tree
     * @param RedBlackTreeNode z: the node to be deleted
     */
    public void deleteNode(RedBlackTreeNode z){
        //Case for deleting a leaf node 
        if (z.left == null && z.right == null)
        {
            if (z.parent.left == z){
                z.parent.left = null;
            }
            else if (z.parent.right == z){
                z.parent.right = null;
            }
        }
        // Case for Node with only one child
        // TODO Finish case for node with only one child case deletion
        
        if (z.left == null || z.right == null){

        }

        //Case for Node with 2 children
        if (z.left != null  && z.right != null){
            //Find successor of node z to replace it with
            RedBlackTreeNode successor = inOrderSuccesor(root, z);
            z = successor;
        }

        /*
         * // TODO Here, you would fix the colors...
         */
        

    }

    //Methods below were utilized from GeeksForGeeks

    /*
    InOrderSuccesor: Find the successor in an in-order traversal (least-greatest value above given)
    @param RedBlackTreeNode root: The root of the Red-Black Tree
    @param RedBlackTreeNode z: The node to find the succesor of
    @return The succesor of node z
     */
    public RedBlackTreeNode inOrderSuccesor( RedBlackTreeNode root, RedBlackTreeNode z){
        if (z.right != null){
            return minimumNode(z.right);
        }
        RedBlackTreeNode p = z.parent;
        while (p != null && z == p.right){
            z = p;
            p = p.parent;
        }
        return p;
    }

    /*
    minimumNode: Finds the next, minimum, biggest node of a subtree
    @param RedBlackTree z: the node that's minimum node would be found
    @return RedBlackTree current: the node that's the minimum node of z
     */
    public RedBlackTreeNode minimumNode(RedBlackTreeNode z){
        RedBlackTreeNode current = z;

        while (current.left != null){
            current = current.left; 
        }
        return current;

    }
}