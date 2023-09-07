import java.util.Arrays;

/*
Given an array Arr of N positive integers and another number X. Determine whether or not there exist two elements in Arr whose sum is exactly X.

Example 1:
Input:
N = 6, X = 16
Arr[] = {1, 4, 45, 6, 10, 8}
Output: Yes
Explanation: Arr[3] + Arr[4] = 6 + 10 = 16

Example 2:
Input:
N = 5, X = 10
Arr[] = {1, 2, 4, 3, 6}
Output: Yes
Explanation: Arr[2] + Arr[4] = 4 + 6 = 10
 */
public class TwoSum {
    public static void main(String[] args) {
//        int arr[] = {1, 4, 45, 6, 10, 8};
//        int target = 16;
        int arr[] = {1, 2, 4, 3, 6};
        int target = 10;
//        solutionUsingCombination(arr,target);
        Arrays.sort(arr);
        solutionIfArrayWasSorted(arr,target);
    }

    private static void solutionIfArrayWasSorted(int[] arr, int target) {
        boolean exist = false;
        int i = 0, j = arr.length-1;
        while(i != j){
            int sum = arr[i] + arr[j];
            if(sum == target){
                exist = true;
                break;
            }
            else if(sum > target)
                j--;
            else
                i++;
        }
        if(exist)
            System.out.println("yes");
        else
            System.out.println("no");
    }

    private static void solutionUsingCombination(int[] arr, int target) {
        Boolean exist = false;
        for (int i = 0; i < arr.length-1; i++)
            for (int j = i+1; j < arr.length; j++)
                if(arr[i] + arr[j] == target) {
                    exist = true;
                    break;
                }
        if(exist)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
