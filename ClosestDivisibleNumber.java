/*
Given non-zero two integers N and M. The problem is to find the number closest to N and divisible by M. If there are more than one such number, then output the one having maximum absolute value.


Example 1:

Input:
N = 13 , M = 4
Output:
12
Explanation:
12 is the Closest Number to
13 which is divisible by 4.
Example 2:

Input:
N = -15 , M = 6
Output:
-18
Explanation:
-12 and -18 are both similarly close to
-15 and divisible by 6. but -18 has
the maximum absolute value.
So, Output is -18
 */
public class ClosestDivisibleNumber {
    public static void main(String[] args) {
//        int target = 13, divisor = 4;
        int target = -15, divisor = 6;
        normalSolution(target,divisor);
    }

    private static void normalSolution(int target, int divisor) {
        if(target % divisor == 0)
            System.out.println(target);
        else {
            int multiplier = target / divisor;
            int front = divisor * multiplier;
            int rear;
            if(target < 0)
                rear = divisor * (multiplier - 1);
            else
                rear = divisor * (multiplier + 1);
            if ((front - target) > (rear - target))
                System.out.println(rear);
            else
                System.out.println(front);
        }
    }
}
