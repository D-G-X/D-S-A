package stackArray;

import java.util.Scanner;

public class Stack {
    // top, max size, array[];
    private int top;
    private int capacity;
    private int[] array;
    private Scanner sc = new Scanner(System.in);

    public int getTop() {
        return top;
    }

    public int getCapacity() {
        return capacity;
    }

    public Stack(int capacity){
        top = -1;
//        System.out.println("Enter the max Capacity of the stack:");
//        capacity = Integer.parseInt(sc.nextLine());
        this.capacity = capacity;
        array = new int[capacity];
    }

    public void push(int value){
        if (!isFull()){
            top++;
            array[top] = value;
            System.out.println(array[top]+"pushed\n");
        } else {
            System.out.println("Stack is full");
        }
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        } else {
            System.out.println(array[top]+"popped\n");
            return array[top--];
        }
    }

    public boolean isFull(){
        return  top == capacity-1;
    }

    public  boolean isEmpty(){
        return top == -1;
    }

    public int peek(){
        if (!isEmpty()) {
            return array[top];
        } else {
            return -1;
        }
    }

    public void displayArray(){
        if (!isEmpty()){
            for (int element: array){
                System.out.println("|\t"+element+"\t|\t");
            }
//            for (int i=0;i<=top;i++){
//                System.out.println(array[i]);
//            }
        }
    }
}
