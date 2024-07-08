package binaryTree;

public class Node {
    int data;
    Node left;
    Node right;
    int height;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
