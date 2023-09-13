/*
Given two numbers 'N' and 'S' , find the largest number that can be formed with 'N' digits and
whose sum of digits should be equals to 'S'. Return -1 if it is not possible.

Example 1:
Input: N = 2, S = 9
Output: 90
Explaination: It is the biggest number with sum of digits equals to 9.
Example 2:
Input: N = 3, S = 20
Output: 992
Explaination: It is the biggest number with sum of digits equals to 20.
 */
public class LargestNumberForSum {
    public static void main(String[] args) {
//        int digit = 2, sum = 9;
        int digit = 6, sum = 50;

        System.out.println(solutionUsingWhileLoop(digit,sum));
    }

    private static long solutionUsingWhileLoop(int digit, int sum) {
        if (digit < 1 || sum < 1 || sum > 9*digit) {
            return -1;
        }
        long output = 0;
        while (digit > 0){
            output = output*10;
            if(sum - 9 >= 0) {
                output = output + 9;
                sum = sum - 9;
            }
            else {
                output = output + sum;
                sum = 0;
            }
            digit--;
        }
        return output;
    }
}
