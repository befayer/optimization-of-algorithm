package org.example;

public class BinaryTreeLca {

    Node root;

    int depth(Node node)
    {
        int depth = 0;
        Node temp = node;
        while (node != null)
        {
            ++depth;
            node = node.parent;
        }
        assert temp != null;
        System.out.println("The depth of " + temp.data + " is " +  depth);
        return depth;
    }

    Node lca(Node n1, Node n2)
    {
        int depth1 = depth(n1);
        int depth2 = depth(n2);
        int difference = depth1 - depth2;

        if (difference < 0)
        {
            Node temp = n1;
            n1 = n2;
            n2 = temp;
            difference = difference * -1;
        }

        // приводим n1 и n2 к одному уровню
        while (difference-- != 0)
            n1 = n1.parent;

        while (n1 != null && n2 != null)
        {
            if (n1 == n2) return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }
        return null;
    }

    public static void main(String[] args)
    {

        /*
         *                         1
         *                   /          \
         *                  2            3
         *                /   \       /   \
         *               4    5      6     7
         *              / \  / \    / \   / \
         *             8  9 10 11 12  13 14 15
         */

        BinaryTreeLca tree = new BinaryTreeLca();

        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.left.parent =  tree.root;
        tree.root.right = new Node(3);
        tree.root.right.parent =  tree.root;

        tree.root.left.left = new Node(4);
        tree.root.left.left.parent = tree.root.left;
        tree.root.left.right = new Node(5);
        tree.root.left.right.parent = tree.root.left;
        tree.root.right.left = new Node(6);
        tree.root.right.left.parent = tree.root.right;
        tree.root.right.right = new Node(7);
        tree.root.right.right.parent = tree.root.right;

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.left.parent = tree.root.left.left;
        tree.root.left.left.right = new Node(9);
        tree.root.left.left.right.parent = tree.root.left.left;
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.left.parent = tree.root.left.right;
        tree.root.left.right.right = new Node(11);
        tree.root.left.right.right.parent = tree.root.left.right;
        tree.root.right.left.left = new Node(12);
        tree.root.right.left.left.parent = tree.root.right.left;
        tree.root.right.left.right = new Node(13);
        tree.root.right.left.right.parent = tree.root.right.left;
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.left.parent = tree.root.right.right;
        tree.root.right.right.right = new Node(15);
        tree.root.right.right.right.parent = tree.root.right.right;

        Node n1 = tree.root;
        Node n2 = tree.root.right.right.right;
        Node lca = tree.lca(n1, n2);
        System.out.println("The LCA of " + n1.data + " and " + n2.data + " is " + lca.data);
    }
}
