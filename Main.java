public class Main {
    public static void main(String[] args) {

        // yay test!!!!
        System.out.println("Testing Red Black Tree Code");
        RedBlackTree mytree = new RedBlackTree();

        // inserting nodes
        mytree.insert(42);
        mytree.insert(5);
        mytree.insert(75);

        mytree.printTree();
        // print root node
        System.out.println("Root = " + mytree.getRoot().toString());

        // insert more stuff
        mytree.insert(11);
        mytree.insert(54);
        mytree.printTree();

        // print root node again
        System.out.println("Root = " + mytree.getRoot().toString());

        // insert and print more stuff
        mytree.insert(2);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());

        // insert and print more stuff
        mytree.insert(33);
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());

        // insert more stuff
        mytree.insert(32);
        mytree.insert(31);
        mytree.insert(30);
        
        // lets delete a node!
        mytree.deleteNode(54, mytree.getRoot());
        mytree.printTree();
    
        // delete another node!
        mytree.deleteNode(32, mytree.getRoot());

        // print final tree
        mytree.printTree();
        System.out.println("Root = " + mytree.getRoot().toString());
    }
}