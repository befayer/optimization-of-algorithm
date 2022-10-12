package org.example;

public class BinaryTree {
    Node root;

    public Node lca(Node node, int x, int y) {
        if (node == null) return null;
        if (node.data == x || node.data == y) return node;

        Node leftLca = lca(node.left, x, y);
        Node rightLca = lca(node.right, x, y);

        if (leftLca != null && rightLca != null) return node;
        if (leftLca != null) return leftLca;
        else return rightLca;
    }

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

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 15; i++) {
            for (int j = i + 1; j <= 15; j++) {
                sb.append("LCA (").append(i).append(", ").append(j).append(") = ").append(tree.lca(tree.root, i, j).data);
                System.out.println(sb);
                sb.setLength(0);
            }
        }
    }
}