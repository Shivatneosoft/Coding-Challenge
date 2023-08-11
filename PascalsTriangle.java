import javax.swing.plaf.ColorUIResource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given a non-negative integer n, print the first n rows of Pascal’s triangle.
Each number in Pascal’s triangle is constructed by adding the two numbers diagonally above, where blank entries being interpreted as 0. For instance, the first eight rows of Pascal’s triangle are depicted in the diagram below.


For Example:
Input: n = 3
Output: [[1], [1, 1], [1, 2, 1]]

Input: n = 5
Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1], [1, 4, 6, 4, 1]]
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        int height = 5;
        solution(height);
    }

    private static void solution(int height) {
        int currentsize = 1;
        int[][] output = new int[height][];

        while (height != 0){
            int[] rowOutput = new int[currentsize];
            for (int i = 0; i < currentsize; i++) {
                if(i == 0 || i == currentsize-1)
                    rowOutput[i] = 1;
                else {
                    rowOutput[i] = output[currentsize-2][i-1] + output[currentsize-2][i];
                }
            }
            output[currentsize-1] = rowOutput;
            currentsize++;
            height --;
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(Arrays.toString(output[i]));
        }
    }
}
