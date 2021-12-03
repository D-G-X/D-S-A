package queueArray;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private int rear,front;
    private final int MAX;
    private List<Integer> queue_Array = new ArrayList<Integer>();

    public Queue(int max){
        MAX = max;
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
                System.out.println("\n"+queue_Array.remove(front)+"\t deQueued. " +
                        "\nfront: "+front+"\t rear: "+rear+"\n");
                System.out.println("reset");
                front = -1;
                rear = -1;
            } else {
                int removed_element = queue_Array.remove(front);
                rear--;
                System.out.println("\n"+removed_element+"\t deQueued. " +
                        "\nfront: "+front+"\t rear: "+rear+"\n");
//                display();
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

}
