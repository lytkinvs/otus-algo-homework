package binarytree;


public class BinaryTree implements ITree {
    private Node root;

    public void insert(int x) {

        if (root == null) {
            root = new Node();
            root.data = x;
            return;
        }

        var currentNode = root;

        while (true) {
            if (x > currentNode.data) {
                if (currentNode.right == null) {
                    currentNode.right = new Node();
                    currentNode.right.parent = currentNode;
                    currentNode.right.data = x;

                    return;
                } else {
                    currentNode = currentNode.right;
                }
            } else if (x < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node();
                    currentNode.left.parent = currentNode;
                    currentNode.left.data = x;
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                return;
            }
        }
    }

    public boolean search(int x) {

        var currentNode = root;

        while (true) {

            if (currentNode == null) break;

            if (x > currentNode.data) {
                currentNode = currentNode.right;
            } else if (x < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                return true;
            }
        }

        return false;
    }

    public void print() {
        printSubtree(root);
    }

    private void printSubtree(Node node) {

        if (node == null) return;

        printSubtree(node.left);
        System.out.print(node.data + " ");
        printSubtree(node.right);

    }

    public void remove(int x) {

        var currentNode = root;

        while (true) {
            if (currentNode == null) break;
            if (x > currentNode.data) {
                currentNode = currentNode.right;
            } else if (x < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                removeNode(currentNode, x);
                break;
            }
        }
    }

    public void removeNode(Node node, int x) {

        if (node.parent == null) {
            var r = node.right;

            if (r == null) {
                r = node.left;
            } else {
                var currentNode = r;

                while (currentNode.left != null) {
                    currentNode = currentNode.left;
                }
                currentNode.left = node.left;

            }
            r.parent = null;
            root = r;
            return;
        }


        if (node.parent.data > x) {
            node.parent.left = node.left;

            if (node.parent.left == null) {
                node.parent.left = node.right;
            } else {
                var currentNode = node.parent.left;

                while (currentNode.right != null) {
                    currentNode.right = currentNode.right.right;
                }
                currentNode.right = node.right;

            }
        } else {
            node.parent.right = node.right;

            if (node.parent.right == null) {
                node.parent.right = node.left;
            } else {
                var currentNode = node.parent.right;

                while (currentNode.left != null) {
                    currentNode.left = currentNode.left.left;
                }
                currentNode.left = node.left;
            }
        }

    }
}
