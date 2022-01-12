package LinkedList;

public class PriorityQueue {
    Node head;
    public class Node{
        int data;
        int priority;
        Node next;
        Node prev;
        public Node(int data, int priority){
            this.data = data;
            this.priority = priority;
            this.next = null;
            this.prev= null;
        }

    }
    public Node createPQ(int data, int priority){
        head = new Node(data,priority);
        head.prev = head;
        head.next = head;
        System.out.println("Created a linked List");
        return head;
    }

    public Node insertStart(int data, int priority){
        if (head != null){
            Node newNode = new Node(data,priority);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        } else {
            createPQ(data,priority);
        }
        return head;
    }

    public Node insertEnd(int data, int priority){
        if (head != null){
            Node newNode = new Node(data,priority);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        } else {
            createPQ(data,priority);
        }
        return head;
    }

    public Node enqueue(int data, int priority){
        if (head != null) {
            Node start = head;
            while(start.priority <= priority && start.next != head){
                start =start.next;
            }
            if (start == head && start.priority >= priority){
                insertStart(data,priority);
            } else if(start.next == head){
                insertEnd(data,priority);
            } else {
                Node newNode = new Node(data,priority);
                newNode.next = start;
                newNode.prev = start.prev;
                start.prev.next = newNode;
                start.prev = newNode;
            }
        } else{
            createPQ(data,priority);
        }
        return head;
    }

    public Node dequeue(){
        if(head != null){
            Node start = head.next;
            head.prev.next = start;
            start.prev = head.prev;
            head = start;
        }
        return head;
    }

    public void displayPQ(){
        if (head == null){
            System.out.println("Empty");
        } else {
            Node start = head;
            System.out.println("\nPriority Queue:");
            while (start.next != head){
                System.out.println(start.data+"\t"+start.priority);
                start = start.next;
            }
            System.out.println(start.data+"\t"+start.priority);
            System.out.println("\n");
        }
    }

}
