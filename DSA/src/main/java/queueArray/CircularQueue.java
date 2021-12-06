package queueArray;

public class CircularQueue {
    private int[] queue;
    private int MAX;
    private int front = -1, rear = -1;

    public CircularQueue(int MAX){
        this.MAX = MAX;
        queue = new int[MAX];
    }

    public boolean isEmpty(){
        if (front == -1 && rear == -1){
            System.out.println("The queue is empty. :)");
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if (rear == MAX -1 && front == 0){
            System.out.println("Queue is Full. :(");
            return true;
        } return false;
    }


    public void enQueue(int value){
        if (!isFull()){
            if (isEmpty()){
                front++;
            }
            rear++;
            queue[rear]=value;
            System.out.println("Enqueued: "+queue[rear]+" "+value);
        } else if (rear == MAX - 1 && front != 0){
            rear = 0;
            queue[rear] = value;
            System.out.println("Enqueued: "+queue[rear]+" "+value);
        }
    }

    public void display(){
        if (!isEmpty()){
            for(int i = front; i<=rear;i++){
                System.out.println(queue[i]);
            }
        }
    }


    public void deQueue(){
        if (!isEmpty()){
            System.out.println("front:"+front+"\trear: "+rear);
            int temp = queue[front];
            if (rear == front){
                System.out.println("if rear == front"+rear+" "+front);
                rear = -1;
                front = -1;
            } else {
                front++;
            }
            System.out.println("Dequeued: "+temp);
        }
    }
}
