import java.util.Arrays;

/*
Given an array arr[] and an integer K where K is smaller than size of
array, the task is to find the Kth smallest element in the given array.
It is given that all array elements are distinct.

Note :-  l and r denotes the starting and ending index of the array.

Example 1:
Input:N = 6, arr[] = 7 10 4 3 20 15, K = 3
Output : 7
Explanation :3rd smallest element in the given array is 7.

Example 2:
Input: N = 5, arr[] = 7 10 4 20 15, K = 4
Output : 15
Explanation :4th smallest element in the given array is 15.
 */
public class NthElementAfterSort {
    public static void main(String[] args) {
//        int arr[] = {7, 10, 4, 20, 15}, k = 4;
        int arr[] = {7, 10, 4, 3, 20, 15}, k = 3;
        solutionUsingRecursion(arr,k);
        solutionUsingWhileLoop(arr,k);
        solutionUsingWhileLoopPointer(arr,k);
        //Did same thing in all three above method, just broke down the steps
    }

    private static void solutionUsingWhileLoopPointer(int[] arr, int targetIndex) {
        int minimum = 0;
        int i = 0;
        int tempVariable = Integer.MAX_VALUE;
        while (targetIndex > 0){
            if(i == arr.length){
                minimum = tempVariable;
                tempVariable = Integer.MAX_VALUE;
                targetIndex--;
                i = 0;
            }
            else {
                if (tempVariable > arr[i] && arr[i] > minimum) {
                    tempVariable = arr[i];
                }
                i++;
            }
        }
        System.out.println(minimum);
    }

    private static void solutionUsingWhileLoop(int[] arr, int targetIndex) {
        int minimum = 0;
        while (targetIndex > 0){
            int tempVariable = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++)
                if(tempVariable > arr[i] && arr[i] > minimum)
                    tempVariable = arr[i];
            minimum = tempVariable;
            targetIndex--;
        }
        System.out.println(minimum);
    }

    private static void solutionUsingRecursion(int[] arr, int targetIndex) {
        Integer output = findMinOnIndex(arr, targetIndex, 0);
        System.out.println(output);
    }

    private static Integer findMinOnIndex(int[] arr, int targetIndex, int minValueIndex) {
        if(targetIndex == 0)
            return minValueIndex;

        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
            if(minimum > arr[i] && arr[i] > minValueIndex)
                minimum = arr[i];

        return findMinOnIndex(arr,--targetIndex,minimum);
    }
}
