package LinkedList;

public class DriverLL {
    public static void testLinkedList(){
        LinkedList linkedList = new LinkedList();
        linkedList.createLinkedList(1);
        linkedList.insertStart(0);
        linkedList.insertEnd(4);
        linkedList.insertAfter(3,1);
        linkedList.insertBefore(2,2);
        linkedList.displayLinkedList();
        linkedList.deleteStart();
        linkedList.displayLinkedList();
        linkedList.deleteEnd();
        linkedList.displayLinkedList();
        linkedList.deleteGivenNode(1);
        linkedList.displayLinkedList();
        linkedList.deleteAfter(0);
        linkedList.displayLinkedList();
        linkedList.insertEnd(10);
        linkedList.insertEnd(11);
        linkedList.insertEnd(12);
        linkedList.displayLinkedList();
        linkedList.deleteBefore(2);
        linkedList.displayLinkedList();
        linkedList.deleteStart();
        linkedList.displayLinkedList();
        linkedList.deleteStart();
        linkedList.displayLinkedList();
        linkedList.deleteStart();
        linkedList.displayLinkedList();
        linkedList.deleteStart();
//        linkedList.displayLinkedList();
    }

    public static void main(String[] args) {
        testLinkedList();
    }
}
