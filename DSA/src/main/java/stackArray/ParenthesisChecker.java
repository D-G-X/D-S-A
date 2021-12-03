package stackArray;

import java.util.ArrayList;
import java.util.List;

public class ParenthesisChecker {
    private static char[] stack;
    private static int stackCapacity;
    private static int top = -1;
    private static char[] expressionCharArray;
    private static List<Character> openingParenthesis = new ArrayList<Character>();
    private static List<Character> closingParenthesis = new ArrayList<Character>();

    private static void initializeValidParenthesis(){
        openingParenthesis.add('(');
        openingParenthesis.add('{');
        openingParenthesis.add('[');

        closingParenthesis.add(']');
        closingParenthesis.add(')');
        closingParenthesis.add('}');
    }

    private static boolean isFull(){
        return top == stackCapacity-1;
    }

    private static boolean isEmpty(){
        return top == -1;
    }

    public static void push(char element){
        if (!isFull()){
            top++;
            stack[top] = element;
            System.out.println("Pushed: "+stack[top]);
        }
    }

    public static char pop() {
        if (!isEmpty()) {
            System.out.println("Popped: " + stack[top]);
            return stack[top--];
        } else {
            System.out.println("Stack is empty");
            return 0;
        }
    }

    public static boolean isOpeningParenthesis(char element){
        if (openingParenthesis.contains(element)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean isClosingParenthesis(char element){
        if (closingParenthesis.contains(element)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean parenthesisChecker(String expression){
        initializeValidParenthesis();
        expressionCharArray = expression.toCharArray();
        stackCapacity = expressionCharArray.length;
        stack = new char[stackCapacity];

        for (char element : expressionCharArray){
            if (isOpeningParenthesis(element)){
                push(element);
            } else if (isClosingParenthesis(element)){
                char poppedElement = pop();
                if (element==')' && poppedElement != '('){
                    return false;
                } else if (element =='}' && poppedElement != '{'){
                    return false;
                } else if (element ==']' && poppedElement != '['){
                    return false;
                }
            }
        }

        if (!isEmpty()){
            return false;
        } else {
            return true;
        }
    }

}
