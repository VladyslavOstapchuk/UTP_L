package com.company.MyImplementation;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.push(1);
        myLinkedList.push(2);
        myLinkedList.push(3);
        myLinkedList.pop(4);
        myLinkedList.pop(5);
        myLinkedList.pop(6);

        myLinkedList.printB();
    }
}

class MyLinkedList<T> {
    Node sentinel = new Node(null, null, null);

    class Node {
        T value;
        Node next;
        Node prev;

        Node(T value, Node prev, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public void push(T value) {
        Node newNode = new Node(value, null, null);

        if (isEmpty()) {
            sentinel.next = newNode;
            sentinel.prev = newNode;

            newNode.next = sentinel;
            newNode.prev = sentinel;
        } else {
            Node tmp = sentinel.prev;

            sentinel.prev = newNode;
            newNode.next = sentinel;

            newNode.prev = tmp;
            tmp.next = newNode;
        }
    }

    public void pop(T value) {
        Node newNode = new Node(value, null, null);

        if (isEmpty()) {
            sentinel.prev = newNode;
            sentinel.next = newNode;

            newNode.prev= sentinel;
            newNode.next = sentinel;
        } else {
            Node tmp = sentinel.next;

            sentinel.next = newNode;
            newNode.prev = sentinel;

            newNode.next = tmp;
            tmp.prev = newNode;
        }
    }

    public void printF() {
        if (sentinel.next != null) {
            Node current = sentinel.next;
            while(current != sentinel){
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public void printB() {
        if (sentinel.prev != null) {
            Node current = sentinel.prev;
            while(current != sentinel){
                System.out.print(current.value + " ");
                current = current.prev;
            }
            System.out.println();
        }
    }

    public boolean isEmpty() {
        return sentinel.prev == null && sentinel.next == null;
    }
}
