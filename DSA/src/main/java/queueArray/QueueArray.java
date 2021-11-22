package queueArray;

import java.util.ArrayList;

public class QueueArray {
    private int rear,front;
    private final int MAX = 10;
    private ArrayList<Integer> queue_Array = new ArrayList<>();

    public QueueArray(){
        front = -1;
        rear = -1;
    }

    //enqueue, dequeue, display, isEmpty, isFull
    public boolean isFull(){
        if( front == 0 && rear == MAX-1){
            return true;
        } else{ return false;}
    }

    public boolean isEmpty(){
        if (front == -1){
            return true;
        }else{ return false; }
    }

    public void enQueue(int value){
        if (isFull()){
            System.out.println("The Queue is full.\n");
        } else{
            queue_Array.add(value);
            rear++;
            if (front == -1) {
                front++;
            }
            System.out.println("\n"+value+"\t enQueued. " +
                    "\nfront: "+front+"\t rear: "+rear+"\n");
        }
    }

    public void deQueue(){
        if (isEmpty()){
            System.out.println("The Queue is Empty.\n");
        } else {
            if (front>=rear){
                front = -1;
                rear = -1;
            } else {
                int removed_element = queue_Array.get(front);
                queue_Array.remove(front);
                front++;
                System.out.println("\n"+removed_element+"\t deQueued. " +
                        "\nfront: "+front+"\t rear: "+rear+"\n");
            }
        }
    }

    public void display(){
        if (isEmpty()){
            System.out.println("The Queue is Empty.\n");
        } else {
            for(int i:queue_Array){
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args){
        QueueArray queue1 = new QueueArray();
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
    }

}
