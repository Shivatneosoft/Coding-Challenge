import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] input = {4,9,3,5,2,5,1};
        solutionUsingRecurrsion(input);
    }

    private static void solutionUsingRecurrsion(int[] input) {
        int[] output = splitAndMerge(input);
        System.out.println(Arrays.toString(output));
    }

    private static int[] splitAndMerge(int[] input) {
        int length = input.length;
        if(length == 1)
            return input;
        int[] left = splitAndMerge(Arrays.copyOfRange(input, 0, length / 2));
        int[] right = splitAndMerge(Arrays.copyOfRange(input, length / 2, input.length));
        int[] tempInput = new int[length];
        int leftPointer = 0,rightPointer = 0;
        for (int i = 0; i < length; i++) {
            if(leftPointer < left.length && rightPointer < right.length){
                if(left[leftPointer] > right[rightPointer]){
                    tempInput[i] = right[rightPointer];
                    rightPointer++;
                }
                else {
                    tempInput[i] = left[leftPointer];
                    leftPointer++;
                }
            }
            else{
                if(leftPointer == left.length){
                    tempInput[i] = right[rightPointer];
                    rightPointer++;
                }
                else{
                    tempInput[i] = left[leftPointer];
                    leftPointer++;
                }
            }
        }
        return tempInput;
    }
}
