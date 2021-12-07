package queueArray;

public class Deque {
    private int[] deque;
    private int MAX;
    private int front, rear;

    public Deque(int max){
        this.MAX = max;
        deque = new int[MAX];
        front = rear = -1;
    }

    public boolean isFull(){
        return (front == 0 && rear == MAX-1 || front == rear+1);
    }

    public boolean isEmpty(){
        return (front == -1);
    }

    public void insertFront(int value){
        if (!isFull()){
            System.out.println("Inserting: front: "+front+"\trear: "+ rear);
            if (front<1){
                front = MAX -1;
            } else {
                front--;
            }
            deque[front] = value;
            System.out.println("Inserted Front: "+ deque[front]+"\tfront: "+front+"\trear: "+ rear);
        } else {
            System.out.println("Full Deque");
        }
    }

    public void insertRear(int value){
        if (!isFull()){
            System.out.println("Inserting: front: "+front+"\trear: "+ rear);
            if (rear >= MAX -1){
                rear = 0;
            } else {
                rear++;
            }
            deque[rear] = value;
            System.out.println("Inserted Rear: "+ deque[rear]);
        } else {
            System.out.println("Full Deque");
        }
    }

    public void deleteFront(){
        if (!isEmpty()){
            int temp = deque[front];
            System.out.println("Deleting: "+temp+"\tfront: "+front+"\trear: "+ rear);
            if (front == rear){
                front = -1;
                rear = -1;
                System.out.println("reset.");
            } else if (front == MAX -1){
                front = 0;
            } else {
                front++;
            }
        } else {
            System.out.println("Empty Deque");
        }
    }

    public void deleteRear(){
        if (!isEmpty()){
            int temp = deque[rear];
            System.out.println("Deleting: "+temp+"\tfront: "+front+"\trear: "+ rear);
            if (front == rear){
                rear = front = -1;
                System.out.println("reset.");
            } else if (rear == 0){
                rear = MAX -1;
            }else {
                rear--;
            }
        } else {
            System.out.println("Empty Deque");
        }
    }
    public int[] getDeque() {
        return deque;
    }
}
