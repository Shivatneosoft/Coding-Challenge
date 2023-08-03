/*
Given an array of distinct integers, shuffle it according to the given order of elements.
For example:
Input:
nums[] = { 1, 2, 3, 4, 5 }
pos[] = { 3, 2, 4, 1, 0 }

Output:

nums[] = { 5, 4, 2, 1, 3 }

i.e., if pos[i] = j, then update nums[j] = nums[i] for every index i.
In other words, update nums[pos[i]] = nums[i] for every index i.
 */

import java.util.Arrays;

public class CustomizeArrange {
    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4, 5 };
        int[] pos = { 3, 2, 4, 1, 0 };

        solutionUsingNewArray(num,pos);
        solutionUsingReplacementProcess(num,pos);
    }

    private static void solutionUsingReplacementProcess(int[] num, int[] pos) {
        int pointer = 0;
        int numValue, posValue;
        while (!checkPosition(pos)){
            posValue = pos[pos[pointer]];
            numValue = num[pos[pointer]];
            pos[pos[pointer]] = pos[pointer];
            num[pos[pointer]] = num[pointer];
            pos[pointer] = posValue;
            num[pointer] = numValue;
        }
        System.out.println(Arrays.toString(num));
    }

    private static boolean checkPosition(int[] pos) {
        for (int i = 0; i < pos.length; i++) {
            if(pos[i] != i)
                return false;
        }
        return true;
    }

    private static void solutionUsingNewArray(int[] num, int[] pos) {
        int[] output = new int[num.length];
        for (int i = 0; i < pos.length; i++) {
            output[pos[i]] = num[i];
        }
        System.out.println(Arrays.toString(output));
    }


}
