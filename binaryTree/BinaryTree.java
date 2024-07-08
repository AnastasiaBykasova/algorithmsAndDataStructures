package binaryTree;

public class BinaryTree {
    public Node root;

    public boolean searchRecursive(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, int value) {
        if (node == null) {
            return false;
        }
        else if (node.data == value) {
            return true;
        }
        else if (value < node.data) {
            return searchRecursive(node.left, value);
        }
        else {
            return searchRecursive(node.right, value);
        }
    }

    public boolean searchIterative(int value) {
        Node current = root;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            else if (value < current.data) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node insertRecursive(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insertRecursive(node.left, value);
        }
        else if (value > node.data) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    public void delete(int value) {
        root = deleteRecursive(root, value);
    }

    private Node deleteRecursive(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (value < node.data) {
            node.left = deleteRecursive(node.left, value);
        }
        else if (value > node.data) {
            node.right = deleteRecursive(node.right, value);
        }
        else {
            // node found
            if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            // two descendants
            node.data = findMin(node.right).data;
            node.right = deleteRecursive(node.right, node.data);
        }
        return node;
    }

    // Возвращает минимальный узел в поддереве, начинающемся с заданного узла.
    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
