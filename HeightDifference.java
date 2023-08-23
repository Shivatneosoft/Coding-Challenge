import java.util.Arrays;

/*
Given an array arr[] denoting heights of N towers and a positive integer K.

For each tower, you must perform exactly one of the following operations exactly once.

Increase the height of the tower by K
Decrease the height of the tower by K
Find out the minimum possible difference between the height of the shortest and tallest towers after you have modified each tower.

Example 1:

Input:
K = 2, N = 4
Arr[] = {1, 5, 8, 10}
Output:
5
Explanation:
The array can be modified as
{1+k, 5-k, 8-k, 10-k} = {3, 3, 6, 8}.
The difference between
the largest and the smallest is 8-3 = 5.
Example 2:

Input:
K = 3, N = 5
Arr[] = {3, 9, 12, 16, 20}
Output:
11
Explanation:
The array can be modified as
{3+k, 9+k, 12-k, 16-k, 20-k} -> {6, 12, 9, 13, 17}.
The difference between
the largest and the smallest is 17-6 = 11.
 */
public class HeightDifference {
    public static void main(String[] args) {
//        int k = 3, sizeOfHeight = 5;
//        int[] heights = {3, 9, 12, 16, 20};
        int k = 2, sizeOfHeight = 4;
        int[] heights = {1,5,8,10};
        solutionOne(k,sizeOfHeight,heights);
    }

    private static void solutionOne(int k, int sizeOfHeight, int[] heights) {
        int averageNumber = 0;
        for (int i = 0; i < sizeOfHeight ; i++) {
            averageNumber = averageNumber + heights[i];
        }
        averageNumber = averageNumber / sizeOfHeight;
        for (int i = 0; i < sizeOfHeight; i++) {
            if(heights[i] < averageNumber)
                heights[i] = heights[i] + k;
            else
                heights[i] = heights[i] - k;
        }
        int min = heights[sizeOfHeight-1];
        int max = 0;
        for (int i = 0; i < sizeOfHeight; i++) {
            if(min > heights[i])
                min = heights[i];
            if(max < heights[i])
                max = heights[i];
        }
        System.out.println(max - min);
    }
}
