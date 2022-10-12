package org.example;

public class LinkedListNode {
    private Node head = new Node();

    public Node getElementFromEnd(int k) {
        if (k <= 0) return null;

        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k - 1; i++) {
            if (p2 == null) return null;
            p2 = p2.next;
        }
        if (p2 == null) return null;

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        tail().next = new Node(data);
    }

    private Node tail() {
        Node tail = head;
        // Находит последний элемент связного списка, известный как хвост
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public static class Node {
        int data;
        Node next = null;

        public Node(int data) { this.data = data; }

        public Node() {}

        @Override
        public String toString() {
            return String.valueOf(data);
        }
    }
}
