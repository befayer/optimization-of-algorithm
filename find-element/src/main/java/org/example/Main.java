package org.example;

public class Main {

    /*
    Реализуйте алгоритм для нахождения в односвязном списке k-го элемента с конца.
     */
    public static void main(String[] args) {
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.append(1);
        linkedListNode.append(2);
        linkedListNode.append(3);
        linkedListNode.append(4);
        linkedListNode.append(5);;
        linkedListNode.append(6);
        linkedListNode.append(7);
        linkedListNode.append(8);
        linkedListNode.append(9);
        linkedListNode.append(10);
        linkedListNode.append(11);
        System.out.println(linkedListNode);
        System.out.println(linkedListNode.getElementFromEnd(5).data);
    }
}