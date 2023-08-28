import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
find two numbers such that they add up to a specific target number.
Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
*/
public class TwoSumSorted {
    public static void main(String[] args) {
        int[] numbers = {-3,-1,0,2,7,11,15};
        int target = 12;
//        int[] numbers = {-1,0};
//        int target = -1;
//        int[] numbers = {-90,3,4,90};
//        int target = 0;

//        System.out.println(Arrays.toString(solutionOne(numbers, target)));
//        System.out.println(Arrays.toString(solutionTwo(numbers, target)));
        System.out.println(Arrays.toString(solutionThree(numbers, target)));

    }

    private static int[] solutionThree(int[] numbers, int target) {
        Map<Integer,Integer> data = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            int other = target - num;
            if (data.containsKey(other))
                return new int[]{data.get(other),i+1};
            else
                data.put(num,i+1);
        }
        return new int[0];
    }

    private static int[] solutionTwo(int[] numbers, int target) {
        int right = numbers.length-1, left = 0;
        while (true){
            int sum = numbers[left] + numbers[right];
            if(sum == target)
                break;
            else if (sum < target)
                left ++;
            else
                right --;
        }
        return new int[]{left+1, right+1};
    }

    private static int[] solutionOne(int[] numbers, int target) {
        boolean flag = true;
        int[] index = null;
        if (target > 0) {
            int firstPointer = 0, secondPointer = numbers.length - 1;
            while (numbers[secondPointer] > target) {
                secondPointer--;
            }
            int tempSecondPointer = secondPointer;
            while (flag){
                firstPointer = secondPointer - 1;
                while (secondPointer > 0) {
                    int sum = numbers[secondPointer] + numbers[firstPointer];
                    if (sum == target) {
                        index = new int[]{firstPointer + 1, secondPointer + 1};
                        flag = false;
                        break;
                    } else {
                        if (firstPointer == 0) {
                            secondPointer--;
                            firstPointer = secondPointer - 1;
                        } else {
                            firstPointer--;
                        }
                    }
                }
                secondPointer = tempSecondPointer ++;
            }
            return index;
        } else if (target == 0) {
            int firstPointer = 0;
            for (firstPointer = 0; firstPointer < numbers.length - 1; firstPointer++) {
                for (int i = firstPointer + 1; i < numbers.length; i++) {
                    if (numbers[i] == -(numbers[firstPointer])) {
                        return (new int[]{firstPointer + 1, i + 1});
                    }
                }
            }
        } else {
            int firstPointer = 0, secondPointer = 0;
            while (numbers[secondPointer] < target) {
                secondPointer++;
            }
            int tempSecondPointer = secondPointer;
            firstPointer = secondPointer + 1;
            while (secondPointer < numbers.length) {
                int sum = numbers[secondPointer] + numbers[firstPointer];
                if (sum == target) {
                    return(new int[]{secondPointer + 1,firstPointer + 1});
                } else {
                    if (firstPointer == numbers.length - 1) {
                        secondPointer++;
                        firstPointer = secondPointer + 1;
                    } else {
                        firstPointer++;
                    }

                }
            }
        }
        return null;
    }
}
