import java.util.Arrays;

/*
Given an integer array, determine whether it can be divided into pairs such that the sum of elements in each pair is divisible by a given positive integer k.
For Example
Input:
arr[] = { 3, 1, 2, 6, 9, 4 }
k = 5

Output: Pairs can be formed

Explanation: Array can be divided into pairs {(3, 2), (1, 9), (4, 6)} where the sum of elements in each pair is divisible by 5.


Input:
arr[] = { 2, 9, 4, 1, 3, 5 }
k = 6

Output: Pairs can be formed

Explanation: Array can be divided into pairs {(2, 4), (9, 3), (1, 5)} where the sum of elements in each pair is divisible by 6.


Input:
arr[] = { 3, 1, 2, 6, 9, 4 }
k = 6

Output: Pairs cannot be formed

Explanation: Array cannot be divided into pairs where the sum of elements in each pair is divisible by 6.

 */
public class DivisiblePair {
    public static void main(String[] args) {
//        int arr[] = { 3, 1, 2, 6, 9, 4 };
        int arr[] = { 2, 9, 4, 1, 3, 5 ,10};
        int target = 6;
        solution(arr,target);
    }

    private static void solution(int[] arr, int target) {
        int[] tempArr = Arrays.copyOf(arr,arr.length);
        int firstPointer = 0;
        int secondPointer = 1;
        while (arr.length != 0){
            if(secondPointer == arr.length)
                break;
            else if((arr[firstPointer] + arr[secondPointer]) % target == 0 ){
//                System.out.println(arr[firstPointer] + " " + arr[secondPointer]);
                arr = newArray(arr,firstPointer,secondPointer);
                secondPointer = 1;
            }
            else
                secondPointer++;
        }
        if(arr.length == 0 || (arr.length == 1 && checkCompactibility(tempArr,arr[0],target))){
            System.out.println("Pairs can be formed");
        }
        else {
            System.out.println("Pairs cannot be formed");
        }

    }

    private static boolean checkCompactibility(int[] tempArr, int value, int target) {
        for (int element:tempArr) {
            if((value + element) % target == 0)
                return true;
        }
        return false;
    }

    private static int[] newArray(int[] arr, int firstPointer, int secondPointer) {
        int[] tempArr = new int[arr.length-2];
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == firstPointer || i == secondPointer){}
            else{
                tempArr[k] = arr[i];
                k++;
            }
        }
        return tempArr;
    }
}
