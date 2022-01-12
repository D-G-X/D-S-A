package LinkedList;

public class DoublyCircularLinkedList {
    Node head;
    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node createDCLL(int data){
        this.head = new Node(data);
        head.prev = head;
        head.next = head;
        System.out.println("Created a Doubly Circular Linked List.");
        return head;
    }

    public Node insertStart(int data){
        if (head != null){
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            head = newNode;
        } else {
            createDCLL(data);
        }
        return head;
    }

    public Node insertEnd(int data){
        if (head != null){
            Node newNode = new Node(data);
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
        } else {
            createDCLL(data);
        }
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
            createDCLL(data);
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
            createDCLL(data);
        }
        return head;
    }

    public Node deleteStart(){
        if(head != null){
            Node start = head.next;
            head.prev.next = start;
            start.prev = head.prev;
            head = start;
        }
        return head;
    }

    public Node deleteEnd(){
        if (head != null){
            Node start = head.prev;
            start.prev.next = head;
            head.prev = start.prev;
        }
        return head;
    }

    public Node deleteAfter(int position){
        if(head != null){
            Node start = head;
            for(int i=0;i<position;i++){
                if (start.next != null) {
                    start = start.next;
                } else {
                    break;
                }
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
            Node start = head;
            for (int i=0;i<position;i++){
                if (start.next != null) {
                    start = start.next;
                } else {
                    break;
                }
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
                if (start.next != null) {
                    start = start.next;
                } else {
                    break;
                }
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
            while(start.data != data && start.next != head){
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
            System.out.println("Doubly Circular LinkedList:");
            while (start.next != head){
                System.out.println(start.data);
                start = start.next;
            }
            System.out.println(start.data);
            System.out.println("\n");
        }
    }


}
