package binaryTree;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class BinaryTreePanel extends JPanel {
    private BinaryTree tree;
    private int nodeSize = 30;
    private int horizontalSpacing = 50;
    private int verticalSpacing = 40;

    public BinaryTreePanel(BinaryTree tree) {
        this.tree = tree;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (tree.root != null) {
            drawTree(g2d, tree.root, getWidth() / 2, 30);
        }
    }

    private void drawTree(Graphics2D g2d, Node node, int x, int y) {
        if (node == null) {
            return;
        }

        // Рисуем узел
        int nodeX = x;
        int nodeY = y;
        g2d.setColor(Color.BLACK);
        g2d.fill(new Ellipse2D.Double(nodeX - nodeSize / 2, nodeY - nodeSize / 2,
                nodeSize, nodeSize));
        g2d.setColor(Color.WHITE);
        g2d.drawString(String.valueOf(node.data), nodeX - nodeSize / 4, nodeY + nodeSize / 4);

        // Рисуем линии к дочерним узлам
        if (node.left != null) {
            drawEdge(g2d, nodeX, nodeY, nodeX - horizontalSpacing, nodeY + verticalSpacing);
            drawTree(g2d, node.left, nodeX - horizontalSpacing, nodeY + verticalSpacing);
        }
        if (node.right != null) {
            drawEdge(g2d, nodeX, nodeY, nodeX + horizontalSpacing, nodeY + verticalSpacing);
            drawTree(g2d, node.right, nodeX + horizontalSpacing, nodeY + verticalSpacing);
        }
    }

    private void drawEdge(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
