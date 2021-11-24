package stackArray;

import java.util.ArrayList;
import java.util.List;

public class InfixToPostfix {
    private char[] infixExpressionCharArray;
    private StringBuilder postfixExpression = new StringBuilder();
    private char[] stack;
    private int top = -1;
    private int stackCapacity;
    private List<Character> elementsValid = new ArrayList<Character>();

    private void initializeValidElements(){
        elementsValid.add('(');
        elementsValid.add(')');
        elementsValid.add('^');
        elementsValid.add('+');
        elementsValid.add('-');
        elementsValid.add('/');
        elementsValid.add('*');
    }
/*
* elements that stack takes in: (, ), +, -, *, /, ^
*
* test expresssion: a+b*(c^d-e)^(f+g*h)-i   test output: abcd^e-fgh*+^*+i-
* */

    private boolean checkPrecedenceWithTheTopElementOfTheStack(char element){
        if (element == '^' || element == '('){
            return true;
        }
        if((element == '*' || element == '/') && (stack[top] != '^')) {
            return true;
        }
        if ((element == '+' || element == '-') && (stack[top] != '*' || stack[top] != '/' || stack[top] != '^')){
            System.out.println("element: "+element+"\t stack Top: "+stack[top]);
            return true;
        } else {
            return false;
        }
        // return true if top element is smaller than the element to be pushed
        // return false if the top element is larger than the element to be pushed
    }

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
            System.out.println("Pushed: "+stack[top]+"\tpostfix Expression: "+postfixExpression.toString());
        }
    }

    public char pop(){
        if(!isEmpty()){
            System.out.println("Popped: "+stack[top]+"\tpostfix Expression: "+postfixExpression.toString());
            return stack[top--];
        }
        return 0;
    }
    public String infixToPostfix(String infixExpression){
        initializeValidElements();
        infixExpression.replaceAll(" ","");
        infixExpressionCharArray = infixExpression.toCharArray();
        stackCapacity = infixExpression.length();
        stack = new char[stackCapacity];
        for(char element: infixExpressionCharArray){

            if (Character.isLetterOrDigit(element)){
                postfixExpression.append(element);
            }

            else if (elementsValid.contains(element)){

                if (element == ')') {
                    System.out.println("closing parentheses");
                    //pop until opening parenthesis is not encountered in the stack
                    while(stack[top] != '('){
                        System.out.println("Until Opening parentheses");
                        postfixExpression.append(pop());
                    }
                } else if (isEmpty()){
                    System.out.println("Stack is empty");
                    push(element);
                } else{
                    System.out.println("checking precedence of the element");
                    // push the elements
                    if (checkPrecedenceWithTheTopElementOfTheStack(element)){
                        System.out.println("Pushing with valid precedence");
                        push(element);
                    } else {
                        System.out.println("Popping till valid precedence");
                        while (!checkPrecedenceWithTheTopElementOfTheStack(element)){
                            postfixExpression.append(pop());
                        }
                    }
                        // no elements with lower level should be top of higher level elements
                            // if elements with lower level is top of higher level pop the higher level element
                        // no elements with the same level should be together in the stack
                            // if the elements are of the same level pop the existing element of the stack and push the new
//                                element in the stack
                }

            }
        }
        while (top != -1){
            System.out.println("Popping remaining elements");
            postfixExpression.append(pop());
        }
        return postfixExpression.toString();
    }
}

/*
*  ^ >>>>>>>>>> *,/
*
* */
