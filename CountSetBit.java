/*
Given a positive integer N, print count of set bits in it.
Example 1:
Input:6
Output:2
Explanation:
Binary representation is '110'
So the count of the set bit is 2.

Example 2:
Input:8
Output:1
Explanation:
Binary representation is '1000'
So the count of the set bit is 1.
 */
public class CountSetBit {
    public static void main(String[] args) {
//        int input = 6;
        int input = 13;
        solutionUsingWhileLoop(input);
    }

    private static void solutionUsingWhileLoop(int input) {
        int count = 0;
        while (input > 0){
            if(input % 2 == 1)
                count ++;
            input = input/2;
        }
        System.out.println(count);
    }
}
