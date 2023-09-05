import java.util.Arrays;

/*
Given an array arr[] of positive integers of size N. Reverse every sub-array group of size K.

Note: If at any instance, there are no more subarrays of size greater than or equal to K, then reverse the last subarray (irrespective of its size). You shouldn't return any array, modify the given array in-place.

Example 1:
Input:N = 5, K = 3
arr[] = {1,2,3,4,5}
Output: 3 2 1 5 4
Explanation: First group consists of elements
1, 2, 3. Second group consists of 4,5.

Example 2:
Input:N = 4, K = 3
arr[] = {5,6,8,9}
Output: 8 6 5 9

Example 3:
Input:N = 10, K = 3
arr[] = {1,2,3,4,5,6,7,8,9,10}
Output: 3 2 1 6 5 4 9 8 7 10
Explanation: First group consists of elements
1, 2, 3. Second group consists of 4,5,6. Third Group consist of 7,8,9 and the last group had only 10.
 */
public class ReverseSetOfArray {
    public static void main(String[] args) {
        int n = 11;
        int k = 3;
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//        solutionUsingWhileLoop(n, k, arr);
        solutionUsingForLoop(n, k, arr);
    }

    private static void solutionUsingForLoop(int n, int k, int[] arr) {
        int startIndex = 0;
        for (int i = 0; i < n/k; i++) {
            for (int j = 0; j < (k)/2; j++){
                swap(arr,startIndex + j,startIndex + k - j -1);
            }
            startIndex = startIndex + k;
        }
        for (int j = 0; j < (arr.length - startIndex)/2; j++){
            swap(arr,startIndex + j, arr.length - j -1);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void solutionUsingWhileLoop(int n, int k, int[] arr) {
        int currentLenght = 0;
        int output[] = new int[arr.length];
        while (currentLenght < n) {
            currentLenght = currentLenght + k;
            if (currentLenght < n)
                saveInOutput(output,reverseArray(Arrays.copyOfRange(arr, currentLenght - k, currentLenght)),currentLenght-k);
            else
                saveInOutput(output,reverseArray(Arrays.copyOfRange(arr, currentLenght - k, arr.length)),currentLenght-k);
        }
        System.out.println(Arrays.toString(output));
    }

    private static void saveInOutput(int[] output, int[] reverseArray, int startIndex) {
        for (int i = 0; i < reverseArray.length; i++) {
            output[startIndex] = reverseArray[i];
            startIndex++;
        }
    }


    private static int[] reverseArray(int[] subArray) {
        int length = subArray.length;
        for (int i = 0; i < length / 2; i++) {
            swap(subArray, i, length - 1 - i);
        }
        return subArray;
    }

    private static void swap(int[] subArray, int first, int second) {
        subArray[first] = subArray[first] + subArray[second];
        subArray[second] = subArray[first] - subArray[second];
        subArray[first] = subArray[first] - subArray[second];
    }
}
