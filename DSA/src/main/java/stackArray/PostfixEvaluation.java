package stackArray;

import java.util.ArrayList;
import java.util.List;

public class PostfixEvaluation {
    private int[] stack;
    private int top = -1;
    private int stackCapacity;
    private char[] postfixExpressionCharArray;
    private List<Character> elementsValid = new ArrayList<Character>();

    private void initializeValidElements(){
        elementsValid.add('^');
        elementsValid.add('+');
        elementsValid.add('-');
        elementsValid.add('/');
        elementsValid.add('*');
    }

    private boolean isFull(){
        return top == stackCapacity-1;
    }

    private boolean isEmpty(){
        return top == -1;
    }

    public void push(int element){
        if (!isFull()){
            top++;
            stack[top] = element;
            System.out.println("Pushed: "+stack[top]+"\n");
        }
    }

    public int pop(){
        if(!isEmpty()){
            System.out.println("Popped: "+stack[top]);
            return stack[top--];
        }
        return 0;
    }

    public double postfixEval(String postfixExpression){
        System.out.println("PostFix Expression:\t"+postfixExpression);
        postfixExpression.replaceAll(" ","");
//        System.out.println(postfixExpression);
        postfixExpressionCharArray = postfixExpression.toCharArray();
        stackCapacity = postfixExpressionCharArray.length;
        stack = new int[stackCapacity];

        for (char element:postfixExpressionCharArray){
//            System.out.println(element);
            if (Character.isDigit(element)){
                System.out.println("\nDIGIT: "+element);
                push(Integer.parseInt(String.valueOf(element)));
            } else{
                System.out.println("Operators: "+element);
                int num1 = pop(), num2 = pop();
                if (element == '+'){
                    push(num1 + num2);
                } else if (element == '-'){
                    push(num2 - num1);
                } else if (element == '*'){
                    push(num1 * num2);
                } else if (element == '/'){
                    push(num1 / num2);
                } else if (element == '^'){
                    push((int)Math.pow(num2,num1));
                }
//                System.out.println("Stack Elements:");
//                for (int x:stack){
//                    System.out.print("|\t"+x+"|\t"+(5-9));
//                }
//                System.out.println("\nTOP value:"+top+"\n");
            }
        }
        return stack[top];
    }
}
