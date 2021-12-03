package queueArray;

public class DriverQueue {
    public static void testQueue(){
        Queue queue1 = new Queue(10);
        queue1.enQueue(1);
        queue1.enQueue(2);
        queue1.enQueue(3);
        queue1.enQueue(4);
        queue1.enQueue(5);
        queue1.enQueue(6);
        queue1.enQueue(7);
        queue1.enQueue(8);
        queue1.enQueue(9);
        queue1.enQueue(10);

        queue1.display();
        System.out.println(queue1.isFull());
        System.out.println(queue1.isEmpty());

        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();

        queue1.display();

        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.deQueue();
        queue1.display();

        queue1.enQueue(1);
        queue1.enQueue(2);
        queue1.enQueue(3);
        queue1.enQueue(4);
        queue1.enQueue(5);
        queue1.enQueue(6);

        queue1.display();
    }

    public static void main(String[] args){
        testQueue();
    }
}
