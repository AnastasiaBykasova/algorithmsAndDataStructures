package binaryTree;

public class AVLTree {
    public Node root;

    public boolean searchRecursive(int value) {
        return searchRecursive(root, value);
    }

    private boolean searchRecursive(Node node, int value) {
        if (node == null) {
            return false;
        } else if (node.data == value) {
            return true;
        } else if (value < node.data) {
            return searchRecursive(node.left, value);
        } else {
            return searchRecursive(node.right, value);
        }
    }

    public boolean searchIterative(int value) {
        Node current = root;
        while (current != null) {
            if (current.data == value) {
                return true;
            } else if (value < current.data) {
                current = current.left;
            } else {
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
        } else if (value > node.data) {
            node.right = insertRecursive(node.right, value);
        } else {
            return node; // Duplicate values are not allowed
        }

        // Обновляем баланс узла после вставки
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        // Проверяем, требуется ли балансировка
        if (balance > 1 && value < node.left.data) {
            return rightRotate(node);
        }
        if (balance < -1 && value > node.right.data) {
            return leftRotate(node);
        }
        if (balance > 1 && value > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balance < -1 && value < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
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
        } else if (value > node.data) {
            node.right = deleteRecursive(node.right, value);
        } else {
            // Узел найден
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Два потомка
            node.data = findMin(node.right).data;
            node.right = deleteRecursive(node.right, node.data);
        }

        // Обновляем баланс узла после удаления
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
            int balance = getBalance(node);

            // Проверяем, требуется ли балансировка
            if (balance > 1 && getBalance(node.left) >= 0) {
                return rightRotate(node);
            }
            if (balance < -1 && getBalance(node.right) <= 0) {
                return leftRotate(node);
            }
            if (balance > 1 && getBalance(node.left) < 0) {
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
            if (balance < -1 && getBalance(node.right) > 0) {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Вращение вправо
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Вращение
        x.right = y;
        y.left = T2;

        // Обновление высот
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        // Возврат нового корня
        return x;
    }

    // Вращение влево
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Вращение
        y.left = x;
        x.right = T2;

        // Обновление высот
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        // Возврат нового корня
        return y;
    }

    // Высота узла
    private int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Баланс узла
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
}