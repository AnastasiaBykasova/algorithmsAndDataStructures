package binaryTree;

import javax.swing.*;

public class MainBinaryTree {
    public static void main(String[] args) {
        // Binary tree
        System.out.println("Binary tree");
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(5);
        bt.root.left = new Node(2);
        bt.root.right = new Node(8);
        bt.root.left.left = new Node(1);
        bt.root.left.right = new Node(4);
        bt.root.right.left = new Node(7);
        bt.root.right.right = new Node(10);
        bt.root.left.left.left = new Node(11);
        bt.root.left.left.left.right = new Node(12);

        bt.insert(6);
        bt.delete(2);

        // Вставка узла
        bt.insert(6);
        // Удаление узла
        bt.delete(2);

        int valueSearch1 = 7;
        System.out.println("Desired value: " + valueSearch1);
        System.out.println("Recursive search: " + bt.searchRecursive(valueSearch1));
        System.out.println("Iterative search: " + bt.searchIterative(valueSearch1));
        System.out.println("\n");

        int valueSearch2 = 6;
        System.out.println("Desired value: " + valueSearch2);
        System.out.println("Recursive search: " + bt.searchRecursive(valueSearch2));
        System.out.println("Iterative search: " + bt.searchIterative(valueSearch2));
        System.out.println("\n");

        int valueSearch3 = 2;
        System.out.println("Desired value: " + valueSearch3);
        System.out.println("Recursive search: " + bt.searchRecursive(valueSearch3));
        System.out.println("Iterative search: " + bt.searchIterative(valueSearch3));
        System.out.println("\n");

        // Визуализация бинарного дерева
        JFrame bTree = new JFrame("Binary Tree Visualization");
        bTree.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bTree.setSize(600, 400);
        bTree.add(new BinaryTreePanel(bt));
        bTree.setVisible(true);


        // AVL tree
        System.out.println("AVL tree");
        AVLTree avl = new AVLTree();
        avl.insert(5);
        avl.insert(2);
        avl.insert(8);
        avl.insert(1);
        avl.insert(4);
        avl.insert(7);
        avl.insert(10);
        avl.insert(11);
        avl.insert(12);

        // Вставка узла
        avl.insert(6);
        // Удаление узла
        avl.delete(2);

        int valueSearch = 7;
        System.out.println("Desired value: " + valueSearch);
        System.out.println("Recursive search: " + avl.searchRecursive(valueSearch));
        System.out.println("Iterative search: " + avl.searchIterative(valueSearch));

        // Визуализация дерева AVL
        JFrame treeAvl = new JFrame("AVL Tree Visualization");
        treeAvl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        treeAvl.setSize(600, 400);
        treeAvl.add(new AVLTreePanel(avl));
        treeAvl.setVisible(true);
    }
}
