package LinkedList;

public class DeQue {
    Node head=null;
    Node tail= null;
    private class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void createDeQue(int data){
        head = tail = new Node(data);
        System.out.println("Created Deque.");
    }

    public void showHeadTail() {
        if (head != null && tail != null) {
            System.out.println("Head: " + head.data + "\tTail: " + tail.data);
        } else {
            System.out.println("Empty DeQue");
        }
    }

    public void enqueue(int data){
        if (head != null){
            Node newNode = new Node(data);
            newNode.next = null;
            tail.next = newNode;
            tail =newNode;
        } else {
            createDeQue(data);
        }
        System.out.println(data+"\tInserted at End\n");
    }

    public void displayDQ(){
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

    public Node dequeueFront(){
        if (head != null && head.next != null){
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
        return head;
    }

    public Node dequeueRear(){
        if (tail != null && head != tail){
            Node start = head;
            while (start.next != tail){
                start = start.next;
            }
            start.next = null;
            tail = start;
        } else {
            head = null;
            tail = null;
        }
        return tail;
    }


}
