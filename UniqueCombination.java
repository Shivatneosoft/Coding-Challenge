import java.util.Arrays;
import java.util.stream.IntStream;

/*
Given an integer array, find all distinct combinations of a given length k, where the repetition of elements is allowed.
For example,
Input:  {1, 2, 3}, k = 2
Output: {1, 1}, {1, 2}, {1, 3}, {2, 2}, {2, 3}, {3, 3}

Input:  {1, 2, 3, 4}, k = 2
Output: {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 2}, {2, 3}, {2, 4}, {3, 3}, {3, 4}, {4, 4}

Input:  {1, 2, 1}, k = 2
Output: {1, 1}, {1, 2}, {2, 2}
 */
public class UniqueCombination {
    public static void main(String[] args) {
        int input[] = {1, 2, 1};
        int targetSize = 2;
        solutionUsingRecussion(input,targetSize);
    }

    private static void solutionUsingRecussion(int[] input, int targetSize) {
        int[] sortedUniqueArray = Arrays.stream(input).sorted().distinct().toArray();
        printingCombination(sortedUniqueArray,targetSize,new int[0]);
    }

    private static void printingCombination(int[] input, int targetSize, int[] result) {
        if(targetSize == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        int[] tempResult = Arrays.copyOf(result,result.length+1);
        for (int i = 0; i < input.length; i++) {
            if (result.length >0 && tempResult[result.length-1] <= input[i]) {
                tempResult[result.length] = input[i];
                printingCombination(input, targetSize, tempResult);
            }
            if(result.length == 0) {
                tempResult[result.length] = input[i];
                printingCombination(input,targetSize,tempResult);
            }
        }
    }
}
