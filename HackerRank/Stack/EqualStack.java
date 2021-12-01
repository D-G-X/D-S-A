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

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
    // Write your code here
    
    Stack<Integer> hs1 = new Stack<Integer>();
    Stack<Integer> hs2 = new Stack<Integer>();
    Stack<Integer> hs3 = new Stack<Integer>();
    
    int hsum1= 0, hsum2=0, hsum3=0;
    
    int minStack;
    
    for(int i = h1.size()-1; i>=0; i--){
        // System.out.println("heyo");
        hs1.push(h1.get(i));
        hsum1 += h1.get(i);
    }
    for(int i = h2.size()-1; i>=0; i--){
        hs2.push(h2.get(i));
        hsum2 += h2.get(i);
    }
    for(int i = h3.size()-1; i>=0; i--){
        hs3.push(h3.get(i));
        hsum3 += h3.get(i);
    }
    
    minStack = Math.min(hsum1,Math.min(hsum2,hsum3));
    
    while(hsum1!=hsum2 || hsum1 != hsum3){
        while(hsum1> minStack){
            hsum1 -= hs1.pop();
        }
        minStack = Math.min(hsum1,Math.min(hsum2,hsum3));
        while(hsum2> minStack){
            hsum2 -= hs2.pop();
        }
        minStack = Math.min(hsum1,Math.min(hsum2,hsum3));
        while(hsum3> minStack){
            hsum3 -= hs3.pop();
        }
        minStack = Math.min(hsum1,Math.min(hsum2,hsum3));
    }
    return minStack;
    
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
