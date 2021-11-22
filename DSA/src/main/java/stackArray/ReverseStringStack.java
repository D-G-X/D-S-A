package stackArray;

public class ReverseStringStack {
    private int top = -1;
    private char[] stack;
    char[] originalStringCharArray;
    private int stackCapacity;
    private StringBuilder reverseString = new StringBuilder();

    private boolean isFull(){
        return top == stackCapacity-1;
    }

    private boolean isEmpty(){
        return top == -1;
    }

    public void push(char element){
        if (!isFull()){
            top++;
            stack[top] = element;
            System.out.println("Pushed: "+stack[top]);
        }
    }

    public char pop(){
        if(!isEmpty()){
            System.out.println("Popped: "+stack[top]);
            return stack[top--];
        }
        return 0;
    }

    public String reverseString(String originalString){
        originalStringCharArray = originalString.toCharArray();
        stackCapacity = originalStringCharArray.length;
        stack = new char[stackCapacity];

        for (char element: originalStringCharArray){
            push(element);
        }

        while (!isEmpty()){
            reverseString.append(pop());
        }

        return reverseString.toString();
    }
}
