package org.example;

public class BinaryTree {
    Node root;
    Node findLCA(Node node, int x, int y) {
        if (node == null) return null;
        if (node.data == x || node.data == y) return node;

        Node leftLca = findLCA(node.left, x, y);
        Node rightLca = findLCA(node.right, x, y);

        if (leftLca != null && rightLca != null) {
            return node;
        }
        if (leftLca != null) {
            return leftLca;
        }
        return rightLca;
    }

    public static void main(String args[]) {

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

        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                System.out.println("LCA (" + i + ", " + j + ") = " + tree.findLCA(tree.root, i, j).data);
            }
        }
        /*
        System.out.println("LCA (2,3) = " + tree.findLCA(2,3).data);
        System.out.println("LCA (4,3) = " + tree.findLCA(4,3).data);
        System.out.println("LCA (4,6) = " + tree.findLCA(4,6).data);
        System.out.println("LCA (2,6) = " + tree.findLCA(2,6).data);
        System.out.println("LCA (8,5) = " + tree.findLCA(8,5).data);
        System.out.println("LCA (4,10) = " + tree.findLCA(4,10).data);
        System.out.println("LCA (5,11) = " + tree.findLCA(5,11).data);
        System.out.println("LCA (6,14) = " + tree.findLCA(6,14).data);
         */
    }
}