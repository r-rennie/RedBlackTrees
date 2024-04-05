public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Red Black Tree Code");
        RedBlackTree mytree = new RedBlackTree();

        mytree.insert(42);
        mytree.insert(5);
        mytree.insert(75);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
        mytree.insert(11);
        mytree.insert(54);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
        mytree.insert(2);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
        mytree.insert(33);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
        mytree.insert(32);
        mytree.insert(31);
        mytree.insert(30);
        mytree.deleteNode(54, mytree.getRoot());
        mytree.printTree();
    
        mytree.deleteNode(32, mytree.getRoot());

        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
    }
}