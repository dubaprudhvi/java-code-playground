package dsa.java.code.playground.linkedlist.single;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class SingleLinkedList implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(SingleLinkedList.class);

    @Override
    public void run(String... args) {
        logger.info("Starting Linked List Operations...");
        demonstrateLinkedListOperations();
    }
    
    private void demonstrateLinkedListOperations() {
        try {
            Node head = createLinkedListFromArray(new int[]{10, 20, 30, 40, 50, 60});
            logger.info("Original list:");
            printList(head);
            
            Node middle = findMiddleNode(head);
            logger.info("Middle node: {}", middle != null ? middle.data : "null");
            
            Node reversed = reverseIteratively(head);
            logger.info("Reversed list:");
            printList(reversed);
            
        } catch (Exception e) {
            logger.error("Error during linked list operations: {}", e.getMessage());
        }
    }
    
    public Node createLinkedListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }
    
    public void printList(Node head) {
        if (head == null) {
            logger.info("List is empty");
            return;
        }
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        String str = sb.toString();
        if(!str.equals("null")){
            logger.info("{}",str);
        }
    }
    
    public Node findMiddleNode(Node head) {
        if (head == null || head.next == null) return head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public Node reverseIteratively(Node head) {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}