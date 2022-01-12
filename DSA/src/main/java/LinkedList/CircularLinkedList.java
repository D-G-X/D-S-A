package LinkedList;

public class CircularLinkedList {
    Node head;
    private static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void createCLL(int data){
        head = new Node(data);
        head.next = head;
        System.out.println("Created a Circular linked List");
    }

    public Node insertStart(int data){
        if (head == null){
            createCLL(data);
        } else {
            Node newNode = new Node(data);
            newNode.next = head;
            head.next = newNode;
            head = newNode;
        }
        System.out.println(data+"\tInserted at Start");
        return head;
    }

    public Node insertEnd(int data){
        if(head == null){
            createCLL(data);
        } else {
            Node newNode = new Node(data);
            Node start = head;
            while(start.next != head){
                start = start.next;
            }
            newNode.next = head;
            start.next = newNode;
        }
        System.out.println(data+"\tInserted at End\n");
        return head;
    }

    public Node insertAfter(int data, int position){
        if (head == null){
            createCLL(data);
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
            createCLL(data);
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
            System.out.println("Circular LinkedList:");
            while (start.next != head){
                System.out.println(start.data);
                start = start.next;
            }
            System.out.println(start.data);
            System.out.println("\n");
        }
    }

    public Node deleteStart(){
        if ((head != null)){
            if (head == head.next){
                return null;
            }
            Node start = head.next;
            while (start.next != head){
                start = start.next;
            }
            start.next = head.next;
            head = head.next;

        }
        return head;
    }

    public Node deleteEnd(){
        if (head != null){
            if (head == head.next){
                return null;
            }
            Node start = head.next;
            Node prev = head;
            while (start.next != head){
                prev = start;
                start = start.next;
            }
            prev.next = head;
        }
        return head;
    }
    
    public Node deleteGivenNode(int position){
        if (head != null){
            Node prev = head;
            Node start = head;
            for (int i=0;i<position;i++){
                prev = start;
                start = start.next;
            }
            prev.next = start.next;
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
            }
        }
        return head;
    }

    public Node deleteBefore(int position){
        if (! (head == null)) {
            if (position < 2) {
                deleteStart();
            } else {
                Node prev = head;
                Node prePrev = head;
                Node start = head;
                for (int i = 0; i < position; i++) {
                    prePrev = prev;
                    prev = start;
                    start = start.next;
                }
                prePrev.next = start;
            }
        }
        return head;
    }

    public Node search(int data){
        Node start = null;
        if(head != null){
            start = head;
            int position = 0;
            while(start.data != data && start.next != head){
                start = start.next;
                position++;
            }

            if (start != head && start.data == data){
                System.out.println(data+" is at "+position+" position of the linked list.\n");
            } else {
                System.out.println(data + " Not Found.\n");
            }

        } else {
            System.out.println("Empty LinkedList");
        }
        return start;
    }
    
}
