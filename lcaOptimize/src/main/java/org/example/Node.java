package org.example;

class Node
{
    int data;
    Node left, right, parent;

    Node(int data)
    {
        this.data = data;
        left = right = parent = null;
    }
}
