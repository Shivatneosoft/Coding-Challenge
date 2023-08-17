import java.util.Arrays;

/*
Given an integer array having distinct elements, find the surpasser count for each element in it. In other words, for each array element, find the total number of elements to its right, which are greater than it.
For example:
Input:  { 4, 6, 3, 9, 7, 10 }

Output: { 4, 3, 3, 1, 1, 0 }
 */
public class CountingLargestRight {
    public static void main(String[] args) {
        int[] input = { 4, 6, 3, 9, 7, 10 };
        solutionUsingTwoForLoop(input);
    }

    private static void solutionUsingTwoForLoop(int[] input) {
        for (int i = 0; i < input.length; i++) {
            int count = 0;
            for (int j = i+1; j < input.length; j++) {
                if(input[i] < input[j])
                    count++;
            }
            input[i] = count;
        }
        System.out.println(Arrays.toString(input));
    }
}
