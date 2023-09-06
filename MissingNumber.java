import java.util.concurrent.ForkJoinPool;

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.



Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
public class MissingNumber {
    public static void main(String[] args) {
//        int[] nums = {3,0,1};
        int[] nums = {9,6,4,2,3,5,7,0,1};
//        solutionUsingSorting(nums);
        solutionUsigContains(nums);
    }

    private static void solutionUsigContains(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            if(!contains(nums,i)) {
                System.out.println(i);
                break;
            }
        }
    }

    private static Boolean contains(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return true;
        }
        return false;
    }

    private static void solutionUsingSorting(int[] nums) {
        sortingArray(nums);
        int missingNumber = getMissingNumber(nums);
        System.out.println(missingNumber);
    }

    private static int getMissingNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(nums[i] != i)
                return i;
        }
        return 0;
    }

    private static void sortingArray(int[] nums) {
        for (int i = 0; i < nums.length-1; i++)
            for (int j = i+1; j < nums.length; j++)
                if(nums[i] > nums[j])
                    swap(nums,i,j);
    }

    private static void swap(int[] nums, int first, int second) {
        nums[first] = nums[first] + nums[second];
        nums[second] = nums[first] - nums[second];
        nums[first] = nums[first] - nums[second];
    }
}
