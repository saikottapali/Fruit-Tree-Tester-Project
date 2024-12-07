public class LinkedBST<T extends Comparable<T>> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    // Add method
    public void add(T data) {
        root = addRecursive(root, data);
    }

    private Node addRecursive(Node node, T data) {
        if (node == null) {
            return new Node(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, data);
        } else {
            node.right = addRecursive(node.right, data);
        }
        return node;
    }

    // Remove method
    public void remove(T data) {
        root = removeRecursive(root, data);
    }

    private Node removeRecursive(Node node, T data) {
        if (node == null) return null;

        if (data.compareTo(node.data) < 0) {
            node.left = removeRecursive(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = removeRecursive(node.right, data);
        } else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            Node smallestValue = findSmallest(node.right);
            node.data = smallestValue.data;
            node.right = removeRecursive(node.right, smallestValue.data);
        }
        return node;
    }

    private Node findSmallest(Node root) {
        return root.left == null ? root : findSmallest(root.left);
    }

    // Search method
    public boolean search(T data) {
        return searchRecursive(root, data);
    }

    private boolean searchRecursive(Node node, T data) {
        if (node == null) return false;
        if (data.compareTo(node.data) == 0) return true;
        return data.compareTo(node.data) < 0
                ? searchRecursive(node.left, data)
                : searchRecursive(node.right, data);
    }

    public void printInOrder() {
        printInOrderRecursive(root);
    }

    private void printInOrderRecursive(Node node) {
        if (node != null) {
            printInOrderRecursive(node.left);
            System.out.println(node.data);
            printInOrderRecursive(node.right);
        }
    }

    public void printPreOrder() {
        printPreOrderRecursive(root);
    }

    private void printPreOrderRecursive(Node node) {
        if (node != null) {
            System.out.println(node.data);
            printPreOrderRecursive(node.left);
            printPreOrderRecursive(node.right);
        }
    }

    public void printPostOrder() {
        printPostOrderRecursive(root);
    }

    private void printPostOrderRecursive(Node node) {
        if (node != null) {
            printPostOrderRecursive(node.left);
            printPostOrderRecursive(node.right);
            System.out.println(node.data);
        }
    }
}