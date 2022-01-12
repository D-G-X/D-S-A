package LinkedList;

public class DoublyLinkedList {
    Node head;
    private class Node{
        Node prev;
        int data;
        Node next;

        public Node(int data){
            this.prev = null;
            this.data = data;
            this.next = null;
        }
    }

    public void createDLL(int data){
        head = new Node(data);
        System.out.println("Created a Doubly linked List");
    }

    public Node insertStart(int data){
        if (head != null){
            Node newNode = new Node(data);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            createDLL(data);
        }
        System.out.println(data+"\tInserted at Start");
        return head;
    }

    public Node insertEnd(int data){
        if (head != null){
            Node newNode = new Node(data);
            Node start = head;
            while (start.next != null){
                start = start.next;
            }
            start.next = newNode;
            newNode.prev = start;
        } else {
            createDLL(data);
        }
        System.out.println(data+"\t Inserted at end");
        return head;
    }

    public Node insertAfter(int data, int position){
        if(head!= null){
            Node newNode = new Node(data);
            Node start = head;
            for(int i=0;i<position;i++){
                start = start.next;
            }
            if (start.next != null){
                newNode.next = start.next;
                newNode.prev = start;
                start.next.prev = newNode;
                start.next = newNode;
            } else {
                head = insertEnd(data);
            }
        } else {
            createDLL(data);
        }
        System.out.println(data+" Inserted After "+ position);
        return head;
    }

    public Node insertBefore(int data, int position){
        if(head != null){
            Node newNode = new Node(data);
            Node start = head;
            for(int i=0; i<position;i++){
                start = start.next;
            }
            if (position != 0){
                newNode.next = start;
                newNode.prev = start.prev;
                start.prev.next = newNode;
                start.prev = newNode;
            } else if (start.next == null){
                insertEnd(data);
            } else if (position == 0){
                insertStart(data);
            }
        }else {
            createDLL(data);
        }
        return head;
    }

    public Node deleteStart(){
        if(head!= null){
            head = head.next;
            head.prev = null;
        }
        return head;
    }

    public Node deleteEnd(){
        if (head != null){
            Node start = head;
            while (start.next != null){
                start= start.next;
            }
            start.prev.next = null;
            start.prev = null;
        }
        return head;
    }

    public Node deleteAfter(int position){
        if(head != null){
            Node start = head;
            for(int i=0;i<position;i++){
                start = start.next;
            }
            if (start.next == null){
                System.out.println("Node doesn't exist");
            } else if(start.next.next == null){
                deleteEnd();
            } else {
                start.next.next.prev = start;
                start.next = start.next.next;
            }

        }
        return head;
    }

    public Node deleteBefore(int position){
        if(head != null){
            Node  start = head;
            for (int i=0;i<position;i++){
                start = start.next;
            }
            if (start.prev == null){
                System.out.println("Node doesn't exist.");
            } else if(start.prev == head){
                deleteStart();
            } else{
                start.prev.prev.next = start;
                start.prev = start.prev.prev;
            }

        }
        return head;
    }

    public Node deleteAtPosition(int position){
        if (head != null){
            Node start = head;
            for (int i=0;i<position;i++){
                start = start.next;
            }
            if (start.next == null){
                deleteEnd();
            } else if (start.prev == null){
                deleteStart();
            } else {
                start.prev.next = start.next;
                start.next.prev = start.prev;
            }
        }
        return head;
    }

    public Node search(int data){
        Node start = null;
        if(head != null){
            start = head;
            int position = 0;
            while(start.data != data && start.next != null){
                start = start.next;
                position++;
            }

            if (start != null && start.data == data){
                System.out.println(data+" is at "+position+" position of the linked list.");
            } else {
                System.out.println(data + " Not Found.");
            }

        } else {
            System.out.println("Empty LinkedList");
        }
        return start;
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

}
