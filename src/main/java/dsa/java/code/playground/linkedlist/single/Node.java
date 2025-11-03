package dsa.java.code.playground.linkedlist.single;

public class Node {

    int data;
    Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
