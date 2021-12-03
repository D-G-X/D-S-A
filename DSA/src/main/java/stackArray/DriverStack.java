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

    public static void testInfixToPostfixStack(){
        InfixToPostfix infixPostfix = new InfixToPostfix();
        System.out.println(infixPostfix.infixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
    }
    public static void testInfixToPrefixStack(){
        InfixToPrefix infixToPrefix = new InfixToPrefix();
        System.out.println(infixToPrefix.infixToPrefix("a+b*(c^d-e)^(f+g*h)-i"));
//        System.out.println(infixPostfix.infixToPretfix("a+b*(c^d-e)^(f+g*h)-i"));
    }

    public static void testParenthesisChecker(){
        System.out.println(ParenthesisChecker.parenthesisChecker("[()]{}{[()()]()}"));
        System.out.println(ParenthesisChecker.parenthesisChecker("{{[[(())]]}}"));

    }

    public static void testPostfixEvaluation(){
        PostfixEvaluation postEval = new PostfixEvaluation();
//        System.out.println("\nFinal Answer:\t"+postEval.postfixEval("231*+9-"));
        System.out.println("\nPrefix Eval\nFinal Answer:\t"+ postEval.prefixEval("+9*26"));
//        System.out.println(postEval.postfixEval("34^"));
    }

    public static void main(String[] args) {
//        testStack();
//        testReverseStringStack();
//        testInfixToPostfixStack();
//        testInfixToPrefixStack();
        testPostfixEvaluation();
//        testParenthesisChecker();
    }

}
