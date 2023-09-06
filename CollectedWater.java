import java.util.Arrays;

/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 */
public class CollectedWater {
    public static void main(String[] args) {
//        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        int height[] = {4,2,0,3,2,5};
//        solutionUsingRecursion(height);
        solutionUsingForLoop(height); // wrong Answer
    }

    private static void solutionUsingForLoop(int[] height) {
        int maxLenght = 0;
        for (int i = 1; i < height.length-2; i++) {
            if(height[i-1] > height[i] && height[i+1] > height[i]){
                int leftMaxIndex = findLeftMax(height,i-1);
                int rightMaxIndex = findRightMax(height,i+1);
                int comparingValue = height[leftMaxIndex] < height[rightMaxIndex] ? height[leftMaxIndex] : height[rightMaxIndex] ;
                for (int j = leftMaxIndex; j < rightMaxIndex; j++) {
                    int storedWater = comparingValue - height[j];
                    maxLenght = maxLenght + (storedWater > 0 ? storedWater : 0);
                }
            }
        }
        System.out.println(maxLenght);
    }

    private static int findLeftMax(int[] height, int index) {
        int max = 0;
        for (int i = 0; i < index; i++)
            if(max < height[i])
                max = height[i];
        for (int i = 0; i < index; i++) {
            if(height[i] == max)
                return i;
        }
        return index;
    }

    private static int findRightMax(int[] height, int index) {
        int length = height.length;
        int max = 0;
        for (int i = index; i < length; i++)
            if (max < height[i])
                max = height[i];
        for (int i = index; i< length; i++)
            if(height[i] == max)
                return i;
        return index;
    }

    private static void solutionUsingRecursion(int[] height) {
        int currentHeightIndex = findIndexOfMax(height);
        int savedWater =
        checkIfSecondMaxExist(currentHeightIndex,0,0, Arrays.copyOfRange(height,0,currentHeightIndex)) +
        checkIfSecondMaxExist(0,height.length-1,0,Arrays.copyOfRange(height,currentHeightIndex+1,height.length));
        System.out.println(savedWater);
    }

    private static int checkIfSecondMaxExist(int currentHeightIndex, int end, int savedWater, int[] height) {
        if(currentHeightIndex == end)
            return savedWater;
        int secondHeightIndex = findIndexOfMax(height);
        if(secondHeightIndex < 0)
            return savedWater;
        int collectWater = 0;
        int secondHeightValue = height[secondHeightIndex];
        if(end == 0){
            int volume = (currentHeightIndex - secondHeightIndex) * secondHeightValue;
            int sum = Arrays.stream(Arrays.copyOfRange(height, secondHeightIndex,currentHeightIndex)).sum();
            collectWater = volume - sum;
            return checkIfSecondMaxExist(secondHeightIndex,end,savedWater + collectWater,Arrays.copyOfRange(height,0,secondHeightIndex));
        }
        else {
            int volume = (currentHeightIndex - secondHeightIndex) * secondHeightValue;
            int sum = Arrays.stream(Arrays.copyOfRange(height, currentHeightIndex, secondHeightIndex)).sum();
            collectWater = volume - sum;
            return checkIfSecondMaxExist(secondHeightIndex,height.length-1,savedWater + collectWater,Arrays.copyOfRange(height,secondHeightIndex+1,height.length));
        }
    }

    private static int findIndexOfMax(int[] height) {
        int value = 0;
        int length = height.length;

        for (int i = 0; i < length; i++)
            if(value < height[i])
                value = height[i];

        for (int i = 0; i < length; i++)
            if(value == height[i])
                return i;
        return -1;
    }
}
