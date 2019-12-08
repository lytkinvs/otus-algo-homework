import binarytree.AvlTree;
import binarytree.ITree;

class Program {


    public static void main(String args[]) {

        var tree = new AvlTree();

        tree.insert(8);
        tree.insert(4);
        tree.insert(12);
        tree.insert(9);
        tree.insert(10);
        tree.insert(19);
        tree.insert(15);
        tree.insert(14);
        tree.insert(16);
        tree.insert(21);
        tree.insert(6);
        tree.insert(3);
        tree.insert(2);


//        System.out.println(tree.search(7));
//        System.out.println(tree.search(8));
//        System.out.println(tree.search(3));
//        System.out.println(tree.search(4));
//
//        tree.remove(15);

        tree.print();
    }


    public static void testTree(ITree tree) {

    }


}
