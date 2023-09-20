import java.util.Arrays;

/*
Given an array arr[] of size N, check if it can be partitioned into two parts
such that the sum of elements in both parts is the same.
Example 1:
Input: N = 4, arr = {1, 5, 11, 5}
Output: YES
Explanation:
The two parts are {1, 5, 5} and {11}.
Example 2:
Input: N = 3, arr = {1, 3, 5}
Output: NO
Explanation: This array can never be
partitioned into two such parts.
 */
public class TwoPartSum {
    public static void main(String[] args) {
//        int lenght = 4, input[] = {1, 5, 11, 5};
        int lenght = 8, input[] = {1,2,2,3,11};
//        int lenght = 8, input[] = {9,5,6,4,6,2,7, 5,20};
//        solutionUsingRecursion(input.length,input);
        solutionUsingTwoArray(input.length, input);
    }

    private static void solutionUsingTwoArray(int lenght, int[] input) {

        if(sumOf(input) % 2 == 1){
            System.out.println("No");
            return;
        }

        for (int i = 0; i < lenght - 1; i++)
            for (int j = i+1; j < lenght; j++)
                if(input[i] > input[j])
                    swap(input,i,j);

        int[] leftArray = new int[lenght-1];
        for (int i = 0; i < lenght-1; i++) {
            leftArray[i] = input[i];
        }
        int[] rightArray = {input[lenght-1]};

        int rightSum = sumOf(rightArray);
        int leftSum = sumOf(leftArray);

        while (rightSum < leftSum){
            int difference = leftSum - rightSum;
            int indexElement = findSameOrlessThan(leftArray,difference/2);
            if(indexElement == -1)
                break;
            rightArray = addElement(rightArray,leftArray[indexElement]);
            leftArray = removeElement(leftArray,indexElement);
            rightSum = sumOf(rightArray);
            leftSum = sumOf(leftArray);
        }

        if(rightSum == leftSum) {
            System.out.println(Arrays.toString(rightArray));
            System.out.println("yes");
        }
        else
            System.out.println("no");
    }

    private static int[] removeElement(int[] array, int targetIndex) {
        int[] tempArray = new int[array.length-1];
        int tempArrayIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(i != targetIndex){
                tempArray[tempArrayIndex] = array[i];
                tempArrayIndex++;
            }
        }
        return tempArray;
    }

    private static int[] addElement(int[] array, int element) {
        int[] tempArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        tempArray[array.length] = element;
        return tempArray;
    }

    private static int findSameOrlessThan(int[] array, int target) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if(array[i] <= target)
                index = i;
        }
        return index;
    }

    private static int sumOf(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total = total + array[i];
        }
        return total;
    }

    private static void swap(int[] input, int i, int j) {
        input[i] = input[i] + input[j];
        input[j] = input[i] - input[j];
        input[i] = input[i] - input[j];
    }

    private static void solutionUsingRecursion(int lenght, int[] input) {
        Boolean outputBoolean = false;
        int total = sumOf(input);
        if(total % 2 == 1)
            System.out.println("No");
        else if(checkIfCombinationSumExist(input,total/2, new int[0], 0))
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private static Boolean checkIfCombinationSumExist(int[] input, int target, int[] output, int currentIndex) {
        int total = sumOf(output);
        if(total == target)
            return true;
        if(currentIndex == input.length+1)
            return false;

        int[] tempOutput = addElement(output,0);

        Boolean outputBoolean = false;

        for (int i = currentIndex; i < input.length; i++) {
            tempOutput[tempOutput.length-1] = input[i];
            if(checkIfCombinationSumExist(input,target,tempOutput,i+1)){
                outputBoolean = true;
                break;
            }
        }
        return outputBoolean ;
    }
}
