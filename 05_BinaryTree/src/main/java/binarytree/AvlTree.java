package binarytree;

public class AvlTree implements ITree {
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

                    calcHeight(currentNode.right);
                    reBalance(currentNode.right);
                    return;
                } else {
                    currentNode = currentNode.right;
                }
            } else if (x < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = new Node();
                    currentNode.left.parent = currentNode;
                    currentNode.left.data = x;

                    calcHeight(currentNode.left);
                    reBalance(currentNode.left);
                    return;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                return;
            }
        }
    }

    private void reBalance(Node node) {

        var currentNode = node;

        while (currentNode != null) {
            var balance = balance(currentNode);

            if (Math.abs(balance) == 2) {
                currentNode = rebalanceTree(currentNode);
                calcHeight(currentNode);
                continue;
            }
            if (currentNode.parent == null) {
                root = currentNode;
            }

            currentNode = currentNode.parent;
        }

    }

    private Node rebalanceTree(Node node) {

        var n = node;

        var heightLeft = height(n.left);
        var heightRight = height(n.right);


        if (heightLeft > heightRight) {

            var l = n.left;

            if (height(l.left) >= height(l.right)) {
                var x = rightRotation(n.left);
                return x;
            } else {
                var f = leftRotation(l.right);
                n.left = f;
                var x = rightRotation(n.left);

                return x;
            }
        } else {
            var l = n.right;

            if (height(l.right) >= height(l.left)) {
                var x = leftRotation(n.right);
                return x;
            } else {
                var f = rightRotation(l.left);
                n.right = f;
                var x = leftRotation(n.right);

                return x;
            }

        }
    }

    private Node rightRotation(Node n) {

        var parent = n.parent;
        parent.left = n.right;

        if (n.right != null) {
            n.right.parent = parent;
        }


        n.right = parent;
        n.parent = n.parent.parent;
        parent.parent = n;

        if (n.parent != null) {
            if (n.parent.data > n.data) {
                n.parent.left = n;
            } else {
                n.parent.right = n;
            }
        }

        recalcHeight(n.right);
        return n;

    }

    private Node leftRotation(Node n) {
        var parent = n.parent;
        parent.right = n.left;

        if (n.left != null) {
            n.left.parent = parent;
        }

        n.left = parent;
        n.parent = n.parent.parent;
        parent.parent = n;

        if (n.parent != null) {
            if (n.parent.data > n.data) {
                n.parent.left = n;
            } else {
                n.parent.right = n;
            }
        }

        recalcHeight(n.left);
        return n;
    }

    private void calcHeight(Node node) {

        var currentNode = node;

        while (currentNode != null) {
            recalcHeight(currentNode);
            currentNode = currentNode.parent;
        }
    }

    private void recalcHeight(Node currentNode) {
        var l = height(currentNode.left);
        var r = height(currentNode.right);

        currentNode.height = Integer.max(l, r) + 1;
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int balance(Node node) {
        return height(node.right) - height(node.left);
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
                calcHeight(currentNode.left);
                reBalance(currentNode.left);
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
                calcHeight(currentNode.right);
                reBalance(currentNode.right);
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

                calcHeight(currentNode.left);
                reBalance(currentNode.left);
            }
        }

    }
}
