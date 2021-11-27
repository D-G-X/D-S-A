import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    private static List<Integer> stack = new ArrayList<Integer>();
    private static int           top   = -1;
    private static int           stackCapacity;
    private static int           maxValue;
    /*
     * Complete the 'getMax' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY operations as parameter.
     */
     
    private static void setMaxElementPush(int value){
        if(top == 0){
            maxValue = value;
        } else if (maxValue<value){
            maxValue = value;
        }
    }
    
    private static void setMaxElementPop(){
        if(!isEmpty()){
        maxValue = Collections.max(stack);
        }
    }
    
    private static boolean isFull(){
        return top == stackCapacity -1;
    }
    
    private static boolean isEmpty(){
        return top == -1;
    }
    
    private static void push(int value){
        if(!isFull()){
            System.out.println("Pushed: "+value);
            top++;
            stack.add(value);
            setMaxElementPush(value);
        }
    }
    
    private static void pop(){
        // System.out.println("Pop");
        if(!isEmpty()){
            System.out.println("Popped: "+stack.get(top));
            stack.remove(top);
            top--;
            setMaxElementPop();
        }
    }
    
    private static void printMax(BufferedWriter bufferedWriter){
        if(!isEmpty()){
            System.out.println(maxValue);
            try{
            bufferedWriter.write(
            maxValue+ "\n"
        );} catch (Exception e){
            System.out.println(e);
        }
        }
    }

    public static List<Integer> getMax(List<String> operations, BufferedWriter bufferedWriter) {
    // Write your code here
    stackCapacity = operations.size();
    for (String operation: operations){       
        if(operation.charAt(0) == '1'){
            String[] operationValuePair = operation.split(" ");
            push(Integer.parseInt(operationValuePair[1]));            
        }else if (operation.charAt(0) == '2'){
            pop();
        }else if(operation.charAt(0) == '3'){
            printMax(bufferedWriter);
        }
    }
    return stack;  
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> ops = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<Integer> res = Result.getMax(ops, bufferedWriter);

        

        bufferedReader.close();
        bufferedWriter.close();
    }
}
