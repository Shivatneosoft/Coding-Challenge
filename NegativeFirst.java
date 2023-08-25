import java.util.Arrays;

/*
Given an array of positive and negative integers, segregate them in linear time and constant space. The output should print all negative numbers, followed by all positive numbers.
For example:
Input:  [9, -3, 5, -2, -8, -6, 1, 3]
Output: [-3, -2, -8, -6, 5, 9, 1, 3]
 */
public class NegativeFirst {
    public static void main(String[] args) {
        int[] input = {9, -3, 5, -2, -8, -6, 1, 3};
        solutionUsingWhileLoop(input);
    }

    private static void solutionUsingWhileLoop(int[] input) {
        int swapIndex = 0;
        int negativeSearch = 0;
        int length = input.length;
        while (negativeSearch < length){
            if(input[swapIndex] < 0)
                swapIndex++;
            else {
                if(input[negativeSearch] < 0){
                    input[swapIndex] = input[swapIndex] + input[negativeSearch];
                    input[negativeSearch] = input[swapIndex] - input[negativeSearch];
                    input[swapIndex] = input[swapIndex] - input[negativeSearch];
                }
                negativeSearch++;
            }
        }
        System.out.println(Arrays.toString(input));
    }
}
