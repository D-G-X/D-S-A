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
    }
    public static void testCLL(){
        CircularLinkedList cll = new CircularLinkedList();
        cll.createCLL(1);
        cll.insertStart(0);
        cll.insertEnd(4);
        cll.insertAfter(2,1);
        cll.insertBefore(3,3);
        cll.displayLinkedList();
        cll.deleteStart();
        cll.displayLinkedList();
        cll.deleteEnd();
        cll.displayLinkedList();
        cll.deleteGivenNode(2);
        cll.displayLinkedList();
        cll.insertEnd(10);
        cll.insertEnd(11);
        cll.insertEnd(12);
        cll.displayLinkedList();
        cll.deleteAfter(1);
        cll.displayLinkedList();
        cll.deleteBefore(1);
        cll.displayLinkedList();
        cll.deleteBefore(1);
        cll.displayLinkedList();
        cll.deleteEnd();
        cll.displayLinkedList();
        cll.deleteEnd();
        cll.displayLinkedList();
    }
    public static void main(String[] args) {
//        testLinkedList();
        testCLL();
    }
}
