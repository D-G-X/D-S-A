package stackArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InfixToPrefix {
    private StringBuilder prefixExpression = new StringBuilder();
    private List<Character> elementsValid = new ArrayList<Character>();
    Stack<Character> stack = new Stack<>();

    private void initializeValidElements(){
        elementsValid.add('(');
        elementsValid.add(')');
        elementsValid.add('^');
        elementsValid.add('+');
        elementsValid.add('-');
        elementsValid.add('/');
        elementsValid.add('*');
    }

    private boolean checkPrecedenceWithTheTopElementOfTheStack(char element){
        System.out.println("element: "+element+"\t stack Top: "+stack.peek());
        if (element == '^' || element == ')'){
            return true;
        }
        if((element == '*' || element == '/') && (stack.peek() != '^'  && stack.peek() != '*' && stack.peek() != '/')) {
            return true;
        }
        if ((element == '+' || element == '-') && (stack.peek() != '*' && stack.peek() != '/' && stack.peek() != '^' && stack.peek() != '+'&& stack.peek() != '-')){
            System.out.println("stack Top:"+stack.peek());
            return true;
        } else {
            return false;
        }
        // return true if top element is smaller than the element to be pushed
        // return false if the top element is larger than the element to be pushed
    }

    public String infixToPrefix(String infixExpression){
        initializeValidElements();

        StringBuilder editableInfixExpression = new StringBuilder(infixExpression);
        editableInfixExpression.reverse();
        for (int i=0;i<editableInfixExpression.length();i++){
            char element = editableInfixExpression.charAt(i);
            if (Character.isLetterOrDigit(element)){
                prefixExpression.append(element);
            }

            else if (elementsValid.contains(element)){

                if (element == '(') {
                    System.out.println("opening parentheses"+"\tstackTop: "+stack.peek());
                    //pop until opening parenthesis is not encountered in the stack
                    while(stack.peek() != ')'){
                        System.out.println("Until Opening parentheses");
                        prefixExpression.append(stack.pop());
                    }
                    if(stack.peek() == ')'){
                        stack.pop();
                    }
                } else if (stack.empty()){
                    System.out.println("Stack is empty");
                    stack.push(element);
                } else{
                    System.out.println("checking precedence of the element");
                    // push the elements
                    if (checkPrecedenceWithTheTopElementOfTheStack(element)){
                        System.out.println("Pushing with valid precedence");
                        stack.push(element);
                    } else {
                        System.out.println("Popping till valid precedence");
                        while (!stack.empty() && !checkPrecedenceWithTheTopElementOfTheStack(element)){
                            prefixExpression.append(stack.pop());
                        }
                        stack.push(element);
                    }
                    // no elements with lower level should be top of higher level elements
                    // if elements with lower level is top of higher level pop the higher level element
                    // no elements with the same level should be together in the stack
                    // if the elements are of the same level pop the existing element of the stack and push the new
//                                element in the stack
                }

            }
        }
        while (!stack.empty()){
            System.out.println("Popping remaining elements"+"\tStacktop:"+stack.peek());
            prefixExpression.append(stack.pop());
        }

        prefixExpression.reverse();
        return prefixExpression.toString();
    }

}
