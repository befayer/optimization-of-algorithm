package org.example;

public class BinaryTree {

    Node root;

    public Node lcaRecursive(Node node, int x, int y) {
        if (node == null) return null;
        if (node.data == x || node.data == y) return node;

        Node leftLca = lcaRecursive(node.left, x, y);
        Node rightLca = lcaRecursive(node.right, x, y);

        if (leftLca != null && rightLca != null) return node;
        if (leftLca != null) return leftLca;
        else return rightLca;
    }

    public Node lcaNotRecursive(Node root, int p, int q) {
        while(root.data != p && root.data != q){
             if(root.data > p && root.data > q)
                root = root.left;
            else if(root.data < p && root.data < q)
                root = root.right;
            else break;
        }
        return root;
    }

    /**
     * 8. Создайте алгоритм и напишите код поиска первого общего предка двух узлов бинарного дерева.
     * Постарайтесь избежать хранения дополнительных узлов в структуре данных.
     * Примечание: бинарное дерево не обязательно является бинарным деревом поиска.
     */

    public static void main(String[] args) {

        /*
         *                         1
         *                   /          \
         *                  2            3
         *                /   \       /   \
         *               4    5      6     7
         *              / \  / \    / \   / \
         *             8  9 10 11 12  13 14 15
         */

        //testLcaRecursive();
        testLcaNotRecirsive();

    }

    public static void testLcaRecursive(){

        BinaryTree tree = new BinaryTree();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);

        System.out.println("LCA between 2 and 3: " + tree.lcaRecursive(tree.root, 2, 3).data);
        System.out.println("LCA between 4 and 3: " + tree.lcaRecursive(tree.root, 4, 3).data);
        System.out.println("LCA between 4 and 5: " + tree.lcaRecursive(tree.root, 4, 5).data);
        System.out.println("LCA between 8 and 5: " + tree.lcaRecursive(tree.root, 8, 5).data);
        System.out.println("LCA between 4 and 10: " + tree.lcaRecursive(tree.root, 4, 10).data);
        System.out.println("LCA between 12 and 13: " + tree.lcaRecursive(tree.root, 12, 13).data);
        System.out.println("LCA between 5 and 12: " + tree.lcaRecursive(tree.root, 5, 12).data);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            for (int j = i + 1; j <= 15; j++) {
                sb.append("LCA (").append(i).append(", ").append(j).append(") = ").append(tree.lcaRecursive(tree.root, i, j).data);
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }

    public static void testLcaNotRecirsive(){

        /*
         *                         6
         *                   /          \
         *                  2            8
         *                /   \       /   \
         *               0    4      7     9
         *              / \
         *             3  5
         */

        BinaryTree tree = new BinaryTree();

        tree.root = new Node(6);
        tree.root.left = new Node(2);
        tree.root.right = new Node(8);
        tree.root.left.left = new Node(0);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(7);
        tree.root.right.right = new Node(9);
        tree.root.left.left.left = new Node(3);
        tree.root.left.left.right = new Node(5);

        System.out.println("LCA between 0 and 4: " + tree.lcaNotRecursive(tree.root, 0, 4).data);
        System.out.println("LCA between 3 and 5: " + tree.lcaNotRecursive(tree.root, 3, 5).data);
        System.out.println("LCA between 4 and 7: " + tree.lcaNotRecursive(tree.root, 4, 7).data);
        System.out.println("LCA between 7 and 9: " + tree.lcaNotRecursive(tree.root, 7, 9).data);
    }
}