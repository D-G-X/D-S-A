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
    private static List<Integer> hourGlassValues = new ArrayList<Integer>();
    /*
     * Complete the 'hourglassSum' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int hourglassSum(List<List<Integer>> arr) {
        int sumOfTopLayer, sumOfMiddleLayer, sumOfBottomLayer;
        for(int j =0;j<4;j++){
        for(int i=0; i<4;i++){
            sumOfTopLayer = arr.get(j).get(i) + arr.get(j).get(i+1) + arr.get(j).get(i+2);
            sumOfMiddleLayer = arr.get(j+1).get(i+1);
            sumOfBottomLayer = arr.get(j+2).get(i) + arr.get(j+2).get(i+1) + arr.get(j+2).get(i+2);
            
            hourGlassValues.add(sumOfTopLayer+sumOfBottomLayer+sumOfMiddleLayer);
        }
        }
        for(int x: hourGlassValues){
        System.out.println(x);
    }
    
    return Collections.max(hourGlassValues);
    }
    
    

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
