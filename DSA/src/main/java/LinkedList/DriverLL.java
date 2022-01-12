package LinkedList;

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
        linkedList.search(13);
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
        cll.search(13);
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

    public static void testDLL(){
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.createDLL(1);
        dll.insertStart(0);
        dll.insertAfter(3,1);
        dll.insertBefore(2,2);
        dll.insertEnd(4);
        dll.insertEnd(5);
        dll.insertEnd(6);
        dll.insertEnd(7);

        dll.search(3);
        dll.search(5);

        dll.deleteStart();
        dll.deleteEnd();
        dll.deleteAfter(0);
        dll.displayLinkedList();
        dll.deleteBefore(1);
        dll.deleteAtPosition(1);
        dll.deleteAfter(1);
        dll.displayLinkedList();
    }

    public static void testDCLL(){
        DoublyCircularLinkedList dcll = new DoublyCircularLinkedList();
        dcll.createDCLL(1);
        dcll.insertStart(0);
        dcll.insertAfter(3,1);
        dcll.insertBefore(2,2);
//        dcll.insertEnd(4);
//        dcll.insertEnd(5);
//        dcll.insertEnd(6);
//        dcll.insertEnd(7);

        dcll.search(3);
        dcll.search(5);

        dcll.deleteStart();
        dcll.deleteEnd();
        dcll.deleteAfter(0);
        dcll.displayLinkedList();
        dcll.deleteBefore(1);
        dcll.deleteAtPosition(1);
        dcll.deleteAfter(1);
        dcll.displayLinkedList();
    }

    public static void testPQ(){
        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(0,1);
        pq.displayPQ();
        pq.enqueue(0,2);
        pq.displayPQ();
        pq.enqueue(0,3);
        pq.displayPQ();
        pq.enqueue(0,4);
        pq.displayPQ();
        pq.enqueue(0,0);
        pq.displayPQ();
        pq.enqueue(0,2);
        pq.displayPQ();
        pq.enqueue(0,5);
        pq.displayPQ();
    }

    public static void testDQ(){
        DeQue dq = new DeQue();
        dq.enqueue(0);
        dq.enqueue(1);
        dq.enqueue(2);
        dq.enqueue(3);
        dq.enqueue(4);
        dq.dequeueRear();
        dq.dequeueFront();
        dq.dequeueFront();
        dq.dequeueFront();
        dq.dequeueFront();
        dq.showHeadTail();
        dq.displayDQ();
    }
    public static void main(String[] args) {
//        testLinkedList();
//        testCLL();
//        testDLL();
//        testDCLL();
//        testPQ();
        testDQ();
    }
}
