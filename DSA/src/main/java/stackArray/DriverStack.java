package stackArray;

public class DriverStack {

    public static void testStack(){
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.displayArray();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(6);
        System.out.println("top -> "+stack.peek());
        System.out.println("Stack Capacity -> "+stack.getCapacity());
    }

    public static void testReverseStringStack(){
        ReverseStringStack revStrStck = new ReverseStringStack();
        String reverseString = revStrStck.reverseString("Darren");
        System.out.println(reverseString);
    }

    public static void main(String[] args) {
//        testStack();
        testReverseStringStack();
    }
}
