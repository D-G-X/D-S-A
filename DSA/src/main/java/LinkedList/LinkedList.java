package LinkedList;

public class LinkedList {
    Node head;

    public class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void createLinkedList(int data){
        head = new Node(data);
        head.next = null;
        System.out.println("Created a linked List");
    }

    public Node insertStart(int data){
        if (head == null){
            createLinkedList(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }
        System.out.println(data+"\tInserted at Start");
        return head;
    }

    public Node insertEnd(int data){
        if (head == null){
            createLinkedList(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = null;
            Node start = head;
            while(start.next != null){
                start = start.next;
            }
            start.next = newNode;
        }
        System.out.println(data+"\tInserted at End\n");
        return head;
    }

    public Node insertAfter(int data, int position){
        if (head == null){
            createLinkedList(data);
        } else {
            Node newNode = new Node(data);
            Node start = head;
            for(int i=0;i<position;i++){
                start = start.next;
            }
            newNode.next = start.next;
            start.next = newNode;
        }
        System.out.println(data+"\tInserted at after Position:"+position);
        return head;
    }

    public Node insertBefore(int data, int position){
        if (head == null){
            createLinkedList(data);
        } else {
            Node newNode = new Node(data);
            Node start = head;
            Node prev = head;
            for (int i=0;i<position;i++){
                prev = start;
                start = start.next;
            }
            newNode.next = start;
            prev.next = newNode;
        }
        System.out.println(data+"\tInserted at before Position:"+position);
        return head;
    }

    public void displayLinkedList(){
        if (head == null){
            System.out.println("Empty");
        } else {
            Node start = head;
            System.out.println("LinkedList:");
            while (start != null){
                System.out.println(start.data);
                start = start.next;
            }
            System.out.println("\n");
        }
    }

    public Node deleteStart(){
        if (! (head == null)){
            head = head.next;
        }
        return head;
    }
    public Node deleteEnd(){
        if (! (head == null)){
            Node start = head;
            while (start.next.next != null){
                start = start.next;
            }
            start.next = null;
        }
        return head;
    }

    public Node deleteGivenNode(int position) {
        if (! (head == null)){
            Node prev = head;
            Node start = head;
            for (int i=0;i<position;i++){
                prev = start;
                start = start.next;
            }
            prev.next = start.next;
//            System.out.println("deleted given node");
        }
        return head;
    }

    public Node deleteAfter(int position){
        if (! (head == null)){
            Node start = head;
            for (int i=0;i<position;i++){
                start = start.next;
            }
            if (start.next != null) {
                start.next = start.next.next;
            } else {
                start.next = null;
            }
        }
        return head;
    }

    public Node deleteBefore(int position){
        if (! (head == null)){
            Node prev = head;
            Node prePrev = head;
            Node start = head;
            for (int i=0;i<position;i++){
                prePrev = prev;
                prev = start;
                start = start.next;
            }
            prePrev.next = start;
        }
        return head;
    }


/*
* Linked List operations:
*
* create a linked list
*
*  insert: a new node at the end
*          a new node at the start
*          a new node after a given node
*          a new node before a given node
*
* delete: from the start
*         from the end
*         before a given node
*         after a given node
*         delete a given node
*
* search a node
*
* display linked list
*
*
*
* */
}

