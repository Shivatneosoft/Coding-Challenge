import java.util.Arrays;
import java.util.OptionalInt;

/*
Given an integer array, trim it such that its maximum element becomes less than twice the minimum, return the minimum number of removals required for the conversion.
For example,
Input:  [4, 6, 1, 7, 5, 9, 2]
Output: The minimum number of removals is 4
The trimmed array is [7, 5, 9] where 9 < 2 × 5.


Input:  [4, 2, 6, 4, 9]
Output: The minimum number of removals is 3
The trimmed array is [6, 4] where 6 < 2 × 4.

 */
public class TrimArrayDoubleMin {
    public static void main(String[] args) {
        int[] input = {4, 6, 1, 7, 5, 9, 2};
//        int[] input = {4, 2, 6, 4, 9};
        solutionUsingTrim(input);
    }

    private static void solutionUsingTrim(int[] input) {
        int lenght = input.length;
        while(true){
            int max = Arrays.stream(input).max().getAsInt();
            int min = Arrays.stream(input).min().getAsInt();
            if((min * 2) > max) {
                System.out.println(lenght - input.length);
                break;
            }
            else {
                int minIndex = indexOf(input,min);
                int maxIndex = indexOf(input,max);

                if (minIndex < maxIndex) {
                    int leftElementCount = minIndex + 1 ;
                    int rightElementCount = input.length - minIndex - 1;
                    if(leftElementCount < rightElementCount)
                        input = Arrays.copyOfRange(input,leftElementCount,input.length);
                    else
                        input = Arrays.copyOfRange(input,0,leftElementCount);
                }
                else {
                    int leftElementCount = input.length - minIndex ;
                    int rightElementCount = minIndex;
                    if(leftElementCount < rightElementCount)
                        input = Arrays.copyOfRange(input,0,rightElementCount);
                    else
                        input = Arrays.copyOfRange(input,rightElementCount,input.length);
                }

            }
        }
    }

    private static int indexOf(int[] input, int max) {
        for (int i = 0; i < input.length; i++) {
            if(input[i] == max)
                return i;
        }
        return -1;
    }

}
